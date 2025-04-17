import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] ans = new Solution().twoSum(nums, target);

        System.out.println(Arrays.toString(ans));

    }
}