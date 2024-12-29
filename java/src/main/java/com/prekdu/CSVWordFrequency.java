package com.prekdu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * This class reads a CSV file and prints the top repeated words in the file.
 */
public final class CSVWordFrequency {

  /** The number of top repeated words to display. */
  private static final int TOP_REPEATED_WORDS = 3;

  private CSVWordFrequency() {
    // Private constructor to prevent instantiation
  }

  /**
   * Main method for running the program.
   *
   * @param args the command-line arguments
   */
  public static void main(final String[] args) {
    final String filePath = "src/main/resources/input.csv";

    try {
      priTopRepeatedwords(filePath, TOP_REPEATED_WORDS);
    } catch (IOException e) {
      System.err.println("Error reading the file: " + e.getMessage());
    }
  }

  /**
   * Reads a CSV file and prints the top repeated words.
   *
   * @param filePath the path to the CSV file
   * @param topN the number of top repeated words to display
   * @throws IOException if an I/O error occurs
   */
  private static void priTopRepeatedwords(final String filePath, final int topN)
      throws IOException {
    Map<String, Integer> wordFrequency = new HashMap<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = reader.readLine()) != null) {
        String[] words = line.split(",");
        for (String word : words) {
          // Use Locale with toLowerCase
          word = word.trim().toLowerCase(Locale.ENGLISH);
          wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }
      }
    }

    // Use Queue interface for PriorityQueue
    Queue<Map.Entry<String, Integer>> pq =
        new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

    for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
      pq.offer(entry);
      if (pq.size() > topN) {
        pq.poll();
      }
    }

    System.out.println("Top " + topN + " repeated words:");
    while (!pq.isEmpty()) {
      Map.Entry<String, Integer> entry = pq.poll();
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
