import java.awt.*;

public class Display {
    Card display = new Card();
    int x = 600;
    int y = 0;

    public void setDisplay(Card card){
        display = card;
    }

    public void draw(Graphics2D g2){
        g2.drawRect(x,y,375,525);
        if (display.img != null){
            g2.drawImage(display.img, x,y, null);
        }
    }
}
