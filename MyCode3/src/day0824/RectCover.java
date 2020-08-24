package day0824;

/*
* 矩形覆盖
* 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
// 如果用1*m的方块覆盖m*n区域，递推关系式为f(n) = f(n-1) + f(n-m)，(n > m)。
// 所以这个题的递推关系是：f(n) = f(n-1) + f(n-2)
public class RectCover {
    public int RectCover(int target) {
        if(target == 0 || target == 1 || target == 2){
            return target;
        }
        return RectCover(target-1)+RectCover(target-2);
    }
}
