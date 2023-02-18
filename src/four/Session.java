package four;

import java.util.Map;
public class Session {
    private String player = "X";
    private final BoardCheck boardCheck = new BoardCheck();
    private Boolean gameOn;
    private Map<String, Cell> buttons;
    public Session() {
        this.gameOn = true;
    }
    public void setGameOn(Boolean value){
        this.gameOn = value;
    }
    public void setButtons(Map<String, Cell> buttons){
        this.buttons = buttons;
    }
    public void setPlayer(){
        this.player = "X";
    }
    public void move(String cellName){
        if (gameOn) {
            fillFirstEmptyCell(buttons.get(cellName).getName(), buttons);
            boardCheck.checkHub(buttons, this);
        }
    }
    private void fillFirstEmptyCell(String name, Map<String, Cell> buttons){
        String btnColName = name.replaceAll("[^A-Za-z]+", "");
        for (int row = 1; row <= 6; row++) {
            Cell cell = buttons.get(btnColName + row);

            if (cell.getText().equals(" ")) {
                cell.setText(player);
                player = "X".equals(player) ? "O" : "X";
                break;
            }
        }
    }
}
