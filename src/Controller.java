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
        
        main();
    }
    
    public final void main() {
        while (handler.getDay() < 280 && handler.getRage() < 100) {
            handler.nextDay();
            handler.setWeekday(handler.nextWeekday());
        }
        
        if (handler.getRage() == 100) 
            event.gameOver();
        
        else if (handler.getDay() == 280 && handler.getRage() < 100) {
            System.out.println("You are sitting at the dinner table with your wife. She looks at you nervously and says, \"Honey, we need to talk...\" \nGAME OVER. PLAY AGAIN? Y/N");
            input = scan.next();
        
            switch (input) {
                case "Y":
                case "y":
                    start();
                    break;
                case "N":
                case "n":
                    System.exit(0);
                    break;
            }
        }
    }
}
