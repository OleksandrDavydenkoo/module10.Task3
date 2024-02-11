package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String filename = "words.txt";
        TreeMap<String, Integer> wordFrequency = countWordFrequency(filename);
        printWordFrequency(wordFrequency);
    }

    private static TreeMap<String, Integer> countWordFrequency(String filename) {
        TreeMap<String, Integer> wordFrequency = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }

    private static void printWordFrequency(TreeMap<String, Integer> wordFrequency) {
        wordFrequency.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry -> System.out.println(entry.getKey() + " " + entry.getValue()));
    }
}