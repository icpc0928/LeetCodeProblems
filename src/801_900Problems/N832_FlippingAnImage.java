public class N832_FlippingAnImage {
    //Runtime: 0 ms, faster than 100.00% of Java online submissions for Flipping an Image.
    //Memory Usage: 41.1 MB, less than 25.63% of Java online submissions for Flipping an Image.

    public static void main(String[] args){
        Solution s = new Solution();
        int[][] image = {
                {1,1,0},
                {1,0,1},
                {0,0,0},
        };
        int[][] newImage = s.flipAndInvertImage(image);
        for(int i = 0; i < newImage.length; i++){
            for(int j = 0; j < newImage[i].length; j++){
                System.out.print(newImage[i][j] + " ");
            }
            System.out.println();
        }
    }


    static class Solution {
        public int[][] flipAndInvertImage(int[][] image) {
            //左右翻轉 + xor反轉
            for(int i = 0; i < image.length; i++){
                for(int j = 0; j < (image.length + 1) / 2; j++){
                    int temp1 = image[i][j] ^ 1;
                    image[i][j] = image[i][image[i].length -1 - j] ^ 1;
                    image[i][image[i].length - 1 - j] = temp1;
                }
            }

            return image;
        }
    }
}
