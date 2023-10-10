package com.chrisprime.sandbox.challenges

import android.util.Log
import kotlin.math.max
import kotlin.math.sqrt

object IncludedHealth {

    fun testGreaterOnRightSide(intArray: IntArray, n: Int) {
        val origIntArray = intArray.copyOf()
        nextGreatestON(intArray, n)
        Log.d("sandboxlog", "nextGreatest(${origIntArray.asList()}, count $n) is ==> ${intArray.asList()}")
    }

    fun runChallenges() {
        val docsAvailAt12 = doctorScheduleAvailableAtTime(12)
        Log.d("sandboxlog", "docsAvailAt12 = $docsAvailAt12")

        val docsWithMostAvailHours = doctorsWithMostAvailableHours()
        Log.d("sandboxlog", "docsWithMostAvailHours = $docsWithMostAvailHours")

        val docsAvailsByHour = doctorsAvailabilityByHour()
        Log.d("sandboxlog", "docsAvailsByHour = $docsAvailsByHour")

        val closestDoctorsToLoc5_5 = closestDoctorsToGivenLocation(5, 5)
        Log.d("sandboxlog", "closestDoctorsToLoc5_5 = $closestDoctorsToLoc5_5")

        val closestDoctorsToLoc99_20 = closestDoctorsToGivenLocation(99, 20)
        Log.d("sandboxlog", "closestDoctorsToLoc99_20 = $closestDoctorsToLoc99_20")

        val doctorsServicing5_5 = doctorsServicingLocation(5, 5)
        Log.d("sandboxlog", "doctorsServicing5_5 = $doctorsServicing5_5")

        val doctorsServicing50_50 = doctorsServicingLocation(50, 50)
        Log.d("sandboxlog", "doctorsServicing50_50 = $doctorsServicing50_50")

        val similarDoctorsGrouped = groupSimilarDoctorsBruteForceONpow2(similarDoctorsList)
        Log.d("sandboxlog", "similarDoctorsGrouped = $similarDoctorsGrouped")

        testGreaterOnRightSide(intArrayOf(16, 17, 4, 3, 5, 2), 6)
        testGreaterOnRightSide(intArrayOf(2, 3, 1, 9), 4)


        val testRover1 = Rover(
            5,
            5,
            1,
            2,
            CardinalDirection.NORTH
        )
        testRover1.controlRover("LMLMLMLMM")
        Log.d("sandboxlog", "testRover1.controlRover(\"LMLMLMLMM\") status: $testRover1")


        val testRover2 = Rover(
            5,
            5,
            3,
            3,
            CardinalDirection.EAST
        )
        testRover2.controlRover("MMRMMRMRRM")
        Log.d("sandboxlog", "testRover2.controlRover(\"MMRMMRMRRM\") status: $testRover2")


        val lineSegmentsForTest1 = listOf(
            intArrayOf(16, 18),
            intArrayOf(6, 8),
            intArrayOf(2, 10),
            intArrayOf(20, 26),
            intArrayOf(5, 14),
            intArrayOf(25, 30),
            intArrayOf(21, 24),
        )
        val combinedLineSegmentsTest1 = combineLineSegments(lineSegmentsForTest1)
        Log.d("sandboxlog", "combinedLineSegmentsTest1: combineLineSegments(${listOfIntArraysToString(lineSegmentsForTest1)}) = ${listOfIntArraysToString(combinedLineSegmentsTest1)}")


        val boggleBoardTest1 = arrayOf(
            arrayOf('a', 'b', 'c'),
            arrayOf('d', 'e', 'f'),
            arrayOf('g', 'h', 'i')
        )
        val boggleWordsTest1 = listOf(
            "bad",
            "bed",
            "dab",
            "head",
            "dad",
            "had",
        )
        val boggledBoardWordsTest1 = boggle(
            boggleBoard = boggleBoardTest1,
            words = boggleWordsTest1
        )
        Log.d("sandboxlog", "boggledBoardTest1: boggle(${listOfArraysToString(boggleBoardTest1)}, ${boggleWordsTest1}) = $boggledBoardWordsTest1")


        val largestPalindromeTest1 = LargestPalindrome.largestPalindrome("abczyx")
        val largestPalindromeTest2 = LargestPalindrome.largestPalindrome("bbaac")
        val largestPalindromeTest3 = LargestPalindrome.largestPalindrome("aabbcc")
        val largestPalindromeTest4 = LargestPalindrome.largestPalindrome("bbbbbaac")





        // unit tests:
        val doctor7vs10zipsSimilar = areIntsSimilar(
            similarDoctorsList.find { it.id == 7 }!!.zipCode,
            similarDoctorsList.find { it.id == 10 }!!.zipCode
        )
//        Log.d("sandboxlog", "doctor7vs10zips = $doctor7vs10zipsSimilar")

    }

