# Lottery Game

A Java-based card game implementation featuring two players, stacks, and queues data structures. The game involves matching randomly selected numbers and strategic gameplay mechanics.

## 🎮 Game Features

- Two-player card game
- Random number card distribution
- Score tracking system
- High score table with persistent storage
- Colorful console interface
- Tournament-based bonus points system

## 🛠 Technical Details

### Data Structures Used
- **Stack**: For managing player cards
- **Queue**: For basic queue operations
- **Circular Queue**: For managing the game bags and high score table

### Classes
1. **Main.java**: Contains the game logic and user interface
2. **Stack.java**: Implementation of the Stack data structure
3. **Queue.java**: Implementation of the basic Queue data structure
4. **circularQueue.java**: Implementation of the Circular Queue data structure

## 🎯 Game Rules

1. Players receive random number cards (between 7-10 cards)
2. Numbers range from 1 to 13 (represented as A, 2-10, J, Q, K)
3. Each round, a random number is selected
4. Scoring System:
   - Match found: +10 points
   - No match: -5 points
   - First to complete tournament (4 matches): +30 points
   - Both complete tournament simultaneously: +15 points each
   - Game completion bonus: +25 points each
   - Empty hand first: +50 points

## 🚀 How to Play

1. Run the program
2. Enter a number between 7 and 10 for initial card count
3. Watch as cards are distributed
4. Follow the game progress with color-coded feedback:
   - 🟢 Green: Successful match
   - 🔴 Red: No match
   - 🟡 Yellow: Bag contents
   - 🔵 Blue: Selected number

## 💾 Installation

1. Clone the repository:
```bash
git clone https://github.com/barissolcay/Lottery-Game.git
