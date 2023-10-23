/*
 * Copyright (c) 2016-2017, Adam <Adam@sigterm.info>
 * Copyright (c) 2020, ThatGamerBlue <thatgamerblue@gmail.com>
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
package mixins;

import net.runelite.api.coords.LocalPoint;
import net.runelite.api.mixins.Inject;
import net.runelite.api.mixins.Mixin;
import net.runelite.rs.api.RSModel;
import openrsc.constants.BoundaryID;
import openrsc.constants.ObjectID;


@Mixin(RSModel.class)
public abstract class RSModelMixin implements RSModel {

	@Inject
	int localX;
	@Inject
	int localY;
	@Inject
	int objectID;
	@Inject
	int width;

	@Inject
	@Override
	public int getLocalX() {
		return localX;
	}
	@Inject
	@Override
	public int getLocalY() {
		return localY;
	}
	@Inject
	@Override
	public int getObjectID() {
		return objectID;
	}
	@Inject
	@Override
	public int getWidth() {
		return width;
	}
	@Inject
	@Override
	public void setLocalX(int localX) {
		this.localX = localX;
	}
	@Inject
	@Override
	public void setLocalY(int localY) {
		this.localY = localY;
	}
	@Inject
	@Override
	public void setObjectID(int objectID) {
		this.objectID = objectID;
	}
	@Inject
	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Inject
	@Override
	public LocalPoint getLocalLocation() {
		return new LocalPoint(getLocalX(), getLocalY());
	}

	@Inject
	boolean isWallObject = false;

	@Inject
	@Override
	public void setIsWallObject(boolean isWallObject) {
		this.isWallObject = isWallObject;
	}

	@Inject
	@Override
	public boolean isWallObject() {
		return isWallObject;
	}

	@Inject
	@Override
	public String getName() {
		if (isWallObject)
			return BoundaryID.Companion.forID(getObjectID()).name();
		else
			return ObjectID.Companion.forID(getObjectID()).name();
	}
}
