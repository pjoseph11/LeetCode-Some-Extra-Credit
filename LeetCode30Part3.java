import java.util.*;

class LeetCode30Part3 {
   public static void main(String[] args){
       String s = "barfoofoobarthemanfoobarman";
       String[] words = {"bar","foo","the"};
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

        for (int i = 0; i <= s.length() - wordLength * words.length; i++) {
            Map<String, Integer> windowCount = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                String word = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (!wordCount.containsKey(word)) {
                    break;
                }
                windowCount.put(word, windowCount.getOrDefault(word, 0) + 1);
                if (windowCount.get(word) > wordCount.getOrDefault(word, 0)) {
                    break;
                }
                j++;
            }
            if (j == words.length) {
                result.add(i);
            }
        }

        return result;
    }
}
