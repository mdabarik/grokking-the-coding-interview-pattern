class Solution {
    int[] computeLPSArray(String pattern) {
        int lenP = pattern.length();
        int[] LPS = new int[lenP];
        int left = 0, right = 1;
        while (right < lenP) {
            char c1 = pattern.charAt(left), c2 = pattern.charAt(right);
            if (c1 == c2) {
                LPS[right] = left + 1;
                left++;
                right++;
            } else {
                if (left != 0) {
                    left = LPS[left - 1];
                } else {
                    right++;
                    // LPS[right] = 0;
                }
            }
        }
        return LPS;
    }
    ArrayList<Integer> search(String pat, String txt)  {
        ArrayList<Integer> indices = new ArrayList<>();
        int[] LPS = computeLPSArray(pat);
        int lenP = pat.length(), lenT = txt.length();
        int i = 0; // for text
        int j = 0; // pattern
        while (i < lenT) {
            char c1 = txt.charAt(i); // char for txt
            char c2 = pat.charAt(j); // char for pat
            if (c1 == c2) {
                i++;
                j++;
            }
            if (j == lenP) { // we found pat in txt
                indices.add(i - j + 1); // for this problem: 1 based indexing
                j = LPS[j - 1];
            } else if (i < lenT && c1 != c2) {
                if (j != 0) {
                    j = LPS[j - 1];
                } else { // j == 0
                    i++;
                }
            }
        }
        return indices;
    }
}
// TC: O(m+n), SC: O(n)
