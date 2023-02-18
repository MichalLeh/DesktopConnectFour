package four;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
public class Cell extends JButton {
    private final String name;
    private final Session session;
    public Cell(String name, int xMultiple, int yMultiple, Session session) {
        this.session = session;
        this.name = name;

        setBackground(new Color(0xC6EA9E));

        int x = 0;
        int y = 0;
        int width = 50;
        int height = 50;

        setBounds(x + xMultiple * height, y + yMultiple * width, width, height);
        setText(" ");

        addActionListener(this::actionPerformed);
    }
    private void actionPerformed(ActionEvent e) {
        session.move(name);
    }
    @Override
    public String getName() {
        return name;
    }
}
