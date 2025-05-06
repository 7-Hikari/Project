package komponen;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class PanelBulat extends JPanel{
    private int d = 70;
    
    
    public PanelBulat (int x) {
        this.d = x;
        setPreferredSize(new Dimension(x, x));
        setOpaque(false);
    }
    
    public PanelBulat (){
        this.d=(d);
        setPreferredSize(new Dimension(d, d));
        setOpaque(false);
    }
    
    
    public int getLingkar(){
        return d;
    }
    public void setDiameter (int x){
        this.d = x;
        setPreferredSize(new Dimension(x, x));
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g){
        Graphics2D G2D = (Graphics2D) g.create();
        G2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        G2D.setColor(getBackground());
        
        int diameter = Math.min(getWidth(), getHeight());
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        
        Ellipse2D lingkar = new Ellipse2D.Double(x, y, d, d);
        
        G2D.fill(lingkar);
        G2D.dispose();
        super.paintComponent(g);
    }
}
