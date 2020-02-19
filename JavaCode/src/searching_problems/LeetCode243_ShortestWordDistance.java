package searching_problems;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 243, Level: Easy
 * 
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * 
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * 
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 */
public class LeetCode243_ShortestWordDistance {
    
    public int shortestDistance(String[] words, String word1, String word2) {
        int first = -1;
        int second = -1;
        
        int distance = words.length;
        
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)) {
                first = i;
            }
            else if(words[i].equals(word2)) {
                second = i;
            }
            
            if (first != -1 && second != -1) {
                distance = Math.min(distance, Math.abs(first - second));
            }
        }
        
        return distance;
    }

    public static void main(String[] args) {
        LeetCode243_ShortestWordDistance obj = new LeetCode243_ShortestWordDistance();

        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        String word1 = "coding";
        String word2 = "practice";
        
        System.out.println(obj.shortestDistance(words, word1, word2));
    }

}
