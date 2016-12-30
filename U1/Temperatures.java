import java.util.*; // Scanner, Locale

class Temperatures {
    public static void main(String[] args) {
        System.out.println ("TEMPERATURES\n");

        // Input tools
        Scanner in = new Scanner (System.in);
        in.useLocale (Locale.US);

        // Enter the number of weeks and measurements
        System.out.print("Number of weeks: ");
        int nOfWeeks = in.nextInt();

        System.out.print("Number of measurments per week: ");
        int nofMeasurmentsPerWeek = in.nextInt();

        // Storage for temperature data
        double[][] t = new double[nOfWeeks + 1][nofMeasurmentsPerWeek + 1];

        // Read the temperatures
        for (int week = 1; week <= nOfWeeks; week++)
        {
            System.out.println("temperatures - week " + week + ":");
            for (int reading = 1; reading <= nofMeasurmentsPerWeek; reading++) t[week][reading] = in.nextDouble();
        }
        System.out.println();

        // Show temperatures
        System.out.println("The temperatures:");
        for (int week = 1; week <= nOfWeeks; week++) {
            for (int reading = 1; reading <= nofMeasurmentsPerWeek; reading++) System.out.print(t[week][reading] + " ");
            System.out.println();
        }
        System.out.println();

        // The least, greatest and average temperature - weekly
        double[]    minT = new double[nOfWeeks + 1];
        double[]    maxT = new double[nOfWeeks + 1];
        double[]    sumT = new double[nOfWeeks + 1];
        double[]    avgT = new double[nOfWeeks + 1];

        // Compute and store the least, greatest and average
        // temperature for each week.

        // Loop through all weeks
        for (int week = 1; week <= nOfWeeks; week++)
        {

            //    **** Compute averages for each week ****
            // Get all temperatures for week and loop through them
            for (int reading = 1; reading <= nofMeasurmentsPerWeek; reading++)
            {
                // Add all temperatures together & store in variable
                sumT[week] += t[week][reading];
            }
            // Divide sum of temperatures with number of datapoints and
            // store result
            avgT[week] = sumT[week] / nofMeasurmentsPerWeek;

            //    **** Compute lowest temp for each week ****
            // Assume first value is smallest
            minT[week] = t[week][1];
            for (int reading = 1; reading <= nofMeasurmentsPerWeek; reading++)
            {
                if (minT[week] > t[week][reading]) {
                    minT[week] = t[week][reading];
                }
            }
            //    **** Compute highest temp for each week ****
            // Assume first value is highest
            maxT[week] = t[week][1];
            for (int reading = 1; reading <= nofMeasurmentsPerWeek; reading++)
            {
                if (maxT[week] < t[week][reading]) {
                    maxT[week] = t[week][reading];
                }
            }
        }

        // Show the least, greatest and average temperature for each week
        System.out.println("Average Temperatures");
        System.out.println("----------------");
        for (int week = 1; week <= nOfWeeks; week++ )
        {
            System.out.println("Week " + week + ": " + avgT[week]);
        }
        System.out.println();

        System.out.println("Smallest Temperatures");
        System.out.println("----------------");
        for (int week = 1; week <= nOfWeeks; week++ )
        {
            System.out.println("Week " + week + ": " + minT[week]);
        }
        System.out.println();

        System.out.println("Largest Temperatures");
        System.out.println("----------------");
        for (int week = 1; week <= nOfWeeks; week++ )
        {
            System.out.println("Week " + week + ": " + maxT[week]);
        }

        // The least, greatest and average temperature - whole period
        double minTemp = minT[1];
        double maxTemp = maxT[1];
        double sumTemp = sumT[1];
        double avgTemp = 0;

        // compute and store the least, greatest and average
        // temperature for the whole period

        // Total amount of readings for the period:
        int totalReadings = nOfWeeks * nofMeasurmentsPerWeek;
        for (int week = 2; week <= nOfWeeks; week++)
        {

            // Add all values together for total sum
            sumTemp += sumT[week];

            // Find smallest value, assume first is smallest initially
            if (minTemp > minT[week])
            {
                minTemp = minT[week];
            }

            // Find largest value, assume first is largest initially
            if (maxTemp < maxT[week])
            {
                maxTemp = maxT[week];
            }

        }
        // Calculate the average temp for the entire period
        avgTemp = sumTemp / totalReadings;

        // show the least, greatest and average temperature for
        // the whole period
        System.out.println();
        System.out.println("Values for entire period");
        System.out.println("----------------");
        System.out.println("Average Temperature: " + avgTemp);
        System.out.println("Minimum Temperature: " + minTemp);
        System.out.println("Maximum Temperature: " + maxTemp);
    }
}
