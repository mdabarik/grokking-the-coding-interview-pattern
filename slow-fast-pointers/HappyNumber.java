class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = sumSquareDigits(n);
        while (fast != 1 && slow != fast) { // stop this loop, when fast==1 or slow==fast
            slow = sumSquareDigits(slow);
            fast = sumSquareDigits(sumSquareDigits(fast));
        }
        return fast == 1 ? true : false;
    }
    public int sumSquareDigits(int n) {
        int sum = 0;
        while (n != 0) {
            int lastDigit = n % 10;
            n = n / 10;
            sum += (lastDigit * lastDigit);
        }
        return sum;
    }
}
/*
TC: F= O(log n)
SC: O(1) */