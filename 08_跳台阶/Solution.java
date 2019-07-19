public class Solution {
    //第一种 递归求解
    public int JumpFloor1(int target) {
        if (target < 1)
            return 0;
        //很巧妙，直接返回本来值就行，2333..
        if (target == 1 || target == 2)
            return target;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    //第二种 记忆化
    public int[] dp;

    public int JumpFloor2(int target) {
        dp = new int[target + 1];
        return rec(target);
    }

    public int rec(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        dp[target] = rec(target - 1) + rec(target - 2);
        return dp[target];
    }

    //第三种 递推(DP)
    public int JumpFloor3(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[target];
    }

    //第四种 滚动优化
    public int JumpFloor4(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int f1 = 1;
        int f2 = 2;
        int res = 0;
        //从特殊用例开始滚动..
        for (int i = 3; i <= target; i++) {
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }

}