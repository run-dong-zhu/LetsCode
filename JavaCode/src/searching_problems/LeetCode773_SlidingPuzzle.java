package searching_problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author run-dong-zhu
 * @description LeetCode 773, Level: Hard
 * 
 * https://leetcode.com/problems/sliding-puzzle/
 */
public class LeetCode773_SlidingPuzzle {
    class Node {
        int[][] board;
        String boardstring;
        int heuristic;
        int zero_r;
        int zero_c;
        int depth;
        
        Node(int[][] B, int zr, int zc, int d) {
            board = B;
            boardstring = Arrays.deepToString(board);

            //Calculate heuristic
            heuristic = 0;
            int R = B.length, C = B[0].length;
            for (int r = 0; r < R; ++r)
                for (int c = 0; c < C; ++c) {
                    if (board[r][c] == 0) continue;
                    int v = (board[r][c] + R*C - 1) % (R*C);
                    // v/C, v%C: where board[r][c] should go in a solved puzzle
                    heuristic += Math.abs(r - v / C) + Math.abs(c - v % C);
                }
            heuristic /= 2;
            zero_r = zr;
            zero_c = zc;
            depth = d;
        }
    }
    
    public int slidingPuzzle(int[][] board) {
        int R = board.length, C = board[0].length;
        int sr = 0, sc = 0;

        // Find sr, sc
        search:
            for (sr = 0; sr < R; sr++)
                for (sc = 0; sc < C; sc++)
                    if (board[sr][sc] == 0)
                        break search;

        // Define Directions
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        PriorityQueue<Node> heap = new PriorityQueue<Node>((a, b) -> (a.heuristic + a.depth) - (b.heuristic + b.depth));
        
        Node start = new Node(board, sr, sc, 0);
        heap.add(start);

        Map<String, Integer> cost = new HashMap<>();
        cost.put(start.boardstring, 9999999);

        String target = Arrays.deepToString(new int[][]{{1,2,3}, {4,5,0}});
        String targetWrong = Arrays.deepToString(new int[][]{{1,2,3}, {5,4,0}});

        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if (node.boardstring.equals(target))
                return node.depth;
            if (node.boardstring.equals(targetWrong))
                return -1;
            if (node.depth + node.heuristic > cost.get(node.boardstring))
                continue;

            for (int[] di: directions) {
                int nei_r = di[0] + node.zero_r;
                int nei_c = di[1] + node.zero_c;

                // If the neighbor is not on the board or wraps incorrectly around rows/cols
                if ((Math.abs(nei_r - node.zero_r) + Math.abs(nei_c - node.zero_c) != 1) ||
                        nei_r < 0 || nei_r >= R || nei_c < 0 || nei_c >= C)
                    continue;

                int[][] newboard = new int[R][C];
                int t = 0;
                for (int[] row: node.board)
                    newboard[t++] = row.clone();

                // Swap the elements on the new board
                newboard[node.zero_r][node.zero_c] = newboard[nei_r][nei_c];
                newboard[nei_r][nei_c] = 0;

                Node nei = new Node(newboard, nei_r, nei_c, node.depth+1);
                if (nei.depth + nei.heuristic >= cost.getOrDefault(nei.boardstring, 9999999))
                    continue;
                heap.add(nei);
                cost.put(nei.boardstring, nei.depth + nei.heuristic);
            }
        }

        return -1;
    }
    
    public int solution(List<List<Integer>> board) {
//        int row = board.length;
//        int col = board[0].length;
        Map<Integer, Character> map = new HashMap<>();
        
        for(char i = 'A'; i <= 'Z'; i++) {
            map.put(i - 'A', i);
        }

        int row = board.size();
        int col = board.get(0).size();
        
        String start = "";
        String goal = "";
        
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
//                start += board[i][j];
                start += map.get(board.get(i).get(j));
//                goal += map.get((i * col + j + 1) % (row * col));
                goal += map.get((i * col + j) % (row * col));
            }
        }
        
        if(start.equals(goal)) {
            return 0;
        }
        
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Set<String> set = new HashSet<>();
        set.add(start);
        
        int steps = 0;
        Queue<String> q = new LinkedList<>();
        
        q.offer(start);
        while(!q.isEmpty()) {
            ++steps;
            int size = q.size();
            
            while(size-- > 0) {
                String s = q.poll();
                
                int zero = s.indexOf('A'); // position of '0'
                
                int r = zero / col;
                int c = zero % col;
                
                for (int i = 0; i < 4; ++i) {
                    int tr = r + directions[i][0];
                    int tc = c + directions[i][1];
                    if (tr < 0 || tc < 0 || tc >= col || tr >= row) 
                        continue;
                    
                    int newZero = tr * col + tc;
                    
                    // swap(t[p], t[pp]);
                    String str = swap(s, zero, newZero);
                    
                    if (set.contains(str)) {
                        continue;            
                    }
                    if (str.equals(goal))
                        return steps;
                    set.add(str);
                    q.add(str);
                }
            }
        }
        
        return -1;
    }
    
    private String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        
        return sb.toString();
    }

    public static void main(String[] args) {
        LeetCode773_SlidingPuzzle obj = new LeetCode773_SlidingPuzzle();

//        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        
//        List<List<Integer>> board = new ArrayList<>();
//        board.add(Arrays.asList(4, 1, 2));
//        board.add(Arrays.asList(5, 0, 3));
        
        List<List<Integer>> board = new ArrayList<>();
        board.add(Arrays.asList(1, 2, 3, 4));
        board.add(Arrays.asList(5, 6, 7, 0));
        board.add(Arrays.asList(9, 10, 11, 8));
        
        System.out.println(obj.solution(board));

    }

}
