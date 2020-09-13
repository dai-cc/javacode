package day0908;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    static int[] pathInZigZagTree(int label) {
        // 找到label原本的标号就可以知道他的父节点，然后将他的父节点标记为label,继续找父节点直到找到1
        // 注意要先找到label才知道他要遍历几次在第几层[2^(i-1),2^i-1]
        int f = 0;
        int dep = 0;
        // 1. 找到他在第几层
        while(true){
            int a = (int) Math.pow(2,f-1);
            int b = (int)Math.pow(2,f)-1;
            if(label >= a && label <= b){
                dep = f;
                break;
            }
        }
        ArrayList<Integer> l = new ArrayList<>();
        for(int i = dep; i >= 0; i--){
            l.add(label);
            if(i%2==0){
                label = (int)Math.pow(2,i-1)+(int)Math.pow(2,i)-1-label;
            }
            label /= 2;
        }
        int[] arr = new int[dep];
        for (int i = 0; i < l.size(); i++) {
            arr[i] = l.get(i);
        }
        Arrays.sort(arr);
        return arr;
    }

    public static void main(String[] args) {

    }
}
