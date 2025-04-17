class Solution {

    /**
     * 简单思路
     * 先把两个数组合并为一个有序数组
     * 合并思路: 取两个数组中较小的数字放在合并结果数组的末尾,直到两个数组都取完
     * 再找中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] nums3 = new int[nums1.length + nums2.length];

        int i = 0; // 合并的时候记录nums1取到哪个位置了
        int j = 0; // 合并的时候记录nums2取到哪个位置了

        int k = 0; // 合并结果nums3合并的时候已经放完数的位置,理论上应该等于i+j,这样可以不定义k并且k也就不用++了,代码应该会更简单

        while (k < nums3.length) {

            if (i > nums1.length - 1) {
                // nums1的指针已经越界了
                nums3[k] = nums2[j];
                j++;
                k++;
                continue;
            }

            if (j > nums2.length - 1) {
                // nums2的指针已经越界了
                nums3[k] = nums1[i];
                i++;
                k++;
                continue;
            }

            // 都没有越界的时候比较两个数字大小,小的合并到新数组并且对应的指针后移
            int m = nums1[i];
            int n = nums2[j];
            if (m > n) {
                nums3[k] = n;
                j++;
            } else {
                nums3[k] = m;
                i++;
            }
            k++;


        }

        if (nums3.length % 2 == 0) {
            int mid = nums3.length / 2 - 1;
            // 找到中间两个,计算平均值
            return (nums3[mid] + nums3[mid + 1]) / 2.0;
        } else {
            int mid = nums3.length / 2;
            return nums3[mid];
        }

    }
}