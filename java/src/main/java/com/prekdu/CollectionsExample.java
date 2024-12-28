package com.prekdu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/*
 * Demonstrates usage of List, Set, and Map for storing and
 * displaying strings and frequencies.
 */
public final class CollectionsExample {

  private CollectionsExample() {
    // Prevent instantiation
  }

  /**
   * Main method for the program.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      List<String> strList = new ArrayList<>();
      Set<String> strSet = new HashSet<>();
      Map<String, Integer> freqMap = new HashMap<>();

      System.out.println("Enter 10 strings:");
      final int stringCount = 10;

      for (int i = 0; i < stringCount; i++) {
        String input = scanner.nextLine();
        strList.add(input);
        strSet.add(input);
        freqMap.put(input, freqMap.getOrDefault(input, 0) + 1);
      }

      System.out.println("\nContents of the List:");
      strList.forEach(System.out::println);

      System.out.println("\nContents of the Set:");
      strSet.forEach(System.out::println);

      System.out.println("\nContents of the Map:");
      freqMap.forEach((key, value) -> System.out.println(key + ": " + value));
    }
  }
}
