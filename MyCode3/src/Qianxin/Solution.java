package Qianxin;

public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * M包糖果，抛M次硬币，硬币连续n次为正面，最多能得到多少颗糖果
     * @param candies int整型一维数组 每包糖果的数量
     * @param coin int整型一维数组 抛硬币的结果
     * @param n int整型 连续是正面的次数
     * @return int整型
     */
    public static int maxCandies (int[] candies, int[] coin, int n) {
        // 先把本来是梅宝的糖果数加起来
        int candyn = 0;

        int max = 0;
        int temp = 0;
        int f = -1;
        for (int i = 0; i < coin.length-n; i++) {
            for (int j = i; j < i+n; j++) {
                temp += candies[j];
                if(max < temp){
                    max = temp;
                    f = j;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            coin[f-i] = 0;
        }
        for (int i = 0; i < coin.length; i++) {
            if(coin[i] == 0){
                candyn += candies[i];
            }
        }
        return candyn;
    }

    public static void main(String[] args) {
        int[] arr1 = {3,5,7,2,8,8,15,3};
        int[] arr2 = {1,0,1,0,1,0,1,0};
        int n = 3;
        System.out.println(maxCandies(arr1,arr2,n));
    }
}