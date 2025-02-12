# Lottery Game

This project implements a simple lottery game in Java. Players draw cards and try to match the drawn cards to a pre-generated set of cards. The game keeps track of player scores and maintains a high score table.

## Project Overview

The project consists of several Java classes:
- `Main.java`: The main class that runs the game.
- `Queue.java`: A class that implements a basic queue.
- `Stack.java`: A class that implements a basic stack.
- `circularQueue.java`: A class that implements a circular queue.

### Features

The game includes:
1. Card drawing and matching.
2. Score calculation.
3. High score table management.
4. User interaction via console input.

## Requirements

The project requires Java Development Kit (JDK) to compile and run the Java files.

## Usage

1. Clone the repository:

    ```bash
    git clone https://github.com/barissolcay/Lottery-Game.git
    cd Lottery-Game
    ```

2. Compile the Java files:

    ```bash
    javac Main.java Queue.java Stack.java circularQueue.java
    ```

3. Run the game:

    ```bash
    java Main
    ```

## Game Flow

1. The player is prompted to enter an integer between 7 and 10.
2. The game reads a high score table from a text file.
3. Two stacks of random cards are generated for two players.
4. The game checks if the two stacks are the same. If they are, the game restarts.
5. Players draw cards and scores are calculated based on the drawn cards.
6. The game displays the current scores and the cards in the players' hands and bags.
7. The game continues until one of the stacks is empty.
8. The winner is determined based on the final scores.
9. The player's score is added to the high score table if it is high enough.
10. The player is asked if they want to play again.

## High Scores

The game maintains a high score table in a text file. The table is sorted in descending order of scores, and the top 12 scores are displayed.

## Contributing

Feel free to open issues or submit pull requests if you have suggestions for improvements or find any bugs.

## License

MIT License

```markdown
MIT License

Copyright (c) 2025 Baris Solcay

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
