class Solution {


    /**
     * 最长子串 双指针
     * 回文串,还是用滑动窗口
     * 我们还是以babad为例
     * 但是跟最长子串不同,回文串要直到滑动窗口到字符串末尾才能找到最长回文串,
     * 而最长不重复子串只要找到第一个重复字符后边就不用找了
     *
     * 优化思路1: 滑动窗口可以从字符串末尾向前,如果已经是回文串了,那就不必继续了
     * 优化思路2: 如果当前回文串长度已经大于i开始到字符串结尾的长度了,也不用查了
     * 以上两步执行时间从213优化到180,击败13.5%,所以其他人都是怎么解的
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        String ans = "";

        // i 滑动窗口开始位置
        // j 滑动窗口结束位置
        // 减一是窗口只需要到字符串的倒数第二位
        for (int i = 0; i < s.length(); i++) {

            for (int j = s.length() - 1; j >= i; j--) {

                if (j - i + 1 < ans.length()) {
                    // 如果当前的滑动窗口已经小于已知的最大回文串长度了,还找个鬼,下一个吧
                    break;
                }

                // 判断i-j之间是不是回文串
                if (valid(s, i, j)) {
                    ans = s.substring(i, j + 1);
                    break;
                }

            }

        }

//        System.out.println(valid("abba", 0, 3));

        return ans;

    }

    public boolean valid(String s, int i, int j) {
        // 1 5
        // 2 4
        // 3

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;

    }

}