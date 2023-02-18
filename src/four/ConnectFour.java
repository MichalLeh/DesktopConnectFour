package four;

import javax.swing.*;
public class ConnectFour extends JFrame {
    public ConnectFour() {
        new GameBoard(new Session());
    }
}