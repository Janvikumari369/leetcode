class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long[] freq = new long[100001];
        long total = 0;

        for (int i = 0; i < nums1.length; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            freq[diff]++;
            total += diff;
        }

        long k = (long) k1 + k2;

        if (k >= total) {
            return 0;
        }

        for (int i = 100000; i > 0 && k > 0; i--) {
            if (freq[i] == 0) {
                continue;
            }

            long move = Math.min(freq[i], k);
            freq[i] -= move;
            freq[i - 1] += move;
            k -= move;
        }

        long ans = 0;

        for (int i = 1; i <= 100000; i++) {
            ans += freq[i] * i * i;
        }

        return ans;
    }
}