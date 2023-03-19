import java.util.*;

class LeetCode30Part1{
    public static void main(String[] args){
       String s = "barfoothefoobarman";
       String[] words = {"foo","bar"};
       System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        int wordLength = words[0].length();
        int windowLength = wordLength * words.length;
        for (int i = 0; i <= s.length() - windowLength; i++) {
            Map<String, Integer> windowCount = new HashMap<>();
            for (int j = i; j < i + windowLength; j += wordLength) {
                String word = s.substring(j, j + wordLength);
                windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
            }
            if (windowCount.equals(wordCount)) {
                result.add(i);
            }
        }
        return result;
    }
}
