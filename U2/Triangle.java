import java.math.*;

public class Triangle {
    // Set properties of the triangle
    private double      mSideA = 0;
    private double      mSideB = 0;
    private double      mSideC = 0;
    private double      mAngleAlpha = 0;
    private double      mAngleBeta = 0;
    private double      mAngleCharlie = 0;

    // Initialise helper variables to catch illegal inputs
    private boolean     inputIsNotDouble = true;
    private String      input = "";
    private double      inputAsDouble = 0.0;

    // Setter functions for triangle sides and angles
    public void setSide(char side) {
        do {
            System.out.printf("Set side %s of the Triangle: ", side);
            input = System.console().readLine();
            // Check that input contains a deimal value
            try {
                inputAsDouble = Double.parseDouble(input);
            } catch(NumberFormatException e) {
                System.out.println("Side has to be a decimal value. Try again.");
                continue;
            }
            // Check that decimal value is larger than 0
            if (inputAsDouble > 0) {
                // Use the side char to determine what side to set
                switch (side) {
                    case 'a':
                        mSideA = inputAsDouble;
                    case 'b':
                        mSideB = inputAsDouble;
                    case 'c':
                        mSideC = inputAsDouble;
                }
                // Gracefully exit the loop
                inputIsNotDouble = false;
            } else {
                System.out.println("Side has to be longer than 0 units, try again.");
                continue;
            }
        } while (inputIsNotDouble);
    }

    public void setAllSides() {
        setSide('a');
        setSide('b');
        setSide('c');
    }

    public void setAngle(String angle) {
        do {
            System.out.printf("Set size of angle %s: ", angle);
            input = System.console().readLine();
            // Check that input contains a deimal value
            try {
                inputAsDouble = Double.parseDouble(input);
            } catch(NumberFormatException e) {
                System.out.println("Angle has to be a decimal value. Try again.");
                continue;
            }

            // Check that decimal value is larger than 0
            if (inputAsDouble > 0 & inputAsDouble < 180) {
                // Use the angle char to determine what angle to set
                switch (angle) {
                    case "alpha":
                        mAngleAlpha = inputAsDouble;
                    case "beta":
                        mAngleBeta = inputAsDouble;
                    case "charlie":
                        mAngleCharlie = inputAsDouble;
                }
                // Gracefully exit the loop
                inputIsNotDouble = false;
            } else {
                System.out.println("Angle has to be between 0 and 180 degrees, try again.");
                continue;
            }

        } while (inputIsNotDouble);
    }

    public void setAllAngles() {
        setAngle("alpha");
        setAngle("beta");
        setAngle("charlie");
    }

    // Getter functions for triangle sides and angles
    public double getSideA() {
        return mSideA;
    }
    public double getSideB() {
        return mSideB;
    };
    public double getSideC() {
        return mSideC;
    };
    public double getAngleAlpha() {
        return mAngleAlpha;
    };
    public double getAngleBeta() {
        return mAngleBeta;
    };
    public double getAngleCharlie() {
        return mAngleCharlie;
    };

    public double bisectorAB(double sideA, double sideB, double angleAlpha) {
        double      angleAlphaRad = Math.toRadians(angleAlpha);
        double      p = 2 * sideA * sideB * Math.cos( angleAlphaRad / 2 );
        double      bisAB = p / ( sideA + sideB );

        return bisAB;
    }

    public double bisectorAC(double sideA, double sideC, double angleCharlie) {
        double      angleCharlieRad = Math.toRadians(angleCharlie);
        double      p = 2 * sideA * sideC * Math.cos( angleCharlieRad / 2 );
        double      bisAC = p / ( sideA + sideC );

        return bisAC;
    };

    public double bisectorBC(double sideB, double sideC, double angleBeta) {
        double      angleBetaRad = Math.toRadians(angleBeta);
        double      p = 2 * sideB * sideC * Math.cos( angleBetaRad / 2 );
        double      bisBC = p / ( sideB + sideC );

        return bisBC;
    };

    // Method to calculate the perimeter of triangle
    public double perimeterOfTriangle(double sideA, double sideB, double sideC) {
        double perimeter = sideA + sideB + sideC;
        return perimeter;
    }

    // Method for calculating the area given three sides
    public double areaUsingSides(double sideA, double sideB, double sideC) {
        double semiperim = perimeterOfTriangle(sideA, sideB, sideC) / 2;
        double area = Math.sqrt( semiperim * (semiperim - sideA) * (semiperim - sideB) * (semiperim - sideC) );

        return area;
    }

    public double circumferenceOfOutcircle(){
        setAllSides();
        setAllAngles();

        double      area = areaUsingSides(mSideA, mSideB, mSideC);
        double      angleAlphaRad = Math.toRadians(mAngleAlpha);
        double      angleBetaRad = Math.toRadians(mAngleBeta);
        double      angleCharlieRad = Math.toRadians(mAngleCharlie);

        double      diameter = Math.sqrt( (2 * area) / (Math.sin(angleAlphaRad) * Math.sin(angleBetaRad) * Math.sin(angleCharlieRad)) );
        double      circumference = Math.PI * diameter;

        return (diameter / 2);
    }

    public double circumferenceOfIncircle() {
        setAllSides();

        double      radius = 2 * areaUsingSides(mSideA, mSideB, mSideC) / perimeterOfTriangle(mSideA, mSideB, mSideC);
        double      circumference = Math.PI * radius * 2;
        return radius;
    }
}
