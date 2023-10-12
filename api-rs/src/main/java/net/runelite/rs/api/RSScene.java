/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
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
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package net.runelite.rs.api;

import net.runelite.mapping.Import;

import java.awt.*;

public interface RSScene
{
    @Import("cameraX")
    int getCameraX();
    @Import("cameraY")
    int getCameraY();
    @Import("cameraZ")
    int getCameraZ();
    @Import("cameraYaw")
    int getCameraYaw();
    @Import("cameraPitch")
    int getCameraPitch();
    @Import("cameraRoll")
    int getCameraRoll();

    @Import("fogZDistance")
    int getFogDistance();

    @Import("fogZDistance")
    void setFogDistance(int fogDistance);

    @Import("clipFar2d")
    int getClipFar2D();

    @Import("clipFar2d")
    void setClipFar2D(int clipFar2d);

    @Import("clipFar3d")
    int getClipFar3D();

    @Import("clipFar3d")
    void setClipFar3D(int clipFar3d);

    @Import("viewDistance")
    int getViewDistance();

    @Import("viewDistance")
    void setViewDistance(int viewDistance);
}
