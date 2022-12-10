import javax.swing.*;
import java.awt.*;

public class Panel extends JComponent {
    Player active;
    Card selected;
    Display display;
    ActionHandler handler;

    public Panel(Player player, Display display, ActionHandler handler){
        active = player;
        this.display = display;
        this.handler = handler;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.fillRect(38,13,89,32);
        active.draw(g2);
        display.draw(g2);
    }

    public void setActiveCard(int x, int y){
        selected = active.setActive(x,y);
        if (selected != null) {
            display.setDisplay(selected);
        } else {
            display.setDisplay(display.blank);
        }
    }

    public void click(int x,int y){
        handler.play(active.getCard(x,y));
    }
}