    fun listOfIntArraysToString(listOfIntArray: List<IntArray>): String {
        var outputStr = "["
        for (intArr in listOfIntArray) {
            outputStr += "${intArr.asList()}, "
        }
        outputStr += "]"
        return outputStr
    }

    fun <T> listOfArraysToString(arrayOfArrays: Array<Array<T>>): String {
        var outputStr = "["
        for (anies in arrayOfArrays) {
            outputStr += "${anies.asList()}, "
        }
        outputStr += "]"
        return outputStr
    }

    val doctorAvailabilities = mapOf(
        "Matt" to listOf(intArrayOf(8,9), intArrayOf(10, 12), intArrayOf(13, 14)),
        "Belda" to listOf(intArrayOf(9,17)),
        "Wyatt" to listOf(intArrayOf(9,12), intArrayOf(15, 18)),
        "Emma" to listOf(intArrayOf(9,12)),
        "Aaron" to listOf(intArrayOf(4,11), intArrayOf(15, 24)),
        "Josh" to listOf(intArrayOf(11,12)),
        "Adrien" to listOf(intArrayOf(1,2), intArrayOf(3, 4), intArrayOf(5, 6)),
        "Andy" to listOf(intArrayOf(1,6)),
    )

//LocX, LocY, Service Area Radius
    var doctorLocationsAndServiceAreas = mapOf(
        "Matt" to intArrayOf(0,0,1),
        "Belda" to intArrayOf(9,7,10),
        "Wyatt" to intArrayOf(51,90,15),
        "Emma" to intArrayOf(100,0,0),
        "Aaron" to intArrayOf(50,50,30),
        "Josh" to intArrayOf(0,0,0),
        "Adrien" to intArrayOf(47,38,25),
        "Andy" to intArrayOf(3,99,15),
    )

    fun doctorScheduleAvailableAtTime(time: Int): List<String> {
//        Log.d("sandboxlog", "doctorScheduleAvailableAtTime($time) with doctorAvailabilities $doctorAvailabilities")
        val availableDoctors = mutableListOf<String>()
        for (doctor in doctorAvailabilities.keys) {
            doctorAvailabilities[doctor]?.let {availability ->
                for (freeTimeChunk in availability) {
                    if ((time > freeTimeChunk[0] &&
                        time < freeTimeChunk[1]) ||
                        time == freeTimeChunk[0]
                    ) {
                        availableDoctors.add(doctor)
                    }
                }
            }
        }
        return availableDoctors
    }

    /**
     * Docs with most avail hours = find max avail hours
     * return all docs with that many avail hours
     */
    fun doctorsWithMostAvailableHours(): List<String> {
//        Log.d("sandboxlog", "doctorsWithMostAvailableHours() with doctorAvailabilities $doctorAvailabilities")
        var doctorsWithMostAvailHours = mutableListOf<String>()
         val doctorsHours = mutableMapOf<String, Int>()
        var maxHoursSeen = 0
        for (doctor in doctorAvailabilities.keys) {
            var doctorAvailableHours = 0
            doctorAvailabilities[doctor]?.let {availability ->
                for (freeTimeChunk in availability) {
                    doctorAvailableHours += freeTimeChunk[1] - freeTimeChunk[0]
                }
                doctorsHours[doctor] = doctorAvailableHours
                if (doctorAvailableHours > maxHoursSeen) {
                    maxHoursSeen = doctorAvailableHours
                }
            }
        }
        doctorsWithMostAvailHours = doctorsHours.filter { (doctor, hours) -> hours == maxHoursSeen }.map { (doctor, hours) -> doctor }.toMutableList()
        return doctorsWithMostAvailHours
    }

