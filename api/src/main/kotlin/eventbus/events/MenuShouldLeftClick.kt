package eventbus.events



class MenuShouldLeftClick {
    var isForceRightClick = false

    fun MenuShouldLeftClick() {}

    override fun equals(o: Any?): Boolean {
        return if (o === this) {
            true
        } else if (o !is MenuShouldLeftClick) {
            false
        } else {
            if (o != this) {
                false
            } else {
                isForceRightClick == o.isForceRightClick
            }
        }
    }
}