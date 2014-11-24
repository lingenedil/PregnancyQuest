import java.io.*;
import java.util.Scanner;
/**
 *
 * @author lingenedil
 */
public class Controller {
    
    Scanner scan = new Scanner(System.in);
    Handler handler = new Handler();
    Event event = new Event();
    String input = "";
    
    public Controller() {
    }
    
    public void start() {
        event.intro();
    }
    
    public final void main() {
        while (handler.getDay() <= 280 && handler.getRage() < 100) {
            handler.nextDay();
        }
        
        System.out.println("You are sitting at the dinner table with your wife. She looks at you nervously and says, \n \"Honey, we need to talk...\" \n GAME OVER. PLAY AGAIN? Y/N");
    }
}