    fun doctorsAvailabilityByHour(): Map<Int, List<String>> {
//        Log.d("sandboxlog", "doctorsAvailabilityByHour() with doctorAvailabilities $doctorAvailabilities")
        val doctorsAvailByHour = mutableMapOf<Int, List<String>>()
        for (hour in 1..24) {
            doctorsAvailByHour[hour] = doctorScheduleAvailableAtTime(hour)
        }
        return doctorsAvailByHour
    }

    fun calculateDistanceBetweenTwoPoints(
        x1: Int,
        y1: Int,
        x2: Int,
        y2: Int,
    ): Double {
        val squaredSum = ((x2 - x1) * (x2 - x1)) +
                ((y2 - y1) * (y2 - y1))
        return sqrt(squaredSum.toDouble())
    }

    fun closestDoctorsToGivenLocation(x: Int, y: Int): List<String> {
//        Log.d("sandboxlog", "closestDoctorsToGivenLocation($x, $y) with doctorLocationsAndServiceAreas $doctorLocationsAndServiceAreas")
//        var closestDoctors = mutableListOf<String>()
        val doctorsDistances = mutableMapOf<String, Double>()
        var closestDistance: Double = -1.0
        for (doctor in doctorLocationsAndServiceAreas.keys) {
            doctorLocationsAndServiceAreas[doctor]?.let { locDist ->
                doctorsDistances[doctor] = calculateDistanceBetweenTwoPoints(
                    x,
                    y,
                    locDist[0],
                    locDist[1]
                )
                doctorsDistances[doctor]?.let { distance ->
                    if (closestDistance >= 0) {
                        if (distance < closestDistance) {
                            closestDistance = distance
                        }
                    } else {
                        closestDistance = distance
                    }
                }
            }
        }
        Log.d("sandboxlog", "closestDoctorsToGivenLocation($x, $y) - closest distance is $closestDistance, filtering doctors...")
        val closestDoctors = doctorsDistances.filter { (docName, distance) -> distance == closestDistance}?.map { (doc, dist) -> doc }
        return closestDoctors ?: mutableListOf()
    }

    fun doctorsServicingLocation(x: Int, y: Int): List<String> {
        Log.d("sandboxlog", "doctorsServicingLocation($x, $y) with doctorLocationsAndServiceAreas $doctorLocationsAndServiceAreas")
        val servicingDoctors = mutableListOf<String>()
        val doctorsDistances = mutableMapOf<String, Double>()
        for (doctor in doctorLocationsAndServiceAreas.keys) {
            doctorLocationsAndServiceAreas[doctor]?.let { locDist ->
                doctorsDistances[doctor] = calculateDistanceBetweenTwoPoints(
                    x,
                    y,
                    locDist[0],
                    locDist[1]
                )
                doctorsDistances[doctor]?.let { distance ->
                    if (distance <= locDist[2]) {
                        //Within service radius!
                        servicingDoctors.add(doctor)
                    }
                }
            }
        }



        return servicingDoctors
    }






    data class DoctorEntry(
        val id: Int,
        val firstName: String,
        val lastName: String,
        val zipCode: Int,
    )

    val similarDoctorsList = listOf(
        DoctorEntry(1, "Matt", "Forbes", 88055),
        DoctorEntry(2, "Mat", "Forbse", 88055),
        DoctorEntry(3, "Matthew", "Forbes", 88555),
        DoctorEntry(4, "Gabe", "Vacaliuc", 62100),
        DoctorEntry(5, "Gabriel", "Vacaliuc", 62100),
        DoctorEntry(6, "Gabe", "Vacluc", 44144),
        DoctorEntry(7, "Steve", "Ruble", 11814),
        DoctorEntry(8, "Steve", "Rubl", 11814),
        DoctorEntry(9, "Steve", "Reptile", 11814),
        DoctorEntry(10, "Steven", "Ruble", 11841),
        DoctorEntry(11, "Stevearoni", "Rubla", 11814),
    )


    // Strings are similar if one is a prefix of the other with at most 4 chars remaining
    fun areStringsSimilar(str1: String, str2: String, maxUnmatchedChars: Int = 4): Boolean {
        val commonPrefix = str1.commonPrefixWith(str2)
        val str1UnmatchedCount = str1.length - commonPrefix.length
        val str2UnmatchedCount = str2.length - commonPrefix.length
        return (str1UnmatchedCount <= maxUnmatchedChars
                && str2UnmatchedCount <= maxUnmatchedChars)
    }

