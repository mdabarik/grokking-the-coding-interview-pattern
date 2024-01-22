class Solution {
    public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = nextStep(nums, slow);
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[nextStep(nums, fast)] > 0) {
                if (slow == fast) {
                    if (slow != nextStep(nums, slow)) { // if valid loop
                        return true;
                    }
                    break; // if self loop
                }
                slow = nextStep(nums, slow);
                fast = nextStep(nums, nextStep(nums, fast));
            }
            // mark as visited or valid cycle not possible at index i ... 
            int k = i;
            while (nums[k] * nums[nextStep(nums, k)] > 0) {
                nums[k] = 0;
                k = nextStep(nums, k);
            }
            nums[k] = 0;
        }
        return false;
    }
    public int nextStep(int[] nums, int i) {
        int n = nums.length;
        if (nums[i] > 0) {
            return (i + nums[i]) % n;
        }
        return (i + nums[i] % n + n) % n;
    }
}
// TC: O(n), SC: O(1)