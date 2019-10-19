import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Random;

import java.util.Scanner;
import java.lang.Math;

public class Part1 {

    public static void main (String[]args) throws NoSuchAlgorithmException, NoSuchProviderException {

        SecureRandom rand = SecureRandom.getInstance("SHA1PRNG", "SUN");

        byte[] randomBytes = new byte[128];


        int correctAns, answer;

        String choice;



        Scanner sc = new Scanner(System.in);



        int rightAnswers = 0;

        int wrongAnswers = 0;


        int getNumber;
        int difficultyLevel = 0;//difficultyLevel(rand);


        int questionsCount = 0;


        do {

            System.out.println("\n1. Addition problems\n2. Subtraction problems \n3. Multiplication problems\n4. Division problems\n5. Mixed\n6. Terminate");


            int problemType = 0;

            do {

                System.out.println("Pick your problem (1 to 5) or 6 to terminate: ");

                problemType=sc.nextInt();


                if (problemType == 6)
                {
                    break;
                }


                if (problemType < 1 && problemType > 5) {

                    System.out.println("That's an invalid input.");

                } else break;

            } while (1==1);


            difficultyLevel = 0;

            do {


                System.out.println("\nEnter difficulty level (1 to 4): ");

                difficultyLevel=sc.nextInt();

                if (difficultyLevel < 1 && difficultyLevel > 4) {

                    System.out.println("That's an invalid input.");

                } else break;

            } while (true);


            while (questionsCount < 10) {

                getQuestion(problemType, difficultyLevel, sc, rand, rightAnswers, wrongAnswers);

                questionsCount++;

            }


            int totalAnswers = rightAnswers + wrongAnswers;
           // System.out.println("test");
            //System.out.println(totalAnswers);
            //System.out.println(rightAnswers);
            //System.out.println(wrongAnswers);

            if ((float) rightAnswers / totalAnswers < 0.75) {

                System.out.println("\nPlease ask your teacher for extra help.");

            } else {

                System.out.println("\nCongratulations you are ready to go to the next level");

            }

            questionsCount = 0;

            rightAnswers = 0;

            wrongAnswers = 0;

        }

        while (true);


    }

    static int difficultyLevel(SecureRandom rand,int difficultyLevel)
    {



        int number = 0;

        do

        {

            //Object difficultyLevel = 1.0;
            number = rand.nextInt(5) % (int)Math.pow(10.0, (double)difficultyLevel);

        }while(number == 0);

        return number;

    }
    static void getQuestion(int questionType, int difficultyLevel, Scanner sc, SecureRandom rand, int rightAnswers, int wrongAnswers)

    {

        int firstNumber = difficultyLevel(rand,difficultyLevel);//getNumber(difficultyLevel); // generate first number

        int secondNumber = difficultyLevel(rand,difficultyLevel);//getNumber(difficultyLevel); // generate second number
        int answer = 0;




        if(questionType == 5) questionType = getRandomNumberBetweenRange(1,4, rand);

        char op = ' ';

        do

        {

            switch(questionType)

            {

                case 1: op = '+'; break;

                case 2: op = '-'; break;

                case 3: op = '*'; break;

                case 4: op = '/'; break;

            }



            System.out.println("How much is");
            System.out.print(firstNumber);
            System.out.print(op);
            System.out.print(secondNumber);
            System.out.println("?");

            double studentAnswer;

            studentAnswer=sc.nextInt();



            switch(questionType)

            {

                case 1: answer = firstNumber + secondNumber; break;

                case 2: answer = firstNumber - secondNumber; break;

                case 3: answer = firstNumber * secondNumber; break;

                case 4: answer = firstNumber / secondNumber; break;

            }



            if(questionType == 4)

            {

                if(Math.abs(answer-studentAnswer) < 0.01)

                {

                    System.out.println("Correct Answer");

                    break;

                }

                else

                {

                    System.out.println("WrongAnswer");

                }

            }

            else

            {

                if(studentAnswer == answer)

                {

                    //System.out.println("Correct Answer");
                    printCorrectAnswer(rand, rightAnswers);

                    break;

                }

                else

                {

                    printWrongAnswer(rand, wrongAnswers);
                    break;
                //  System.out.println("Wrong Answer");
                    //test code
                    //System.out.println(answer);
                    //System.out.println(firstNumber);
                    //System.out.println(secondNumber);
                }

            }

        }while(true);

    }


    static int getRandomNumberBetweenRange(int start, int end, SecureRandom rand)
    {

        return (rand.nextInt() % (end - start + 1)) + start;

    }

    static void printCorrectAnswer(SecureRandom rand,int rightAnswers)

    {

        //String message[] = {"Very good!", "Excellent!", "Nice Work!", "Keep the good work!"};

        //int messageIndex = getRandomNumberBetweenRange(0,3, rand);

        //System.out.printf("%s", message[messageIndex]);
        System.out.println("Correct");


        rightAnswers++;
        System.out.println(rightAnswers);

    }

    static void printWrongAnswer(SecureRandom rand, int wrongAnswers)

    {

       // String message[] = {"No. Please try again.", "Wrong. Try once more.", "Don't give up!", "No. Keep trying"};

        //int messageIndex = getRandomNumberBetweenRange(0,3, rand);

       // System.out.printf("%s\n", message[messageIndex]);
        System.out.println("Incorrect");


               wrongAnswers++;
               System.out.println(wrongAnswers);

    }

    static int getNumber(int difficultyLevel) {
        int number = 0;

        return number;

    }

}
