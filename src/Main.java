import pres.MainPanel;
import pres.MyFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> new MyFrame()
        );
    }
}
