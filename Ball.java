import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
  private int xSpeed;
  private int ySpeed;

  public Ball()
  {
    super(200,200);
    xSpeed = 1;
    ySpeed = 1;
  }

  public Ball(int x, int y)
  {
    super(x, y);
    xSpeed = 1;
    ySpeed = 1;
  }

  public Ball(int x, int y, int width, int height)
  {
    super(x, y, width, height);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x, int y, int width, int height, Color col)
  {
    super(x, y, width, height, col);
    xSpeed = 3;
    ySpeed = 1;
  }

  public Ball(int x, int y, int width, int height, int xSpeed, int ySpeed)
  {
    super(x, y, width, height);
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }

  public Ball(int x, int y, int width, int height, Color col, int xSpeed, int ySpeed)
  {
    super(x, y, width, height, col);
    this.xSpeed = xSpeed;
    this.ySpeed = ySpeed;
  }
        
      
  //add the set methods
  public void setXSpeed(int xSpeed) {
    this.xSpeed = xSpeed;
  }

  public void setYSpeed(int ySpeed) {
    this.ySpeed = ySpeed;
  }
   

  public void moveAndDraw(Graphics window)
  {
    //draw a white ball at old ball location
    draw(window, Color.WHITE);

    setX(getX() + xSpeed);
    setY(getY() + ySpeed);

    //draw the ball at its new location
    draw(window);
  }
   
  public boolean equals(Object obj)
  {
    Ball b = (Ball) obj;
    return (super.equals(b) && xSpeed == b.xSpeed && ySpeed == b.ySpeed);
  }

  //Collide Methods
  public boolean didCollideLeft(Object obj) {
    Block b = (Block) obj;
    return super.getX() <= b.getX() + b.getWidth() + Math.abs(getXSpeed());
  }  

  public boolean didCollideRight(Object obj) {
    Block b = (Block) obj;
    return super.getX() >= b.getX() - Math.abs(getXSpeed());
  }  

  public boolean didCollideTop(Object obj) {
    Block b = (Block) obj;
    return super.getY() + super.getHeight() <= b.getY();
  } 

  public boolean didCollideBottom(Object obj) {
    Block b = (Block) obj;
    return super.getY() >= b.getY() + b.getHeight();
  } 

  //add the get methods
  public int getXSpeed() {
    return xSpeed;
  }

  public int getYSpeed() {
    return ySpeed;
  }

  public String toString() {
    return super.toString() + " " + xSpeed + " " + ySpeed;
  }
}