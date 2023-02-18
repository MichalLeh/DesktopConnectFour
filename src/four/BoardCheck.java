package four;

import java.awt.*;
import java.util.*;
import java.util.List;
public class BoardCheck {
    private final List<String> rows = Arrays.asList("1","2","3","4","5","6");
    private final List<String> cols = Arrays.asList("A", "B", "C", "D", "E", "F", "G");
    private String cell = "";
    private String nextCell = "";
    private Set<String> winningCells = new HashSet<>();
    private Session session;
    private Map<String, Cell> buttons;

    public void checkHub(Map<String, Cell> buttons, Session session){
        this.session = session;
        this.buttons = buttons;

        verticalCheck();
        horizontalCheck();
        checkDiagonal();
    }
    private void checkDiagonal(){
        int colSize = cols.size() - 1;
        int row = 0;

        while(row < rows.size()/2) {
            for (int col = 0; col < 8; col++) {
                winningCells.clear();
                for (int j = 1; j < 4; j++) {
                    // check right-leaning diagonal
                    if (col < 4) {
                        cell = "Button" + cols.get(col) + rows.get(row);
                        nextCell = "Button" + cols.get(col + j) + rows.get(row + j);
                    // check left-leaning diagonal
                    } else {
                        cell = "Button" + cols.get(colSize - (col - 4)) + rows.get(row);
                        nextCell = "Button" + cols.get(colSize - j - (col - 4)) + rows.get(row + j);
                    }
                    addToSet(cell, nextCell);
                }
            }
            row++;
        }
    }
    private void horizontalCheck() {
        for (String row : rows){
            winningCells.clear();
            for (int i = 0; i < cols.size() - 1; i++){
                cell = "Button" + cols.get(i) + row;
                nextCell = "Button" + cols.get(i + 1) + row;

                addToSet(cell, nextCell);
            }
        }
    }
    private void verticalCheck(){
        for (String col : cols) {
            winningCells.clear();
            for (int i = 0; i < rows.size() - 1; i++){
                cell = "Button" + col + rows.get(i);
                nextCell = "Button" + col + rows.get(i + 1);
                addToSet(cell, nextCell);
            }
        }
    }
    private void addToSet(String cell, String nextCell){
        if (!buttons.get(cell).getText().equals(" ")) {
            if (buttons.get(cell).getText().equals(buttons.get(nextCell).getText())) {
                winningCells.add(cell);
                winningCells.add(nextCell);
                if (winningCells.size() == 4) {
                    changeColor(buttons);
                }
            } else {
                winningCells.clear();
            }
        }
    }
    private void changeColor(Map<String, Cell> buttons){
        session.setGameOn(false);
        for(String cell : winningCells){
            Color colorBackground = new Color(0x52BBF7);
            buttons.get(cell).setBackground(colorBackground);
        }
    }
}
