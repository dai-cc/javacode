package day32;
/*
* 2的个数
* 编写一个方法，输出0-n包括n中数字2出现了几次
* 2 12 20 21 .。。。29 32 */
public class NumOfTwo {
    private static int numOfTwo(int n){
        int count = 0;
        if(n < 2){
            return 0;
        }
        for (int i = 2; i <= n; i++) {
            int j = i;
            while(j > 0){
                if(j % 10 == 2){
                    count++;
                }
                j /= 10;
            }
        }
        return count;
    }
    public static int countNumberOf2s(int n) {
        // write code here
        int count = 0;
        for (int i = 1; i <= n; i++) {
            String s = String.valueOf(i);
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j)=='2'){
                    count++;
                }
            }
        }
        return count;
    }
        public static int countNumberOf2s1(int n) {
            // write code here
            int count = 0;
            for (int i = 1; i <= n; i*=10) {
                int a = n/i;
                int b = n%i;
                int res = (a%10==2)?b+1:0;
                count += (a+7)/10*i+res;
            }
            return count;
        }

    public static void main(String[] args) {
        System.out.println(numOfTwo(2322));
        System.out.println(countNumberOf2s(2322));
        System.out.println(countNumberOf2s1(2322));
    }
}
