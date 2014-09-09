public class Solution {
    public static void main(String[] args) {
        int[] gas = { 5 };
        int[] cost = { 4 };

        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        int total = 0;
        int currentGas = 0;

        for (int i = 0; i < gas.length; i++) {
            int remain = gas[i] - cost[i];
            if (currentGas >= 0) {
                currentGas += remain;
            }
            else {
                currentGas = remain;
                result = i;
            }
            total += remain;
        }

        return total >= 0 ? result : -1;
    }
}
