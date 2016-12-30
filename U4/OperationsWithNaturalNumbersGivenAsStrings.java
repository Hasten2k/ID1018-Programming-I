import java.util.Scanner;
import static java.lang.System.out;

class OperationsWithNaturalNumbersGivenAsStrings {
  public static void main(String[] args) {
    out.println("OPERATIONS ON NATURAL NUMBERS " + "IN CHARACTER STRINGS");

    // Enter two natural numbers
    Scanner   in = new Scanner(System.in);
    out.println("Enter two natural numbers to add: ");
    String    number1 = in.next();
    String    number2 = in.next();
    out.println();

    // Add numbers and show result
    String    sum = add(number1, number2);
    // out.printf("The sum is %s. %n", sum);
    show(number1, number2, sum, '+');

    // Subtract numbers and show result
    // Enter two natural numbers
    out.println("Enter two natural numbers to subtract: ");
    number1 = in.next();
    number2 = in.next();
    out.println();
    String    subtract = subtract(number1, number2);
    show(number1, number2, subtract, '-');
  }


  // The add method accepts two natural numbers represented
  // as character strings and returns their sum as a
  // character string.
  public static String add (String num1, String num2) {
    // Initiate helper variables
    int carry = 0;
    int result = 0;
    StringBuilder resultContainer = new StringBuilder();
    String total = "";
    int longestNumber;
    int length = 0;

    // reverse numbers to make them easier to work with in loops
    num1 = new StringBuilder(num1).reverse().toString();
    num2 = new StringBuilder(num2).reverse().toString();

    // Check which number is longest and set the shorter to loop length
    longestNumber = ( (num1.length() >= num2.length() ) ? 1 : 2 );

    if (longestNumber == 1) {
      length = num2.length();
    } else {
      length = num1.length();
    }

    int i = 0; // loop counter variable
    do {
      // convert the char to its equivalent integer value
      int x = num1.charAt(i) - 48;
      int y = num2.charAt(i) - 48;
      result = x + y + carry;

      if (result > 9) {
        // Set the carry to 1 and get the single integer as a result
        carry = 1;
        result -= 10;
      } else {
        carry = 0;
      }

      resultContainer.append(result);

      i++;
    } while (i < length);

    // Add the last digits to the result before returning it
    switch (longestNumber) {
      case 1:
        while ( i < num1.length() ) {
          int x = num1.charAt(i) - 48;
          result = x + carry;
          if (result > 9) {
            // Set the carry to 1 and get the single integer as a result
            carry = 1;
            result -= 10;
          }
          resultContainer.append(result);
      		i++;
        }
        break;
      case 2:
        while ( i < num2.length() ) {
          int x = num2.charAt(i) - 48;
          result = x + carry;
          if (result > 9) {
            // Set the carry to 1 and get the single integer as a result
            carry = 1;
            result -= 10;
          }
          resultContainer.append(result);
          carry = 0;
          i++;
        }
        break;
    }

    // Check if there is still a carry to take into account after last operation
    if (carry == 1) {
      resultContainer.append(carry);
    }

    total = resultContainer.reverse().toString();
    return total;
  }

  // The subtract method accepts two natural numbers
  // represented as character strings and returns their
  // difference as a character string.
  // The first number is not smaller than the second
  public static String subtract (String num1, String num2) {
    // Set some helper variables
    int i           = 0; // counter variable to be used in several loops
    int carry       = 0;
    int timesToLoop = 0;
    String negative = ""; // if the result is negative, this var will hold a "-" sign

    StringBuilder larger  = new StringBuilder(); // variable to hold the larger number
    StringBuilder smaller = new StringBuilder(); // variable to hold the smaller number
    StringBuilder resultContainer = new StringBuilder();

    if ( num1.equals(num2) ) {
      return resultContainer.append("0").toString(); // If both strings are the same, result will be 0
    }

    // Check which number is the largest
    if (num1.length() == num2.length()) {
      // If both numbers are equally long, check each digit to see which one is the larger number
      do {
        if (num1.charAt(i) == num2.charAt(i)) {
          i++;
          continue;
        } else if (num1.charAt(i) > num2.charAt(i)) {
          larger.append(num1);
          smaller.append(num2);
          break;
        } else {
          larger.append(num2);
          smaller.append(num1);
          negative = "-";
          break;
        }
      } while (i < num1.length());
    } else if (num1.length() > num2.length()) {
      larger.append(num1);
      smaller.append(num2);
    } else {
      larger.append(num2);
      smaller.append(num1);
      negative = "-";
    }

    // Set the amount of times to loop
    timesToLoop = smaller.length();

    // reverse numbers to make them easier to work with in loops
    larger = larger.reverse();
    smaller = smaller.reverse();

    i = 0; // reset the counter variable for new loop
    do {
      int sub = 0; // temporary variable to hold resuls of calculations
      // Subtract 48 from each char to get the proper integer value
      int x = larger.charAt(i) - 48;
      int y = smaller.charAt(i) - 48;
      if (x < y || (x == 0 && carry == 1) ) {
        sub = 10 + x - y - carry;
        carry = 1;
        resultContainer.append(sub);
        i++;
      } else {
        sub = x - y - carry;
        resultContainer.append(sub);
        i++;
      }
    } while (i < timesToLoop);

    if (carry == 1) {
      int x = larger.charAt(i) - 48;
      if (x > 0) {
        x = x - carry;
        resultContainer.append(x);
        i++;
      } else {
        int y = larger.charAt(i + 1) - 48;
        x = 10 - carry; // will always be 9 but more readable like this
        y = y - 1;
        resultContainer.append(x);
        resultContainer.append(y);
        i = i + 2;
      }
    }

    while (i < larger.length()) {
      resultContainer.append(larger.charAt(i));
      i++;
    }

    resultContainer.append(negative);

    return resultContainer.reverse().toString();
  }

  // The show method presents two natural numbers, an // operator and the result string.
  public static void show (String num1, String num2, String result, char operator) {
    // Set an appropriate length on numbers and result
    int   len1     = num1.length();
    int   len2     = num2.length();
    int   len      = result.length();
    int   maxLen   = result.length();

    num1    = setLen(num1, maxLen - len1);
    num2    = setLen(num2, maxLen - len2);
    result  = setLen(result, maxLen - len);

    // Show the expression
    out.println("  " + num1);
    out.println("" + operator + " " + num2);
    for(int i = 0; i < maxLen + 2; i++) {
      out.print("-");
    }
    out.println();
    out.println("  " + result + "\n");
  }

  // The setLen method prepends the supplied number of
  // spaces to the beginning of a string
  public static String setLen (String s, int nofSpaces) {
    StringBuilder sb = new StringBuilder (s);
    for (int i = 0; i < nofSpaces; i++) {
      sb.insert (0, " ");
    }

    return sb.toString();
  }

}
