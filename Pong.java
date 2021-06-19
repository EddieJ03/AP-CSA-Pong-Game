import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
  private Ball ball;

  private Wall leftWall;
  private Wall rightWall;
  private Wall topWall;
  private Wall bottomWall;

  private Score score;

  private int gameWidth;
  private int gameHeight;

  private Paddle leftPaddle;
  private Paddle rightPaddle;

  private boolean[] keys;

  private BufferedImage back;


  public Pong(int chooseBall, int width, int height)
  {
    gameWidth = width;
    gameHeight = height;

    //set up all variables related to the game
    if(chooseBall == 0) {
      ball = new Ball(width / 2, height / 2);
    } else if(chooseBall == 1) {
      ball = new BlinkyBall(width / 2, height / 2);
    } else if(chooseBall == 2) {
      ball = new SpeedUpBall(width / 2, height / 2);
    }

    //instantiate a left Paddle
    leftPaddle = new Paddle(50, gameHeight / 2, 15, 75, Color.GREEN, 2);

    //instantiate a right Paddle
    rightPaddle = new Paddle(width - 50, gameHeight / 2, 15, 75, Color.BLACK, 2);


    leftWall = new Wall(0, 9, 1, gameHeight, Color.WHITE);
    rightWall = new Wall(gameWidth - 2, 0, 1, gameHeight, Color.WHITE);
    topWall = new Wall(0, 105, gameWidth, 1, Color.BLACK);
    bottomWall = new Wall(0, gameHeight - 40, gameWidth, 1, Color.WHITE);

    score = new Score(gameWidth, gameHeight);


    keys = new boolean[5];

    
    setBackground(Color.WHITE);
    setVisible(true);

    addKeyListener(this); //starts the key thread to log key strokes
                
    new Thread(this).start();

  }
        
  public void update(Graphics window){
    paint(window);
  }

  public void paint(Graphics window)
  {
    //set up the double buffering to make the game animation nice and smooth
    Graphics2D twoDGraph = (Graphics2D)window;

    //take a snap shop of the current screen and same it as an image
    //that is the exact same width and height as the current screen
    if (back==null)
      back = (BufferedImage)(createImage(getWidth(), getHeight()));

    //create a graphics reference to the back ground image
    //we will draw all changes on the background image
    Graphics graphToBack = back.createGraphics();


    //see if ball hits left wall or right wall
    if (ball.didCollideLeft(leftWall) || ball.didCollideRight(rightWall))
    {
      
      if(ball.didCollideLeft(leftWall)) {
        score.incrementRight();
      } else {
        score.incrementLeft();
      }
      
      ball.setXSpeed((int)(Math.random() * 2) == 1 ? ball.getXSpeed() : -ball.getXSpeed());
      ball.setYSpeed((int)(Math.random() * 2) == 1 ? ball.getYSpeed() : -ball.getYSpeed());

      ball.setX(gameWidth / 2);
      ball.setY(gameHeight / 2);

    }

                
    //see if the ball hits the top or bottom wall 
    if (ball.didCollideBottom(bottomWall) || ball.didCollideTop(topWall))
    {
      ball.setYSpeed(-ball.getYSpeed());
    }


    //see if the ball hits the left paddle
    if (  ( ball.didCollideLeft(leftPaddle)
          &&
          ( ball.getY() >= leftPaddle.getY() &&
            ball.getY() <= leftPaddle.getY() + leftPaddle.getHeight()  ||
            ball.didCollideBottom(leftPaddle) &&
            ball.didCollideTop(leftPaddle) ) )  )
    {
      if(  ball.getX()  <=  leftPaddle.getX() + leftPaddle.getWidth() - Math.abs(ball.getXSpeed()) ) {
        ball.setYSpeed(-ball.getYSpeed()); 
      }
      else {
        ball.setXSpeed(-ball.getXSpeed());
      }

    }


  //see if the ball hits the right paddle
  if (  ( ball.didCollideRight(rightPaddle)
          &&
          ( ball.getY() >= rightPaddle.getY() &&
            ball.getY() <= rightPaddle.getY() + rightPaddle.getHeight()  ||
            ball.didCollideBottom(rightPaddle) &&
            ball.didCollideTop(rightPaddle) ) )  )
  {
      if(  ball.getX()  >=  rightPaddle.getX() + Math.abs(ball.getXSpeed()) ) {
        ball.setYSpeed(-ball.getYSpeed()); 
      }
      else {
        ball.setXSpeed(-ball.getXSpeed());
      }

  }           
                
    
    twoDGraph.drawImage(back, null, 0, 0);

    //see if the paddles need to be moved
    if (keys[0])
    {
      if((leftPaddle.getY() + leftPaddle.speed() >= topWall.getY()))
      {
        //move left paddle up and draw it on the window
        leftPaddle.moveUpAndDraw(graphToBack);
      }
    }
    if (keys[1])
    {
      if(( leftPaddle.getY() + leftPaddle.getHeight() <= gameHeight - 40))
      {
      //move left paddle down and draw it on the window
      leftPaddle.moveDownAndDraw(graphToBack);
      }
    }
    if (keys[2])
    {
      if((rightPaddle.getY() + rightPaddle.speed() >= topWall.getY()))
      {
        //move left paddle up and draw it on the window
        rightPaddle.moveUpAndDraw(graphToBack);
      }
    }
    if (keys[3])
    {
      if((rightPaddle.getY() + rightPaddle.getHeight() <= gameHeight - 40))
      {
        //move left paddle up and draw it on the window
        rightPaddle.moveDownAndDraw(graphToBack);
      }
    }

    ball.moveAndDraw(graphToBack);

    leftPaddle.draw(graphToBack);

    rightPaddle.draw(graphToBack);

    score.showScore(graphToBack);

    topWall.draw(graphToBack);

  }

  public void keyPressed(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=true; break;
    case 'Z' : keys[1]=true; break;
    case 'I' : keys[2]=true; break;
    case 'M' : keys[3]=true; break;
    }
  }

  public void keyReleased(KeyEvent e)
  {
    switch(toUpperCase(e.getKeyChar()))
    {
    case 'W' : keys[0]=false; break;
    case 'Z' : keys[1]=false; break;
    case 'I' : keys[2]=false; break;
    case 'M' : keys[3]=false; break;
    }
  }

  public void keyTyped(KeyEvent e){}
        
  public void run()
  {
    try
    {
      while(true)
      {
        Thread.currentThread().sleep(8);
        repaint();
      }
    }catch(Exception e)
    {
    }
  }     
}