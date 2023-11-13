import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GoalPost extends Rectangle {
    int id;
    GoalPost(int x, int y, int GOALPOST_WIDTH, int GOALPOST_HEIGHT, int id) {
        super(x, y, GOALPOST_WIDTH, GOALPOST_HEIGHT);
        this.id = id;
    }
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}
