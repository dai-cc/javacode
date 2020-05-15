package day33;

public class TaiJie {
    public static int countWays(int n) {
        // write code here
        if(n!=1){
            if(n!=2){
                return countWays(n-1)+countWays(n-2);
            }else{
                return 2;
            }
        }else {
            return 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(countWays(1));
    }
}
