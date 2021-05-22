public class N134_GasStation {

    //Runtime: 57 ms, faster than 14.96% of Java online submissions for Gas Station.
    //Memory Usage: 39 MB, less than 81.90% of Java online submissions for Gas Station.

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] gas =  {2,};
        int[] cost = {2,};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }

    static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int[] gasCost = new int[gas.length];
            int net = 0;

            for(int i = 0; i < gas.length; i++){
                gasCost[i] = gas[i] - cost[i];
                net += gasCost[i];
            }
            if(net < 0) return -1;

            lab1:
            for(int i = 0; i < gasCost.length; i++){
                if(gasCost[i] < 0) continue;
                int tempNet = 0;
                for(int j = 0; j < gasCost.length; j++){
                    tempNet += gasCost[(i + j) % gasCost.length];
                    if(tempNet < 0) continue lab1;
                }
                return i;
            }

            return -1;
        }
    }
}
