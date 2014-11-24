import java.util.Scanner;
/**
 *
 * @author lingenedil
 */
public class Event {
    
    Scanner scan = new Scanner(System.in);
    Handler handler = new Handler();
    String input = "";
    private final int numberOfEvents = 3;
    
    public Event() {
    }
    
    public int getNumberOfEvents() {
        return numberOfEvents;
    }
    
    public final void intro() {
        handler.reset();
        System.out.print("Welcome to PregnancyQuest! \nYou are a young, nameless husband living with your wife. She has recently, unbeknownst to you, become pregnant with your first child. \nFor 280 days, it is your job to keep her happy. If you fail to keep her sufficiently happy, it's game over for you. \nAt any time, you can type !h for help or !q to quit the game. Good luck!\n");
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
        System.out.println("DAY " + handler.getDay() + ": " + "You are sitting at the dinner table with your wife. She looks at you nervously and says, \"Honey, we need to talk...\"");
        System.out.println("!1: \"Yes, dear?\" !2 \"What is it?\" !3 \"Not right now.\"");
        input = scan.next();
        
        while (!input.equals("!q")){
            
        switch (input) {
            case "!1":
                startGetBox();
                break;
            case "!2":
                startGetBox2();
                break;
            case "!3":
                System.out.println("She gives you a look crossed with displeasure and disappointment. \"Never mind,\" she says, before leaving in a huff.");
                gameOver();
            case "!h":
                handler.help();
                break;
            case "!t":
                System.out.println("You look at your watch. It is currently " + handler.getTime() +  " on " + handler.getWeekday() + ".");
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
    
    public void startGetBox() {
        handler.lowCompliment();
        System.out.println("She reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
        System.out.println("!1: Open the box. !2: \"What's this?\" !3: \"I don't have time for this.\"");
        input = scan.next();
        
        while (!input.equals("!q")){
            
        switch (input) {
            case "!1":
                startOpenBox();
                break;
            case "!2":
                break;
            case "!3":
                System.out.println("She gives you a look crossed with displeasure and disappointment. \"Never mind,\" she says, before leaving in a huff, the box unmoved on the table.");
                gameOver();
                break;
            case "!h":
                handler.help();
                break;
            case "!t":
                System.out.println("You look at your watch. It is currently " + handler.getTime() +  " on " + handler.getWeekday() + ".");
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
    
    public void startGetBox2() {
        handler.mediumInsult();
        System.out.println("She gives you a sour look before saying, \"There's something important I have to tell you...\" \nShe reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
        System.out.println("!1: Open the box. !2: \"What's this?\" !3: \"I don't have time for this.\"");
        input = scan.next();
        
        while (!input.equals("!q")){
            
        switch (input) {
            case "!1":
                startOpenBox();
                break;
            case "!2":
                break;
            case "!3":
                System.out.println("She gives you a look crossed with displeasure and disappointment. \"Never mind,\" she says, before leaving in a huff, the box unmoved on the table.");
                gameOver();
                break;
            case "!h":
                handler.help();
                break;
            case "!t":
                System.out.println("You look at your watch. It is currently " + handler.getTime() +  " on " + handler.getWeekday() + ".");
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
    
    public void startOpenBox() {
        System.out.println("You reach for the box and open it. Inside is a pair of very small shoes - the right size for a newborn. You glance up at your wife. She is looking at you with nervous excitement.");
        System.out.println("!1: Say nothing. !2: \"Are you...?\" !3: \"What is this?\"");
        input = scan.next();
        
        while (!input.equals("!q")){
            
        switch (input) {
            case "!1":
                break;
            case "!2":
                startYes();
                break;
            case "!3":
                startShoes();
                break;
            case "!h":
                handler.help();
                break;
            case "!t":
                System.out.println("You look at your watch. It is currently " + handler.getTime() +  " on " + handler.getWeekday() + ".");
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
    
    public void startYes() {
        System.out.println("She glances down and fidgets. \"Yes... I was afraid to tell you...\"");
        System.out.println("!1: Say nothing. !2: \"This is wonderful news!\" !3: \"I don't think we're ready for this...\"");
        input = scan.next();
        
        while (!input.equals("!q")){
            
        switch (input) {
            case "!1":
                break;
            case "!2":
                handler.highCompliment();
                System.out.println("She gazes at you with relief and joy. \n\"We have so much to do! We'll get started tomorrow.\" She motions for you to come to bed, a smile on her lips.");
                break;
            case "!3":
                System.out.println("She briefly glances back up at you with a heartbroken look. \"I... I'll be right back...\" she mutters before rushing out of the room.");
                gameOver();
                break;
            case "!h":
                handler.help();
                break;
            case "!t":
                System.out.println("You look at your watch. It is currently " + handler.getTime() +  " on " + handler.getWeekday() + ".");
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
    
    public void startShoes() {
        System.out.println("She looks at you nervously. \"Shoes... For a baby...\" she trails off, her voice weak and nervous.");
        System.out.println("!1: Say nothing. !2: \"Are you...?\" !3: \"Why are you giving me baby shoes?\"");
        input = scan.next();
        
        while (!input.equals("!q")){
            
        switch (input) {
            case "!1":
                break;
            case "!2":
                startYes();
                break;
            case "!3":
                break;
            case "!h":
                handler.help();
                break;
            case "!t":
                System.out.println("You look at your watch. It is currently " + handler.getTime() +  " on " + handler.getWeekday() + ".");
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
    
    public void gameOver() {
        System.out.println("GAME OVER. PLAY AGAIN? Y/N");
        
        input = scan.next();
        
            switch (input) {
                case "y":
                case "Y":
                    intro();
                    break;
                case "n":
                case "N":
                    System.exit(0);
            }
    }
}
