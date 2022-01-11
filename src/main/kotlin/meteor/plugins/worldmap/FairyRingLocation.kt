/*
 * Copyright (c) 2018, Morgan Lewis <https://github.com/MESLewis>
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
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
package meteor.plugins.worldmap

import net.runelite.api.coords.WorldPoint

internal enum class FairyRingLocation(val code: String, val location: WorldPoint) {
    AIR("AIR", WorldPoint(2699, 3249, 0)), AIQ("AIQ", WorldPoint(2995, 3112, 0)), AJR(
        "AJR",
        WorldPoint(2779, 3615, 0)
    ),
    AJS("AJS", WorldPoint(2499, 3898, 0)), AKQ("AKQ", WorldPoint(2318, 3617, 0)), AKS(
        "AKS",
        WorldPoint(2570, 2958, 0)
    ),
    ALP("ALP", WorldPoint(2502, 3638, 0)), ALQ("ALQ", WorldPoint(3598, 3496, 0)), ALS(
        "ALS",
        WorldPoint(2643, 3497, 0)
    ),
    BIP("BIP", WorldPoint(3409, 3326, 0)), BIQ("BIQ", WorldPoint(3248, 3095, 0)), BIS(
        "BIS",
        WorldPoint(2635, 3268, 0)
    ),
    BJS("BJS", WorldPoint(2147, 3069, 0)), BKP("BKP", WorldPoint(2384, 3037, 0)), BKR(
        "BKR",
        WorldPoint(3468, 3433, 0)
    ),
    BLP("BLP", WorldPoint(2432, 5127, 0)), BLR("BLR", WorldPoint(2739, 3353, 0)), CIP(
        "CIP",
        WorldPoint(2512, 3886, 0)
    ),
    CIR("CIR", WorldPoint(1303, 3762, 0)), CIQ("CIQ", WorldPoint(2527, 3129, 0)), CJR(
        "CJR",
        WorldPoint(2704, 3578, 0)
    ),
    CKR("CKR", WorldPoint(2800, 3005, 0)), CKS("CKS", WorldPoint(3446, 3472, 0)), CLP(
        "CLP",
        WorldPoint(3081, 3208, 0)
    ),
    CLS("CLS", WorldPoint(2681, 3083, 0)), DIP("DIP", WorldPoint(3039, 4757, 0)), DIS(
        "DIS",
        WorldPoint(3109, 3149, 0)
    ),
    DJP("DJP", WorldPoint(2657, 3232, 0)), DJR("DJR", WorldPoint(1452, 3659, 0)), DKP(
        "DKP",
        WorldPoint(2899, 3113, 0)
    ),
    DKR("DKR", WorldPoint(3126, 3496, 0)), DKS("DKS", WorldPoint(2743, 3721, 0)), DLQ(
        "DLQ",
        WorldPoint(3422, 3018, 0)
    ),
    DLR("DLR", WorldPoint(2212, 3101, 0)), CIS("CIS", WorldPoint(1638, 3868, 0)), CLR(
        "CLR",
        WorldPoint(2737, 2739, 0)
    ),
    ZANARIS("Zanaris", WorldPoint(2411, 4436, 0));
}