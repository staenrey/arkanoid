import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Breakout extends BasicGame {

    final float BALL_SPEED = 0.2f;
    final int BALL_SIZE = 10;

    float ballX = 315;
    float ballY = 480 - BALL_SIZE;
    float ballSpeedX = BALL_SPEED;
    float ballSpeedY = BALL_SPEED;

    public Breakout() {
        super("Breakout");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        ballX = ballX + ballSpeedX * delta;
        ballY = ballY - ballSpeedY * delta;

        if (ballX <= 0) {
            ballX = 0;
            ballSpeedX = -ballSpeedX;
        }

        if (ballX >= 640 - BALL_SIZE) {
            ballX = 640 - BALL_SIZE;
            ballSpeedX = -ballSpeedX;
        }

        if (ballY <= 0) {
            ballY = 0;
            ballSpeedY = -ballSpeedY;
        }

        if (ballY >= 480 - BALL_SIZE) {
            ballY = 480 - BALL_SIZE;
            ballSpeedY = -ballSpeedY;
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer appgc = new AppGameContainer(new Breakout());
        appgc.setDisplayMode(640, 480, false);
        appgc.start();
    }
}
