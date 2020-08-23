package day0823;
/*
构建乘积数组
*
给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在

B0   1  A1  A2  A3
B1  A0  1   A2  A3
B2  A0  A1  1   A3
B3  A0  A1  A2  1
*/
public class newMultiply {
    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        int temp1 = 1;
        int temp2 = 1;
        // 先算下半边的
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
           temp1 *= A[i-1];
            B[i] = temp1;
        }
        // 再算上半边
        for (int i = A.length-2; i >= 0; i--) {
            temp2 *= A[i+1];
            B[i] *= temp2;
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4,5};
        int[] B = multiply(A);
        for (int i = 0; i < B.length; i++) {
            System.out.println(B[i]);
        }
    }
}
