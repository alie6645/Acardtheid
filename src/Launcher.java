import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        Player anc = new Player();
        Player np = new Player();
        Display display = new Display();
        CardLibrary library = new CardLibrary();
        ActionHandler handler = new ActionHandler(anc, np);
        for (Card card:library.anc){
            anc.load(card);
        }
        anc.draw(4);
        Panel panel = new Panel(anc, display, handler);
        ClickListener listener = new ClickListener(panel);

        frame.add(panel);
        frame.addMouseMotionListener(listener);
        frame.addMouseListener(listener);
        frame.setBackground(Color.lightGray);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000,800));
        frame.setVisible(true);
    }
}