    // Ints are similar if they contain the exact same digits but in a different order
    fun areIntsSimilar(int1: Int, int2: Int): Boolean {
        var num1 = int1
        var num2 = int2
        val numArrayInt1 = mutableListOf<Int>()
        val numArrayInt2 = mutableListOf<Int>()
        if (int1 < 10 && int2 < 10) {   //If both single digits, just compare the single digits
            return int1 == int2
        }
        if (int1 < 10 || int2 < 10) {   //If one is still less than 10, they are definitely not similar
            return false
        }
        while (num1 > 0) {
            val lastDigit = num1 % 10
            numArrayInt1.add(lastDigit)
            num1 /= 10
        }
        while (num2 > 0) {
            val lastDigit = num2 % 10
            numArrayInt2.add(lastDigit)
            num2 /= 10
        }
//        Log.d("sandboxlog", "areIntsSimilar($int1, $int2): array1=$numArrayInt1, array2=$numArrayInt2")
        return if (numArrayInt1.size == numArrayInt2.size) { //Actually should list and compare digits now
            var foundAnyUnmatchedDigits = false
            for (number1 in numArrayInt1) {
                if (!numArrayInt2.contains(number1)) {
                    foundAnyUnmatchedDigits = true
                }
            }
            for (number2 in numArrayInt2) {
                if (!numArrayInt1.contains(number2)) {
                    foundAnyUnmatchedDigits = true
                }
            }
            !foundAnyUnmatchedDigits
        } else {
            false
        }
    }

    //user / dr list with similarities
    //Matching rules:
    // Strings are similar if one is a prefix of the other with at most 4 chars remaining
    // Ints are similar if they contain the exact same digits but in a different order
    //This method will just compare each to each other, o(n^2), suboptimal
    fun groupSimilarDoctorsBruteForceONpow2(doctorList: List<DoctorEntry>): List<List<Int>> {
//        Log.d("sandboxlog", "groupSimilarDoctors() with doctorList $doctorList")
        val similarDoctors = mutableListOf<MutableList<Int>>()
        for ((entryIndex, doctorEntry) in doctorList.withIndex()) {
            var hasThisDoctorBeenAdded = false
//            Log.d("sandboxlog", "groupSimilarDoctors(): ** Processing doctorEntry $doctorEntry")
            for ((otherIndex, otherDoctorEntry) in doctorList.withIndex()) {
                if (entryIndex != otherIndex) {
                    val areFirstNamesSimilar = areStringsSimilar(doctorEntry.firstName, otherDoctorEntry.firstName)
                    val areLastNamesSimilar = areStringsSimilar(doctorEntry.lastName, otherDoctorEntry.lastName)
                    val areZipCodesSimilar = areIntsSimilar(doctorEntry.zipCode, otherDoctorEntry.zipCode)
                    if (areFirstNamesSimilar && areLastNamesSimilar && areZipCodesSimilar) {
//                        Log.d("sandboxlog", "groupSimilarDoctors(${doctorEntry.id}, ${otherDoctorEntry.id}): first, last, zip similar for $doctorEntry and $otherDoctorEntry!  Checking if already a group in $similarDoctors")
                        val similarDoctorGroup = findAndAddToExistingSimilarDoctorGroup(similarDoctors, doctorEntry, otherDoctorEntry)
                        if (similarDoctorGroup == null) {
//                            Log.d("sandboxlog", "groupSimilarDoctors(${doctorEntry.id}, ${otherDoctorEntry.id}): no similarDoctorGroup, creating one for ${doctorEntry.id} and ${otherDoctorEntry.id}")
                            similarDoctors.add(mutableListOf(doctorEntry.id, otherDoctorEntry.id))
                        }
                        hasThisDoctorBeenAdded = true
                    } else {    //Not similar to anything yet, create a new similar doctors group for this guy
//                        Log.d("sandboxlog", "groupSimilarDoctors(${doctorEntry.id}, ${otherDoctorEntry.id}): no similarities found, firstNames=$areFirstNamesSimilar, lastNames=$areLastNamesSimilar, zips=$areZipCodesSimilar")
                        val similarDoctorGroup = findAndAddToExistingSimilarDoctorGroup(
                            similarDoctors,
                            doctorEntry,
                            otherDoctorEntry,
                            shouldAddDoctor = false
                        )
                        if (similarDoctorGroup == null) {
//                            Log.d("sandboxlog", "groupSimilarDoctors(${doctorEntry.id}, ${otherDoctorEntry.id}): not similar to any similarDoctorGroup, creating group for $doctorEntry")
                            similarDoctors.add(mutableListOf(doctorEntry.id))
                            hasThisDoctorBeenAdded = true
                        }
                    }
                }
            }

            if (!hasThisDoctorBeenAdded) {
//                Log.d("sandboxlog", "groupSimilarDoctors(${doctorEntry.id}): this doctor has not been added at all, possibly the last lone gunman - creating group for $doctorEntry")
                similarDoctors.add(mutableListOf(doctorEntry.id))
            }
        }
        return similarDoctors
    }

