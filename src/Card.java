import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Card {
    public static int height = 100;
    public static int width = 70;
    public String type = "fate";
    public int pCost=2;
    public int vCost=2;
    public String name = "empty";
    public boolean active = false;
    public BufferedImage img;
    public String commands = "draw 1 end";

    public void draw(Graphics2D g2, int x, int y){
        if (active){
            g2.setColor(Color.yellow);
            g2.fillRoundRect(x-2,y-2,width+4,height+4,2,2);
        }
        g2.setColor(Color.white);
        g2.fillRect(x,y,width,height);
        g2.setColor(new Color(215,100,3));
        if (type.equals("anc")){
            g2.setColor(new Color(8,159,0));
        }
        if (type.equals("fate")){
            g2.setColor(new Color(255,13,114));
        }
        g2.fillRect(x,y,width,height/6);
        g2.fillRect(x,y+height*5/6,width,height/6);
        g2.setColor(Color.cyan);
        for (int i=0; i<pCost; i++){
            g2.fillOval(x+i*width/6,y+height*5/6,width/6,width/6);
        }
        g2.setColor(new Color(200,0,0));
        for (int i=3; i<vCost+3; i++){
            g2.fillOval(x+i*width/6,y+height*5/6,width/6,width/6);
        }
        g2.setColor(Color.black);
        drawText(g2,name,x,y+height/7);
    }

    public void drawText(Graphics2D g2, String str, int x, int y){
        int lineheight = g2.getFontMetrics().getHeight();
        for (String line: str.split("\n")){
            g2.drawString(line,x,y+=lineheight);
        }

    }
}
