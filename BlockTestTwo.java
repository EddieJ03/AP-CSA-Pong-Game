import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;

import javax.swing.JFrame;

public class BlockTestTwo extends Canvas
{
  public BlockTestTwo()
  {
    setBackground(Color.WHITE);
  }

  public void paint(Graphics window)
  {
    Block one = new Block();
    one.draw(window);

    Block two = new Block(50, 50, 30, 30);
    two.draw(window);

    Block three = new Block(350,350,15,15,Color.RED);
    three.draw(window);

    Block four = new Block(450,50,20,60, Color.GREEN);
    four.draw(window);
                
    Block five = new Block(200, 50, 50, 60, Color.BLUE);
    five.draw(window);                    
  }

  public static void main(String[] args) {
    JFrame jf = new JFrame("BlockTestTwo");
    BlockTestTwo b2 = new BlockTestTwo();
    jf.setVisible(true);
    jf.setSize(600, 400);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.add(b2);
  }
}