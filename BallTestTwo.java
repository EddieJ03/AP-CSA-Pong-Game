import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

class BallTestTwo extends Canvas implements Runnable
{
  private Ball ball;

  public BallTestTwo()
  {
    setBackground(Color.WHITE);
    setVisible(true);

    //instantiate a new Ball
    //ball = new Ball();


    //test the Ball thoroughly
    //ball = new Ball(100, 350);   
		//ball = new Ball(200, 90, 10, 10, Color.BLUE);  
		ball = new Ball(300, 10, 10, 10, Color.GREEN, 2, 2);

    //test all constructors

    

    new Thread(this).start();
  }
        
  public void update(Graphics window)
  {
    paint(window);
  }

  public void paint(Graphics window)
  {
    ball.moveAndDraw(window);

    if(!(ball.getX()>=10 && ball.getX()<=550))
    {
      ball.setXSpeed(-ball.getXSpeed());
    }

    if(!(ball.getY()>=10 && ball.getY()<=450))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }
  }
        
  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(19);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }

  public static void main(String[] args) {
    JFrame jf = new JFrame("BallTestTwo");
    BallTestTwo b2 = new BallTestTwo();
    jf.setVisible(true);
    jf.setSize(550, 450);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jf.add(b2);
  }
}