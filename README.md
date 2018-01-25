# Mastermind
The board game mastermind implemented using java (OOP).
In the GameConfiguartion.java, the number of guesses a user gets, the colors a user can guess and the length of the code (pegNumber) can be modified.


In this text version of mastermind, the computer generates a random secret code which are different color pegs. For example,  the pegNumber is 4 so the secret code could be BBRG (Blue, Blue, Red, Green).
This game can be run on test mode by passing the argument 1 when running the Driver.java or game mode by passing the argument 0. If the program runs in test mode the game will display the random secret code generated. 
The program first starts off with user being asked if they want to play a game. If the user responds with yes then the game begins if no the program terminates. Once the game begins, the computer displays how many guesses the user has and the user is prompted to guess. If the user types in an invalid guess, an error will be displayed and the user will be asked to enter another guess. If a valid guess is made,feedback will be given in the form of number of black pegs and number of white pegs. Black pegs indicate one of your guesses was in the correct spot and the correct color, while white pegs indicate one of your guesses is the right color but in the wrong spot. For example, the user guesses ROOP when the secret code is RBPG. The feedback provided will be 1 black peg as the R is in the correct positon and the correct color and 1 white peg as the P is the correct color but wrong position. Based off this feedback, the user will have a better chance to guess the secret code generated. The user is also allowed to type HISTORY as a guess and all previous guesses with their feedback will be displayed. After each game, the user has the option of playing again or quitting. 

Testing mode on: 

<img width="374" alt="testing mode on" src="https://user-images.githubusercontent.com/19617642/35414807-3c14b142-01e9-11e8-8559-19a98eef868d.png">

Testing mode off: 

<img width="326" alt="testing mode off" src="https://user-images.githubusercontent.com/19617642/35414903-7f363c0c-01e9-11e8-82f4-0add8274c46e.png">

Invalid guess: 

<img width="233" alt="invalid guess" src="https://user-images.githubusercontent.com/19617642/35414920-8d36661a-01e9-11e8-94c8-366011fae7b2.png">

Win: 

<img width="300" alt="win" src="https://user-images.githubusercontent.com/19617642/35414935-9932e056-01e9-11e8-9d3b-76c4a810a6c0.png">

History and lose:

<img width="296" alt="history and lose" src="https://user-images.githubusercontent.com/19617642/35414953-a482a5ea-01e9-11e8-931f-ae085a37d478.png">


