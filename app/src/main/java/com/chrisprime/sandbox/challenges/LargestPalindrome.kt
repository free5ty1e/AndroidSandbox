package com.chrisprime.sandbox.challenges

import android.util.Log

/*
Write a function that will generate one of the longest possible palindromes buildable from the characters within a given string

For example:
abczyx => a (any one of the characters would have been fine)
bbaac => abcba
aabbcc => abccba
bbbbbaac  => bbacabb
*/
object LargestPalindrome {
    fun largestPalindrome(string: String): String {
        val pairedChars = mutableListOf<Char>()
        val stringAsChars = string.toCharArray()
        val leftoverChars = string.toMutableList()
        for ((letterIndex, letter) in stringAsChars.toSet().withIndex()) {
            val size = stringAsChars.filter { it == letter }.size
            if (size >= 1) {
                // println("Size is $size > 1 for letter $letter, checking pairs")
                val numPairs = size / 2
                // println("numPairs = $numPairs for letter $letter")
                for (i in 1..numPairs) {
                    pairedChars.add(letter)
                    leftoverChars.remove(letter)
                    leftoverChars.remove(letter)
                    // println("added letter $letter to pairedChars: $pairedChars\nand removed from leftoverChars $leftoverChars")
                }
            }
        }
        var palindrome = ""
        println("leftoverChars from $string = $leftoverChars")
        if (leftoverChars.size > 0) {
            palindrome = leftoverChars[0].toString()
        }

        for (pairedChar in pairedChars) {
            palindrome = "${pairedChar}${palindrome}${pairedChar}"
        }
        // println("Palindrome from pairs: $palindrome")

        if (palindrome.isEmpty() && string.isNotEmpty()) {    //take any char
            // println("Palindrome needs any char")
            palindrome = string.substring(0, 1)
        }
//        println("largestPalindrome($string) = $palindrome")
        Log.d("sandboxlog", "largestPalindrome($string) = $palindrome")

        return palindrome
    }

    fun main(args: Array<String>) {
        largestPalindrome("abczyx")
        largestPalindrome("bbaac")
        largestPalindrome("aabbcc")
        largestPalindrome("bbbbbaac")
    }
}