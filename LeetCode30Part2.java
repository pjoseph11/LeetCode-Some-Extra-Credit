import java.util.*;

class LeetCode30Part2 {
   public static void main(String[] args){
       String s = "abarfoootheaafooobarman";
       String[] words = {"fooo","bar"};
       System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        // map keeps track of each work in the input array
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        int wordLength = words[0].length();
        // calculating size of sliding window
        int windowLength = wordLength * words.length;
        
        for (int i = 0; i <= s.length() - windowLength; i++) {
            Map<String, Integer> windowCount = new HashMap<>();
            int j = i;
            while (j < i + windowLength) {
                String word = getNextWord(s, j, wordCount.keySet());
                if (word == null) {
                    break;
                }
                windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                j += word.length();
            }
            if (windowCount.equals(wordCount)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    /* sinces words can be different sizes startsWith method is implemented to compare
    words in the window as it slides across the input string */
    private static String getNextWord(String s, int start, Set<String> words) {
        for (String word : words) {
            if (s.startsWith(word, start)) {
                return word;
            }
        }
        return null;
    }
}
