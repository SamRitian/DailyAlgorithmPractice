import java.util.HashMap;
import java.util.Map;

public class StringPatterns {
    private static final int TOTAL_VOWELS = 5; // Total number of vowels in English
    private static final int TOTAL_CONSONANTS = 21; // Total number of consonants in English

    public static void main(String[] args) {
        int wordLen = 4;
        int maxVowels = 1;
        System.out.println("Unique words: " + calculateWays(wordLen, maxVowels));
    }

    // Method to calculate the number of unique words given word length and maximum consecutive vowels
    public static long calculateWays(int wordLen, int maxVowels) {
        // Initialize memoization table to store intermediate results
        Map<String, Long> memo = new HashMap<>();
        return countWays(wordLen, maxVowels, 0, 0, memo);
    }

    // Recursive method to count the number of unique words
    private static long countWays(int wordLen, int maxVowels, int position, int consecutiveVowels, Map<String, Long> memo) {
        // Base case: If the word length is reached
        if (position == wordLen) {
            return 1;
        }

        // Generate a memoization key for the current state
        String key = position + "-" + consecutiveVowels;

        // If the result for the current state is already calculated, return it
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        long ways = 0;

        // If we can still add vowels
        if (consecutiveVowels < maxVowels) {
            ways += countWays(wordLen, maxVowels, position + 1, consecutiveVowels + 1, memo) * TOTAL_VOWELS;
        }

        // Add consonants
        ways += countWays(wordLen, maxVowels, position + 1, 0, memo) * TOTAL_CONSONANTS;

        // Store the result in the memoization table and return it
        memo.put(key, ways);
        return ways;
    }
}
