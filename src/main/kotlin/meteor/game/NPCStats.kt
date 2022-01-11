/*
 * Copyright (c) 2019, TheStonedTurtle <https://github.com/TheStonedTurtle>
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
package meteor.game

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.io.IOException
import java.lang.UnsupportedOperationException

class NPCStats {
    var name: String? = null
    var hitpoints = 0
    var combatLevel = 0
    var slayerLevel = 0
    var attackSpeed = 0
    var attackLevel = 0
    var strengthLevel = 0
    var defenceLevel = 0
    var rangeLevel = 0
    var magicLevel = 0
    var stab = 0
    var slash = 0
    var crush = 0
    var range = 0
    var magic = 0
    var stabDef = 0
    var slashDef = 0
    var crushDef = 0
    var rangeDef = 0
    var magicDef = 0
    var bonusAttack = 0
    var bonusStrength = 0
    var bonusRangeStrength = 0
    var bonusMagicDamage = 0
    var poisonImmune = false
    var venomImmune = false
    var dragon = false
    var demon = false
    var undead = false
    fun builder() : NPCStats {
        return Builder().start()
    }
    class Builder {
        private var npcStats = NPCStats()
        fun start() : NPCStats {
            return npcStats
        }

        fun build() : NPCStats {
            return npcStats
        }

        fun name(s: String) : Builder {
            npcStats.name = s
            return this
        }

        fun hitpoints(i: Int) : Builder {
            npcStats.hitpoints = i
            return this
        }

        fun combatLevel(i: Int) : Builder {
            npcStats.combatLevel = i
            return this
        }

        fun slayerLevel(i: Int) : Builder {
            npcStats.slayerLevel = i
            return this
        }

        fun attackSpeed(i: Int) : Builder {
            npcStats.attackSpeed = i
            return this
        }

        fun attackLevel(i: Int) : Builder {
            npcStats.attackLevel = i
            return this
        }

        fun strengthLevel(i: Int) : Builder {
            npcStats.strengthLevel = i
            return this
        }

        fun defenceLevel(i: Int) : Builder {
            npcStats.defenceLevel = i
            return this
        }

        fun rangeLevel(i: Int) : Builder {
            npcStats.rangeLevel = i
            return this
        }

        fun magicLevel(i: Int) : Builder {
            npcStats.magicLevel = i
            return this
        }

        fun stab(i: Int) : Builder {
            npcStats.stab = i
            return this
        }

        fun slash(i: Int) : Builder {
            npcStats.slash = i
            return this
        }

        fun crush(i: Int) : Builder {
            npcStats.crush = i
            return this
        }

        fun range(i: Int) : Builder {
            npcStats.range = i
            return this
        }

        fun magic(i: Int) : Builder {
            npcStats.magic = i
            return this
        }

        fun stabDef(i: Int) : Builder {
            npcStats.stabDef = i
            return this
        }

        fun slashDef(i: Int) : Builder {
            npcStats.slashDef = i
            return this
        }

        fun crushDef(i: Int) : Builder {
            npcStats.crushDef = i
            return this
        }

        fun rangeDef(i: Int) : Builder {
            npcStats.rangeDef = i
            return this
        }

        fun magicDef(i: Int) : Builder {
            npcStats.magicDef = i
            return this
        }

        fun bonusAttack(i: Int) : Builder {
            npcStats.bonusAttack = i
            return this
        }

        fun bonusStrength(i: Int) : Builder {
            npcStats.bonusStrength = i
            return this
        }

        fun bonusRangeStrength(i: Int) : Builder {
            npcStats.bonusRangeStrength = i
            return this
        }

        fun bonusMagicDamage(i: Int) : Builder {
            npcStats.bonusMagicDamage = i
            return this
        }

        fun poisonImmune(b: Boolean) : Builder {
            npcStats.poisonImmune = b
            return this
        }

        fun venomImmune(b: Boolean) : Builder {
            npcStats.venomImmune = b
            return this
        }

        fun dragon(b: Boolean) : Builder {
            npcStats.dragon = b
            return this
        }

        fun demon(b: Boolean) : Builder {
            npcStats.demon = b
            return this
        }

        fun undead(b: Boolean) : Builder {
            npcStats.undead = b
            return this
        }
    }

    /**
     * Based off the formula found here: http://services.runescape.com/m=forum/c=PLuJ4cy6gtA/forums.ws?317,318,712,65587452,209,337584542#209
     *
     * @return bonus XP modifier
     */
    fun calculateXpModifier(): Double {
        val averageLevel = Math.floor(((attackLevel + strengthLevel + defenceLevel + hitpoints) / 4).toDouble())
        val averageDefBonus = Math.floor(((stabDef + slashDef + crushDef) / 3).toDouble())
        return 1 + Math.floor(averageLevel * (averageDefBonus + bonusStrength + bonusAttack) / 5120) / 40
    }

    companion object {
        // Because this class is here we can't add the TypeAdapter to gson (easily)
        // doesn't mean we can't use one to do it a bit quicker
        val NPC_STATS_TYPE_ADAPTER: TypeAdapter<NPCStats?> = object : TypeAdapter<NPCStats?>() {
            override fun write(out: JsonWriter, value: NPCStats?) {
                throw UnsupportedOperationException("Not supported")
            }

            @Throws(IOException::class)
            override fun read(`in`: JsonReader): NPCStats? {
                `in`.beginObject()
                val builder = Builder()

                // Name is the only one that's guaranteed
                `in`.skipValue()
                builder.name(`in`.nextString())
                while (`in`.hasNext()) {
                    when (`in`.nextName()) {
                        "hitpoints" -> builder.hitpoints(`in`.nextInt())
                        "combatLevel" -> builder.combatLevel(`in`.nextInt())
                        "slayerLevel" -> builder.slayerLevel(`in`.nextInt())
                        "attackSpeed" -> builder.attackSpeed(`in`.nextInt())
                        "attackLevel" -> builder.attackLevel(`in`.nextInt())
                        "strengthLevel" -> builder.strengthLevel(`in`.nextInt())
                        "defenceLevel" -> builder.defenceLevel(`in`.nextInt())
                        "rangeLevel" -> builder.rangeLevel(`in`.nextInt())
                        "magicLevel" -> builder.magicLevel(`in`.nextInt())
                        "stab" -> builder.stab(`in`.nextInt())
                        "slash" -> builder.slash(`in`.nextInt())
                        "crush" -> builder.crush(`in`.nextInt())
                        "range" -> builder.range(`in`.nextInt())
                        "magic" -> builder.magic(`in`.nextInt())
                        "stabDef" -> builder.stabDef(`in`.nextInt())
                        "slashDef" -> builder.slashDef(`in`.nextInt())
                        "crushDef" -> builder.crushDef(`in`.nextInt())
                        "rangeDef" -> builder.rangeDef(`in`.nextInt())
                        "magicDef" -> builder.magicDef(`in`.nextInt())
                        "bonusAttack" -> builder.bonusAttack(`in`.nextInt())
                        "bonusStrength" -> builder.bonusStrength(`in`.nextInt())
                        "bonusRangeStrength" -> builder.bonusRangeStrength(`in`.nextInt())
                        "bonusMagicDamage" -> builder.bonusMagicDamage(`in`.nextInt())
                        "poisonImmune" -> builder.poisonImmune(`in`.nextBoolean())
                        "venomImmune" -> builder.venomImmune(`in`.nextBoolean())
                        "dragon" -> builder.dragon(`in`.nextBoolean())
                        "demon" -> builder.demon(`in`.nextBoolean())
                        "undead" -> builder.undead(`in`.nextBoolean())
                    }
                }
                `in`.endObject()
                return builder.build()
            }
        }
    }
}