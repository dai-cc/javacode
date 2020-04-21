package day19;

import java.util.HashMap;

/*
* 现有一个小写英文字母组成的字符串s和一个包含较短小写英文转字符串的数组p，
* 设计一个算法，对于p中的每一个字符串，判断其是否为s的子串
* */
public class SubStr {
    //p是子字符串数组，n是p数组的长度，s为母串
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] result = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(s.contains(p[i])){
                result[i] = true;
            }else {
                result[i] = false;
            }
        }
        return result;
    }
}

