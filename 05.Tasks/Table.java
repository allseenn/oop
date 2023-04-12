import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.Frame;

public class Table extends Canvas {
    private int[][] table = new int[10][10];

    public void paint(Graphics g) {
        int cellWidth = getWidth() / 10;
        int cellHeight = getHeight() / 10;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                g.setColor(Color.WHITE);
                g.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                g.setColor(Color.BLACK);
                g.drawRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                g.drawString(String.valueOf(table[i][j]), i * cellWidth + cellWidth / 2, j * cellHeight + cellHeight / 2);
            }
        }
    }

    public void setValue(int x, int y, int value) {
        table[x][y] = value;
        repaint();
    }

}