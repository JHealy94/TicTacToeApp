package com.example.tictactoelaptop

import kotlin.Pair as Pair

class Game{
    //keeps track of whose turn it is
    private var turnCount = 0
    //create 2 lists that keep track of the players plays
    private var playerX = mutableListOf<Int>()
    private var playerO = mutableListOf<Int>()
    //create an array of lists of all possible win states
    private val win1 = listOf(0,1,2)
    private val win2 = listOf(3,4,5)
    private val win3 = listOf(6,7,8)
    private val win4 = listOf(0,3,6)
    private val win5 = listOf(1,4,7)
    private val win6 = listOf(2,5,8)
    private val win7 = listOf(0,4,8)
    private val win8 = listOf(2,4,6)
    private val winStates = arrayOf(win1,win2,win3,win4,win5,win6,win7,win8)

    fun turn (position: String): Triple<Int, String, List<Int>> {
        val pos = Integer.parseInt(position)
        var text = " "
        var state = 0
        var winPositions = mutableListOf<Int>()
        //see if the position has already been used otherwise add position to corresponding player and switch turn
        if(playerO.contains(pos)){
            text = "O"
        }
        else if(playerX.contains(pos)){
            text = "X"
        }
        else if(turnCount % 2 == 0){
            text="X"
            playerX.add(pos)
            turnCount++
        }
        else{
            text="O"
            playerO.add(pos)
            turnCount++
        }
        //checks for win conditions
        for(win in winStates){
            if (playerO.containsAll(win)) {
                state = 2
                winPositions = win as MutableList<Int>
            }
            else if(playerX.containsAll(win)) {
                state = 1
                winPositions = win as MutableList<Int>
            }
        }
        //checks to see if it is a draw
        if (turnCount == 9 && state == 0){
            state = 3
        }

        return Triple(state, text, winPositions)

    }



}