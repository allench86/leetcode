//Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
//
//If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
//
//The replacement must be in-place, do not allocate extra memory.
//
//Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
//1,2,3 → 1,3,2
//3,2,1 → 1,2,3
//1,1,5 → 1,5,1
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] num = { 1, 2, 3 };
        s.nextPermutation(num);
        for (Integer i : num) {
            System.out.print(i + ", ");
        }
    }

    public void nextPermutation(int[] num) {
        if (num != null && num.length > 1) {
            int partitionIndex = -1;
            int partition = Integer.MAX_VALUE;
            for (int i = num.length - 1; i > 0; i--) {
                if (num[i - 1] < num[i]) {
                    partitionIndex = i - 1;
                    partition = num[partitionIndex];
                    break;
                }
            }

            for (int i = num.length - 1; i > partitionIndex; i--) {
                if (num[i] > partition) {
                    num[partitionIndex] = num[i];
                    num[i] = partition;
                    break;
                }
            }

            int l = partitionIndex + 1;
            int r = num.length - 1;
            while (l < r) {
                int temp = num[l];
                num[l] = num[r];
                num[r] = temp;
                l++;
                r--;
            }
        }
    }
}
