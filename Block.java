import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
  private int xPos;
  private int yPos;
  private int width;
  private int height;

  private Color color;

  public Block()
  {
    this.xPos = 100;
    this.yPos = 150;
    this.width = 10;
    this.height = 10;
    color = Color.BLACK;
  }

  public Block(int xPos, int yPos)
  {
    this.xPos = xPos;
    this.yPos = yPos;
    this.width = 10;
    this.height = 10;
    color = Color.BLACK;
  }

  public Block(int xPos, int yPos, int width, int height) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.width = width;
    this.height = height;
    color = Color.BLACK;
  }

  public Block(int xPos, int yPos, int width) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.width = width;
    this.height = 10;
    color = Color.BLACK;
  }
        
  public Block(int xPos, int yPos, int width, int height, Color color) {
    this.xPos = xPos;
    this.yPos = yPos;
    this.width = width;
    this.height = height;
    this.color = color;
  }
        
   

  public void setColor(Color col)
  {
    this.color = col;
  }

  public void setPos(int x, int y) {
    xPos = x;
    yPos = y;
  }

  public void setX( int x ) {
    xPos = x;
  }

  public void setY( int y ) {
    yPos = y;
  }

  public int getWidth() {
    return width;
  }
  public int getHeight() {
    return height;
  }

  public void draw(Graphics window)
  {
    window.setColor(color);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }

  public void draw(Graphics window, Color col)
  {
    window.setColor(col);
    window.fillRect(getX(), getY(), getWidth(), getHeight());
  }
   
  public boolean equals(Object obj)
  {
    Block b = (Block) obj;
    return(xPos == b.xPos && yPos == b.yPos && height == b.height && width == b.width && color.equals(b.color));
  }   

  public int getX() {
    return xPos;
  }
  public int getY() {
    return yPos;
  }

  public String toString() {
    return xPos + " " + yPos + " " + width + " " + height + " " + color;
  }

}