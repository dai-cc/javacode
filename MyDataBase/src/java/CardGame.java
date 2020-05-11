/**
 * @Author: will
 * @Date: 2019/11/14
 * @description:
 */


// 一副扑克有52张牌，这里不考虑大小王
package java;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Random;

public class CardGame {

    public static final String[] SUITS = {"♥", "♠", "♣", "♦"};
    // 初始化扑克牌
    public List<Card> buyDeck()
    {
        List<Card> cards = new ArrayList<>(52);

        // 代表花色
        for(int i = 0; i < 4; ++i)
        {
            // 给每个花色有13张牌
            for(int j = 0; j < 13; ++j)
            {
                Card card = new Card(j+1, SUITS[i]);
                cards.add(card);
            }
        }

        return cards;
    }

    // 洗牌
    public void shuffle(List<Card> cards)
    {
        Random rand = new Random(20191114);
        for(int i = cards.size()-1; i > 0; --i)
        {
            int r = rand.nextInt(i);
            swap(cards, i, r);
        }
    }

    public void send(ArrayList<ArrayList<Card>> person, List<Card> cards, int nums, int cardCnt)
    {
        // 将三个人设置好
        for(int i = 0; i < nums; ++i)
        {
            person.add(new ArrayList<Card>());
        }

        // 开始发牌
        for(int i = 0; i < cardCnt; ++i)
        {
            // 第i轮发牌
            for(int j = 0; j < nums; ++j)
            {
                Card d = cards.remove(0);
                person.get(j).add(d);
            }
        }
    }

    void play(ArrayList<ArrayList<Card>> persons)
    {
        Card d = new Card(1, "黑桃");

        for(int i = 0; i < persons.size(); ++i){
            ArrayList<Card> onePerson = persons.get(0);

            for(int j = 0; j < onePerson.size(); ++i){
                if(onePerson.contains(d))
                {
                    System.out.printf("%d 输了", j);
                }

            }
        }
    }

    private void swap(List<Card> cards, int i, int j)
    {
        Card t = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, t);
    }

    public static void main(String[] args) {

        CardGame cg = new CardGame();
        List<Card> cards = cg.buyDeck();

        // 打印牌
        System.out.println(cards);

        // 洗牌
        cg.shuffle(cards);
        System.out.println(cards);

        ArrayList<ArrayList<Card>> Persons = new ArrayList<>();
        cg.send(Persons, cards, 3, 5);
        System.out.println("========================");
        for(int i = 0; i < Persons.size(); ++i)
            System.out.println(Persons.get(i));

        System.out.println("===========================");


    }
}