    //This solution explores Extension 1: Blocking Keys to drastically reduce the search space

    private fun findAndAddToExistingSimilarDoctorGroup(
        similarDoctors: MutableList<MutableList<Int>>,
        doctorEntry: DoctorEntry,
        otherDoctorEntry: DoctorEntry,
        shouldAddDoctor: Boolean = true,
    ): MutableList<Int>? {
//        Log.d("sandboxlog", "findAndAddToExistingSimilarDoctorGroup($doctorEntry, $otherDoctorEntry, shouldAddDoctor = $shouldAddDoctor)")
        var foundSimilarDoctorGroup: MutableList<Int>? = null
        for (similarDoctorGroup in similarDoctors) {
            if (similarDoctorGroup.contains(doctorEntry.id)
                || similarDoctorGroup.contains(otherDoctorEntry.id)) {
                foundSimilarDoctorGroup = similarDoctorGroup
                if (shouldAddDoctor) {
                    if (!similarDoctorGroup.contains(doctorEntry.id)) {
                        Log.d("sandboxlog", "findAndAddToExistingSimilarDoctorGroup(): adding doctor ${doctorEntry.id} to group $similarDoctorGroup")
                        similarDoctorGroup.add(doctorEntry.id)
                    } else if (!similarDoctorGroup.contains(otherDoctorEntry.id)) {
                        Log.d("sandboxlog", "findAndAddToExistingSimilarDoctorGroup(): adding otherDoctor ${otherDoctorEntry.id} to group $similarDoctorGroup")
                        similarDoctorGroup.add(otherDoctorEntry.id)
                    }
                }
                break
            }
        }
        return foundSimilarDoctorGroup
    }


    //https://practice.geeksforgeeks.org/problems/greater-on-right-side4305/1
    //randomly ordered int array,
    //at each index, wanna determine largest #
    // to right of that index, and put it in that index
    // (e.g. int array 1,2,3,4,5 would be replaced with 5,5,5,5,5)
    // maybe search through for largest value and plug it in
    // maybe pre-sorting array and popping off values as reach indices?
    //   can always pop value at end of array as largest?
    // no, maybe Priority Queue:
//      just stuff values in, order doesnt matter
    //  root is always gonna be largest number, so:
    //  before get value in array, remove current val at index 0,
    //  for example above the #5, always peek at the root
    //  pop off value at current index and peek at root,
//          gives log n solution
    //          because removing op is o(log(n)) and peeking is o(n)
    /* Function to replace every element with the
	next greatest element */
    /**
     * You are given an array Arr of size N. Replace every element with the next greatest element
     * (greatest element on its right side) in the array. Also, since there is no element
     * next to the last element, replace it with -1.
     */

    //Below implementation is O(n^2) time, O(1) space
    fun nextGreatestONpow2(arr: IntArray?, n: Int) {
        arr?.let {
            for (i in 0 until n) {
                var maxVal = -1
                for (j in i + 1 until n) {
                    maxVal = max(maxVal, it[j])
                }
                it[i] = maxVal
            }
        }
    }

    //Below uses single traversal, O(n) time O(1) space
    fun nextGreatestON(arr: IntArray?, n: Int) {
        arr?.let {
            var maxFromRight = it[n - 1]  //Initialize the next greatest element
            it[n - 1] = -1    //The last element is always transformed to -1
            for (i in n - 2 downTo 0) {
                val current = it[i] //Store current element, needed later for updating the next greatest element
                it[i] = maxFromRight //Replace current element with next greatest
                if (maxFromRight < current) { //Updated the greatest element, if needed
                    maxFromRight = current
                }
            }
        }
    }

    //Below is Priority Queue implementation if I have time:















