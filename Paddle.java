import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
  //instance variables
  private int speed;

  public Paddle()
  {
    super(10, 10);
    speed = 5;
  }

  //add the other Paddle constructors
  public Paddle(int xPos, int yPos) {
    super(xPos, yPos);
    speed = 5;
  }

  public Paddle(int xPos, int yPos, int width) {
    super(xPos, yPos, width);
    speed = 5;
  }

  public Paddle(int xPos, int yPos, int width, int height, int speed) {
    super(xPos, yPos, width, height);
    this.speed = speed;
  }

  public Paddle(int xPos, int yPos, int width, int height, Color col, int speed) {
    super(xPos, yPos, width, height, col);
    this.speed = speed;
  }

  public void moveUpAndDraw(Graphics window)
  {
    //draw a white paddle at old paddle location
    draw(window, Color.WHITE);

    setY(getY() - speed);

    //draw the paddle at its new location
    draw(window);
  }

  public void moveDownAndDraw(Graphics window)
  {
    //draw a white paddle at old paddle location
    draw(window, Color.WHITE);

    setY(getY() + speed);

    //draw the paddle at its new location
    draw(window);
  }

  //add get methods
  public int speed() {
    return speed;
  }

  public boolean equals(Object obj) {
    Paddle p = (Paddle) obj;
    return super.equals(p) && p.speed == speed;
  }
   
   
  //add a toString() method
  public String toString() {
    return super.toString() + " " + speed;
  }
}