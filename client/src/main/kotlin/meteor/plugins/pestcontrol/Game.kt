/*
 * Copyright (c) 2017, Adam <Adam@sigterm.info>
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
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES
 * LOSS OF USE, DATA, OR PROFITS OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package meteor.plugins.pestcontrol

import lombok.extern.slf4j.Slf4j
import meteor.Logger
import meteor.ui.overlay.Overlay
import java.awt.Dimension
import java.awt.Graphics2D

import java.util.ArrayList

@Slf4j
class Game : Overlay()
{
    // Game starts with all possible rotations
    private var possibleRotations = Rotation.values()
    // Number of shields dropped
    var shieldsDropped = 0

    var purple = PortalContext(Portal.PURPLE)
    var blue = PortalContext(Portal.BLUE)
    var yellow = PortalContext(Portal.YELLOW)
    var red = PortalContext(Portal.RED)
    
    val log = Logger("PestControlGame")

    fun fall(color: String)
    {
        if(color == "purple") {
            fall(purple)
        } else if(color == "red") {
            fall(blue)
        } else if(color == "yellow") {
            fall(yellow)
        } else if(color == "blue") {
            fall(blue)
        }
    }

    fun fall(portal: PortalContext)
    {
        if (!portal.shielded) { return }

        println("Shield dropped for " +  portal.portal)

        portal.shielded = false
        var shieldDrop = shieldsDropped++

        // Remove impossible rotations
        var rotations = mutableListOf<Rotation>();

        possibleRotations.forEach {
            if(it.getPortal(shieldDrop) == portal.portal) { rotations.add(it) }
        }

        possibleRotations = rotations.toTypedArray();
    }

    fun die(portal: PortalContext)
    {
        if (portal.dead)
        {
            return
        }

        portal.portal?.let { log.info("Portal {} died", it) }

        portal.dead = true
    }

    fun getNextPortals(): MutableList<Portal> {
        var portals = mutableListOf<Portal>()

        possibleRotations.forEach {
            var portal = it.getPortal(shieldsDropped)
            
            if(portal!= null && !portals.contains(portal)) {portals.add(portal)}
            
        }
        
        return portals
    }

    override fun render(graphics: Graphics2D): Dimension? {
        TODO("Not yet implemented")
    }
}
