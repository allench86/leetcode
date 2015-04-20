public class Solution {
    public static void main(String[] args) {
        int[] numbers = { 0, 0, 3, 4 };
        Solution s = new Solution();
        int target = 0;
        int[] results = s.twoSum(numbers, target);
        if (results != null) {
            for (int i : results) {
                System.out.print(i + ", ");
            }
        }
        else {
            System.out.println("Not found");
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] indice = null;
        if (numbers != null && numbers.length > 0) {
            int r = 0;
            int l = numbers.length - 1;
            while (r < l) {
                if (numbers[r] + numbers[l] == target) {
                    indice = new int[2];
                    indice[0] = r + 1;
                    indice[1] = l + 1;
                    break;
                }
                else if (numbers[r] + numbers[l] < target) {
                    r++;
                }
                else {
                    l--;
                }
            }
        }
        return indice;
    }

}