import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        //MONEY
        final int PRIZE1 = 10000;
        final int PRIZE2 = 100000; // Safety net
        final int PRIZE3 = 250000;
        final int PRIZE4 = 500000; // Safety net
        final int PRIZE5 = 1000000;

        // Instructions
        final String INSTRUCTIONS = "You must correctly answer a series of multiple-choice questions in order to advance to the\nnext question. There are 5 questions in this version of the game and each question is worth\na specific amount of money with no time limit to come up with an answer. You can choose your\nanswer by entering either 1, 2, 3 or 4. You will also get 2 lifelines. Secondary options\nmust be selected with either 1, 2 or 3 when permitted.\n";

        // QUESTIONS
        final String QUESTION_1 = "Q1. What is the currency of Russia? \n1. Real\n2. Dollar\n3. Euro\n4. Ruble";
        final String QUESTION_2 = "Q2. Which is the largest planet in the solar system? \n1. Mars \n2. Jupiter\n3. Neptune\n4. Saturn";
        final String QUESTION_3 = "Q3. How many rings are on the Olympic flag? \n1. 9 Rings\n2. 4 Rings\n3. 5 Rings\n4. 7 Rings";
        final String QUESTION_4 = "Q4. In Medieval times, which of these professionals was responsible for entertaining the royal courts? \n1. Barber \n2. Knight\n3. Blacksmith\n4. Jester";
        final String QUESTION_5 = "Q5. If a ship moves from freshwater into seawater, it will? \n1. Rise a little higher\n2. Remain unaffected\n3. Sink completely\n4. Sink a little bit";

        // Secondary Questions After The Main Question.
        final String SECONDARY_Q1 = "\nWould you like to:\n1) Walk away with $10,000?\n2) Answer the question";
        final String SECONDARY_Q2 = "\nWould you like to:\n1) Walk away with $100,000?\n2) Answer the question";
        final String SECONDARY_Q3 = "\nWould you like to:\n1) Walk away with $250,000?\n2) Answer the question";
        final String SECONDARY_Q4 = "\nWould you like to:\n1) Walk away with $500,000?\n2) Answer the question";
        final String LIFE_LINE1 = "3) Use 'Double Dip' lifeline";
        final String LIFE_LINE2 = "3) Use '50:50' lifeline";

        //50-50 LifeLine Combinations
        final String Q5Combo1 = "\nQ5. If a ship moves from freshwater into seawater, it will? \n1. Rise a little higher\n2. Remain unaffected\n3.\n4.";
        final String Q5Combo2 = "\nQ5. If a ship moves from freshwater into seawater, it will? \n1. Rise a little higher\n2.\n3. Sink completely\n4.";
        final String Q5Combo3 = "\nQ5. If a ship moves from freshwater into seawater, it will? \n1. Rise a little higher\n2.\n3.\n4. Sink a little bit";

        // ANSWERS
        final byte ANSWER_Q1 = 4;
        final byte ANSWER_Q2 = 2;
        final byte ANSWER_Q3 = 3;
        final byte ANSWER_Q4 = 4;
        final byte ANSWER_Q5 = 1;

        //VARIABLES
        int answer; // Stores Player answer
        int playQuestion; // Stores player decision to either walkout, answer question or use lifeline.
        int lifeline5050; // random number is generated and stored in this variable for 50:50 lifeline. Depending on a number between 1-3 inclusive player will get a combination of 50:50 choices.
        boolean game = true;
        boolean doubleDip = true;

        ////////////////// GAME STARTS HERE \\\\\\\\\\\\\\\\\\

        System.out.print("Enter your name:"); // Prompts Player to enter their name.
        String name = input.nextLine();
        System.out.printf("\nWelcome %s to Who Wants To Be A Millionaire!\n\n",name); // Greets user to the game.
        System.out.println("Here are your game instructions:"); // Prompts user with game instructions
        System.out.println(INSTRUCTIONS); // Prints out game instructions.

        /////////////////////////////////-Starts with Question 1-\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

        //  While loop is used to terminate the game when ever the player answers incorrectly or decides to walk out.
        while(game) {
            System.out.printf("-----$%,d Question-----\n", PRIZE1);  // prints Cash Value for the Question 1
            System.out.println(QUESTION_1);                          // prints question 1
            // Do while loop tests to make sure input is valid.
            do {
                System.out.print("Your answer is:"); // Prompts user for answer.
                answer = input.nextInt();
                if (answer == ANSWER_Q1){    // Checks if answer is correct.
                    System.out.printf("\nYou are correct! You have banked $%,d.\n",PRIZE1);  // If question 1 is answered correctly and player is prompted with amount of money they've earned.
                }else if (answer >= 1 && answer <= 4 && answer != ANSWER_Q1){ // Checks if answer is incorrect.
                    System.out.println("\nI'm sorry that is incorrect. You are walking away with $0."); // If question 1 is answered incorrectly and player is prompted with amount money they are walking away with.
                    game = false; // main game loop breaks. The game ends.
                } else {
                    System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                }
            } while (answer != 4 && answer !=3 && answer !=2 && answer !=1); // Do while loop condition to keep asking user for input if the answer is invalid.

            /////////////////////////////////- Question 2 -\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

            if (answer == ANSWER_Q1) { // IF QUESTION 1 IS ANSWERED CORRECTLY MOVE TO QUESTION 2.

                System.out.printf("\n-----$%,d Question-----\n", PRIZE2); // Prints cash value for the Question 2
                System.out.println(QUESTION_2);                           // Prints question 2
                System.out.println(SECONDARY_Q1);   // asks player if they'd like to walkout with money won so far or answer the new question.
                if (doubleDip) {                     // if doubleDip is true, prompt the player with the option of a lifeline.
                    System.out.println(LIFE_LINE1);   // prints out the option to use the double dip lifeline if it hasn't already been used.
                }
                System.out.print("Option:"); // Prompts user for input.
                playQuestion = input.nextInt();     // Ask for player input if they want to walkout, answer, or use a lifeline.

                if (playQuestion == 2) { // If player decides to answer the question do the following ⬇
                    // Do while loop tests to make sure input is valid.
                    do {
                        System.out.print("Your answer is:"); // Prompts user for answer.
                        answer = input.nextInt();
                        if(answer == ANSWER_Q2){    // Checks if answer is correct.
                            System.out.printf("\nYou are correct! You have banked $%,d.\n",PRIZE2); // If question 2 is answered correctly and player is prompted with amount of money they've earned.
                        } else if ( answer >= 1 && answer <= 4 && answer != ANSWER_Q2 ){ // Checks if answer is incorrect.
                            System.out.println("\nI'm sorry that is incorrect. You are walking away with $0."); // If question 2 is answered incorrectly and player is prompted with amount money they are walking away with.
                            game = false; // main game loop breaks. The game ends.
                        } else{
                            System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                        }
                    } while (answer != 4 && answer !=3 && answer !=2 && answer !=1); // Do while loop condition to keep asking user for input if the answer is invalid.
                } else if (playQuestion == 3 && doubleDip){ // If player decides to use their life line do the following ⬇
                    doubleDip = false; // lifeline is redeemed
                    do {
                        System.out.print("Your first final answer is:"); // asks for first final answer.
                        answer = input.nextInt();
                        if (answer == ANSWER_Q2){    // Checks if answer is correct.
                            System.out.printf("\nYou are correct! You have banked $%,d.\n", PRIZE2); // If question 2 is answered correctly and player is prompted with amount of money they've earned.
                        } else if (answer >= 1 && answer <= 4 && answer != ANSWER_Q2){ // Checks if answer is incorrect.
                            System.out.println("Your first final answer is incorrect."); // If question 2 is answered incorrectly the first time while being in range, the player is prompted to answer again.
                            do{
                                System.out.print("This is your last chance. Your second final answer is:"); // asks for final second answer and a do while loop validates the player input.
                                answer = input.nextInt();
                                if (answer == ANSWER_Q2){    // Checks if answer is correct.
                                    System.out.printf("\nYou are correct! You have banked $%,d.\n", PRIZE2); // If question 2 is answered correctly and player is prompted with amount of money they've earned.
                                } else if (answer >= 1 && answer <= 4 && answer != ANSWER_Q2) { // Checks if answer is incorrect.
                                    System.out.println("\nI'm sorry that is incorrect. You are walking away with $0."); // If question 2 is answered incorrectly and player is prompted with amount money they are walking away with.
                                    game = false; // main game loop breaks. The game ends.
                                } else {
                                    System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                                }
                            } while (answer != 4 && answer != 3 && answer != 2 && answer != 1);  // Do while loop condition to keep asking user for input if the second answer is invalid.
                        } else {
                            System.out.println("Invalid answer. Please enter 1, 2, 3, or 4.");  // If the input is invalid for the first player input the user is prompted to answer either 1,2,3 or 4.
                        }
                    } while (answer != 4 && answer != 3 && answer != 2 && answer != 1); // Do while loop condition to keep asking user for input if the answer is invalid.

                } else { // if player chooses to walk away prompt player with how much money they have banked and thank them for playing.
                    System.out.printf("\nThank you for playing. You are walking away with $%,d!", PRIZE1); // prompt player with a thank you for playing message and how much money they are walking away with.
                    game = false; // main game loop breaks. The game ends.
                }

                /////////////////////////////////- Question 3 -\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

                if (answer == ANSWER_Q2) { // IF QUESTION 2 IS ANSWERED CORRECTLY MOVE TO QUESTION 3.
                    System.out.printf("\n-----$%,d Question-----\n", PRIZE3); // Prints Cash Value for the Question 3
                    System.out.println(QUESTION_3);     // prints question 3
                    System.out.println(SECONDARY_Q2);  // asks player if they'd like to walkout with money won so far or answer the new question.
                    if (doubleDip) {                    // if doubleDip is true, prompt the player with the option of a lifeline.
                        System.out.println(LIFE_LINE1);  // prints out the option to use the double dip lifeline if it hasnt already been used.
                    }
                    System.out.print("Option:"); // Prompts user for input.
                    playQuestion = input.nextInt();     // Ask for player input if they want to walkout, answer, or use a lifeline.

                    if (playQuestion == 2){ // if player chooses to answer the question do the following ⬇
                        // Do while loop tests to make sure input is valid.
                        do {
                            System.out.print("Your answer is:"); // Prompts user for answer.
                            answer = input.nextInt();
                            if(answer == ANSWER_Q3){ // Checks if answer is correct.
                                System.out.printf("\nYou are correct! You have banked $%,d.\n",PRIZE3); // If question 3 is answered correctly and player is prompted with amount of money they've earned.
                            } else if ( answer >= 1 && answer <= 4 && answer != ANSWER_Q3 ){ // Checks if answer is incorrect.
                                System.out.printf("\nI'm sorry, that is incorrect. But you are walking away with $%,d!",PRIZE2); // If question 2 is answered incorrectly and player is prompted with amount money they are walking away with. (leaves game with safety net)
                                game = false; // main game loop breaks. The game ends.
                            } else{
                                System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                            }
                        } while (answer != 4 && answer !=3 && answer !=2 && answer !=1); // Do while loop condition to keep asking user for input if the answer is invalid.
                    } else if (playQuestion == 3 && doubleDip){ // If player decides to use their life line do the following ⬇
                        doubleDip = false; // lifeline is redeemed
                        do {
                            System.out.print("your first final answer is:"); // asks for first final answer.
                            answer = input.nextInt();
                            if (answer == ANSWER_Q3){
                                System.out.printf("\nYou are correct! You have banked $%,d.\n", PRIZE3); // If question 3 is answered correctly and player is prompted with amount of money they've earned.
                            } else if (answer >= 1 && answer <= 4 && answer != ANSWER_Q3){
                                System.out.println("Your first final answer is incorrect.");  // If question 3 is answered incorrectly the first time while being in range, the player is prompted to answer again.
                                do{
                                    System.out.print("This is your last chance. Your second final answer is:"); // asks for final second answer and a do while loop validates the player input.
                                    answer = input.nextInt();
                                    if (answer == ANSWER_Q3){ // Checks if answer is correct.
                                        System.out.printf("\nYou are correct! You have banked $%,d.\n", PRIZE3); // If question 3 is answered correctly and player is prompted with amount of money they've earned.
                                    } else if (answer >= 1 && answer <= 4 && answer != ANSWER_Q3) { // Checks if answer is incorrect.
                                        System.out.printf("\nI'm sorry, that is incorrect. But you are walking away with $%,d!",PRIZE2); // If question 3 is answered incorrectly and player is prompted with amount money they are walking away with. (leaves game with safety net)
                                        game = false; // main game loop breaks. The game ends.
                                    } else { // checks if answer is valid.
                                        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                                    }
                                } while (answer != 4 && answer != 3 && answer != 2 && answer != 1); // Do while loop condition to keep asking user for input if the second answer is invalid.
                            } else {
                                System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                            }
                        } while (answer != 4 && answer != 3 && answer != 2 && answer != 1); // Do while loop condition to keep asking user for input if the answer is invalid.

                    } else { // if player chooses to walk away prompt player with how much money they have banked and thank them for playing.
                        System.out.printf("\nThank you for playing. You are walking away with $%,d!", PRIZE2); // prompt player with a thank you for playing message and how much money they are walking away with.
                        game = false; // main game loop breaks. The game ends.
                    }

                    /////////////////////////////////- Question 4 -\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

                    if (answer == ANSWER_Q3) { // IF QUESTION 3 IS ANSWERED CORRECTLY MOVE TO QUESTION 4.
                        System.out.printf("\n-----$%,d Question-----\n", PRIZE4); // Cash Value for the Question 4
                        System.out.println(QUESTION_4);     // prints question 4
                        System.out.println(SECONDARY_Q3);  // asks player if they'd like to walkout with money won so far or answer the new question.
                        if (doubleDip) {                    // if doubleDip is true, prompt the player with the option of a lifeline.
                            System.out.println(LIFE_LINE1);  // prints out the option to use the double dip lifeline if it hasnt already been used.
                        }
                        System.out.print("Option:"); // Prompts user for input.
                        playQuestion = input.nextInt();     // Ask for player input if they want to walkout, answer, or use a lifeline.

                        if (playQuestion == 2){ // If player decides to answer the question do the following ⬇
                            // Do while loop tests to make sure input is valid.
                            do {
                                System.out.print("Your answer is:"); // Prompts user for answer.
                                answer = input.nextInt();
                                if(answer == ANSWER_Q4){    // Checks if answer is correct.
                                    System.out.printf("\nYou are correct! You have banked $%,d.\n",PRIZE4); // If question 4 is answered correctly and player is prompted with amount of money they've earned.
                                } else if ( answer >= 1 && answer <= 4 && answer != ANSWER_Q4 ){ // Checks if answer is incorrect.
                                    System.out.printf("\nI'm sorry, that is incorrect. But you are walking away with $%,d!",PRIZE2); // If question 4 is answered incorrectly and player is prompted with amount money they are walking away with. (leaves game with safety net)
                                    game = false; // main game loop breaks. The game ends.
                                } else{
                                    System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                                }
                            } while (answer != 4 && answer !=3 && answer !=2 && answer !=1); // Do while loop condition to keep asking user for input if the answer is invalid.
                        } else if (playQuestion == 3 && doubleDip){ // If player decides to use their life line do the following ⬇
                            doubleDip = false; // lifeline is redeemed
                            do {
                                System.out.print("your first final answer is:"); // asks for first final answer.
                                answer = input.nextInt();
                                if (answer == ANSWER_Q4){    // Checks if answer is correct.
                                    System.out.printf("\nYou are correct! You have banked $%,d.\n", PRIZE4); // If question 4 is answered correctly and player is prompted with amount of money they've earned.
                                } else if (answer >= 1 && answer <= 4 && answer != ANSWER_Q4){ // Checks if answer is incorrect.
                                    System.out.println("Your first final answer is incorrect.");  // If question 4 is answered incorrectly the first time while being in range, the player is prompted to answer again.
                                    do{
                                        System.out.print("This is your last chance. Your second final answer is:"); // asks for final second answer.
                                        answer = input.nextInt();
                                        if (answer == ANSWER_Q4){    // Checks if answer is correct.
                                            System.out.printf("\nYou are correct! You have banked $%,d.\n", PRIZE4);// If question 4 is answered correctly and player is prompted with amount of money they've earned.
                                        } else if (answer >= 1 && answer <= 4 && answer != ANSWER_Q4) { // Checks if answer is incorrect.
                                            System.out.printf("\nI'm sorry, that is incorrect. But you are walking away with $%,d!",PRIZE2); // If question 4 is answered incorrectly and player is prompted with amount money they are walking away with. (leaves game with safety net)
                                            game = false; // main game loop breaks. The game ends.
                                        } else { // checks if answer is valid.
                                            System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                                        }
                                    } while (answer != 4 && answer != 3 && answer != 2 && answer != 1); // Do while loop condition to keep asking user for input if the second answer is invalid.
                                } else {
                                    System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                                }
                            } while (answer != 4 && answer != 3 && answer != 2 && answer != 1); // Do while loop condition to keep asking user for input if the answer is invalid.

                        } else { // if player chooses to walk away prompt player with how much money they have banked and thank them for playing.
                            System.out.printf("\nThank you for playing. You are walking away with $%,d!", PRIZE3); // prompt player with a thank you for playing message and how much money they are walking away with.
                            game = false; // main game loop breaks. The game ends.
                        }

                        /////////////////////////////////- Question 5 -\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

                        if (answer == ANSWER_Q4) { // IF QUESTION 4 IS ANSWERED CORRECTLY MOVE TO QUESTION 5.
                            System.out.printf("\n-----$%,d Question-----\n", PRIZE5); // Cash Value for the Question 5
                            System.out.println(QUESTION_5); // prints question 5
                            System.out.println(SECONDARY_Q4); // asks player if they'd like to walkout with money won so far or answer the new question.
                            System.out.println(LIFE_LINE2); // presents 50:50 life line.
                            System.out.print("Option:"); // Prompts user for input.
                            playQuestion = input.nextInt();
                            if (playQuestion == 2) { // If player decides to answer the question do the following ⬇
                                // Do while loop tests to make sure input is valid.
                                do {
                                    System.out.print("Your answer is:"); // Prompts user for answer.
                                    answer = input.nextInt();
                                    if(answer == ANSWER_Q5){    // Checks if answer is correct.
                                        System.out.printf("\nYou are correct! You have banked $%,d.\n", PRIZE5); // If question 5 is answered correctly and player is prompted with amount of money they've earned.
                                        System.out.printf("Congratulations %s! You are now a millionaire💰💰💰❗ Thank you for playing.\n",name); // User is congratulated for winning the game, and thanks them.
                                        game = false; // main game loop breaks. The game ends.
                                    } else if ( answer >= 1 && answer <= 4 && answer != ANSWER_Q5 ){ // Checks if answer is incorrect.
                                        System.out.printf("\nI'm sorry, that is incorrect. But you are walking away with $%,d!",PRIZE4); // If question 5 is answered incorrectly and player is prompted with amount money they are walking away with. (leaves game with safety net)
                                        game = false; // main game loop breaks. The game ends.
                                    } else{
                                        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                                    }
                                } while (answer != 4 && answer !=3 && answer !=2 && answer !=1); // Do while loop condition to keep asking user for input if the answer is invalid.
                            } else if (playQuestion == 3){  // If player decides to use their life line do the following ⬇
                                lifeline5050 = rand.nextInt(3)+1; // generates a random number between 1-3 inclusive to knock off a combination of two incorrect answers.
                                // Switch case to print out corresponding combination of 50:50 answers.
                                switch (lifeline5050) {
                                    case 1:
                                        System.out.println(Q5Combo1);  // random number 1 prints out the first combination of 50:50 answers.
                                        break;
                                    case 2:
                                        System.out.println(Q5Combo2);  // random number 2 prints out the second combination of 50:50 answers.
                                        break;
                                    default:
                                        System.out.println(Q5Combo3);  // random number 3 prints out the third combination of 50:50 answers.
                                }
                                // Do while loop tests to make sure input is valid.
                                do {
                                    System.out.print("Your answer is:"); // Prompts user for answer.
                                    answer = input.nextInt();
                                    if((answer == ANSWER_Q5)){ // Checks if answer is correct.
                                        System.out.printf("\nYou are correct! You have banked $%,d.\n", PRIZE5); // If question 5 is answered correctly and player is prompted with amount of money they've earned.
                                        System.out.printf("Congratulations %s! You are now a millionaire💰💰💰❗ Thank you for playing.\n",name); // User is congratulated for winning the game, and thanks them.
                                        game = false; // main game loop breaks. The game ends.
                                    } else if ((answer >= 1) && (answer <= 4) && (answer != ANSWER_Q5)){ // Checks if the answer is within the range and incorrect.
                                        System.out.printf("\nI'm sorry, that is incorrect. But you are walking away with $%,d!",PRIZE4); // If question is answered wrong player walks out with $500,000
                                        game = false; // main game loop breaks. The game ends.
                                    } else{
                                        System.out.println("Invalid answer. Please enter 1, 2, 3, or 4."); // If the input is invalid user is prompted to answer either 1,2,3 or 4.
                                    }
                                } while (answer != 4 && answer !=3 && answer !=2 && answer !=1); // Do while loop condition to keep asking user for input if the answer is invalid.
                            } else {  // if player chooses to walk away prompt player with how much money they have banked and thank them for playing.
                                System.out.printf("\nThank you for playing. You are walking away with $%,d!", PRIZE4); // prompt player with a thank you for playing message and how much money they are walking away with.
                                game = false; // main game loop breaks. The game ends.
                            }
                        } //  part of if answer to fourth question is correct proceed to question 5.
                    } // part of  if answer to third question is correct proceed to question 4.
                } // part of  if answer to second question is correct proceed to question 3.
            } // part of if answer to first question is correct proceed to question 2.
        } // part of while(game).
    }
}