import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class Player extends Rectangle{
    int id;
    int yVelocity;
    int xVelocity;
    int speed = 10;
    Player(int x, int y, int PLAYER_WIDTH, int PLAYER_HEIGHT, int id) {
        super(x, y, PLAYER_WIDTH, PLAYER_HEIGHT);
        this.id = id;
    }
    public void keyPressed(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    setXDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    setXDirection(speed);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    setXDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    setXDirection(speed);
                    move();
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e){
        switch(id){
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    setXDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    setXDirection(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    setXDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    setXDirection(0);
                    move();
                }
                break;
        }
    }

    public void setYDirection(int yDirection){
        yVelocity = yDirection;
    }
    public void setXDirection(int xDirection){
        xVelocity = xDirection;
    }
    public void move(){
        y += yVelocity;
        x += xVelocity;
    }
    public void draw(Graphics g){
        if(id==1)
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
}
