package komponen;

import java.awt.*;
import javax.swing.*;

public class koordinat extends JPanel {
    
    protected void paintcomponent(Graphics g){
        super.paintComponent(g);
        
        g.setColor(Color.GRAY);
        
        int lebar = getWidth();
        int tinggi = getHeight();
        
        g.drawLine(0, tinggi/2, lebar, tinggi /2);
        g.drawLine(lebar / 2, 0, lebar / 2, tinggi);
        
        g.setColor(Color.red);
        for(int i = 0 ; i<tinggi; i+=50){
            g.drawLine(i, 0, i, tinggi);
        }
        for (int j = 0; j< lebar;j+=50){
            g.drawLine(0, j, lebar, j);
        }
    }
}
