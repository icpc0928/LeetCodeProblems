public class N85_MaximalRectangle {

    public static void main(String[] args){
        Solution solution = new Solution();
//        char[][] matrix = new char[][]{
//                {'1','0','1','0','0',},
//                {'1','0','1','1','1',},
//                {'1','1','1','1','1',},
//                {'1','0','0','1','0',},
//        };
        char[][] matrix = new char[][]{
                {'1','0',},
                {'1','0',},
        };
        int ans = solution.maximalRectangle(matrix);
        System.out.println(ans);
    }

    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            if(matrix.length == 0)
                return 0;
            if(matrix[0].length == 0)
                return 0;

            int maxArea = 0;

            for(int i = 0; i < matrix.length; i++){         //往下
                for(int j = 0; j < matrix[i].length; j++){  //往右

                    if(matrix[i][j] == '0'){
                        continue;
                    }
                    System.out.println("i: " + i + ", j: " + j);

                    //matrix[i][j]
                    //再跑剩餘的內部雙層迴圈取最大矩形
                    int untilPosJ = matrix[i].length - 1;    //迴圈終點
                    int untilPosI = matrix.length - 1;       //迴圈終點
                    int maxi=0,maxj=0;
                    for(int posi = i; posi <= untilPosI; posi++){

                        maxi++;
                        maxj=0;
                        for(int posj = j; posj <= untilPosJ; posj++){

                            System.out.println("Posi: " + posi + ", Posj: " + posj);
                            maxj++;

                            if(matrix[posi][posj] == '0'){
                                untilPosJ = posj - 1;
                                break;
                            }else{

                                maxArea = Math.max( (maxi) *  (maxj), maxArea);
                                System.out.println(" MaxArea: " + maxArea);
                            }



                        }

                    }
                }
            }
            return maxArea;
        }
    }
}
