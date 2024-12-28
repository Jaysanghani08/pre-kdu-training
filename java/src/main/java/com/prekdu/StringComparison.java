package com.prekdu;

import java.util.Scanner;

/*
 * Create a basic Java Program that takes two strings as input
 * and produces the following output:
 * - Print the length of the first string
 * - Print the length of the second string
 * - Print if the length matches or not
 * - Print if the two strings are the same
 */

/*
 * Compares two strings and prints
 * their lengths, equality, and other properties.
 */
public final class StringComparison {

  private StringComparison() {
    // Private constructor to prevent instantiation
  }

  /**
   * Main method for the program.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Enter first string:");
      String str1 = scanner.nextLine();

      System.out.println("Enter second string:");
      String str2 = scanner.nextLine();

      System.out.println("Length of first string: " + str1.length());
      System.out.println("Length of second string: " + str2.length());
      System.out.println("Lengths match: " + (str1.length() == str2.length()));
      System.out.println("Strings are same: " + str1.equals(str2));
    }
  }
}
