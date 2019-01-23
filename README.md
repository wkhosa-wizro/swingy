# swingy
Simple console and gui text based RPG written in java using swing framework

## Requirements to build and run the project
1. javac command (java compiler)
2. java command (.class java interpreter)
3. mvn command (maven used for build automation)

## Building and runnig project
#### run the following commands
1. _**mvn clean package**_ (perform clean build and outputs a swingy.jar)
2. _**java -jar swingy.jar console**_ (this will launch the swingy game on console mode)
3. _**java -jar swingy.jar gui**_ (this will launch the swingy game on gui mode)

## About this project
This a simple java game played on console or gui (which will call the view), the player interacts
with the game by cliking (on gui mode only), inputing text and reading from the view (console or gui view).
When a game launches the player has two options either choose a Hero from list of characters or create a new
Hero from the view. The player will be placed inside a square map where the player has to fight with enemies
of different strengths, collect hidden artifacts to gear up  (armor, helm, weapon) and reach all four conners
of the map to gain points. When certain points are reached the player progresses to the next level. The game
ends when the player looses a battle or his life reaches zero and all the game state is saved in a text file,
the user can resume from where the game ended last time.

**The objective of the project is to learn the following**
* OPP
* MVC
* Project management tools like maven
* GUI software development

## Game
The game is broken into three parts and the game can be only in one of the part at a time.
* **Game Launch**
  * The very first part of the game
  * Player select a Hero from previously created Heros or create a new Hero.
* **Game Play**
  * Game is played here
* **Game End**
  * The game has come to an end.
  * All game states are saved in a file.
  
#### Game Launch 
The Plyer will be presented with two options to either select a Hero or create a new Hero. Player can abort the game by Quiting
any time of the game and that will move the part to the **Game End**

#### Game Play
Now that the Player has the desired Hero the Game begins, if the player created a new Hero the Player starts the game at Level 1
otherwise the Player will starts from the level of the selected Hero saved on the previous play. **The mission of a Hero is to reach
all four cornes of the map**. When the Level starts the Hero is placed at the center of the map. **The Hero progresses to the next
level when a certain Experiance points are reached and the Mission is completes**. If the Hero completes the **Mision** but the
**Experiance points** are lower than the **Required Experince points for next level** the current **Level** is restarted until
**Mission is complete** and the **Required Experience points for next level** are reached, the Hero moves to the next Level.

When the Level begins the are hidden enemies and collectable artifacts spread over the map. **The Higher The Level The Bigger the Map And The More 
Enemies and Artifacts are in the Map**. When a Hero moves into  a position where the is an enemy there are two options fight the Enemy
or run. Running gives the Hero 50% of successfully returning to the previous position or engaging in a fight. If the Hero Loose the
fight The game ends (**Game End part**) and if the fight is won the Hero gains the Experinace points  depending on the Experince of the
defeated Enemy. The Hero's chances of wining the fight depends on the Eemy's Experince points. When a Hero moves into a position where
there is an Artifact the Hero has two options to pick the Artifact or move on. Picking Artifact increases Heros Stats like defense points,
hit points or attack points.

The Hero can move one step at a time in one of the four direction **North,West,South or East**.

#### Game Functions
* Navigation
  * move towards **East**
  * move towards **West**
  * move towards **South**
  * move towards **North**
* Run - get you back to the previous position
* Fight - engage in a fight with enemy
* Pick - picks artifact
* Quit - saves Hero stats and ends game (**Game End**)
