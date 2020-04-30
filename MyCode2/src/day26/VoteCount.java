package day26;

import java.util.*;

/*
* 计票统计
* 输入候选人人数，第二行输入候选人名字，第三行投票人人数，第四行输入投票
* 每行输出候选人的名字和得票数量
* */
public class VoteCount {
    private static LinkedHashMap<String,Integer> hm = new LinkedHashMap<>();
    private static int invalidvote = 0;
    private static int AddCandidate(String CandidateName){
        //设置候选人姓名，输入值非法返回0，已经添加过返回0，添加成功返回1
        if(hm.containsKey(CandidateName)){
            return 0;
        }
        hm.put(CandidateName,0);
        return 1;
    }
    private static void Vote(String CandidateName){
        //投票
        boolean flg = hm.containsKey(CandidateName);
        if(flg){
            int value = hm.getOrDefault(CandidateName,0)+1;
            hm.put(CandidateName,value);
        }else {
            invalidvote++;
        }
    }
    private static int GetVoteResult(String CandidateName){
        //获取候选人的票数，如果输入的是无效的人名，返回无效的票数,同时说明本次投票活动结束，释放资源
        return hm.getOrDefault(CandidateName,invalidvote);

    }
    private static void Clear(){
        //清除投票结果，释放所有资源
        invalidvote = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int canNum = sc.nextInt();
            for (int i = 0; i < canNum; i++) {
                AddCandidate(sc.next());
            }
            int voteNum = sc.nextInt();

            for (int i = 0; i < voteNum; i++) {
                String CandidateName = sc.next();
               Vote(CandidateName);
            }
            for (Map.Entry<String,Integer> a:hm.entrySet()) {
                System.out.println(a.getKey() +" : "+a.getValue());
            }
            System.out.println("Invalid : "+invalidvote);
        }
    }
}
