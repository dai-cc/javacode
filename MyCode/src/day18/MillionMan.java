package day18;

public class MillionMan {
    public static void main(String[] args) {
        int miler = 0;
        long stranger = 0;
        miler = 10 * 30;
        for (int i = 1; i <=30 ; i++) {
            stranger += (long)Math.pow(2,i-1);
        }

        System.out.println(miler);
        System.out.println(stranger);
    }
}
