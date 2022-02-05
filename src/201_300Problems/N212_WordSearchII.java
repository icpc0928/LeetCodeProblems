import java.util.*;

public class N212_WordSearchII {

    //TODO 要用Trie


    public static void main(String[] args){
        char[][] board = {
                {'a','a','a','a','a','a','a','a',},
                {'a','a','a','a','a','a','a','a',},
                {'a','a','a','a','a','a','a','a',},
        };
        String[] words = {"a","aa","aaa","aaaa","aaaaa","aaaaa",};

        Solution solution = new Solution();
        System.out.println(solution.findWords(board, words).toString());
    }


    static class Solution {

        List<String> answers = new ArrayList<>();
        Set<String> stringSet = new HashSet<>();
        public List<String> findWords(char[][] board, String[] words) {

            for(int i = 0; i < words.length; i++){
                for(int sr = 0; sr < board.length; sr++){
                    for(int sc = 0; sc < board[sr].length; sc++){
                        //DFS
                        if(!stringSet.contains(words[i])){
                            int[][] checkBoard = new int[board.length][board[0].length];
                            DFS(board, sr, sc, words[i], 0, checkBoard);
                        }


                    }
                }
            }
            return answers;
        }


        public void DFS(char[][] board, int sr, int sc, String word, int wordIndex, int[][] checkBoard){
            if(sr < 0 || sr >= board.length || sc < 0 || sc >= board[0].length || checkBoard[sr][sc] == 1 || stringSet.contains(word)){
                return;
            }

            int[][] newCheckBoard = new int[checkBoard.length][checkBoard[0].length];
            for(int i = 0; i < checkBoard.length; i++){
                newCheckBoard[i] = Arrays.copyOf(checkBoard[i], checkBoard[i].length);
            }

            //非字元
            if(word.charAt(wordIndex) != board[sr][sc]){
                return;
            }

            //取到最後一碼 OK惹
            if(wordIndex == word.length() - 1){

                answers.add(word);
                stringSet.add(word);

                return;
            }

            newCheckBoard[sr][sc] = 1;

            DFS(board, sr + 1, sc, word, wordIndex + 1, newCheckBoard);
            DFS(board, sr - 1, sc, word, wordIndex + 1, newCheckBoard);
            DFS(board, sr, sc + 1, word, wordIndex + 1, newCheckBoard);
            DFS(board, sr, sc - 1, word, wordIndex + 1, newCheckBoard);
        }
    }
}

class TrieNode{
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;
    public TrieNode(){};
    public String toString(){
        return this.word;
    }
}
