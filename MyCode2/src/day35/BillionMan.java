package day35;
/*
* 百万富翁问题
* */
public class BillionMan {
    public static void main(String[] args) {
        int stranger = 0;
        for (int i = 0; i < 30; i++) {
            stranger += Math.pow(2,i);
        }

        int billioner = 10 * 30;
        System.out.println(billioner + " " + stranger);
    }
}
