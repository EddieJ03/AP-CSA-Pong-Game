import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{


  public SpeedUpBall()
  {

    super();

  }

  public SpeedUpBall(int x, int y)
  {

    super(x, y);

  }


  public SpeedUpBall(int x, int y, int xSpd, int ySpd)
  {

    super(x, y);
    super.setXSpeed(xSpd);
    super.setYSpeed(ySpd);

  }

  public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
  {

    super(x, y, wid, ht, xSpd, ySpd);

  }


  public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
  {

    super(x, y, wid, ht, col, xSpd, ySpd);

  }


  public void setXSpeed( int xSpd )
  {

    super.setXSpeed((xSpd + ((xSpd < 0) ? -1 : 1)) < 9 ? (xSpd + ((xSpd < 0) ? -1 : 1)) : xSpd);

  }

  public void setYSpeed( int ySpd )
  {

    super.setYSpeed((ySpd + ((ySpd < 0) ? -1 : 1)) < 9 ? ySpd + ((ySpd < 0) ? -1 : 1) : ySpd);

  }
}

