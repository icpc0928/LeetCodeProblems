public class N304_RangeSumQuery2D_Immutable {

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        NumMatrix n = new NumMatrix(matrix);
        System.out.println("sum: "+n.sumRegion(2,1,4,3));
        System.out.println("sum: "+n.sumRegion(1,1,2,2));
        System.out.println("sum: "+n.sumRegion(1,2,2,4));


    }




    public static class NumMatrix {
        int[][] matrix;
        int[][] sumMatrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            setSumMatrixByMatrix();
        }

        /**
         * 實作方法 使用sumMatrix做計算
         * @param row1
         * @param col1
         * @param row2
         * @param col2
         * @return (r2,c2) - (r1-1,c2) - (r2,c1-1) + (r1-1,c1-1)
         */
        public int sumRegion(int row1, int col1, int row2, int col2) {
            return getValueInSumMatrix(row2, col2)
                    - getValueInSumMatrix(row1 - 1, col2)
                    - getValueInSumMatrix(row2, col1 - 1)
                    + getValueInSumMatrix(row1 - 1, col1 - 1);
        }

        /**
         * sumM[i][j] = matrix[i][j] + sumM[i-1][j] + sumM[i][j-1] - sumM[i-1][j-1]
         */
        public void setSumMatrixByMatrix(){
            sumMatrix = new int[matrix.length][matrix[0].length];
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    sumMatrix[i][j] = matrix[i][j]
                            + getValueInSumMatrix(i - 1,j)
                            + getValueInSumMatrix(i,j - 1)
                            - getValueInSumMatrix(i - 1,j - 1);
                }
            }
        }


        /**
         * if(r1-1, c1-1, <0) return 0
         */
        public int getValueInSumMatrix(int r, int c){
            if(r < 0 || c < 0) return 0;
            return sumMatrix[r][c];
        }





        public void printMatrix(){
            for(int i = 0; i < sumMatrix.length; i++){
                for(int j = 0; j < sumMatrix[i].length; j++){
                    System.out.print(sumMatrix[i][j] + ", ");
                }
                System.out.println();
            }
        }

    }
}
