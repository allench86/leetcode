public class Solution {
    public static void main(String[] args) {
        int[] gas = { 4 };
        int[] cost = { 5 };

        Solution s = new Solution();
        System.out.println(s.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;

        for (int i = 0; i < gas.length; i++) {
            int current = i;
            int carryGas = 0;
            int costGas = 0;
            int j = 0;
            for (; j < gas.length; j++) {
                carryGas += gas[current];
                costGas += cost[current];
                if (costGas > carryGas) {
                    break;
                }
                current = (current + 1 + gas.length) % gas.length;
            }
            if (j == gas.length) {
                result = i;
                break;
            }
        }
        return result;
    }
}
