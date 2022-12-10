import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CardLibrary {
    List<Card> anc = new ArrayList<>();
    List<Card> np = new ArrayList<>();
    List<Card> fate = new ArrayList<>();
    public CardLibrary(){
        createCards();
        registerCommands();

    }

    private void createCards() {
        String root = "images/";
        anc.add(createCard("Defiance\nCampaign", "anc",1,0,root+"1.png"));
        anc.add(createCard("General\nStrikes", "anc",1,0,root+"2.png"));
        anc.add(createCard("Black\nConscious\nMovement", "anc",2,0,root+"3.png"));
        anc.add(createCard("United\nDemocratic\nFront", "anc",3,0,root+"4.png"));
        anc.add(createCard("Student\nMovements","anc",2,1,root+"5.png"));
        anc.add(createCard("Freedom\nCharter","anc",1,0,root+"6.png"));
        anc.add(createCard("Boycott","anc",1,0,root+"7.png"));
        anc.add(createCard("Boycott","anc",1,0,root+"8.png"));
        anc.add(createCard("Boycott","anc",1,0,root+"9.png"));
        anc.add(createCard("Protest","anc",1,0,root+"10.png"));
        anc.add(createCard("Protest","anc",1,0,root+"11.png"));
        anc.add(createCard("Protest","anc",1,0,root+"12.png"));
        anc.add(createCard("Protest","anc",1,0,root+"13.png"));
        anc.add(createCard("Defiance\nCampaign\nPt.2","anc",2,0,root+"14.png"));
        anc.add(createCard("Umkhoto\nWe Sizwe\nAttacks","anc",2,0,root+"15.png"));
        anc.add(createCard("Umkhoto\nWe Sizwe\nAttacks","anc",2,0,root+"16.png"));
        anc.add(createCard("Umkhoto\nWe Sizwe\nAttacks","anc",2,0,root+"17.png"));
        anc.add(createCard("Umkhoto\nWe Sizwe\nAttacks","anc",2,0,root+"18.png"));
        anc.add(createCard("Frontline\nSupport","anc",1,1,root+"19.png"));
    }

    private void registerCommands(){
        anc.get(6).commands = "draw 1 mill 1 end";
    }

    public Card createCard(String name, String type, int pCost, int vCost, String filename){
        Card card = new Card();
        card.name = name;
        card.type = type;
        card.pCost = pCost;
        card.vCost = vCost;
        try {
            card.img = ImageIO.read(new File(filename));
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return card;
    }
}
