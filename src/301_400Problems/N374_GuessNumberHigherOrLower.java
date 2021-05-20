public class N374_GuessNumberHigherOrLower {

    /**
     * Forward declaration of guess API.
     * @param  num   your guess
     * @return 	     -1 if num is lower than the guess number
     *			      1 if num is higher than the guess number
     *               otherwise return 0
     * int guess(int num);
     */

    public static void main(String[] args){

    }

    static public class Solution extends GuessGame {
        public int guessNumber(int n) {
            int low = 1;
            int high = n;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                int res = guess(mid);
                if (res == 0)
                    return mid;
                else if (res < 0)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
            return -1;
        }
    }

    static class GuessGame{
//        int ans = (int)(Math.random() * Integer.MAX_VALUE) + 1;
    }

    static public int guess(int guess){
        int pick = 3;
        return Integer.compare(pick, guess);
    }
}
