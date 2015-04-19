public class Solution {
    public static void main(String[] args) {
        int[] num = { 3, 6, 9, 1 };
        Solution s = new Solution();
        System.out.println(s.maximumGap(num));
    }

    public int maximumGap(int[] num) {
        if (num == null || num.length < 2) {
            return 0;
        }
        if (num.length == 2) {
            return Math.abs(num[0] - num[1]);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < num.length; i++) {
            if (max < num[i]) {
                max = num[i];
            }
            if (min > num[i]) {
                min = num[i];
            }
        }

        int bucketSize = (int) Math.ceil((max - min) * 1.0 / (num.length - 1));
        int numBucket = (max - min) / bucketSize + 1;
        Bucket[] buckets = new Bucket[numBucket];

        for (int i = 0; i < num.length; i++) {
            int bucketIndex = (num[i] - min) / bucketSize;
            if (buckets[bucketIndex] == null) {
                buckets[bucketIndex] = new Bucket();
                buckets[bucketIndex].max = num[i];
                buckets[bucketIndex].min = num[i];
            }
            else {
                if (buckets[bucketIndex].max < num[i]) {
                    buckets[bucketIndex].max = num[i];
                }
                if (buckets[bucketIndex].min > num[i]) {
                    buckets[bucketIndex].min = num[i];
                }
            }
        }

        int i = 0;
        int maxGap = 0;
        while (i < numBucket) {
            Bucket current = null;
            while (buckets[i] == null) {
                i++;
            }
            if (i < numBucket) {
                current = buckets[i];
                i++;
            }
            else {
                break;
            }

            Bucket next = null;
            while (i < numBucket && buckets[i] == null) {
                i++;
            }
            if (i < numBucket) {
                next = buckets[i];
            }
            else {
                break;
            }

            if (current != null && next != null) {
                maxGap = Math.max(next.min - current.max, maxGap);
            }
        }

        return maxGap;
    }

    public class Bucket {
        public int min = Integer.MAX_VALUE;
        public int max = Integer.MIN_VALUE;
    }
}
