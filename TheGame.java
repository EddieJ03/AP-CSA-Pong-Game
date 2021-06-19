import javax.swing.JFrame;
import java.awt.Component;
import java.util.Scanner;

public class TheGame extends JFrame
{
  private static final int WIDTH = 800;
  private static final int HEIGHT = 600;

  public TheGame(String chooseBall, String width, String height)
  {
    super("PONG");
    setSize(Integer.parseInt(width), Integer.parseInt(height));

    Pong game = new Pong(Integer.parseInt(chooseBall), Integer.parseInt(width), Integer.parseInt(height));

    ((Component)game).setFocusable(true);
    getContentPane().add(game);

    setVisible(true);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main( String args[] )
  {
    Scanner s = new Scanner(System.in);
    System.out.println("Welcome to Pong!");
    System.out.print("Choose a ball: 0-regular, 1-blinky, 2-speedup: ");

    String chooseBall = s.nextLine();

    System.out.print("Enter Width: ");

    String width = s.nextLine();

    System.out.print("Enter Height: ");

    String height = s.nextLine();

    System.out.println("Starting the game . . .");

    TheGame run = new TheGame(chooseBall, width, height);
  }
}