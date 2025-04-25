package Login;
//@uthor Rafli RD

import javax.swing.JFrame;

public class NewClass extends JFrame {
    
    public static void main(String[] args) {
        NewClass testing = new NewClass();
        testing.setSize(1440, 900);
        testing.setVisible(true);
        
        CobaPanel panel_testing = new CobaPanel();
        
        testing.add(panel_testing);
    }
}
