package persistentBugger

/** Aufgabe von codingwars.com, erstellt von joh_pot
 *
 *  In diesem Programm wird jede Stelle einer Zahl,
 *  solange miteinander multipliziert, bis das Ergebnis
 *  nur noch eine Stelle aufweist.
 */

fun main() {
    println(persistence(39))
    println(persistence(4))
    println(persistence(999))
}

fun persistence(num: Int) : Int {
    return resultCount(num, 1)
}

fun resultCount(num: Int, count: Int) : Int {
    if (num.toString().count() == 1) {
        return 0
    }

    val charArray = num.toString().toCharArray()
    var tempNum = 1
    for (char in charArray) {
        tempNum *= char.toString().toInt()
    }

    return if (tempNum.toString().count() > 1) {
        resultCount(tempNum, count + 1)
    } else {
        count
    }
}