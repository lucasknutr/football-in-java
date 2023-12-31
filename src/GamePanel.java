import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class GamePanel extends JPanel implements Runnable{
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    static final int BALL_DIAMETER = 25;
    static final int PLAYER_DIAMETER = 50;
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
        random = new Random();
        ball = new Ball((GAME_WIDTH/2) - (BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER);
    }
    public void newGoalPosts(){
        goalpost1 = new GoalPost(0, (GAME_HEIGHT/2)-(GOALPOST_HEIGHT/2), GOALPOST_WIDTH, GOALPOST_HEIGHT, 1);
        goalpost2 = new GoalPost(GAME_WIDTH - GOALPOST_WIDTH, (GAME_HEIGHT/2)-(GOALPOST_HEIGHT/2), GOALPOST_WIDTH, GOALPOST_HEIGHT, 2);
    }
    public void paintComponent(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }
    public void draw(Graphics g){
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);
        score.draw(g);
        goalpost1.draw(g);
        goalpost2.draw(g);
    }
    public void move(){
        player1.move();
        player2.move();
        ball.move();
    }
    public void checkCollision(){
        if(ball.y <= 0){
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.y >= GAME_HEIGHT - BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }
        if(ball.x <= 0){
            ball.setXDirection(-ball.xVelocity);
        }
        if(ball.x >= GAME_WIDTH - BALL_DIAMETER){
            ball.setXDirection(-ball.xVelocity);
        }
        if(ball.intersects(player1)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if(ball.yVelocity>0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(player1.getXVelocity());
            ball.setYDirection(player1.getYVelocity());
        }
        if(ball.intersects(player2)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;
            if(ball.yVelocity>0)
                ball.yVelocity++;
            else
                ball.yVelocity--;
            ball.setXDirection(player2.getXVelocity());
            ball.setYDirection(player2.getYVelocity());
        }
        if(ball.intersects(goalpost1)){
            score.player2++;
            newGoalPosts();
            newBall();
            System.out.println("Player 2: "+score.player2);
        }
        if(ball.intersects(goalpost2)){
            score.player1++;
            newGoalPosts();
            newBall();
            System.out.println("Player 1: "+score.player1);
        }
        if(player1.y<=0)
            player1.y = 0;
        if(player1.y >= (GAME_HEIGHT - PLAYER_DIAMETER))
            player1.y = GAME_HEIGHT - PLAYER_DIAMETER;
        if(player2.y<=0)
            player2.y = 0;
        if(player2.y >= (GAME_HEIGHT - PLAYER_DIAMETER))
            player2.y = GAME_HEIGHT - PLAYER_DIAMETER;
        if(player1.x<=0)
            player1.x = 0;
        if(player1.x >= (GAME_WIDTH - PLAYER_DIAMETER))
            player1.x = GAME_WIDTH - PLAYER_DIAMETER;
        if(player2.x<=0)
            player2.x = 0;
        if(player2.x >= (GAME_WIDTH - PLAYER_DIAMETER))
            player2.x = GAME_WIDTH - PLAYER_DIAMETER;
        if(ball.x<=0)
            ball.x = 0;
        if(ball.x >= (GAME_WIDTH - BALL_DIAMETER))
            ball.x = GAME_WIDTH - BALL_DIAMETER;
    }
    public void run(){
        // Game loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime)/ns;
            lastTime = now;
            if(delta >= 1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }
    public class AL extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            player1.keyPressed(e);
            player2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            player1.keyReleased(e);
            player2.keyReleased(e);
        }
    }
}
