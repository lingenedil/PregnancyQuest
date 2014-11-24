import java.util.Scanner;
/**
 *
 * @author lingenedil
 */
public class Event {
    
    Scanner scan = new Scanner(System.in);
    Handler handler = new Handler();
    String input = "";
    
    public Event() {
    }
    
    public final void intro() {
        System.out.print("Welcome to PregnancyQuest! \n You are a young, nameless husband living with your wife. She has recently, unbeknownst to you, become pregnant with your first child. \n For 280 days, it is your job to keep her happy. If you fail to keep her sufficiently happy, it's game over for you. \n At any time, you can type !h for help or !q to quit the game. Good luck! \n");
        System.out.println("BEGIN GAME? Y/N");
        
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
        handler.addCash(1650);
        handler.randomAddRage();
        handler.setTime("7:00 PM");
        System.out.println("DAY " + handler.getDay() + ": " + "You are sitting at the dinner table with your wife. She looks at you nervously and says, \n \"Honey, we need to talk...\"");
        System.out.println("!1: \"Yes, dear?\" !2 \"What is it?\" !3 \"Not right now.\"");
        input = scan.next();
        
        while (!input.equals("!q")){
            
        switch (input) {
            case "!1":
                System.out.println("She reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
                handler.lowCompliment();
                break;
            case "!2":
                System.out.println("She gives you a sour look before saying, \n \"There's something important I have to tell you...\" \n She reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
                handler.mediumInsult();
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
            case "!h":
                handler.help();
                break;
            case "!t":
                System.out.println("You look at your watch. It is currently " + handler.getTime() + ".");
                break;
            case "!w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    public void start1() {
        input = scan.next();
        
        while (!input.equals("!q")){
            
        switch (input) {
            case "!1":
                System.out.println("She reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
                handler.lowCompliment();
                break;
            case "!2":
                System.out.println("She gives you a sour look before saying, \n \"There's something important I have to tell you...\" \n She reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
                handler.mediumInsult();
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
            case "!h":
                handler.help();
                break;
            case "!t":
                System.out.println("You look at your watch. It is currently " + handler.getTime() + ".");
                break;
            case "!w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
}
