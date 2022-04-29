package romanNumeralsDecoder

/** Aufgabe von codingwars.com, erstellt von jhoffner
 *
 *  Dieser Code wandelt einen String aus römischen
 *  Zeichen in die entsprechende Dezimalzahl um.
 */

fun main() {
    println(decode("MCMXX"))
}

fun decode(str: String): Int {
    val listDigitRome = mutableListOf<MutableList<Any>>(
        mutableListOf("I", 1),
        mutableListOf("V", 5),
        mutableListOf("X", 10),
        mutableListOf("L", 50),
        mutableListOf("C", 100),
        mutableListOf("D", 500),
        mutableListOf("M", 1000)
    )
    val digits = mutableListOf<Int>()
    val solution = mutableListOf<Int>()

    val letters = str.trim()
    for (letter in letters) {
        digits.add(getDigitFromRome(listDigitRome, letter.toString()))
    }

    val newList = createList(digits, solution)
    var newDigit = 0

    for (i in newList) {
        newDigit += i
    }

    return newDigit
}

fun createList(digits: MutableList<Int>, solution: MutableList<Int>): MutableList<Int> {

    if (digits.size == 1) {
        solution.add(digits[0])
        return solution
    }

    if (digits.size != 0) {
        for ((index, digit) in digits.withIndex()) {

            if (digits[index + 1] > digit) {
                solution.add(digits[index + 1] - digit)
                removeSlice(digits, 0, 1)
                createList(digits, solution)
                break
            }
            if (digits[index + 1] == digit || (digits[index + 1] < digit && digits[index + 1] >= digit/2)) {
                solution.add(digit + digits[index + 1])
                removeSlice(digits, 0, 1)
                createList(digits, solution)
                break
            } else {
                solution.add(digit)
                removeSlice(digits, 0, 0)
                createList(digits, solution)
                break
            }
        }
    }
    return solution
}

fun removeSlice(list: MutableList<Int>, from: Int, end: Int) {
    for (i in end downTo from) {
        list.removeAt(i)
    }
}

fun getDigitFromRome(list: MutableList<MutableList<Any>>, letter: String): Int {
    var result = 0
    for (element in list) {
        if (element[0] == letter) {
            result = element[1].toString().toInt()
        }
    }
    return result
}