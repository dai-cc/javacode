package lesson2;

import org.junit.Test;

import java.io.*;

public class FillOperatorTest {
    @Test
    public void fileRead_1() throws IOException {
        //字节转换流
        FileInputStream  fis = new FileInputStream(
                new File("D:\\javaCode1\\DuoXianCheng\\io-study\\res/info.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
//字符流的按行读取
//        String line;
//        while((line = br.readLine())!=null){
//            System.out.println(line);
//        }

        //字符流按字符数组读取
        char[] chars = new char[1024];
        //off：偏移量，偏移量为0意思是从头开始读
        int len = 0;//读取多长的

        while((len = br.read(chars,0,1024))!=-1){
            String str= new String(chars,0,len);
            System.out.println(str);
        }
    }

    @Test
    public void fileRead_2() throws IOException {

        FileInputStream fis = new FileInputStream(
                new File("D:\\javaCode1\\DuoXianCheng\\io-study\\res/info.txt"));
        //按字节进行读取
        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes,0,1024))!=-1){
            String str = new String(bytes,0,len);
            System.out.println(str);
        }
    }



    @Test
    public void fileWrite_1() throws IOException {

        FileOutputStream fos = new FileOutputStream(
                new File("D:\\javaCode1\\DuoXianCheng\\io-study\\res/info.txt"));
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
        //使用缓冲流，输出的时候要进行flush刷新缓冲区，否则不会真实的输出数据到目的设备
        br.write("1:dafaeeaiogere\n");//write方法写数据到系统内存缓冲区
        br.write("2:ogere\n");
        br.write("3:sagagfare\n");

        br.flush();//缓冲区刷新，发送数据到目的设备
    }

    @Test
    public void copyFile() throws IOException{
        //自己尝试将本地的一个文件到另一个地方的操作
        //这样只能对文本文件进行操作，而不能对二进制文件进行操作
        //如果是二进制的文件读写，可以用二进制流
        //但这样效率低
        //可以用缓冲的字节流
        FileInputStream fis = new FileInputStream(
                new File("D:\\javaCode1\\DuoXianCheng\\io-study\\res/info.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));

        FileOutputStream fos = new FileOutputStream(
                new File("D:\\javaCode1\\DuoXianCheng\\io-study\\res/info1.txt"));
        BufferedWriter bW = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));

        //字符流按字符数组读取
        char[] chars = new char[1024];
        //off：偏移量，偏移量为0意思是从头开始读
        int len = 0;//读取多长的

        while((len = br.read(chars,0,1024))!=-1){
            String str= new String(chars,0,len);
            bW.write(str);
            bW.flush();
        }
    }

    //文件复制的操作一般用缓冲的输入输出流效率更好
    @Test
    public void copyFile_teacher() throws IOException{
        //如果是二进制的文件读写，可以用二进制流
        //但这样效率低
        //可以用缓冲的字节流
        //下面用展示缓冲的字节流方式
        FileInputStream fis=null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(
                    new File("D:\\javaCode1\\DuoXianCheng\\io-study\\res/info.txt"));
            bis = new BufferedInputStream(fis);

            fos = new FileOutputStream(
                    new File("D:\\javaCode1\\DuoXianCheng\\io-study\\res/info1.txt"));
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024];
            int len;
            while((len = fis.read(bytes))!=-1){
                bos.write(bytes);
                bos.flush();
            }
        } finally {
            //注意IO流的操作完成之后要进行资源的释放
            //顺序是根据依赖关系反向释放
            //A依赖B就先释放A
            if(bis != null)
                bis.close();
            if(fis != null)
                fis.close();
            if(bos != null)
                bos.close();
            if(fos != null){
                fos.close();
            }
        }
    }

}
