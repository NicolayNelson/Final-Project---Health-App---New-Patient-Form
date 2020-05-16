package edu.whccd.nnelson;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/*The following program will contain at least the name / age (to year)/ and gender as well as 10 quesions
that would be used in a Health App - New Patient Form
Author Nicolay Nelson
 */


public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        // Enter the first and last name will enter as Last, First in Console
        System.out.print("First Name:\t");
        String firstName = input.next();
        System.out.print("Last Name:\t");
        String lastName = input.next();

        // Enter year of birth for 4 digits


        // Limits the number to 1000-Current

        boolean isValidAge = false;
        int yearOfBirth;
        do {
            System.out.println("Year of birth 4 digits (1000 - Current Year):\t");
            yearOfBirth = input.nextInt();
            if (yearOfBirth > 1000 && yearOfBirth <= LocalDateTime.now().getYear()) {
                isValidAge = true;
            }
        }while (!isValidAge);

            int age = LocalDateTime.now().getYear() - yearOfBirth;


            // Set ups a gender question and input
            boolean gender1 = false;
            String gender;
            do {
                System.out.print("Gender (M => Male, F => Female, O => Other / Not Listed):\t");
                gender = input2.nextLine();
                switch ( gender ) {
                    case "m":
                    case "M":
                        gender = "Male";
                        gender1 = true;
                        break;
                    case "f":
                    case "F":
                        gender = "Female";
                        gender1 = true;
                        break;
                    case "o":
                    case "O":
                        gender = "Other / Not Listed";
                        gender1 = true;
                        break;
                    default:
                        System.out.println("Please enter either M/F/O");
                        break;
                }
            } while (!gender1);


            // Questions to be answered.

            ArrayList<String> questions = new ArrayList<>();
            questions.add("Has the patient traveled to anyplace outside of the United States recently:\t");
            questions.add("Does the patient have any known conditions:\t");
            questions.add("Is the patient allergic to any type of medicine:\t");
            questions.add("Was the patient admitted before:\t");
            questions.add("Family medical history:\t");
            questions.add("Current medications the patient is on:\t");
            questions.add("Recent surgeries:\t");
            questions.add("How much alcohol does the patient consume a week:\t");
            questions.add("Does the patient have a smoking history:\t");
            questions.add("Does the patient have insurance:\t");
            questions.add("Emergency contact information:\t");

            // ArrayList for the answers
            ArrayList<String> answers = new ArrayList<>();

            // Answer loop for each question
            for (String s : questions) {
                System.out.println(s);
                String answer = input2.nextLine();
                answers.add(answer);
            }
            // Attempt to put both ArrayList for questions and ArrayList for answers into one
            ArrayList<String> questionsAndAnswers = new ArrayList<>();
            for (int i = 0; i < questions.size(); i++) {
                questionsAndAnswers.add(questions.get(i));
                questionsAndAnswers.add(answers.get(i));
            }
            // Console print out of Name / age /gender / questions / answers
            System.out.println("User's Full name last, first: " + lastName + ", " + firstName);
            System.out.println("User's age: " + age);
            System.out.println("User's Gender:  " + gender);

            int counter = 1;
            for (int i = 0; i < questionsAndAnswers.size(); i++) {
                if (i % 2 == 0) {
                    System.out.println((counter) + ". " + questionsAndAnswers.get(i));
                    counter++;
                } else {
                    System.out.println("\t- " + questionsAndAnswers.get(i));
                }
            }
        }
    }

