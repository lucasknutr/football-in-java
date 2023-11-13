import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GamePanel extends JPanel implements Runnable{
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 25;
    static final int PLAYER_DIAMETER = 20;
    static final int GOALPOST_WIDTH = 20;
    static final int GOALPOST_HEIGHT = 200;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Player player1;
    Player player2;
    Ball ball;
    Score score;
    GoalPost goalpost1;
    GoalPost goalpost2;
    GamePanel(){
        newPlayers();
        newBall();
        newGoalPosts();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void newPlayers(){
        player1 = new Player(100, (GAME_HEIGHT/2)-(PLAYER_DIAMETER/2), PLAYER_DIAMETER, PLAYER_DIAMETER, 1);
        player2 = new Player(GAME_WIDTH - PLAYER_DIAMETER - 100, (GAME_HEIGHT/2)-(PLAYER_DIAMETER/2), PLAYER_DIAMETER, PLAYER_DIAMETER, 2);
    }
    public void newBall(){

    }
    public void newGoalPosts(){

    }
    public void paintComponent(Graphics g){

    }
    public void draw(Graphics g){

    }
    public void move(){

    }
    public void checkCollision(){

    }
    public void run(){

    }
    public class AL extends KeyAdapter{

    }
}
