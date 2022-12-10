import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ActionHandler {
    Player anc;
    Player np;
    private List<Card> ancHand;
    private List<Card> npHand;
    private List<Card> ancDiscard;
    private List<Card> npDiscard;
    private List<Card> triggers = new ArrayList<>();
    private List<Card> costs = new ArrayList<>();
    private int phase = 0;

    public ActionHandler(Player anc, Player np){
        this.anc = anc;
        this.np = np;
         ancHand = anc.hand;
         npHand = np.hand;
         ancDiscard = anc.discard;
         npDiscard = np.discard;
    }

    public void play(Card card){
        card.active = false;
        Player opponent = np;
        Player self = anc;
        if (phase==2){
            opponent = anc;
            self = np;
        }
        Player target = self;

        Scanner commands = new Scanner(card.commands);
        while (commands.hasNext()){
            String run = commands.next().strip();
            if (run.equals("s")){
                target = self;
            }
            if (run.equals("o")){
                target = opponent;
            }
            if (run.equals("draw")){
                int num = commands.nextInt();
                target.draw(num);
            }
            if (run.equals("mill")){
                int num = commands.nextInt();
                self.mill(num);
            }
            if (run.equals("end")){
                self.hand.remove(card);
                self.discard.add(card);
            }
            if (run.equals("trigger")){
                triggers.add(card);
                break;
            }
        }
    }
}
