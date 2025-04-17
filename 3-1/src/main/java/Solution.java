import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * 所有无重复子xx的问题首先想到双指针
     * 这个问题我们用滑动窗口尝试解决
     * 思路是:(我们以abcabcbb为例)
     * 下边我们以(1 - a)的形式表示字符串中第1个字符a
     * 首先:以第一个字符1 - a为起点
     * 2 - b 不重复
     * 3 - c 不重复
     * 4 - a 重复,此时上一个位置3就是以1 - a为起点的最长子串
     * 更换起点为2 - b,并且将1 - a从查询重复的缓存中去除
     * 此时经过上一次的判断我们知道:从2到3之间的位置是不重复的
     * (1到3是不重复子串,更换起点只是移除了1,2-3是1-3这个不重复字符串的子串,当然不重复)
     * 所以此时依然以上次窗口的结束位置4 - a为开始判断新窗口是不是重复,如果不重复,更换串口结束位置,如果重复,更换窗口起点
     * 直到结束
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        char[] string = s.toCharArray();
        // 优化3 2ms-1ms
        // 这个是完全没有想到的,
        // 不过也是可有可无的优化,如果用HashSet缓存的话,这个节省的时间忽略不计
        // 一直以为Java的字符串是不可变的,
        // 所以字符串实例化之后length应该是和hashCode一样缓存后直接读取的,
        // 实际上不是
        int len = s.length();

        String rtn = "";

        int maxLen = 0;

        // 最长不连续子串的结束位置
        int j = 0;

//        Set<Character> cache = new HashSet<>();


        // 优化2 6ms-2ms
        // 一个骨骼清奇的人才能想到的优化点,此时优化1有没有都不影响
        // 思路其实是八股文常见的用BitMap代替Map,将char的ascii码作为下标判断是不是存在
        // 此时用时击败95%,内存击败92%,要知道Map是比较占内存的
        // 而且用Map的话需要装包拆包,还要计算hash,这都要时间
        int[] map = new int[128];


        // 将字符串中的每个字符作为起点查找它的最长不连续子串
        for (int i = 0; i < len; i++) {

            while (j < len) {
                char c = string[j];
//                if (cache.contains(c)) {
//                    cache.remove(s.charAt(i));
//                    break;
//                }
                if (map[c] > 0) {
                    map[string[i]] = -1;
                    break;
                }

//                cache.add(c);
                map[c] = 1;
                j++;

                if (j - i > maxLen) {
                    maxLen = j - i;

//                    rtn = s.substring(i, j);
                }
            }

            // 优化1 10ms-7ms
            // 一个简单的优化,就可以从时间击败34%-67.99%,此时内存击败30%
            // 如果从i开始的位置到结束的位置已经没有找出来的最长字符串的长度大了,那么就没有必要继续找了
//            if (n - i < maxLen) {
//                break;
//            }


        }

//        System.out.println(rtn);

        return maxLen;


    }
}