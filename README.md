# TankStars

A version of the tank stars game made on LibGDX, coded in Java, by Viviana Longjam and Siddharth Rajput.

## Description of The Game

This is the LibGDX version of the TankStars game, which executes its basic functions and gameplay. The game allows two players to play turn by turn, starting by choosing their tanks and then moving, aiming and firing at their opponent's tank to decrease their health. The game is won when one player is defeated by reducing their health to zero. TankStars games involves the features of pausing, resuming and restarting a game at any given time, and also saving the current game (such that all the current data related to health, fuel, positions etc. is saved) so that it can be played later. 

This project involves the major concepts of Object Oriented Programming, with relation between classes, their objects and functions being implemented. Serialization has been implemented to save and store the games, as well as concepts of design patterns (eg. Singleton class used in Ground, iterator used) and JUnit testing.


## Screens and Entities made in Java

The screens made for the game to function are:
- `MainMenuScreen.java`: The main menu is the start of the game, and provides three options: `New Game`, `Resume` and `Exit`. `New Game` starts a fresh game for two players to play from the beginning, which directs us to the `ChooseTankScreen.java` screen. `Resume` displays games paused and saved in the past which can be continued from the point both players left it (meaning all their stats such as fuel or health and their positions would be saved). `Exit` quits the program.

- `ChooseTankScreen.java`: This screen allows the players to select one of the three available tanks (Toxic, Abrams and Helios), by navigating on the left/right buttons on the screen. Player 1 selects their tank first by clicking "Choose", followed by Player 2. The game is played with their respective chosen tanks.

- `PlayGameScreen.java`: This is the main gameplay portion of TankStars, which allows the players to play the game against each other. The game proceeds in turns, starting from Player 1. Each player is allowed to aim (by using up and down arrow keys in the keyboard, rotating the angle and hence the trajectory of their projectile) and move in their respective turns (using left and right keys). The player can only move till their fuel remains for that turn (resetting the fuel to full after every turn) and no further movement would take place even on pressing the appropriate keys if fuel is finished. The player can then fire, trying to hit the opponent's tank. Hitting the opponent's tank damages the other player's health (reducing their health bar), and can shift the tank to a distance depending on the impact of the hit. The game continues until one of the players wins by fully reducing the other player's health to zero.

- `PauseGameScreen.java`: The game can be paused in between, directing to this screen. The players can have the option of `Resume` to go back to their game and continue, `Save Game` to save the current status of the game and resume it later (which can be viewed and continued later from `SavedGamesScreen.java`), `Restart` to start over with a new game (which directs to `ChooseTankScreen.java`), and `Exit` to quit the program.

- `Player1VictoryScreen.java`: After the game is finished, this page gets displayed in case Player 1 wins. The user has the option here to `Restart` or `Exit`.

- `Player2VictoryScreen.java`: After the game is finished, this page gets displayed in case Player 2 wins. The user has the option here to `Restart` or `Exit`.

- `SavedGamesScreen.java`: This screen displays all the games played, left somewhere in between and previously saved. You can select one of the games to continue, or go back to previous screen.

The entities in the game are:
- `Ground.java`: The Ground Class is implemented here, as a singleton class so that only one instance is allowed.

- `Player.java`: The Player Class sets the tanks for the players, keeps a tab on their fuel and health (attributes), and has functions to change its location in case the tank is hit, to refill fuel, to decrease health etc.

- `Weapon.java`: The Weapon class initialises the bullet and keeps a track of the power and aim of the bullet to be fired. 

## How to play the game

The game can be played by downloading the code and running it on LibGDX. The main file to be run is `TankStars.java`.

### Rules:
- Press `SPACEBAR` to fire a bullet.
- Press `LEFT` and `RIGHT` arrow keys to move the tank.
- Press `UP` and `DOWN` arrow keys to aim the angle of the bullet.
- Press `A` and `D` to set the power of the bullet.


## References
Image Sources for backgrounds:
- https://mir-s3-cdn-cf.behance.net/project_modules/fs/d932c465333621.5af0ea8ca355a.png
- https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/a439b065333621.5af0ea8ca23f5.png
- screenshot of main screen from original game
