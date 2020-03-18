package array_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 245, Level: Medium
 * 
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 * 
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Input: word1 = “makes”, word2 = “coding”
 * Output: 1
 * 
 * Input: word1 = "makes", word2 = "makes"
 * Output: 3
 */
public class LeetCode245_ShortestWordDistance3 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        int first = -1;
        int second = -1;

        int distance = words.length;
        

        if(word1.equals(word2)) {
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    if(first != -1) {
                        distance = Math.min(distance, i - first);
                    }
                    first = i;
                }
            }
        }
        else {
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    first = i;
                }
                else if(words[i].equals(word2)) {
                    second = i;
                }

                if(first != -1 && second != -1) {
                    distance = Math.min(distance, Math.abs(first - second));
                }
            }
        }

        return distance;
    }
    
    public static void main(String[] args) {
        LeetCode245_ShortestWordDistance3 obj = new LeetCode245_ShortestWordDistance3();
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        
        System.out.println(obj.shortestWordDistance(words, "perfect", "makes"));
        System.out.println(obj.shortestWordDistance(words, "makes", "makes"));
    }

}
