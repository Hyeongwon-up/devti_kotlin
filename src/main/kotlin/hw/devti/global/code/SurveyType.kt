package hw.devti.global.code

enum class SurveyType(
    private val value: Int
): DevtiEnumerable {
    DEVTI(0);

    override fun getKey(): String {
        return name
    }

    override fun getValue(): Int {
        return value
    }

}