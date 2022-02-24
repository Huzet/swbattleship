# StarWarsBattleship

## Team Project 7 

**Star Wars themed battleship game** with story elements.
*Player* guesses the locations of hidden enemy ships on the board. 
And wins the game if all enemy ships are found.

### High Level Basic Operations of Application (What's In the game?) 

Game starts with player entering their **Name** in the prompter.
And choose between *Start/Quit* options.

Player gets to choose **Board Size** between *Small/Medium/Larger*

Player is provided an empty grid board.
Ships are randomly auto-generated and player needs to guess ship locations.
Guesses are registered by entering supposed co-ordinates.

Co-ordinates start with 
**Longitude** represented by **Number** and **Latitude** represent by **Alphabet**
e.g. 1A

Depending on *HIT* represented by **X**, or *MISS* represented by **M**
Player is greeted by an ASCII ART

After player successfully guesses all the ship positions the game is *Completed*
The *post-game* page displays the **Player Name** and **Score**. 
With *option* to **restart** or **quit** game.


Game will have several modes (Depending on time):
-	First mode (target practice),  player (human) vs computer. Where a random grid map will be generated with computer ships. Player will guess grid point and try to destroy enemy ship with least amount of guesses.
-	Second mode (computer vs human) both player and computer have randomly generated grid map with ships. Players take turn guessing locations of ships. First player to destroy all ships wins
-	Player vs Player. Both players get random generated grid maps with ships. Players take turn trying to destroy each others ships. First player to destroy the other players ships wins. 

Ideas:
-	World Events
     o	Saismic storms
     o	Story events
     o	Intel ships
-	Different Weapons for different ships alive
     o	Deathstar
     o	Bombers
     o	X wing / tie wing
     o	Limited ammunition (30% grid)
-	Timer
     o	For game to end
     o	Per turn
-	Scoreboard with prizes / debit card
