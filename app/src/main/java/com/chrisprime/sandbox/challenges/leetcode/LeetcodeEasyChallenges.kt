package com.chrisprime.sandbox.challenges.leetcode

object LeetcodeEasyChallenges {

    fun runChallenges() {




    }




























    /**
     * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
     * 28. Find the Index of the First Occurrence in a String
     * Easy
     * 4.9K
     * 274
     * Companies
     * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
     *
     *
     *
     * Example 1:
     *
     * Input: haystack = "sadbutsad", needle = "sad"
     * Output: 0
     * Explanation: "sad" occurs at index 0 and 6.
     * The first occurrence is at index 0, so we return 0.
     * Example 2:
     *
     * Input: haystack = "leetcode", needle = "leeto"
     * Output: -1
     * Explanation: "leeto" did not occur in "leetcode", so we return -1.
     *
     *
     * Constraints:
     *
     * 1 <= haystack.length, needle.length <= 104
     * haystack and needle consist of only lowercase English characters.
     */
    fun strStr(haystack: String, needle: String): Int {
        // firstOccurrenceIndex = -1
        // firstOccurrenceIndex = haystack.indexOf(needle)



        // return firstOccurrenceIndex
        return haystack.indexOf(needle)
    }



















    /**
     * https://leetcode.com/problems/remove-element
     * 27. Remove Element
     * Easy
     * 1.3K
     * 1.8K
     * Companies
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
     *
     * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
     *
     * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
     * Return k.
     * Custom Judge:
     *
     * The judge will test your solution with the following code:
     *
     * int[] nums = [...]; // Input array
     * int val = ...; // Value to remove
     * int[] expectedNums = [...]; // The expected answer with correct length.
     *                             // It is sorted with no values equaling val.
     *
     * int k = removeElement(nums, val); // Calls your implementation
     *
     * assert k == expectedNums.length;
     * sort(nums, 0, k); // Sort the first k elements of nums
     * for (int i = 0; i < actualLength; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * If all assertions pass, then your solution will be accepted.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [3,2,2,3], val = 3
     * Output: 2, nums = [2,2,_,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 2.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * Example 2:
     *
     * Input: nums = [0,1,2,2,3,0,4,2], val = 2
     * Output: 5, nums = [0,1,4,0,3,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
     * Note that the five elements can be returned in any order.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     *
     * Constraints:
     *
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {

        nums?.filter { num ->
            num != `val`
        }?.let {
            it.forEachIndexed{ index, num ->
                nums[index] = num
            }
            return it.size
        }
        return 0
    }




















    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array
     * 26. Remove Duplicates from Sorted Array
     * Easy
     * 12.8K
     * 16.9K
     * Companies
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
     *
     * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     *
     * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
     * Return k.
     * Custom Judge:
     *
     * The judge will test your solution with the following code:
     *
     * int[] nums = [...]; // Input array
     * int[] expectedNums = [...]; // The expected answer with correct length
     *
     * int k = removeDuplicates(nums); // Calls your implementation
     *
     * assert k == expectedNums.length;
     * for (int i = 0; i < k; i++) {
     *     assert nums[i] == expectedNums[i];
     * }
     * If all assertions pass, then your solution will be accepted.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     * Example 2:
     *
     * Input: nums = [0,0,1,1,1,2,2,3,3,4]
     * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
     * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     *
     *
     * Constraints:
     *
     * 1 <= nums.length <= 3 * 104
     * -100 <= nums[i] <= 100
     * nums is sorted in non-decreasing order.
     */
    fun removeDuplicates(nums: IntArray): Int {
        val numsDistinct = nums.distinct()
        nums.distinct().let {
            it.forEachIndexed { index, value ->
                nums[index] = value
            }
            return it.size
        }
        return 0
        // var currentIndex = 0
        // var max = nums.size - 1
        // var prevNum: Int? = null
        // var distinctNums = intArrayOf(nums.)
        // // val indicesToRemove = mutableListOf<Int>()
        // for ((numIndex, num) in nums.withIndex()) {
        //     if (prevNum != null) {
        //         if (num == prevNum) {
        //             nums.remove(num)
        //             // indicesToRemove.add(num)
        //         }
        //     }
        //     prevNum = num
        // }
        // // for (indexToRemove in indicesToRemove) {
        // //     nums.remove(indexToRemove)
        // // }
        // return numsDistinct.size
    }




















