package day11;
/*
* 构建乘积数组
* 给定一个数组A[0,1,...n-1]
* 构建一个个数组B[0,1,...,n-1]
* 其中B中的元素B[i] = A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
* 不能使用除法*/
public  class Mutiply {
    //方法1：暴力解题，一个一个乘
    //方法2：找规律发现A[0]~A[n]和B[0]~B[n]组成的表中
    //      除了对角线的元素不乘之外，其余的元素相乘
    //      将对角线下方的元素按规律计算出来，再将对角线上放的元素计算出来
    //      最终将两个结果相乘即为B
    //      将对角线处的元素值设置为1，D[0]=1,C[n-1]=1
    //      B1[i] = B1[i-1]*B1[i-1]
    //      C[i-1] = c[i]*A[i]
    public static int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];

        B[0] = 1;
        B[len-1] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i-1]*A[i-1];
        }
        //记录后半部分的乘积
        int backSum = 1;
        for (int j = len-2; j >=0; j--) {
            //B[j] *= B[j+1] * A[j+1];不能这样写，应该是A[j+1]*后半部分的乘积
            //为了减少运算，创建一个变量记录后半部分的乘积
            backSum *= A[j+1];
            B[j] *= backSum;
        }
        return B;
    }
    public static void main(String[] args){
        int[] A = {1,2,3};
        int[] B = multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }
}
