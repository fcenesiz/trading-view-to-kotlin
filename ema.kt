fun ema(src: List<Double>, length: Int): List<Double> {
    if (length > 200) // max length 200
        return listOf()
    val list = src.takeLast(length * (if (length <= 140) 7 else if (length < 165) 6 else 4))
    val end = list.size - 1
    val start = end - length

    val optInK_1 = 2.0 / (length + 1)
    var prevMA = list[0]
    var today = 1

    val outReal = mutableListOf<Double>()

    while (today <= start) {
        prevMA += ((list[today++] - prevMA) * optInK_1)
    }

    outReal.add(prevMA)

    while (today <= end) {
        prevMA += ((list[today++] - prevMA) * optInK_1)
        outReal.add(prevMA)
    }

    return outReal
}
