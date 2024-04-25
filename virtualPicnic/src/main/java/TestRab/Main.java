package TestRab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Map<String, Integer> wordCount = new HashMap<>();
        String longestWord = "";
        int maxFrequency = 0;

        try {
            File file = new File("input.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next();
                int count = wordCount.getOrDefault(word, 0);
                wordCount.put(word, count + 1);

                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

            scanner.close();

            System.out.println("Количество слов в файле: " + wordCount.size());
            System.out.println("Самое длинное слово: " + longestWord);
            System.out.println("Частота встреч каждого слова:");
            for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue() + " раз");
            }

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден.");
        }
    }
}