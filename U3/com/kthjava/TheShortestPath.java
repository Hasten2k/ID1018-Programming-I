package com.kthjava;

public class TheShortestPath {

  // The method intermediateStations returns a vector of the
  // intermediate stations that are on the shortest path.
  // The ordinal number of the first station is located in
  // index 1 of the vector, and the second station on index 2.
  public static int[] intermediateStations(double [] a, double [][] b, double [] c) {
    // Inititate the return variable containing the two stations
    int[] stations = new int[2];

    // Initiate the variable to hold the distance of the shortest path. Assume the first path is shortest initially.
    double shortestLength = a[0] + b[0][0] + c[0];
    // Initiate the distance comparison variable
    double currentLength;

    // Initiate variables to keep track of the stations.
    int stationU = 1;
    int stationV = 1;

    // Loop over all stations and get the two that represents the shortest path between zone 1 and 4.
    for (int i = 0; i < a.length; i++ ) {
      for (int j = 0; j < b[i].length; j++ ) {
        // Calculate the current length of the path
        currentLength = a[i] + b[i][j] + c[j];

        if (currentLength < shortestLength) {
          shortestLength = currentLength;
          stationU = i + 1; // Add one to get the station number and not the index value.
          stationV = j + 1;
        }
      }
    }

    // Assign the two stations to the return variable
    stations[0] = stationU;
    stations[1] = stationV;

    return stations;
  }

  // The method length returns the length of the shortest path.
  public static double length (double [] a, double [][] b, double [] c) {
    // Initiate the variable to hold the distance of the shortest path. Assume the first path is shortest initially.
    double shortestLength = a[0] + b[0][0] + c[0];
    // Initiate the distance comparison variable
    double currentLength;

    // Loop over all stations and get the two that represents the shortest path between zone 1 and 4.
    for (int i = 0; i < a.length; i++ ) {
      for (int j = 0; j < b[0].length; j++ ) {
        // Calculate the current length of the path
        currentLength = a[i] + b[i][j] + c[j];

        if (currentLength < shortestLength) {
          shortestLength = currentLength;
        }
      }
    }

    return shortestLength;
  }
}
