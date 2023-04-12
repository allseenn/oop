import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Button;

public class Main {
    public static int i = 0;
    public static void main(String[] args) {
        
        Frame frame = new Frame("Table");
        Table table = new Table();
        Button button = new Button("Нажми меня");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                i++;
                table.setValue(5, 5, i);
            }
        });
        frame.setLayout(new BorderLayout());
        frame.add(table, BorderLayout.CENTER);
        frame.add(button, BorderLayout.SOUTH);
        frame.setSize(800, 400);
        frame.setVisible(true);
        table.setValue(0, 0, 1);
        table.setValue(1, 1, 2);
        table.setValue(2, 2, 3);

    }
}