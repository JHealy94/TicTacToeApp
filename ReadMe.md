## Tic Tac Toe App

### About
The app is a basic player against player TicTacToe app developed on Android Studio utilizing Kotlin.

### Requirements
In order to run the app you need android studio and a machine with an intel processor to be able to run the android virtual machine or an android device which at minimum has android version 4.0.3 (android api level 15).

### Implementation
The app consists of two screens a title screen and the board itself. the title screen just has a text giving the title and a button that when pressed loads the game board and loads the game logic. The game board has two texts that display the wins, a reset button, and a grid of 9 buttons that when pressed will display corresponding symbol. When a winstate is achieved the corresponding text of wins will increment by one, a toast will appear stating who won, the board is frozen until reset is clicked, and the winning triplet is made green. Then in the instance of a draw a toast states draw and the board is frozen until reset is clicked. The game logic is put into a class to allow for easier implementations of alternate game modes.