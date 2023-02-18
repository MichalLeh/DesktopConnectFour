package four;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
public class ResetButton extends JButton {
    private final Map<String, Cell> buttons;
    private final Session session;
    public ResetButton(Map<String, Cell> buttons, Session session) {
        this.buttons = buttons;
        this.session = session;

        setName("ButtonReset");
        setText("Reset");
        setBounds(249, 1, 100,30);

        addActionListener(e -> resetGame());
    }
    private void resetGame(){
        for (Cell cell : buttons.values()) {
            if(!cell.getText().equals(" ")){
                cell.setText(" ");
                cell.setBackground(new Color(0xC6EA9E));
            }
        }
        session.setGameOn(true);
        session.setPlayer();
    }
}
