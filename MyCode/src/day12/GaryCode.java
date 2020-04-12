package day12;
/*
* 将一组书的编码中，任意两相邻代码只有一位二进制数不同的编码叫做格雷码
* 给定一个整数n，返回n位的格雷码，从0开始
* n=1  0,1
* n=2  00,01, 11,10
* n=3  000,001,011,010,  110,111,101,100
*
* 观察可以得到规律：n位的格雷码都是通过n-1位的格雷码生成的
*       比如说2位的格雷码*/
public class GaryCode {
    public String[] getGray(int n) {
        //n为几数组的长度就为2的几次方，按这个规律创建数组
        StringBuffer[] sbs = new StringBuffer[(int)Math.pow(2,n)];
        if(n == 1){
            
        }

    }
}
