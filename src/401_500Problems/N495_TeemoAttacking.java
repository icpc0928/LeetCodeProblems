public class N495_TeemoAttacking {

    //提摩打艾希
    static class Solution {
        public int findPoisonedDuration(int[] timeSeries, int duration) {
            int result = 0;
            if(duration <= 0) return 0;

            for(int i = 0; i < timeSeries.length - 1; i++){
                int nowT = timeSeries[i];
                int toT = timeSeries[i + 1];

                result += Math.min((toT - nowT), duration);
            }
            result += duration;

            return result;
        }
    }
}
