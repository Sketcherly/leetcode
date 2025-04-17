class Solution {

    /**
     * 两次遍历
     * 思路最简单,性能最差
     * 时间复杂度O(n^2)
     * 空间复杂度O(1)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (i == j) {
                    continue;
                }

                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }


            }

        }
        return new int[]{};
    }
}