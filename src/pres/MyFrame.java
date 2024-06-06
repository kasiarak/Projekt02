package pres;

import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(){
        this.setSize(600,400);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new MainPanel());
        this.setVisible(true);
    }
}
