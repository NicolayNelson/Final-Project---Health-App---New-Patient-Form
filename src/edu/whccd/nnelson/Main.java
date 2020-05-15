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


        // Limits the number to 1000-Current Year
        boolean isValidAge = true;
        do {
            System.out.println("Year of birth 4 digits (1000 - Current Year):\t");
            int yearOfBirth = input.nextInt();
            if (yearOfBirth > 1000 || yearOfBirth <= LocalDateTime.now().getYear()) {
                isValidAge = true;
            }
        }while (!isValidAge); 
            int age = LocalDateTime.now().getYear() - yearOfBirth;

            // Set ups a gender question and input
            System.out.print("Gender (M => Male, F => Female, O => Other / Not Listed):\t");
            String gender = input2.nextLine();

            // Sets up a variable for the console log for what the user inputs
            if (gender.equalsIgnoreCase("m")) {
                gender = "Male";
            } else if (gender.equalsIgnoreCase("male")) {
                gender = "Male";
            } else if (gender.equalsIgnoreCase("f")) {
                gender = "Female";
            } else if (gender.equalsIgnoreCase("female")) {
                gender = "Female";
            } else {
                gender = "Other / Not Listed (" + gender + ")";
            }

            // Questions to be answered.

            ArrayList<String> questions = new ArrayList<>();
            questions.add("[1]Has the patient traveled to anyplace outside of the United States recently:\t");
            questions.add("[2]Does the patient have any known conditions:\t");
            questions.add("[3]Is the patient allergic to any type of medicine:\t");
            questions.add("[4]Was the patient admitted before:\t");
            questions.add("[5]Family medical history:\t");
            questions.add("[6]Current medications the patient is on:\t");
            questions.add("[7]Recent surgeries:\t");
            questions.add("[8]How much alcohol does the patient consume a week:\t");
            questions.add("[9]Does the patient have a smoking history:\t");
            questions.add("[10]Does the patient have insurance:\t");
            questions.add("[11]Emergency contact information:\t");

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

            for (int i = 0; i < questionsAndAnswers.size(); i++) {
                if (i % 2 == 0) {
                    System.out.println((i + 1) + ". " + questionsAndAnswers.get(i));
                } else {
                    System.out.println("\t- " + questionsAndAnswers.get(i));
                }
            }
        }
    }

