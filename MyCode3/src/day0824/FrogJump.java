package day0824;

/*
* 跳台阶
* 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
* 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
* */
public class FrogJump {
    public int JumpFloor(int target) {
        if(target == 0 || target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        return JumpFloor(target-1)+JumpFloor(target-2);
    }
}
