package rs117.hd

object RGB {
    fun rgb(r: Int, g: Int, b: Int): FloatArray {
        return floatArrayOf(
            HDUtils.gammaToLinear(r / 255f),
            HDUtils.gammaToLinear(g / 255f),
            HDUtils.gammaToLinear(b / 255f)
        )
    }
}