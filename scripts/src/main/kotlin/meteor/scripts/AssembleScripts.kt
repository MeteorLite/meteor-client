/*
 * Copyright (c) 2018, Adam <Adam@sigterm.info>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.scripts

import com.google.common.io.Files
import meteor.Logger.Companion.getLogger
import java.io.File
import net.runelite.cache.script.assembler.Assembler
import net.runelite.cache.definitions.savers.ScriptSaver
import net.runelite.cache.IndexType
import com.google.common.io.MoreFiles
import com.google.common.io.RecursiveDeleteOption
import java.io.IOException
import java.io.FileInputStream
import java.lang.RuntimeException
import kotlin.jvm.JvmStatic
import java.io.DataOutputStream
import java.io.FileOutputStream
import java.lang.NumberFormatException

class AssembleScripts private constructor(private val scriptDirectory: File, private val outputDirectory: File) {
    private val log = getLogger(AssembleScripts::class.java)
    fun execute() {
        val instructions = RuneLiteInstructions()
        instructions.init()
        val assembler = Assembler(instructions)
        val saver = ScriptSaver()
        var count = 0
        val scriptOut = File(
            outputDirectory,
            Integer.toString(IndexType.CLIENTSCRIPT.number)
        )
        scriptOut.mkdirs()

        // Clear the target directory to remove stale entries
        try {
            MoreFiles.deleteDirectoryContents(scriptOut.toPath(), RecursiveDeleteOption.ALLOW_INSECURE)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        for (scriptFile in scriptDirectory.listFiles { dir: File?, name: String -> name.endsWith(".rs2asm") }) {
            log.debug("Assembling $scriptFile")
            try {
                FileInputStream(scriptFile).use { fin ->
                    val script = assembler.assemble(fin)
                    val packedScript = saver.save(script)
                    val targetFile = File(scriptOut, Integer.toString(script.id))
                    Files.write(packedScript, targetFile)

                    // Copy hash file
                    val hashFile = File(
                        scriptDirectory,
                        Files.getNameWithoutExtension(scriptFile.name) + ".hash"
                    )
                    if (hashFile.exists()) {
                        Files.copy(hashFile, File(scriptOut, Integer.toString(script.id) + ".hash"))
                    } else if (script.id
                        < 10000
                    ) // Scripts >=10000 are RuneLite scripts, so they shouldn't have a .hash
                    {
                        throw RuntimeException("Unable to find hash file for $scriptFile")
                    }
                    ++count
                }
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
        }
        log.info("Assembled $count scripts")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val scriptDirectory = File("./src/main/scripts")
            val buildScriptsDir = File("./build/scripts")
            val outputDirectory = File("../client/src/main/resources/runelite")
            val indexFile = File("../client/src/main/resources/runelite/index")
            if (buildScriptsDir.exists()) buildScriptsDir.delete()
            AssembleScripts(scriptDirectory, outputDirectory).execute()
            try {
                DataOutputStream(FileOutputStream(indexFile)).use { fout ->
                    for (indexFolder in outputDirectory.listFiles()) {
                        if (indexFolder.isDirectory) {
                            val indexId = indexFolder.name.toInt()
                            for (archiveFile in indexFolder.listFiles()) {
                                var archiveId: Int
                                archiveId = try {
                                    archiveFile.name.toInt()
                                } catch (ex: NumberFormatException) {
                                    continue
                                }
                                fout.writeInt(indexId shl 16 or archiveId)
                            }
                        }
                    }
                    fout.writeInt(-1)
                }
            } catch (ex: IOException) {
                ex.printStackTrace()
            }
        }
    }
}