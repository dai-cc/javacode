/**
 * @Author: will
 * @Date: 2019/11/14
 * @description:
 */
package java;
public class Card {
    private int rank;   // 牌面值
    private String suit; // 花色

    public Card(int rank, String suit)
    {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setRank(int rank) {

        this.rank = rank;
    }

    @Override
    public String toString() {
        String v;
        v = String.valueOf(rank);
        return  String.format("[%s, %s]", v, suit);
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}
