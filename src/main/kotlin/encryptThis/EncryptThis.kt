package encryptThis

/** Aufgabe von codingwars.com, erstellt von suic
 *
 *  In diesem Codewars-Problem soll ein String in eine
 *  Geheimsprache umgewandelt werden. Folgende Regeln
 *  müssen beachtet werden:
 *      - The first letter must be converted to its ASCII code.
 *      - The second letter must be switched with the last letter
 */

fun main() {
    println(encryptThis("A wise old owl lived in an oak"))
}

fun encryptThis(text:String): String{
    val separateText = text.split(" ")
    var resultText = ""

    for (word in separateText) {
        var tempChar = ""
        for ((index, letter) in word.withIndex()) {
            if (index == 0) {
                tempChar += letter.code
            }
            else if (index == 1) {
                tempChar += word[word.length - 1]
            }
            else if (index == word.length - 1) {
                tempChar += word[1]
            } else {
                tempChar += letter
            }
        }
        if (word == separateText.last()) {
            resultText += tempChar
        } else {
            resultText += "$tempChar "
        }
    }
    return resultText
}