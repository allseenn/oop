package ms.aoe;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class Viewer extends Canvas {

    private int width, hight, textSize;
    private String[][] table;

    public Viewer(int width, int hight, int textSize) {
        this.width = width;
        this.hight = hight;
        this.textSize = textSize;
        this.table = new String[width][hight];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < hight; j++) {
                table[i][j] = "";
            }
        }
    }

    public void paint(Graphics g) {
        int cellWidth = getWidth() / width;
        int cellHeight = getHeight() / hight;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < hight; j++) {
                g.setFont(new Font("FreeSerif", Font.PLAIN, textSize));
                g.setColor(Color.WHITE);
                g.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                g.setColor(Color.BLACK);
                g.drawRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                g.drawString(String.valueOf(table[i][j]), i * cellWidth + cellWidth/5, j * cellHeight + cellHeight-7);

            }
        }
    }

    public void setValue(int x, int y, String value) {
        table[x][y] = value;
        repaint();
    }

}
