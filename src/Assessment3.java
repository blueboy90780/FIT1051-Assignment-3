import java.util.ArrayList;
import java.util.Arrays;

/*
 * Assessment 3
 *
 * Copyright (c) 2022  Monash University
 *
 * Template made by  Jonny Low
 * Assessment completed by Nguyen Tien Dung (David)
 *
 *
 * References:
 * 1) https://www.geeksforgeeks.org/how-to-convert-an-array-to-string-in-java/
 * 2) https://www.javatpoint.com/java-string-format
 * 3) https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html
 * 4) https://www.tutorialspoint.com/get-the-size-of-an-arraylist-in-java#:~:text=The%20size%20of%20an%20ArrayList%20can%20be%20obtained%20by%20using,the%20ArrayList%20i.e.%20the%20size.
 * 5) https://www.geeksforgeeks.org/arraylist-contains-java/
 * 6) https://www.w3schools.com/java/java_switch.asp
 * 7) https://www.javatpoint.com/java-string-format
 * 9) https://www.techiedelight.com/initialize-array-string-java/
 * 10) https://stackoverflow.com/questions/6640184/java-output-right-alignment
 */
public class Assessment3 {

    public static void main(String[] args) {

        Assessment3 a3 = new Assessment3();

        // Instruction: To run your respective task, uncomment below individually
//        a3.task1a();
        a3.task2();
//        a3.task3();
//        a3.gradeScale("80");
//        a3.daysOfTheWeek("2");
//        a3.task6();
//        a3.task7(20);

    }


    private void task1a() {
        // Variable declaration
        double[] arrayDouble = {1.0, 2.0, 3.0, 4.0, 5.0};
        double valueType = arrayDouble[0];

        System.out.println("Before: " + Arrays.toString(arrayDouble));
        task1b(arrayDouble, valueType);
        // arrayDouble returns a reference pointer to the double array
        // valueType returns a copy of valueType in memory, passing by value
        // valueType gets cleared in memory when code jumps to task1b
        System.out.println("After: " + Arrays.toString(arrayDouble));
        // arrayDouble[0] did not change after calling task1b
        // arrayDouble[1] did change after calling task1b
    }

    private void task1b(double[] arrayReference, double valueCopy) {
        arrayReference[1] += 8324.2342343242;
        //"arrayReference" is an identifier sharing the same object in memory as the identifier "arrayReference" in the scope of method task1a()
        valueCopy += 100;
    }

    // TBD Later
    private void task2() {
        // Declare + Initialize Variables
        int len = 15;
        String spacer = String.format("%" + len + "d", 0).replace("0", " ");
        String myNumber1 = "1";
        String myNumber2 = "10";
        String myNumber3 = "100";
        String myNumber4 = "1000";

        // Offset myNumber with empty spaces such that each line is evenly aligned towards the right
        System.out.println(spacer.substring(myNumber1.length()) + myNumber1);
        System.out.println(spacer.substring(myNumber2.length()) + myNumber2);
        System.out.println(spacer.substring(myNumber3.length()) + myNumber3);
        System.out.println(spacer.substring(myNumber4.length()) + myNumber4);
    }

    private void task3() {

        // Declare + Initialize ArrayList
        ArrayList<String> myList = new ArrayList<>();
        myList.add("one");
        myList.add("seven");
        myList.add("five");
        myList.add("three");
        myList.add("eight");
        myList.add("ten");

        // Adds a element after "five"
        myList.add(3, "eleven");
        for (int i = 0; i < myList.size(); i++) {
            System.out.println("Index " + i + ": " + myList.get(i));
        }

        // Removes second-last element
        myList.remove(myList.size() - 2);

        // Checks myList contains the element "seven"
        System.out.println(myList.contains("seven"));
    }

    private String gradeScale(String mark) {
        // Declare + Initialize Variables
        String Grade;
        int markInt = Integer.parseInt(mark);

        // Checks markInt and assigns a String to Grade
        if (markInt >= 80 && markInt <= 100) {
            Grade = "High Distinction";
        } else if (markInt >= 70 && markInt <= 79) {
            Grade = "Distinction";
        } else if (markInt >= 60 && markInt <= 69) {
            Grade = "Credit";
        } else if (markInt >= 50 && markInt <= 59) {
            Grade = "Pass";
        } else if (markInt >= 0 && markInt <= 49) {
            Grade = "Fail";
        } else { // If all else fails, grade must be <0 or >100
            Grade = "Mark should be between 0 and 100";
        }

        //Print and return
        System.out.println(Grade);
        return Grade;
    }

    private String daysOfTheWeek(String day) {

        // Declare + Initialize Variables
        int dayInt = Integer.parseInt(day);
        String dayString;

        // Checks dayInt and assigns it's corresponding day
        switch (dayInt) {
            case 1:
                dayString = "Monday";
                break; // break; is added to every case to exit switch early without redundantly checking other cases
            case 2:
                dayString = "Tuesday";
                break;
            case 3:
                dayString = "Wednesday";
                break;
            case 4:
                dayString = "Thursday";
                break;
            case 5:
                dayString = "Friday";
                break;
            case 6:
                dayString = "Saturday";
                break;
            case 7:
                dayString = "Sunday";
                break;
            default:
                dayString = "The days number should be between 1 to 7";
        }

        //Prints and return
        System.out.println(dayString);
        return dayString;
    }

    private void task6() {
        // Declare + Initialize Variables
        int radius = 0; //first increment starts with 1
        double area = Math.PI * Math.pow(radius, 2);
        double circumference = 2 * Math.PI * radius;
        double ratio = area / circumference;

        // Prints out radius and ratio for every radius up till 60
        while (ratio < 30) {
            radius++; // Increments radius by 1 every loop
            area = Math.PI * Math.pow(radius, 2);
            circumference = 2 * Math.PI * radius;
            ratio = area / circumference;

            System.out.printf("""
                    Radius: %s
                    Ratio: %s
                    %n""", radius, ratio);
        }
    }


    private void task7(int size) {

        // Initialize + Declare Variables
        int height = size;
        int width = size;
        char[] row = new char[width];

        for (int i = 0; i < height; i++) {

            // Fills row with ' ' or '*'
            Arrays.fill(row, ' '); // Each loop replaces row with empty ' ' characters
            row[i] = '*';
            row[row.length - (i + 1)] = '*';

            //Prints out all elements of row on the same line
            for (char x : row) {
                System.out.print(x);
            }

            //Breaks new line
            System.out.println();
            System.out.println();
        }
    }

}