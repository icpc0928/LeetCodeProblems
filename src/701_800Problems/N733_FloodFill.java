public class N733_FloodFill {


    public static void main(String[] args){

    }

    static class Solution {
        int[][] sameMatrix;
        public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
            int target = image[sr][sc];
            sameMatrix = new int[image.length][image[0].length];
            DFS(target, sr, sc, image);

            for(int i = 0; i < image.length; i++){
                for(int j = 0; j < image[i].length; j++){
                    if(sameMatrix[i][j] == 1){
                        image[i][j] = newColor;
                    }
                }
            }

            return image;
        }

        public void DFS(int target, int sr, int sc, int[][] image){
            if(sr >= sameMatrix.length || sr < 0 || sc >= sameMatrix[sr].length || sc < 0 || sameMatrix[sr][sc] == 1)
                return;

            if(image[sr][sc] == target)
                sameMatrix[sr][sc] = 1;
            else return;

            DFS(target, sr + 1, sc, image);
            DFS(target, sr - 1, sc, image);
            DFS(target, sr, sc + 1, image);
            DFS(target, sr, sc - 1, image);
        }
    }
}
