public class N661_ImageSmoother {
    //Runtime: 13 ms, faster than 15.89% of Java online submissions for Image Smoother.
    //Memory Usage: 40.3 MB, less than 29.31% of Java online submissions for Image Smoother.

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] img = {
                {100,200,100},
                {200, 50,200},
                {100,200,100},
        };
        int[][] ans = sol.imageSmoother(img);

        for(int i = 0; i < ans.length; i++){
            for(int j = 0; j < ans[i].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }

    }


    static class Solution {
        public int[][] imageSmoother(int[][] img) {
            int[][] ans = new int[img.length][img[0].length];
            int sum;
            int counter = 1;

            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    sum = img[i][j];
                    for(int t = 0; t < forward[0].length; t++){
                        if(i + forward[0][t] >= 0 && i + forward[0][t] < img.length && j + forward[1][t] >= 0 && j + forward[1][t] < img[0].length){
                            sum += img[i + forward[0][t]][j + forward[1][t]];
                            counter++;
                        }
                    }
                    ans[i][j] = sum / counter;
                    counter = 1;
                }
            }
            return ans;
        }
        int[][] forward = {
                {-1, -1, -1, 0, 0, 1, 1, 1,},
                {-1,  0,  1,-1, 1,-1, 0, 1,},
        };
    }
}
