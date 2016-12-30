import java.util.*;

public class TriangleAndItsCircles {
    // Set the Java Utility Scanner as input tool
    public static Scanner in = new Scanner (System.in);

    // Instantiate a new Triangle object to use methods on
    public static Triangle    triangle = new Triangle();

    public static void main(String[] args) {
        in.useLocale(Locale.US);

        System.out.println("A program for calculating various things on a Triangle.");
        System.out.println("-------------------------------------------------------");
        System.out.println();

        /**********************************
        *       MAIN MENU OF PROGRAM
        ***********************************/
        // Menu Helper variables
        int         calculationSelector = 0;
        boolean     inputIsNotInteger = true;

        // Ask user what to calculate
        System.out.println("Choose what you want to calculate:");
        System.out.println("Available options:");
        System.out.println("1. Bisector (requires two sides and angle between them)");
        System.out.println("2. Area of Triangle by using all three sides.");
        System.out.println("3. Circumference of the Outcircle.");
        System.out.println("4. Circumference of the Incircle.");

        // Get the users selection
        do {
            System.out.printf("Select what to calculate here: ");
            // Check that input is an integer
            if (in.hasNextInt()) {
                calculationSelector = in.nextInt();
                if (calculationSelector > 4 || calculationSelector <= 0) {
                    System.out.println("Sorry, that is not a valid option. Try again.");
                    calculationSelector = 0;
                    continue; // restart loop directly
                } else {
                    inputIsNotInteger = false;
                }
            } else {
                // If input is not an integer, ask user to try again
                in.next();
                System.out.println("Sorry, input has to be an Integer. Please try again.");
                continue;
            }
        } while (inputIsNotInteger);

        // Clean out read buffer
        in.nextLine();

        /**************************
        *   PERFORM CALCULATIONS
        ***************************/
        // variable to hold results of calculations
        double      result = 0;

        switch (calculationSelector) {
            case 1: // Bisector calculation
                bisectorSelector();
                break;

            case 2: // Area using sides
                triangle.setAllSides();

                double      area = triangle.areaUsingSides(triangle.getSideA(), triangle.getSideB(), triangle.getSideC());
                System.out.println("The area is " + area + " units large.");
                break;

            case 3: // Circumference of Outcircle
                result = triangle.circumferenceOfOutcircle();
                System.out.println("The circumference of the Outcircle is: " + result + " units long.");
                break;

            case 4: // Circumference of the Incircle
                result = triangle.circumferenceOfIncircle();
                System.out.println("The circumference of the Incircle is: " + result + " units long.");
                break;

        }
    }

    /****************************************
    *   SUB MENU FOR BISECTOR CALCULATIONS
    *****************************************/

    public static void bisectorSelector() {
        // Helper variables
        int         calculationSelector = 0;
        boolean     inputIsNotInteger = true;

        System.out.println("What bisector would you like to calculate?");
        System.out.println("1. Side A, B and angle between them.");
        System.out.println("2. Side A, C and angle between them.");
        System.out.println("3. Side B, C and angle between them.");
        System.out.println("4. All Bisectors.");

        // Ask for the bisector to calculate
        do {
            System.out.printf("Select what to calculate here: ");
            // Check that input is an integer
            if (in.hasNextInt()) {
                calculationSelector = in.nextInt();
                if (calculationSelector <= 4 | calculationSelector >= 1) {
                    System.out.println("Sorry, that is not a valid option. Try again.");
                    calculationSelector = 0;
                    continue; // restart loop directly
                } else {
                    inputIsNotInteger = false;
                }
            }
            // If input is not an integer, ask user to try again
            in.next();
            System.out.printf("Sorry, input has to be an Integer. Please try again.");
        } while (inputIsNotInteger);
        System.out.printf("Type the appropriate option number here: ");

        // Instantiate the return variable for the bisectors
        double bisector;

        // Clean out read buffer
        in.nextLine();

        switch (calculationSelector) {
            case 1:
            case 2:
            case 3:
                triangle.setSide('a');
                triangle.setSide('b');
                System.out.printf("Set the angle between them (in degrees): ");
                triangle.setAngle("alpha");
                bisector = triangle.bisectorAB(triangle.getSideA(), triangle.getSideB(), triangle.getAngleAlpha());
                System.out.println("The bisector is " + bisector + " units long.");
                break;

            case 4:
                triangle.setAllSides();

                double  bisectorAB = triangle.bisectorAB(triangle.getSideA(), triangle.getSideB(), triangle.getAngleAlpha());
                double  bisectorAC = triangle.bisectorAC(triangle.getSideA(), triangle.getSideC(), triangle.getAngleCharlie());
                double  bisectorBC = triangle.bisectorBC(triangle.getSideB(), triangle.getSideC(), triangle.getAngleBeta());
                System.out.println("The bisectors are " + bisectorAB + ", " + bisectorAC + ", and " + bisectorBC + " units long respectively.");
                break;
        }
    }
}
