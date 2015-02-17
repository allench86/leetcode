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

        int i = 0, h = 0, l = 0;
        int temp = 0, secondIndex = 0;

        while (i < numbers.length && numbers[i] <= target && target - numbers[i] >= numbers[i]) {
            temp = target - numbers[i];
            l = i + 1;
            h = numbers.length - 1;
            secondIndex = binarySearch(numbers, h, l, temp);
            if (secondIndex != -1) {
                indice = new int[2];
                indice[0] = i + 1;
                indice[1] = secondIndex + 1;
                break;
            }
            i++;
        }

        return indice;
    }

    public int binarySearch(int[] numbers, int h, int l, int target) {
        int m = 0;
        while (l < numbers.length && h < numbers.length && l <= h) {
            m = (h + l) / 2;
            if (numbers[m] == target) {
                return m;
            }
            else if (numbers[m] < target) {
                l = m + 1;
            }
            else if (numbers[m] > target) {
                h = m - 1;
            }
        }
        return -1;
    }
}