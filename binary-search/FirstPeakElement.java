class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) return 0;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2; // (left + right) / 2;
            if (nums[mid] < nums[mid + 1]) {
                // peak element exist on the right (m+1 -> r)
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left; // right
    }
} // TC: O(log n), SC: O(1)