    //========================================Combining Line Segments
    //sort by first num, iterate thru and combine = ONLogN time
    fun combineLineSegments(segments: List<IntArray>): List<IntArray> {
        var combinedLineSegments = mutableListOf<IntArray>()

        //sort by first num
        val sortedSegments = segments.sortedBy { it[0] }
//        Log.d("sandboxlog", "combineLineSegments() sorted segments: ${listOfIntArraysToString(sortedSegments)}")

        //iterate thru and combine on the way up
        var combinedLineStartCoordinate: Int? = null
        var combinedLineEndCoordinate: Int? = null
        for (segment in sortedSegments) {
            val lineSegmentStart = segment[0]
            val lineSegmentEnd = segment[1]
            if (combinedLineEndCoordinate == null) {
                combinedLineEndCoordinate = lineSegmentEnd
            }
            if (combinedLineStartCoordinate == null) {  //First segment
                combinedLineStartCoordinate = lineSegmentStart

            } else {    //Not the first segment
                if (lineSegmentStart <= combinedLineEndCoordinate) {
                    if (lineSegmentEnd > combinedLineEndCoordinate) { //Combine
                        combinedLineEndCoordinate = lineSegmentEnd
                    }
                } else if (lineSegmentStart > combinedLineEndCoordinate) { //Store, start new segment
                    combinedLineSegments.add(intArrayOf(combinedLineStartCoordinate, combinedLineEndCoordinate))
                    combinedLineStartCoordinate = lineSegmentStart
                    combinedLineEndCoordinate = lineSegmentEnd
                }
            }

        }
        //Now, store the last line segment we were in the middle of combining:
        if (combinedLineStartCoordinate != null && combinedLineEndCoordinate != null) {
            combinedLineSegments.add(
                intArrayOf(
                    combinedLineStartCoordinate,
                    combinedLineEndCoordinate
                )
            )
        }




        return combinedLineSegments
    }












    //======================================Boggle
    val boggleDirections = mapOf(
        "NORTHWEST" to  intArrayOf(-1, -1),
        "NORTH" to      intArrayOf( 0, -1),
        "NORTHEAST" to  intArrayOf( 1, -1),
        "EAST" to       intArrayOf( 1,  0),
        "SOUTHEAST" to  intArrayOf( 1,  1),
        "SOUTH" to      intArrayOf( 0,  1),
        "SOUTHWEST" to  intArrayOf(-1,  1),
        "WEST" to       intArrayOf(-1,  0)
    )

    fun boggleLetterHunt(
        boggleBoard: Array<Array<Char>>,
        letter: Char,
        currentCoordinates: IntArray,
        usedTiles: List<IntArray>
    ): IntArray? {
        for (direction in boggleDirections.keys) {  //Check all 8 valid directions
            val directionCoordinates = boggleDirections[direction]
            directionCoordinates?.let {
                var peekCoordinates = intArrayOf(
                    currentCoordinates[0] + it[0],
                    currentCoordinates[1] + it[1]
                )
                if (peekCoordinates[0] >= 0 && peekCoordinates[1] >= 0
                    && boggleBoard.size > peekCoordinates[1]
                    && boggleBoard[0].size > peekCoordinates[0]) {
                    if (boggleBoard[peekCoordinates[0]][peekCoordinates[1]] == letter) {
                        //Before returning, check if returned coordinates already exist in our wordpath's used tiles - we cannot use the same tile twice!

                        if (!usedTiles.contains(peekCoordinates)) {
                            return peekCoordinates
                        }
                    }
                }
            }
        }
        return null
    }

    fun boggleWordHunt(
        boggleBoard: Array<Array<Char>>,
        word: String,
        startCoordinates: IntArray,
    ): List<IntArray> {
        val wordPath = mutableListOf<IntArray>()
        var currentCoordinates = startCoordinates
        var firstLetter = true
        for (letter in word.toCharArray()) {
            if (firstLetter) {
                firstLetter = false
            } else {
                val letterHuntResult = boggleLetterHunt(
                    boggleBoard,
                    letter,
                    currentCoordinates,
                    wordPath
                )
                if (letterHuntResult == null) {
                    return listOf()
                } else {
                    wordPath.add(letterHuntResult)
                    currentCoordinates = letterHuntResult
                }
            }
        }

        return wordPath
    }
    fun boggle(
        boggleBoard: Array<Array<Char>>,
        words: List<String>,
    ): List<String> {
        var boggledWords = mutableListOf<String>()

        for (word in words) {    //Word search!
            val boggledWordResult = boggleFindWord(word, boggleBoard)
            if (boggledWordResult != null) {
                boggledWords.add(word)
            }
        }
        return boggledWords
    }

