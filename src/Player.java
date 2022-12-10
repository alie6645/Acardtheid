import java.awt.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Player {
    int hp;
    List<Card> hand = new ArrayList<>();
    List<Card> discard = new ArrayList<>();
    Deque<Card> deck = new ArrayDeque(30);

    public void draw(int cards){
        for (int i=0; i<cards; i++) {
            hand.add(deck.remove());
        }
    }

    public void mill(int cards){
        for (int i=0; i<cards; i++){
            discard.add(deck.remove());
        }
    }

    public void draw(Graphics2D g2){
        if (hand.size() > 0) {
            int spacing = 550 / hand.size();
            for (int i = 0; i < hand.size(); i++) {
                hand.get(i).draw(g2, i*spacing+50, 400);
            }
        }
        g2.setColor(Color.lightGray);
        g2.fillRect(100,550,Card.width,Card.height);
        g2.setColor(Color.black);
        g2.drawString(String.valueOf(deck.size()),110,600);

        if (discard.size() > 0){
            discard.get(discard.size()-1).draw(g2,200,550);
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
