package recursion;

/**
 * @Description
 * @Author liyichen
 * @date 2020.09.15 16:28
 */
public class HouseRobber {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(20000000000L);
        int[] s = new int[]{1,2,3,1};
        rob(s);
    }

    /**
     *  题目中说了，不能在相邻的房间偷窃
     *  则如果想让当前所在位置n是最大的偷窃值，
     *      1.要不就是n-1是最大值
     *      2.要不就是n-2 加上当前房子里的值是最大值
     *   由此可得，就是想在这两个里面求一个大的数。
     *   动态转移方程就出来了:dp[n] = max(dp[n-1], dp[n-2] + num)
     *
     *   举个栗子：
     *   1号房间的最大偷窃金额是6 --->dp[1] = 5,
     *   2号房间是6 ---->dp[2] = 4,
     *   3号房间是4
     *     此时最大偷窃金额是多少？很明显就是偷窃1号和3号房间。
     *     那我们如何知道下一次偷窃的地址呢？
     *     就是看是前一位大呢？（2号房间大呢）还是1号房间+3号房间大呢（因为不相邻我们可以偷窃2次）取大值就是这次能偷窃到的最大金额。
     *     循环往复直到偷完所有的房间。
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] dp = new int[len + 1];

        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }

    /**
     *
     * 这个题我们可以从后往前分析，首先判断倒数第二个元素能否到达最后一个元素，
     * 如果可以，我们将不再考虑最后一个元素，不可以则继续向前寻找。
     * 因为根据刚才的分析如果可以到达倒数第二个，那么也可以到达最后一个元素。
     * 然后依次往前递推，如果都能跳到的话，我们最后应该分析的就是第一个元素能否跳到第二个元素上。
     *
     * 其实这题用贪心做的话，时间复杂度更低。O(n)就可以解决。
     * 你可以尝试逆序递推，nums = [2, 3, 1, 1, 4]为例
     * 比如我们目标是到达最后一个角标的元素，那如何才能到达呢？
     * 只需要达到倒数第二个元素即可，如何才能到达倒数第二个元素呢？
     * 只需要达到倒数第三个元素即可...
     *
     * 那我们可以用一个tag变量来表示 if(nums[i] + i >= tag) 就证明可以到达，可以到达我们就让tag = i,如果最后i是0就为可达。
     * 哈哈，是不很容易。
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        /** 这是DP的写法，不是贪心，贪心的时间复杂度要更优，可以按上面思路试试**/
        if (nums == null) {
            return false;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // 如果之前的j节点可达，并且从此节点可以到跳到i
                if (dp[j] && nums[j] + j >= i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];
    }
}
