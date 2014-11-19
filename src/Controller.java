import java.io.*;
import java.util.Scanner;
/**
 *
 * @author lingenedil
 */
public class Controller {
    
    Scanner scan = new Scanner(System.in);
    String input = "";
    
    public Controller() {
        
    }
    
    public final void intro() {
        System.out.print("Welcome to PregnancyQuest! \n You are a young, nameless husband living with your wife. She has recently, unbeknownst to you, become pregnant with your first child. \n For 280 days, it is your job to keep her happy. If you fail to keep her sufficiently happy, it's game over for you. \n At any time, you can type !h for help or !q to quit the game. Good luck! \n");
        System.out.println("BEGIN GAME? Y/N \n");
        
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
    public final void start() {
        System.out.println("You are a young husband, sitting at the dinner table with your wife. She looks at you nervously and says, \n \"Honey, we need to talk...\" \n");
        System.out.println("!1: \"Yes, dear?\" !2 \"What is it?\" !3 \"Not right now.\"");
        input = scan.next();
        switch (input) {
            case "!1":
                System.out.println("She reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
                break;
            case "!2":
                System.out.println("She gives you a sour look before saying, \n \"There's something important I have to tell you...\" \n She reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
                
                break;
            case "!3":
                System.out.println("She gives you a look crossed with displeasure and a nervous sadness. \n \"Never mind,\" she says, before leaving in a huff. \n \n GAME OVER. PLAY AGAIN? Y/N");
                input = scan.next();
                switch (input) {
                    case "y":
                    case "Y":
                        start();
                        break;
                    case "n":
                    case "N":
                        System.exit(0);
                }
        }
    }
}
