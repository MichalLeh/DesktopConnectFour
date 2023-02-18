package four;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class GameBoard extends JFrame {
    private final Map<String, Cell> buttons;
    private final Session session;
    public GameBoard(Session session) {
        this.buttons = new LinkedHashMap<>();
        this.session = session;
        setupGameBoard();
    }
    private void setupGameBoard() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Connect Four");
        setLayout(null);

        // setting the bounds for the JFrame
        setBounds(500,400,385,390);
        Border br = BorderFactory.createLineBorder(Color.black);
        Container cont = getContentPane();

        //Creating a JPanel for the JFrame
        JPanel upperPanel = new JPanel();
        JPanel lowerPanel = new JPanel();

        //setting the panel layout as null
        upperPanel.setLayout(null);
        lowerPanel.setLayout(null);

        // setup for cellButton
        int yMultiple = 0;
        int xMultiple = 0;

        // create board cells
        for (int i = 6; i > 0; i--) {
            for (char c = 'A'; c <= 'G'; c++) {
                String cellBtnName = "Button" + c + i;

                Cell cellBtn = new Cell(cellBtnName, xMultiple, yMultiple, session);
                buttons.putIfAbsent(cellBtnName, cellBtn);
                upperPanel.add(cellBtn);

                xMultiple++;
            }
            yMultiple++;
            xMultiple = 0;
        }
        lowerPanel.add(new ResetButton(buttons, session));

        upperPanel.setBackground(Color.LIGHT_GRAY);
        upperPanel.setBounds(10,10,350,300);

        lowerPanel.setBackground(Color.LIGHT_GRAY);
        lowerPanel.setBounds(10,310,350,31);

        // Panel border
        upperPanel.setBorder(br);
        lowerPanel.setBorder(br);

        //adding the panel to the Container of the JFrame
        cont.add(upperPanel);
        cont.add(lowerPanel);

        setVisible(true);

        session.setButtons(buttons);
    }
}
