package day32;

import java.util.Scanner;

/*
 * 在霍格沃兹找零钱（20）
 * 17Sickle = 1Galleon
 * 29Knut = 1Sickle
 * 在一行中分别给出P和A，格式为“Galleon.Sickle.Knut”
 * Galleon是[0,10^7]区间内的整数，Sickle是[0,17)区间内的整数，Knut是[0,29)区间内的整数
 * 按同样的个数输出要找的零钱，如果没带够钱，那么输出的应该是负数*/
public class ChangeAtHogwarts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            //用两个数组分别存放P和A，0位置表示Galleon，1位置表示Sickle，2位置表示Knut
            String[] P = sc.next().split("\\.");
            String[] A = sc.next().split("\\.");
            int[] p = new int[3];
            int[] a = new int[3];

            for (int i = 0; i < 3; i++) {
                p[i] = Integer.valueOf(P[i]).intValue();
                a[i] = Integer.valueOf(A[i]).intValue();
            }
            int x = p[0]*17*29+p[1]*29+p[2];
            int y = a[0]*17*29+a[1]*29+a[2];
            int z = y - x;
            if(z < 0){
                System.out.print("-");
                z = -z;
            }
            System.out.println(z/(17*29) + "." + z%(17*29)/29 +"." + z%(17*29)%29);

        }
    }
}
