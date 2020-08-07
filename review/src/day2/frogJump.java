package day2;

/*
    变态跳台阶
* 一只青蛙一次可以跳上一级台阶，也可以两级，也可以n级
    求该青蛙跳n级台阶总共多少种跳法
    */
public class frogJump {
    // 方法一：暴力法
    public static int JumpFloorII1(int target) {
        // 如果是第0个或者第1个台阶那么只有一种跳法
        // 如果上一步跳1步到达target，那么说明上一步在target-1，设跳到target-1有f[target-1]种方法
        // 如果上一步跳2步到达target，那么说明上一步在target-2，设跳到target-2有f[target-2]种方法
        // 如果上一步跳3步到达target，那么说明上一步在target-3，设跳到target-3有f[target-3]种方法
        // 。。。
        // 如果上一步跳target步到达target，那么说明上一步在0，设跳到0有f[0]种方法
        // 所以跳到target的可能性应该是f[target] = f[target-1]+f[target-2]+f[target-3]+...+f[1]+f[0]
        int[] f = new int[target+1];
        f[0] = f[1] = 1;
        for(int i = 2;i <= target ;i++){
            for(int j = 0;j <= i-1 ;j++){
                f[i] += f[j];
            }
        }
        return f[target];
    }

    // 优化
    public static int JumpFloorII2(int target) {
        // 如果是第0个或者第1个台阶那么只有一种跳法
        // 如果上一步跳1步到达target，那么说明上一步在target-1，设跳到target-1有f[target-1]种方法
        // 如果上一步跳2步到达target，那么说明上一步在target-2，设跳到target-2有f[target-2]种方法
        // 如果上一步跳3步到达target，那么说明上一步在target-3，设跳到target-3有f[target-3]种方法
        // 。。。
        // 如果上一步跳target步到达target，那么说明上一步在0，设跳到0有f[0]种方法
        // 所以跳到target的可能性应该是f[target] = f[target-1]+f[target-2]+f[target-3]+...+f[1]+f[0]
        // f[target-1] = f[target-2]+f[target-3]+...+f[1]+f[0]
        // f[target] = f[target-1]*2
        // f[target-1] = f[target-2]*2
        // 。。。
        // f[target] = 2^(target-1)*f[1]
        return (int)Math.pow(2,(target-1));
    }

    public static void main(String[] args) {
        System.out.println(JumpFloorII2(2));
    }
}