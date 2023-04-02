import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException
    {
        String answer = "";
        do
        {
            //region İnput For n
            System.out.println(ANSI_GREEN + "-----------------------------------------------");
            System.out.println(ANSI_GREEN + "        Good luck with your game!");
            System.out.println();
            Scanner sc = new Scanner(System.in);

            System.out.print(ANSI_RESET + "Please enter an integer between 7 and 10: ");
            int num = sc.nextInt();

            System.out.println();

            if (num < 7 || num > 10) {
                System.out.println("\nThe number you entered is not between 7 and 10.");

                System.out.print("Please enter an integer between 7 and 10: ");
                num = sc.nextInt();

                if (num < 7 || num > 10) {
                    System.out.println("\nThe number you entered is still not between 7 and 10. Try again.");
                }
            }
            //endregion

            //region TXT Read
            BufferedReader reader = new BufferedReader(new FileReader("D:\\highscoretable.txt"));

            circularQueue names = new circularQueue(12);
            circularQueue scores = new circularQueue(12);
            String line = reader.readLine();
            while (line != null)
            {
                String[] parts = line.split(" ");
                names.enqueue(parts[0]);
                scores.enqueue(Integer.parseInt(parts[1]));
                line = reader.readLine();
            }
            //endregion

            //region Creat Stack
            Random rand = new Random();
            int[] values1 = new int[num];
            int[] values2 = new int[num];

            for (int i = 0; i < values1.length; i++) {
                int randomValue = rand.nextInt(13) + 1;
                boolean isDuplicate = false;

                for (int j = 0; j < i; j++) {
                    if (values1[j] == randomValue) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    values1[i] = randomValue;
                } else {
                    i--;
                }
            }

            for (int i = 0; i < values2.length; i++) {
                int randomValue = rand.nextInt(13) + 1;
                boolean isDuplicate = false;

                for (int j = 0; j < i; j++) {
                    if (values2[j] == randomValue) {
                        isDuplicate = true;
                        break;
                    }
                }

                if (!isDuplicate) {
                    values2[i] = randomValue;
                } else {
                    i--;
                }
            }

            Stack stack1 = new Stack(num);
            Stack stack2 = new Stack(num);

            Stack tempstack1 = new Stack(num);
            Stack tempstack2 = new Stack(num);

            for (int value : values1) {
                stack1.push(value);
            }
            for (int value : values2) {
                stack2.push(value);
            }

            sortStack(stack1);
            sortStack(stack2);

//endregion

            //region Is Stack Same
            if(isStackEqual(stack1,stack2) == true)
            {
                System.out.println("They are same please try again.");
                System.exit(0);
            }
            //endregion

            //region Select Card - Gameplay -  Print
            circularQueue fullQueue = new circularQueue(13);
            circularQueue emptyQueue = new circularQueue(13);

            int score1 = 0;
            int score2 = 0;

            boolean firstTour = false;
            int count1 = 0;
            int count2 = 0;

            for (int i = 1; i <= 13; i++)
            {
                fullQueue.enqueue(i);
            }

            for (int i = 0; i < 1; i++) //first print for screen
            {
                System.out.print(ANSI_CYAN + "Player1: ");
                while (!stack1.isEmpty())
                {
                    if ((int) stack1.peek() == 1)
                    {
                        tempstack1.push(stack1.peek());
                        System.out.print("A" + " ");
                        stack1.pop();
                    }
                    else if ((int) stack1.peek() == 11)
                    {
                        tempstack1.push(stack1.peek());
                        System.out.print("J" + " ");
                        stack1.pop();
                    }
                    else if ((int) stack1.peek() == 12)
                    {
                        tempstack1.push(stack1.peek());
                        System.out.print("Q" + " ");
                        stack1.pop();
                    }
                    else if ((int) stack1.peek() == 13)
                    {
                        tempstack1.push(stack1.peek());
                        System.out.print("K" + " ");
                        stack1.pop();
                    }
                    else
                    {
                        tempstack1.push(stack1.peek());
                        System.out.print(stack1.pop() + " ");
                    }
                }
                while (!tempstack1.isEmpty())
                {
                    stack1.push(tempstack1.pop());
                }
                System.out.print("          Score: " + score1);
                System.out.print("          Bag1: A 2 3 4 5 6 7 8 9 10 J Q K");

                System.out.println();

                System.out.print(ANSI_CYAN + "Player2: ");
                while (!stack2.isEmpty())
                {
                    if ((int) stack2.peek() == 1)
                    {
                        tempstack2.push(stack2.peek());
                        System.out.print("A" + " ");
                        stack2.pop();
                    }
                    else if ((int) stack2.peek() == 11)
                    {
                        tempstack2.push(stack2.peek());
                        System.out.print("J" + " ");
                        stack2.pop();
                    }
                    else if ((int) stack2.peek() == 12)
                    {
                        tempstack2.push(stack2.peek());
                        System.out.print("Q" + " ");
                        stack2.pop();
                    }
                    else if ((int) stack2.peek() == 13)
                    {
                        tempstack2.push(stack2.peek());
                        System.out.print("K" + " ");
                        stack2.pop();
                    }
                    else
                    {
                        tempstack2.push(stack2.peek());
                        System.out.print(stack2.pop() + " ");
                    }
                }
                while (!tempstack2.isEmpty())
                {
                    stack2.push(tempstack2.pop());
                }
                System.out.print("          Score: " + score2);
                System.out.print("          Bag2: ");
                System.out.println();

                i++;
            }


            while (!stack1.isEmpty() && !stack2.isEmpty())
            {
                int selectedNumber = rand.nextInt(13) + 1; //random number

                //region Stack(player) Control
                int size1 = stack1.size();
                int size2 = stack2.size();
                int b = 0;
                int c = 0;

                boolean varmi1 = false;
                boolean varmi2 = false;



                while (size1 != b)
                {
                    b++;
                    if ((int) stack1.peek() == selectedNumber)
                    {
                        stack1.pop();
                        varmi1 = true;
                    }
                    else
                    {
                        tempstack1.push(stack1.pop());
                    }
                }
                while (!tempstack1.isEmpty())
                {
                    stack1.push(tempstack1.pop());
                }

                while (size2 != c)
                {
                    c++;
                    if ((int) stack2.peek() == selectedNumber)
                    {
                        stack2.pop();
                        varmi2 = true;
                    }
                    else
                    {
                        tempstack2.push(stack2.pop());
                    }
                }
                while (!tempstack2.isEmpty())
                {
                    stack2.push(tempstack2.pop());
                }
                //endregion

                //region Print and Score Calculate
                if(varmi1 == true || varmi2 == true)
                {
                    //region Queue(bag) control
                    int size0 = emptyQueue.size() + 1;
                    int size = fullQueue.size();
                    int a = 0;

                    while (size != a)
                    {
                        a++;
                        if (selectedNumber == (int) fullQueue.peek())
                        {
                            fullQueue.dequeue();
                            emptyQueue.enqueue(selectedNumber);
                        } else
                        {
                            fullQueue.enqueue(fullQueue.dequeue());
                        }
                    }
                    //endregion

                    //region print selected number
                    System.out.println();
                    if(selectedNumber == 13)
                    {
                        System.out.println(ANSI_BLUE + "Selected number: " + "K");
                    }
                    else if(selectedNumber == 12)
                    {
                        System.out.println(ANSI_BLUE + "Selected number: " + "Q");
                    }
                    else if(selectedNumber == 11)
                    {
                        System.out.println(ANSI_BLUE + "Selected number: " + "J");
                    }
                    else if(selectedNumber == 1)
                    {
                        System.out.println(ANSI_BLUE + "Selected number: " + "K");
                    }
                    else
                        System.out.println(ANSI_BLUE + "Selected number: " + selectedNumber);
                    //endregion

                    //region print player, score and bag
                    if(varmi1 == true) //green print when it is true
                    {
                        System.out.print(ANSI_GREEN + "Player1: ");
                        while (!stack1.isEmpty())
                        {
                            if ((int) stack1.peek() == 1)
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print("A" + " ");
                                stack1.pop();
                            }
                            else if ((int) stack1.peek() == 11)
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print("J" + " ");
                                stack1.pop();
                            }
                            else if ((int) stack1.peek() == 12)
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print("Q" + " ");
                                stack1.pop();
                            }
                            else if ((int) stack1.peek() == 13)
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print("K" + " ");
                                stack1.pop();
                            }
                            else
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print(stack1.pop() + " ");
                            }
                        }
                        while (!tempstack1.isEmpty())
                        {
                            stack1.push(tempstack1.pop());
                        }
                        count1++;
                        score1 += 10;
                        String str1 = String.format("%20s","Score: ");
                        System.out.print(str1 + score1);
                    }
                    else if (varmi1 == false) //red print when it is false
                    {
                        System.out.print(ANSI_RED + "Player1: ");
                        while (!stack1.isEmpty())
                        {
                            if ((int) stack1.peek() == 1)
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print("A" + " ");
                                stack1.pop();
                            }
                            else if ((int) stack1.peek() == 11)
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print("J" + " ");
                                stack1.pop();
                            }
                            else if ((int) stack1.peek() == 12)
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print("Q" + " ");
                                stack1.pop();
                            }
                            else if ((int) stack1.peek() == 13)
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print("K" + " ");
                                stack1.pop();
                            }
                            else
                            {
                                tempstack1.push(stack1.peek());
                                System.out.print(stack1.pop() + " ");
                            }
                        }
                        while (!tempstack1.isEmpty())
                        {
                            stack1.push(tempstack1.pop());
                        }
                        score1 -= 5;
                        String str1 = String.format("%20s","Score: ");
                        System.out.print(str1 + score1);
                    }

                    System.out.print(ANSI_YELLOW + "        Bag1: ");
                    int f = 0;
                    while(size != f +1)
                    {
                        f++;
                        if((int)fullQueue.peek() == 13)
                        {
                            System.out.print("K" + " ");
                        }
                        else if((int)fullQueue.peek() == 12)
                        {
                            System.out.print("Q" + " ");

                        }
                        else if((int)fullQueue.peek() == 11)
                        {
                            System.out.print("J" + " ");

                        }
                        else if((int)fullQueue.peek() == 1)
                        {
                            System.out.print("A" + " ");
                        }
                        else
                            System.out.print(fullQueue.peek() + " ");

                        fullQueue.enqueue(fullQueue.dequeue());
                    }

                    System.out.println();

                    if(varmi2 == true)
                    {
                        System.out.print(ANSI_GREEN + "Player2: ");
                        while (!stack2.isEmpty())
                        {
                            if ((int) stack2.peek() == 1)
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print("A" + " ");
                                stack2.pop();
                            }
                            else if ((int) stack2.peek() == 11)
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print("J" + " ");
                                stack2.pop();
                            }
                            else if ((int) stack2.peek() == 12)
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print("Q" + " ");
                                stack2.pop();
                            }
                            else if ((int) stack2.peek() == 13)
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print("K" + " ");
                                stack2.pop();
                            }
                            else
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print(stack2.pop() + " ");
                            }
                        }
                        while (!tempstack2.isEmpty())
                        {
                            stack2.push(tempstack2.pop());
                        }
                        count2++;
                        score2 += 10;
                        String str1 = String.format("%20s","Score: ");
                        System.out.print(str1 + score2);
                    }
                    else if (varmi2 == false)
                    {
                        System.out.print(ANSI_RED + "Player2: ");
                        while (!stack2.isEmpty())
                        {
                            if ((int) stack2.peek() == 1)
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print("A" + " ");
                                stack2.pop();
                            }
                            else if ((int) stack2.peek() == 11)
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print("J" + " ");
                                stack2.pop();
                            }
                            else if ((int) stack2.peek() == 12)
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print("Q" + " ");
                                stack2.pop();
                            }
                            else if ((int) stack2.peek() == 13)
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print("K" + " ");
                                stack2.pop();
                            }
                            else
                            {
                                tempstack2.push(stack2.peek());
                                System.out.print(stack2.pop() + " ");
                            }
                        }
                        while (!tempstack2.isEmpty())
                        {
                            stack2.push(tempstack2.pop());
                        }
                        score2 -= 5;
                        String str1 = String.format("%20s","Score: ");
                        System.out.print(str1 + score2);
                    }

                    System.out.print(ANSI_YELLOW + "        Bag2: ");
                    int g = 0;
                    while(size0 != g)
                    {
                        g++;
                        if((int)emptyQueue.peek() == 13)
                        {
                            System.out.print("K" + " ");
                        }
                        else if((int)emptyQueue.peek() == 12)
                        {
                            System.out.print("Q" + " ");
                        }
                        else if((int)emptyQueue.peek() == 11)
                        {
                            System.out.print("J" + " ");
                        }
                        else if((int)emptyQueue.peek() == 1)
                        {
                            System.out.print("A" + " ");
                        }
                        else
                            System.out.print(emptyQueue.peek() + " ");

                        emptyQueue.enqueue(emptyQueue.dequeue());
                    }


                    if(count1 == 4 && firstTour == false)
                    {
                        System.out.println();
                        System.out.println(ANSI_PURPLE + "\nFirst tournament is completed.");
                        score1 += 30;
                        firstTour = true;
                    }
                    else if(count2 == 4 && firstTour == false)
                    {
                        System.out.println();
                        System.out.println(ANSI_PURPLE + "\nFirst tournament is completed.");
                        score2 += 30;
                        firstTour = true;
                    }
                    else if (count1 == 4 && count2 == 4 && firstTour == false)
                    {
                        System.out.println();
                        System.out.println(ANSI_PURPLE + "\nFirst tournament is completed.");
                        score1 += 15;
                        score2 += 15;
                        firstTour = true;
                    }
                    //endregion
                }
                //endregion
            }
            //endregion

            //region Gameover Screen
            int highscore = 0;
            System.out.println();
            System.out.println(ANSI_RESET + "\nGame over!\n");

            if(stack1.isEmpty() && stack2.isEmpty())
            {
                score1 += 25;
                score2 += 25;

                if(score1 == score2)
                {
                    System.out.println("No Ninner Player1 and Player2 tied with " + score1 + " points. Play again.\n");
                    System.exit(0);
                    highscore = score2;
                }
                else if (score1 > score2)
                {
                    System.out.println("Winner: Player1 " + score1 + " points\n");
                    highscore = score1;
                }
                else if (score2 > score1)
                {
                    System.out.println("Winner: Player2 " + score2 + " points\n");
                    highscore = score2;
                }
            }
            else if (stack1.isEmpty())
            {
                score1 += 50;
                highscore = score1;
                System.out.println("Winner: Player1 with " + score1 + " points\n");
            }
            else if (stack2.isEmpty())
            {
                score2 += 50;
                highscore = score2;
                System.out.println("Winner: Player2 with " + score2 + " points\n");
            }

            System.out.print("What is your name: ");
            String inputname = sc.next();
            //endregion

            //region Highscore
            sortCircularQueue(scores, names);
            circularQueue tempscore = new circularQueue(12);
            circularQueue tempname = new circularQueue(12);

            if(names.size() < 12)
            {
                scores.enqueue(highscore);
                names.enqueue(inputname);
                sortCircularQueue(scores, names);

                System.out.println();
                System.out.println("High Score Table");
                System.out.println("----------------");
                while(!names.isEmpty())
                {
                    tempscore.enqueue(scores.peek());
                    tempname.enqueue(names.peek());
                    System.out.println((String)names.dequeue() + " " + (int)scores.dequeue());
                }
                System.out.println("----------------");
                while (!tempscore.isEmpty())
                {
                    names.enqueue(tempname.dequeue());
                    scores.enqueue(tempscore.dequeue());
                }
            }
            else
            {
                while(scores.size() != 1)
                {
                    tempscore.enqueue(scores.dequeue());
                    tempname.enqueue(names.dequeue());
                }
                if(highscore >= (int)scores.peek())
                {
                    scores.dequeue();
                    names.dequeue();
                    tempname.enqueue((inputname));
                    tempscore.enqueue(highscore);
                }
                else
                {
                    System.out.println("Your score does not have enough points to enter the top leaderboard.");
                    tempscore.enqueue(scores.dequeue());
                    tempname.enqueue(names.dequeue());
                }

                sortCircularQueue(tempscore,tempname);
                System.out.println();
                System.out.println("High Score Table");
                System.out.println("----------------");
                while(!tempscore.isEmpty())
                {
                    names.enqueue(tempname.peek());
                    scores.enqueue(tempscore.peek());
                    System.out.println((String)tempname.dequeue() + " " + (int)tempscore.dequeue());
                }
                System.out.println("----------------");
            }


            //endregion

            //region TXT Write
            try{
                FileWriter writer = new FileWriter("D:\\highscoretable.txt");
                while(!names.isEmpty())
                {
                    writer.write((String)names.dequeue() + " " + (int)scores.dequeue() + "\n");
                }
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            //endregion

            //region Play again?
            System.out.println();
            System.out.print(ANSI_RED+"Do you want to play again? (yes/no) ");
            answer = sc.next().toLowerCase();
            System.out.println();
            System.out.println();
            //endregion
        }
        while(answer.equals("yes"));
    }

    //region FUNCTION
    public static void sortStack(Stack stack) {
    Stack tempStack = new Stack(10);

    while (!stack.isEmpty()) {
        int temp = (int) stack.pop();
        while (!tempStack.isEmpty() && (int) tempStack.peek() < temp) {
            stack.push(tempStack.pop());
        }
        tempStack.push(temp);
    }
    while (!tempStack.isEmpty()) {
        stack.push(tempStack.pop());
    }
}
    public static Object[] sortCircularQueue(circularQueue scoreQueue, circularQueue nameQueue) {
        circularQueue helperScoreQueue = new circularQueue(12);
        circularQueue helperNameQueue = new circularQueue(12);

        int maxscore = 0;
        int currentscore = 0;
        String maxname = "";
        String currentName = "";

        while (scoreQueue.size() != 0)
        {
            int len = scoreQueue.size();
            maxscore = 0;
            for (int i = 0; i < len; i++)
            {
                currentscore = (int) scoreQueue.dequeue();
                currentName = (String) nameQueue.dequeue();
                if (currentscore > maxscore)
                {
                    if (i != 0)
                    {
                        scoreQueue.enqueue(maxscore);
                        nameQueue.enqueue(maxname);
                    }
                    maxscore = currentscore;
                    maxname = currentName;
                }
                else
                {
                    scoreQueue.enqueue(currentscore);
                    nameQueue.enqueue(currentName);
                }
            }
//            System.out.println(maxname + " " + maxscore);
            helperScoreQueue.enqueue(maxscore);
            helperNameQueue.enqueue(maxname);
        }

        while(!helperNameQueue.isEmpty())
        {
            nameQueue.enqueue(helperNameQueue.dequeue());
            scoreQueue.enqueue(helperScoreQueue.dequeue());
        }

        Object[] result = {helperScoreQueue, helperNameQueue};
        return result;
    }
    public static boolean isStackEqual(Stack stack1, Stack stack2) {
        Stack temp1 = new Stack(12);
        Stack temp2 = new Stack(12);
        boolean isEqual = true;

        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int item1 = (int) stack1.pop();
            int item2 = (int) stack2.pop();

            if (item1 != item2) {
                isEqual = false;
            }

            temp1.push(item1);
            temp2.push(item2);
        }

        // If either stack is not empty, they are not equal
        if (!stack1.isEmpty() || !stack2.isEmpty()) {
            isEqual = false;
        }

        // Re-add the popped items to their respective stacks
        while (!temp1.isEmpty()) {
            stack1.push(temp1.pop());
        }
        while (!temp2.isEmpty()) {
            stack2.push(temp2.pop());
        }

        return isEqual;
    }
    //endregion

    //region COLOR
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RESET = "\u001B[0m";

//endregion
}