    private fun boggleFindWord(
        word: String,
        boggleBoard: Array<Array<Char>>,
    ): List<IntArray>? {
        for (wordChar in word.toCharArray()) {   //Letter search!

            //Step 1: locate (each) instance of the first letter
            for ((boggleBoardYIndex, boggleBoardYArray) in boggleBoard.withIndex()) {
                for ((boggleBoardXIndex, boggleBoardChar) in boggleBoardYArray.withIndex()) {
                    if (boggleBoardChar == wordChar) {

                        //Step 2: search the 8 valid directions in the array for the next char
                        val boggleHuntResult = boggleWordHunt(
                            boggleBoard,
                            word,
                            intArrayOf(boggleBoardXIndex, boggleBoardYIndex)
                        )


                        if (boggleHuntResult != null) {
                            return boggleHuntResult
                        }
                    }
                }
            }

            //Step 3: Rinse and repeat until the end of the word

            //Step 4: If reached end of word, found all letters, shove into boggledWords list

        }
        return null
    }


    //=============================================Rover control
    enum class CardinalDirection{
        NORTH,
        EAST,
        SOUTH,
        WEST,
    }

    //Map of directions to their left and right turn results as a pair
    val cardinalDirectionTurns = mapOf(
        CardinalDirection.NORTH to arrayOf(CardinalDirection.WEST, CardinalDirection.EAST),
        CardinalDirection.EAST to arrayOf(CardinalDirection.NORTH, CardinalDirection.SOUTH),
        CardinalDirection.SOUTH to arrayOf(CardinalDirection.EAST, CardinalDirection.WEST),
        CardinalDirection.WEST to arrayOf(CardinalDirection.SOUTH, CardinalDirection.NORTH)
    )

    val turnDirectionIndices = mapOf(
        'L' to 0,
        'R' to 1
    )

    //This assumes (0,0) is lower left (southwest corner)
    // and (gridSize, gridSize) is upper right (northeast corner)
    // and contains an array of (x, y) modifiers to be added to position variables
    val moveDirectionCoordinateModifiers = mapOf(
        CardinalDirection.NORTH to arrayOf(0, 1),
        CardinalDirection.EAST to arrayOf(1, 0),
        CardinalDirection.SOUTH to arrayOf(0, -1),
        CardinalDirection.WEST to arrayOf(-1, 0)
    )

    data class Rover(
        val gridSizeX: Int,
        val gridSizeY: Int,
        var posX: Int = 0,
        var posY: Int = 0,
        var direction: CardinalDirection = CardinalDirection.NORTH,
        val gridEdgesStopRover: Boolean = true,
    ) {
        fun controlRover(controls: String?): Boolean {
            var controlled = false
            controls?.let {
                for (control in controls.uppercase().toCharArray()) {
                    //Return true if even one command is accepted
                    controlled = controlRover(control) or controlled    //bitwise OR
                }
            }
            return controlled
        }

        fun controlRover(control: Char) = when (control) {
                'L', 'R' -> turn(control)
                'M' -> move()
                else -> false
            }

        fun turn(leftOrRight: Char): Boolean {
            var turned = false
            val turnDirectionIndices = turnDirectionIndices[leftOrRight]
            cardinalDirectionTurns[direction]?.let {
                if (turnDirectionIndices != null) {
                    direction = it[turnDirectionIndices]
                    turned = true
                }
            }
            return turned
        }
        fun move(): Boolean {
            // don't move if facing edge of grid, check gridsize / dir / pos
            var moved = false
            if (gridEdgesStopRover) {
                when (direction) {
                    CardinalDirection.NORTH -> if (posY == gridSizeY) return moved
                    CardinalDirection.EAST -> if (posX == gridSizeX) return moved
                    CardinalDirection.SOUTH -> if (posY == 0) return moved
                    CardinalDirection.WEST -> if (posX == 0) return moved
                }
            }
            moveDirectionCoordinateModifiers[direction]?.let {
                posX += it[0]
                posY += it[1]
                moved = true
            }
            return moved
        }
    }
}