    /**
     * https://leetcode.com/problems/merge-two-sorted-lists
     * 21. Merge Two Sorted Lists
     * Easy
     * 20.2K
     * 1.9K
     * Companies
     * You are given the heads of two sorted linked lists list1 and list2.
     *
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     *
     * Return the head of the merged linked list.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: list1 = [1,2,4], list2 = [1,3,4]
     * Output: [1,1,2,3,4,4]
     * Example 2:
     *
     * Input: list1 = [], list2 = []
     * Output: []
     * Example 3:
     *
     * Input: list1 = [], list2 = [0]
     * Output: [0]
     *
     *
     * Constraints:
     *
     * The number of nodes in both lists is in the range [0, 50].
     * -100 <= Node.val <= 100
     * Both list1 and list2 are sorted in non-decreasing order.
     *
     * Example:
     * var li = ListNode(5)
     * var v = li.`val`
     * Definition for singly-linked list.
     * class ListNode(var `val`: Int) {
     *     var next: ListNode? = null
     * }
     */
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var mergedListNode = ListNode(0)
        var l1 = list1
        var l2 = list2
        var current: ListNode? = mergedListNode
        while (l1 != null && l2 != null) {
            if (l1.`val` < l2.`val`) {
                current?.next = l1
                l1 = l1.next
            } else {
                current?.next = l2
                l2 = l2.next
            }
            current = current?.next
        }
        //If one list shorter than the other, link the rest of the longer list here
        if (l1 != null) current?.next = l1
        if (l2 != null) current?.next = l2
        // var currentList1Node: ListNode? = list1
        // var currentList2Node: ListNode? = list2
        // while (currentList1Node != null || currentList2Node != null) {
        //     currentList1Node?.let { node1 ->
        //         if (mergedListNode == null) {    //Init
        //             mergedListNode = node1
        //         } else {
        //             mergedListNode.next =
        //         }
        //     }
        // }
        return mergedListNode.next
    }




















    /**
     * https://leetcode.com/problems/valid-parentheses
     * 20. Valid Parentheses
     * Easy
     * 22.2K
     * 1.5K
     * Companies
     * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
     *
     * An input string is valid if:
     *
     * Open brackets must be closed by the same type of brackets.
     * Open brackets must be closed in the correct order.
     * Every close bracket has a corresponding open bracket of the same type.
     *
     *
     * Example 1:
     *
     * Input: s = "()"
     * Output: true
     * Example 2:
     *
     * Input: s = "()[]{}"
     * Output: true
     * Example 3:
     *
     * Input: s = "(]"
     * Output: false
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 104
     * s consists of parentheses only '()[]{}'.
     */
    fun isValid(s: String): Boolean {
        var length = 0
        var stringToProcess = s
        while (length != stringToProcess.length) {
            length = stringToProcess.length
            stringToProcess = stringToProcess.replace("()", "")
                .replace("{}", "")
                .replace("[]", "")
        }
        return stringToProcess.isEmpty()
        //     val closureMap = mapOf<String, String> (
        //         "(" to ")",
        //         "[" to "]",
        //         "{" to "}",
        //     )


        //     //Closures must be in order.  Can only close most recent opened.


        //     // var expectedClosures = mutableListOf<String>()
        //     var expectedClosureStack = Stack<String>()

        //     for (character in s) {
        //         // println("character $character processing...")
        //         val charAsString = character.toString()
        //         val charIsOpener = closureMap.keys.contains(charAsString)
        //         val charIsCloser = closureMap.values.contains(charAsString)
        //         // println("character $character charIsOpener? $charIsOpener, charIsCloser? $charIsCloser")

        //         if (charIsOpener) {
        //             val expectedClosure = closureMap[charAsString]
        //             if (expectedClosure == null) {
        //                 // println("expectedClosure == null for $character, invalid!")
        //                 return false
        //             } else {
        //                 // println("character $character is opener, expectedClosure: $expectedClosure, pushing to stack")
        //                 expectedClosureStack.push(expectedClosure)

        //             }
        //         } else if (charIsCloser) {
        //             if (expectedClosureStack.size < 1) {
        //                 return false
        //             }
        //             val nextExpectedClosure = expectedClosureStack.pop()
        //             // println("character $character is closer, nextExpectedClosure: $nextExpectedClosure")
        //             if (nextExpectedClosure == charAsString) {
        //                 // println("nextExpectedClosure matches charAsString, valid.")
        //             } else {
        //                 // println("nextExpectedClosure does not match charAsString, invalid!")
        //                 return false
        //             }
        //         }
        //     }

        //     //Here, if any remain in the stack, they are unclosed and this is invalid
        //     if (expectedClosureStack.size == 0) {
        //         return true
        //     } else {
        //         // println("expectedClosureStack.size was not 0: ${expectedClosureStack.size}, fail")
        //         return false
        //     }
    }















    /**
     * https://leetcode.com/problems/longest-common-prefix
     * 14. Longest Common Prefix
     * Easy
     * 16K
     * 4.2K
     * Companies
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * If there is no common prefix, return an empty string "".
     *
     *
     *
     * Example 1:
     *
     * Input: strs = ["flower","flow","flight"]
     * Output: "fl"
     * Example 2:
     *
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     *
     * Constraints:
     *
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lowercase English letters.
     */
    fun longestCommonPrefix(strs: Array<String>): String {
        val firstString = strs[0]
        firstString.forEachIndexed { index, character ->
            if (strs.any { it.length == index || it[index] != character }) return firstString.take(index)
        }
        return firstString
        // var commonPrefix = ""
        // if (strs.size === 1) {
        //     commonPrefix = strs[0]
        // } else if (strs.size > 1) {
        //     var currentPrefixChar: Char? = null
        //     var shortestStrLength: Int = strs[0].length
        //     var charIndex = -1
        //     while (++charIndex < shortestStrLength) {
        //         // println("Processing character $charIndex")
        //         if (currentPrefixChar != null) {    //Just found another common prefix char
        //             commonPrefix += currentPrefixChar
        //         }
        //         currentPrefixChar = null
        //         for (str in strs) {
        //             if (str.isEmpty()) {
        //                 return ""
        //              }
        //             // println("Processing str $str character $charIndex")
        //             if (str.length < shortestStrLength) {
        //                 shortestStrLength = str.length
        //                 // println("shortestStrLength updated to $shortestStrLength")
        //             }
        //             val currentChar = str.toCharArray()[charIndex]
        //             if (currentPrefixChar == null) {
        //                 currentPrefixChar = currentChar
        //             } else {
        //                 if (currentPrefixChar != currentChar) {
        //                     currentPrefixChar = null
        //                     shortestStrLength = charIndex   //will end the while loop
        //                     break;
        //                 }
        //             }
        //             // println("currentChar is now $currentChar")
        //         }
        //     }
        //     if (currentPrefixChar != null) {     //We have one more waiting to be added
        //         commonPrefix += currentPrefixChar
        //     }
        // }
        // return commonPrefix
    }












    /**
     * https://leetcode.com/problems/roman-to-integer
     * 13. Roman to Integer
     * Easy
     * 12.5K
     * 737
     * Companies
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "III"
     * Output: 3
     * Explanation: III = 3.
     * Example 2:
     *
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     * Example 3:
     *
     * Input: s = "MCMXCIV"
     * Output: 1994
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     *
     *
     * Constraints:
     *
     * 1 <= s.length <= 15
     * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     */
    private val roman = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )
    fun romanToInt(s: String): Int {
        val strTrimmed = s.trim()
        if (s.isEmpty() || s.any { it !in roman.keys }) return -1
        var result = 0
        var prevValue = roman.getValue(strTrimmed.first())
        for (numeral in strTrimmed) {
            val newValue = roman.getValue(numeral)
            if (prevValue < newValue) result -= 2 * prevValue
            result += newValue
            prevValue = newValue
        }
        return result
    }
    //     var prevNumeral: RomanNumerals? = null    //For subtraction checking
    //     var total = 0
    //     for (numeral in s.toCharArray()) {
    //         val romanNumeral = enumValueOf<RomanNumerals>(numeral.toString())
    //         val romanNumeralValue = romanNumeral.value
    //         total += romanNumeralValue
    //         // println("Roman Numeral value for $numeral is $romanNumeralValue, added to total = $total")
    //         prevNumeral?.let { prevNumeralNonNull ->
    //             val toSubtract = when(prevNumeralNonNull) {
    //                 RomanNumerals.I -> {
    //                     when(romanNumeral) {
    //                         RomanNumerals.V,
    //                         RomanNumerals.X -> { prevNumeralNonNull.value * 2 }
    //                         else -> { 0 }
    //                     }
    //                 }
    //                 RomanNumerals.X -> {
    //                     when(romanNumeral) {
    //                         RomanNumerals.L,
    //                         RomanNumerals.C -> { prevNumeralNonNull.value * 2 }
    //                         else -> { 0 }
    //                     }
    //                 }
    //                 RomanNumerals.C -> {
    //                     when(romanNumeral) {
    //                         RomanNumerals.D,
    //                         RomanNumerals.M -> { prevNumeralNonNull.value * 2 }
    //                         else -> { 0 }
    //                     }
    //                 }
    //                 else -> { 0 }
    //             }
    //             total -= toSubtract
    //             // println("Prev Roman Numeral  ${prevNumeralNonNull.name} resulted in toSubtract of $toSubtract, total is now $total")
    //         }

    //         prevNumeral = romanNumeral
    //     }
    //     // print("Total is calculated to be $total")
    //     return total
    // }

    // enum class RomanNumerals(val value: Int) {
    //     I(1),
    //     V(5),
    //     X(10),
    //     L(50),
    //     C(100),
    //     D(500),
    //     M(1000),
    // }






















    /**
     * https://leetcode.com/problems/palindrome-number
     * 9. Palindrome Number
     * Easy
     * 11.2K
     * 2.6K
     * Companies
     * Given an integer x, return true if x is a
     * palindrome
     * , and false otherwise.
     *
     *
     *
     * Example 1:
     *
     * Input: x = 121
     * Output: true
     * Explanation: 121 reads as 121 from left to right and from right to left.
     * Example 2:
     *
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
     * Example 3:
     *
     * Input: x = 10
     * Output: false
     * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
     *
     *
     * Constraints:
     *
     * -231 <= x <= 231 - 1
     *
     *
     * Follow up: Could you solve it without converting the integer to a string?
     */
    fun isPalindrome(x: Int): Boolean {

        //Brute convert to string and compare
        // val numStringForwards = x.toString()
        // // println("forwards:" + numStringForwards)
        // val numStringBackwards = x.toString().reversed()
        // // println("backwards:" + numStringBackwards)
        // return numStringForwards == numStringBackwards


        //Two pointer method
        if (x < 0) return false
        val num = x.toString()
        var start = 0
        var end = num.length - 1

        while (start < end) {
            if (num[start] != num[end]) {
                return false
            }
            start++
            end--
        }

        return true
    }






















    /**
     * https://leetcode.com/problems/two-sum
     * 1. Two Sum
     * Easy
     * 52.1K
     * 1.7K
     * Companies
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     *
     * You can return the answer in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: [1,2]
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: [0,1]
     *
     *
     * Constraints:
     *
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     *
     *
     * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
     */
    fun twoSum(nums: IntArray, target: Int): IntArray {
        //T/S = O(n^2) / O(1)
        // for ((num1Index, num1) in nums.withIndex()) {
        //     for ((num2Index, num2) in nums.withIndex()) {
        //         if (num1Index != num2Index) {
        //             if (num1 + num2 == target){
        //                 return intArrayOf(num1Index, num2Index)
        //             }
        //         }
        //     }
        // }
        // return intArrayOf()

        val seenValuesMap = mutableMapOf<Int, Int>()
        for ((num1Index, num1) in nums.withIndex()) {
            val neededValue = target - num1
            val neededIndexFromMap = seenValuesMap[neededValue]
            if (neededIndexFromMap != null) {
                //found it!
                return intArrayOf(num1Index, neededIndexFromMap)
            } else {
                //Not yet, just keep populating the map
                seenValuesMap.put(num1, num1Index)
            }
        }
        return intArrayOf()
    }

}