package Qianxin;

public class Square {
    public int getMaxArea (int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
        // write code here
        int area = 0;
        // 没有重合且没有交点的时候
        if(x3 > x2 && y3 > y2){
            area = (y3-y2)*10;
        }
        // 刚好交点
        return area;
    }
}
