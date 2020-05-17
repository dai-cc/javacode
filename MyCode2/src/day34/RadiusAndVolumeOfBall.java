package day34;

import java.util.Scanner;

/*
* 球的半径和体积
* 输入球的中心点和球上某一点坐标，计算球的半径和体积
* 球的半径：sqrt((x1-x0)^2+(y1-y0)^2+(z1-z0)^2)
* 球的体积V= (4/3)* PI* r^3
* */
public class RadiusAndVolumeOfBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int x0 = sc.nextInt();
            int y0 = sc.nextInt();
            int z0 = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();

            double r = Math.sqrt(Math.pow((x1-x0),2)+Math.pow((y1-y0),2)+Math.pow((z1-z0),2));
            double v = 4* Math.acos(-1)* Math.pow(r,3)/3;
            // 注意不能这么写，因为这样4/3都是整型除下来一定为1，结果不对，所以要把他们分开计算
            // double v = (4/3) * Math.acos(-1)* Math.pow(r,3);
            System.out.printf("%.3f %.3f",r,v);
        }
    }
}
