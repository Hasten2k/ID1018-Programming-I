import java.util.Scanner;
import com.kthjava.TheShortestPath;

class DetermineTheShortestPath {
  public static void main(String[] args) {

    System.out.println("Determine the shortest path between stations X and Y.");
    System.out.println("-----------------------------------------------------");
    System.out.println("");

    // Initate a new input to facilitate getting integers
    Scanner in = new Scanner (System.in);

    // Get the amount of stations in the system:
    System.out.printf("Amount of stations in Zone 2: ");
    int zone2Stations = in.nextInt();

    System.out.printf("Amount of stations in Zone 3: ");
    int zone3Stations = in.nextInt();

    double[] zone2 = new double[zone2Stations];
    double[][] zone3 = new double[zone2Stations][zone3Stations];
    double[] zone4 = new double[zone3Stations];

    // Get the lengths of the paths bewtween stations
    for (int i = 0; i < zone2Stations ; i++ ) {
      System.out.printf("What is the distance between Station X and Station %d in Zone 2? ", (i + 1));
      zone2[i] = in.nextInt();

      for (int j = 0; j < zone3Stations ; j++ ) {
        System.out.printf("What is the distance between Station %d in Zone 2 and Station %d in Zone 3? ", (i + 1), (j + 1));
        zone3[i][j] = in.nextInt();
      }
    }

    for (int j = 0; j < zone3Stations ; j++ ) {
      System.out.printf("What is the distance between Station %d in Zone 3 and Station Y? ", (j + 1));
      zone4[j] = in.nextInt();
    }

    // Esthetic new line
    System.out.println();

    int[] stations = TheShortestPath.intermediateStations(zone2, zone3, zone4);

    System.out.printf("The shortest path goes between Station %d in Zone 2 and Station %d in Zone 3. %n", stations[0], stations[1]);

    // Esthetic new line
    System.out.println();

    double distance = TheShortestPath.length(zone2, zone3, zone4);
    System.out.printf("The path is " + distance + " units long. %n");
  }
}
