public class Main {
    public static void main(String[] args) {


        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3, 4};


        double ans = new Solution().findMedianSortedArrays(nums1, nums2);

        System.out.println(ans);

    }
}