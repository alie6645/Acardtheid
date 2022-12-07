import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClickListener extends MouseAdapter {
    private Panel panel;

    public ClickListener(Panel panel){
        this.panel = panel;
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        panel.setActiveCard(x,y);
        panel.repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        panel.click(x,y);
        panel.repaint();
    }
}
