package day46;

import java.util.*;

/*用例:
e:\1\aa3.txt 3 e:\3\aa1.txt 2 e:\2\aa2.txt 3 e:\3\aa1.txt 1 e:\1\aa1.txt 3 e:\3\aa1.txt 2 e:\1\aa3.txt 3 e:\2\aa3.txt 2 e:\1\aa1.txt 2 e:\3\aa3.txt 2 e:\1\aa2.txt 2 e:\1\aa3.txt 1 e:\1\aa3.txt 1 e:\2\aa3.txt 2 e:\1\aa2.txt 1 e:\3\aa1.txt 2 e:\1\aa1.txt 3 e:\2\aa1.txt 1 e:\3\aa3.txt 2 e:\1\aa1.txt 1 e:\2\aa2.txt 2 e:\3\aa3.txt 2 e:\1\aa2.txt 1 e:\1\aa3.txt 2 e:\1\aa3.txt 3 e:\1\aa2.txt 3 e:\3\aa1.txt 3 e:\2\aa2.txt 2 e:\1\aa1.txt 1 e:\2\aa3.txt 1 e:\3\aa1.txt 1 e:\2\aa1.txt 3 e:\3\aa3.txt 2 e:\1\aa3.txt 3 e:\2\aa3.txt 3 e:\1\aa2.txt 3 e:\2\aa2.txt 1 e:\1\aa3.txt 1 e:\1\aa3.txt 1 e:\3\aa3.txt 3 e:\3\aa3.txt 2 e:\1\aa2.txt 3 e:\1\aa2.txt 3 e:\1\aa2.txt 3 e:\1\aa1.txt 1 e:\2\aa3.txt 1 e:\3\aa3.txt 1 e:\2\aa3.txt 2 e:\3\aa1.txt 3 e:\2\aa2.txt 2 e:\2\aa2.txt 2 e:\2\aa3.txt 1 e:\1\aa3.txt 3 e:\3\aa1.txt 2 e:\3\aa2.txt 2 e:\1\aa2.txt 1 e:\2\aa2.txt 1 e:\2\aa1.txt 2 e:\2\aa2.txt 1 e:\1\aa2.txt 1 e:\2\aa3.txt 1 e:\2\aa2.txt 1 e:\2\aa1.txt 2 e:\3\aa2.txt 3 e:\3\aa1.txt 3 e:\2\aa2.txt 3 e:\2\aa3.txt 1 e:\3\aa3.txt 2 e:\2\aa3.txt 1 e:\1\aa1.txt 2 e:\3\aa3.txt 1 e:\3\aa1.txt 1 e:\2\aa2.txt 3 e:\3\aa3.txt 2 e:\2\aa1.txt 3 e:\1\aa3.txt 3 e:\3\aa2.txt 1 e:\2\aa1.txt 3 e:\1\aa3.txt 3 e:\2\aa2.txt 2 e:\1\aa1.txt 2 e:\3\aa1.txt 1 e:\1\aa3.txt 1 e:\3\aa1.txt 2 e:\1\aa1.txt 2 e:\1\aa1.txt 3 e:\3\aa1.txt 1 e:\3\aa1.txt 1 e:\2\aa3.txt 3 e:\2\aa2.txt 1 e:\2\aa1.txt 2 e:\2\aa2.txt 1 e:\3\aa2.txt 3 e:\1\aa2.txt 1 e:\3\aa2.txt 2 e:\2\aa1.txt 1 e:\2\aa3.txt 3 e:\1\aa1.txt 2 e:\1\aa1.txt 1 e:\1\aa1.txt 2
对应输出应该为:
aa1.txt 2 14 aa3.txt 1 13 aa1.txt 1 12 aa2.txt 1 12 aa3.txt 3 11 aa3.txt 2 11 aa2.txt 3 10 aa1.txt 3 9
你的输出为:
aa3.txt 3 1*/
/*
* 简单错误记录
* 一行或多行字符串，每行包括带路径文件名，行号，
* 将所有的记录统计并将结果输出，
* 格式：文件名 代码行数 数目
* */
public class SimpleMisNote {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String,Integer> hm = new LinkedHashMap<>();
        while(sc.hasNext()){
            String fileName = sc.next();
            int n = sc.nextInt();
            for (int i = fileName.length()-1; i >= 0; i--) {
                if(fileName.charAt(i) == '\\'){
                    fileName = fileName.substring(i+1);
                    break;
                }
            }

            String s = fileName+" "+n;
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        sc.close();


        //对记录进行排序
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
            //降序
            @Override
            public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
                return(arg1.getValue()-arg0.getValue()) == 0? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
            }
        });
        //只输出前8条
        int m=0;
        for(Map.Entry<String, Integer> mapping : list){
            m++;
            if(m<=8){
                String[] str = mapping.getKey().split(" ");
                String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                String n = str[1];
                System.out.println(k+" "+n+" "+mapping.getValue());
            }else{
                break;
            }

        }

    }

}
     /*   //注意要对记录进行排序
        //对记录进行排序
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
            //降序
            @Override
            public int compare(Map.Entry<String, Integer> arg0, Map.Entry<String, Integer> arg1) {
                return(arg1.getValue()-arg0.getValue()) == 0? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
            }
        });
        int m = 0;
        for (Map.Entry<String,Integer> entry:hm.entrySet()) {
            m++;
            if(m <= 8) {
                String key = entry.getKey();
                if(key.length() > 16){
                    int start = key.length() - 16;
                    key = key.substring(start);
                }
                System.out.println(key + " " + entry.getValue());
            }else {
                break;
            }
        }
    }
}*/

/*
        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.HashMap;
        import java.util.LinkedHashMap;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.Map;
        import java.util.Map.Entry;
        import java.util.Scanner;


public class HuaWeiErrorRecords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();//LinkedHashMap而不是hashmap！！！！！
        String key;
        String filename;
        String path;
        while(in.hasNext()){
            path = in.next();
            //将路径转换为文件名
            int id = path.lastIndexOf('\\');
            //如果找不到说明只有文件名没有路径
            filename = id<0  ? path : path.substring(id+1);
            int linenum = in.nextInt();
            //统计频率
            key = filename+" "+linenum;
            if(map.containsKey(key)){
                map.put(key, map.get(key)+1);
            }else{
                map.put(key, 1);
            }
        }

        in.close();

        //对记录进行排序
        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<String, Integer>>(){
            //降序
            @Override
            public int compare(Entry<String, Integer> arg0, Entry<String, Integer> arg1) {
                return(arg1.getValue()-arg0.getValue()) == 0? (arg0.getValue()-arg1.getValue()) : (arg1.getValue()-arg0.getValue());
            }
        });
        //只输出前8条
        int m=0;
        for(Map.Entry<String, Integer> mapping : list){
            m++;
            if(m<=8){
                String[] str = mapping.getKey().split(" ");
                String k = str[0].length()>16 ? str[0].substring(str[0].length()-16) : str[0];
                String n = str[1];
                System.out.println(k+" "+n+" "+mapping.getValue());
            }else{
                break;
            }

        }

    }

}*/



/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s == null || "".equals(s)) break;
            String[] split = s.split("\\s");
            String key = split[0].substring(split[0].lastIndexOf('\\') + 1) + " " + split[1];
            map.put(key, map.containsKey(key) ? map.get(key) + 1 : 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        for (int i = 0; i < 8; i ++) {
            String[] split = list.get(i).getKey().split("\\s");
            if(split[0].length() > 16) split[0] = split[0].substring(split[0].length() - 16);
            System.out.println(split[0] + " " + split[1] + " " + list.get(i).getValue());
        }
    }
}*/
