import java.awt.Color;
import java.awt.Graphics;

public class Score {
  private int leftPaddleScore;
  private int rightPaddleScore;
  private int gameWidth;
  private int gameHeight;

  public Score(int width, int height) {
    leftPaddleScore = 0;
    rightPaddleScore = 0;
    gameWidth = width;
    gameHeight = height;
  }

  public void incrementLeft() {

    leftPaddleScore++;

  }

  public void incrementRight() {

    rightPaddleScore++;

  }

  public void showScore(Graphics g)
  {
    g.clearRect(0, 0, gameWidth, 104);
    g.clearRect(0, 0, 20, gameHeight);
    g.drawString("Left Paddle Score: " + String.valueOf(leftPaddleScore), 25, 50);
    g.drawString("Right Paddle Score: " + String.valueOf(rightPaddleScore), gameWidth - 175, 50);
  }

}