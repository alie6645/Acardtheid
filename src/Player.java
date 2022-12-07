import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Player {
    private int hp;
    private List<Card> hand = new ArrayList<>();
    private List<Card> discard = new ArrayList<>();
    private Deque<Card> deck = new ArrayDeque(30);

    public void draw(int cards){
        for (int i=0; i<cards; i++) {
            hand.add(deck.remove());
        }
    }

    public void draw(Graphics2D g2){
        if (hand.size() > 0) {
            int spacing = 550 / hand.size();
            for (int i = 0; i < hand.size(); i++) {
                hand.get(i).draw(g2, i*spacing+50, 400);
            }
        }
    }

    public void load(Card card){
        deck.add(card);
    }

    public Card setActive(int x, int y){
        for (Card card:hand){
            card.active = false;
        }
        Card hover = getCard(x,y);
        if (hand.size() > 0) {
            if (hover!=null){
                hover.active = true;
                return hover;
            }
        }
        return null;
    }

    public Card getCard(int x, int y){
        if (hand.size() > 0) {
            int spacing = 550 / hand.size();
            for (int i = 0; i < hand.size(); i++) {
                if (y>400&&y<400+Card.height){
                    if (x>i*spacing+50&&x<i*spacing+50+Card.width){
                        return hand.get(i);
                    }
                }
            }
        }
        return null;
    }
}
