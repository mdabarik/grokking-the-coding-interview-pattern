class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if (nums1.length > nums2.length) {
            A = nums2;
            B = nums1;
        }

        int total = A.length + B.length;
        int half = total / 2;
        double median = 1.0;

        int min = Integer.MIN_VALUE, max = Integer.MAX_VALUE;

        int left = 0, right = A.length - 1;
        while (true) {
            // (-1) / 2 = -1 (floorDiv)
            // -1 / 2 = 0 (regular): time limit exceeded
            int i = Math.floorDiv(left + right, 2);// (left + right) / 2;
            int j = half - (i + 1) - 1; // half - i - 2

            int Aleft = i >= 0 ? A[i] : min; // i
            int Aright = i+1 < A.length ? A[i+1] : max; // i + 1
            int Bleft = j >= 0 ? B[j] : min; // j
            int Bright = j+1 < B.length ? B[j+1] : max; // j+1

            if (Aleft <= Bright && Bleft <= Aright) {
                if (total % 2 == 0) {
                    median = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                } else {
                    median = Math.min(Aright, Bright);
                }
                return median;
            }
            if (Aright < Bleft) {
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
    }
}
// TC: O(log min(n1, n2)), SC: O(1)
// [1,2,3|,4,5], [6,7,8,9|10,12,13,14,15]