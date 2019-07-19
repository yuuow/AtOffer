public class Solution {
    //第一种 递归求解
    public int JumpFloorII1(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int sum = 1;
        for (int i = 1; i < target; i++) {
            sum += JumpFloorII(i);
        }
        return sum;
    }

    //第二种(递推(DP))
    public int JumpFloorII2(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int[] dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        int preSum = 3;
        for (int i = 3; i <= target; i++) {
            dp[i] = preSum + 1;
            preSum += dp[i];
        }
        return dp[target];
    }

    //第三种(滚动优化)
    public int JumpFloorII3(int target) {
        if (target < 1)
            return 0;
        if (target == 1 || target == 2)
            return target;
        int preSum = 3, res = 0;//一开始  preSum = f1 + f2的值
        for (int i = 3; i <= target; i++) {
            res = preSum + 1; //之前的和　加上自己的
            preSum += res;
        }
        return res;
    }

    //第四种(找规律)
    public int JumpFloorII4(int target) {
        return 1 << (target - 1);
    }

}