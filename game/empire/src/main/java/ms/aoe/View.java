package ms.aoe;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class View extends Canvas {

    private int width, hight, textSize, textColor, fillColor, lines;
    String textStyle;
    private String[][] table;

    public View(int width, int hight, int textSize, int textColor, String textStyle, int fillColor, int lines) {
        this.width = width;
        this.hight = hight;
        this.textSize = textSize;
        this.textStyle = textStyle;
        this.textColor = textColor;
        this.fillColor = fillColor;
        this.lines = lines;
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
                g.setFont(new Font(textStyle, Font.PLAIN, textSize));
                if(fillColor == 0){ g.setColor(Color.WHITE);}
                else if(fillColor == 1){ g.setColor(Color.YELLOW);}
                else if(fillColor == 2){ g.setColor(Color.GREEN);}
                else if(fillColor == 3){ g.setColor(Color.RED);}
                else if(fillColor == 4){ g.setColor(Color.BLACK);}

                g.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                if(textColor == 0){ g.setColor(Color.WHITE);}
                else if(textColor == 1){ g.setColor(Color.YELLOW);}
                else if(textColor == 2){ g.setColor(Color.GREEN);}
                else if(textColor == 3){ g.setColor(Color.RED);}
                else if(textColor == 4){ g.setColor(Color.BLACK);}
                if(lines > 0) { g.drawRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);}
                g.drawString(String.valueOf(table[i][j]), i * cellWidth + cellWidth/5, j * cellHeight + cellHeight-7);

            }
        }
    }

    public void setValue(int x, int y, String value) {
        table[x][y] = value;
        repaint();
    }

}
