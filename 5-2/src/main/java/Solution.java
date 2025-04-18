class Solution {

    /**
     * 1. 子串问题还是滑动窗口
     * 2. 子串条件判断是不是可以缓存
     * 滑动窗口不用说,双指针双循环
     * 子串条件判断是我们这次优化的重点(从暴力的O(n^3)到O(n^2)的关键)
     * 分析回文串特点如果一个字符串是回文串,那么它去掉前后各一个字符后的子串(如果还有的话)必然还是回文串
     * 所以如果要判断s[i..j]是不是回文串,在s[i]和s[j]相同的情况下,只要s[i+1...j-1]是回文串就可以了(ps:状态转移)
     * 此时我们可以构造一个二维表boolean[i][j],其中下标i/j表示子串的开始和结束位置,这个位置的值表示这个子串是不是回文串
     * 还是以babad为例
     * 要直到从下标0开始的子串是不是回文串,就要知道从1开始的子串,就要知道从下标2开始的子串...
     * 所以我们可以从后向前判断,将每次判断的结果记录到二维表中,并且判断长度是不是当前最长,如果是的话记录下来
     * **这种每一步判断依赖上一步结果的递归就是动态规划**
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {

        int start = 0;
        int end = 0;

        int n = s.length();

        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                dp[i][j] = is(dp, s, i, j);

                if (j - i > end - start && dp[i][j]) {
                    start = i;
                    end = j;
                }

            }

        }

        return s.substring(start, end + 1);


    }

    public boolean is(boolean[][] dp, String s, int i, int j) {

        // 先判断起始字符和结束字符是不是一样,不一样就不是回文串,返回
        if (s.charAt(i) != s.charAt(j)) {
            return false;
        }

        // 一样的话要看子串
        // 因为之前的逻辑已经保证子串判断过了所以这里直接取
        if (i + 1 < j - 1) {
            return dp[i + 1][j - 1];
        }
        return true;

    }

}