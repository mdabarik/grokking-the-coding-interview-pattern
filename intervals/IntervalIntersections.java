class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> intersections = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while (p1 < firstList.length && p2 < secondList.length) {
            int start = Math.max(firstList[p1][0], secondList[p2][0]);
            int end = Math.min(firstList[p1][1], secondList[p2][1]);
            if (start <= end) intersections.add(new int[] {start, end});
            if (firstList[p1][1] == secondList[p2][1]) {
                p1 += 1; // p1++
                p2 += 1; // p2++
            } else if (firstList[p1][1] < secondList[p2][1]) {
                p1 += 1; // p1++
            } else {
                p2++;
            }
        }
        return intersections.toArray(new int[intersections.size()][2]);
    }
}
// TC: O(m + n), SC: O(1)