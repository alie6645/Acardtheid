import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        Player anc = new Player();
        Display display = new Display();
        for (int i=0; i<4; i++){
            Card add = new Card();
            add.name = String.valueOf(i);
            add.img = ImageIO.read(new File("images/"+1+i+".png"));
            anc.load(add);
        }
        anc.draw(4);
        Panel panel = new Panel(anc, display);
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
