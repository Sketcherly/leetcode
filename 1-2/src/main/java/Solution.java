import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    /**
     * 使用Map优化,存储的数据如 Map{int, List[]}
     * 思路是
     * 第一次遍历的时候,将当前的数作为key,数字在数组中的位置作为value的元素
     * 第二次遍历的时候,计算target-当前位置数字的差值,再将这个差值作为key在Map中找
     * 如果找不到,过
     * 找到了,判断是不是只有一个,如果只有一个,判断是不是个当前索引一样,如果一样 过
     * 如果有多个,将下一个作为答案返回
     *
     * @param nums
     * @param target
     * @return
     */
    // 方案是对的,但是击败有点少,再优化一下
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> cache = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> list = cache.get(num);
            if (list == null) {
                list = new ArrayList<>();
                cache.put(num, list);
            }

            list.add(i);


            // 开始找答案
            int n = target - num;
            list = cache.get(n);
            if (!cache.containsKey(n)) {
                continue;
            }

            int j = list.get(0);
            if (i != j) {
                return new int[]{i, j};
            } else {
                if (list.size() == 1) {
                    continue;
                } else {
                    j = list.get(1);
                    return new int[]{i, j};
                }
            }

        }

        return new int[]{};

    }


}