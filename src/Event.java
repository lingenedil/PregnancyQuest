import java.util.Scanner;
import java.util.Random;
/**
 * @author Lauren Moore
 * @version 1.0
 * Project 5
 * Event class for Project 5 - handles all of the events for the game.
 */
public class Event {
    
    Scanner scan = new Scanner(System.in);
    Handler handler = new Handler();
    Random random = new Random();
    String input = "";
    
    /**
     * Constructor for the Event class.
     */
    public Event() {
    }
    
    /**
     * Method to control the bulk of the game.
     */
    public final void mainGame() {
        
        //Checks what day it is and whether or not the rage meter has hit 100.
        while (handler.getDay() < 280) {
            
            //Increases the day, sets the next weekday, and prints the date.
            handler.nextDay();
            handler.setWeekday(handler.nextWeekday());
            System.out.println(handler.getWeekday() + ", DAY " + handler.getDay() + ":");
            
            //Pay bills once a month.
            if ((handler.getDay() % 30) == 0)
                handler.payBills();
            
            //Sends player to sleep on couch if the rage meter is >= 90.
            if (handler.getRage() >= 90 && handler.getRage() < 100)
                sleepOnCouch();
            
            else if (handler.getRage() >= 100) 
                sleepInCar();
            
            switch (handler.getWeekday()) {
                case "Sunday":
                case "Saturday":
                    //Calls a weekend event if an RNG is > 25, otherwise player gets a break.
                    if (random.nextInt(100) > 25) {
                        randomWeekendEvent();
                        
                        //Adds to rage meter if a randomly generated number is < 5.
                        if (random.nextInt(100) < 5) {
                        handler.mediumInsult();
                    
                        //Adds to rage meter again if a randomly generated number equals 74.
                        if (random.nextInt(75) == 74)
                            handler.highInsult();
                        }
                        
                        //Calls a night event if an RNG is > 15.
                        else if (random.nextInt(100) > 15)
                            randomNightEvent();
                    }
                    else {
                        if (random.nextInt(100) > 25)
                            randomNightEvent();
                        else
                            playerBreak();
                    }
                    break;
                case "Thursday":
                    handler.addCash(handler.getPayCheck());
                    handler.resetPayCheck();
                    //Calls a work event if an RNG is > 25, otherwise player gets a break.
                    if (random.nextInt(100) > 25) {
                        randomWorkEvent();
                        
                        //Adds to rage meter if a randomly generated number is < 5.
                        if (random.nextInt(100) < 5) {
                        handler.mediumInsult();
                    
                        //Adds to rage meter again if a randomly generated number equals 74.
                        if (random.nextInt(75) == 74)
                            handler.highInsult();
                        }
                        
                        //Calls a night event if an RNG is > 15.
                        else if (random.nextInt(100) > 15)
                            randomNightEvent();
                    }
                    else {
                        if (random.nextInt(100) > 25)
                            randomNightEvent();
                        else
                            playerBreak();
                    }
                    break;
                default:
                    //Calls a work event if an RNG is > 25, otherwise player gets a break.
                    if (random.nextInt(100) > 25) {
                        randomWorkEvent();
                        
                        //Adds to rage meter if a randomly generated number is < 5.
                        if (random.nextInt(100) < 5) {
                        handler.mediumInsult();
                    
                        //Adds to rage meter again if a randomly generated number equals 74.
                        if (random.nextInt(75) == 74)
                            handler.highInsult();
                        }
                        
                        //Calls a night event if an RNG is > 15.
                        else if (random.nextInt(100) > 15)
                            randomNightEvent();
                    }
                    else {
                        if (random.nextInt(100) > 25)
                            randomNightEvent();
                        else
                            playerBreak();
                    }
                    break;
            }          
        }

            //If the player has made it to 280 days without the rage meter hitting 100, cycles to a new game.
            if (handler.getDay() == 280 && handler.getRage() < 100) {
                wonGame();
            }
    }
    
    /**
     * Intro method that resets all variables (in case the game is lost and restarted), plays welcome dialogue, and asks user to begin a new game.
     */
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
    
    /**
     * Start method - the very beginning of the actual game. Adds cash to wallet, randomly sets how upset your wife is, and sets the time to 7:00 PM.
     */
    public final void start() {
        handler.addCash(5650);
        handler.randomAddRage();
        handler.setTime("7:00 PM");
        System.out.println("DAY " + handler.getDay() + ": " + "\nYou are sitting at the dinner table with your wife. She looks at you nervously and says, \"Honey, we need to talk...\"");
        System.out.println("1: \"Yes, dear?\" 2: \"What is it?\" 3: \"Not right now.\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startGetBox();
                break;
            case "2":
                startGetBox2();
                break;
            case "3":
                System.out.println("She gives you a look crossed with displeasure and disappointment. \"Never mind,\" she says, before leaving in a huff.");
                gameOver();
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to handle the event in which your wife hands you a box containing baby shoes.
     */
    public void startGetBox() {
        handler.lowCompliment();
        System.out.println("She reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
        System.out.println("1: Open the box. 2: \"What's this?\" 3: \"I don't have time for this.\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startOpenBox();
                break;
            case "2":
                startAskBox();
                break;
            case "3":
                System.out.println("She gives you a look crossed with displeasure and disappointment. \"Never mind,\" she says, before leaving in a huff, the box unmoved on the table.");
                gameOver();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * An alternate method to handle the event in which your wife hands you a box containing baby shoes - this method makes your wife slightly upset with you.
     */
    public void startGetBox2() {
        handler.mediumInsult();
        System.out.println("She gives you a sour look before saying, \"There's something important I have to tell you...\" \nShe reaches under her chair and pulls out a small wrapped box. She places it on the table and nudges it towards you.");
        System.out.println("1: Open the box. 2: \"What's this?\" 3: \"I don't have time for this.\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startOpenBox();
                break;
            case "2":
                startAskBox();
                break;
            case "3":
                System.out.println("She gives you a look crossed with displeasure and disappointment. \"Never mind,\" she says, before leaving in a huff, the box unmoved on the table.");
                gameOver();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to handle asking your wife what is in the box.
     */
    public void startAskBox() {
        handler.lowInsult();
        System.out.println("She looks at you nervously. \"Open it and you'll find out,\" she says, her voice shaking with anticipation.");
        System.out.println("1: Open the box. 2: \"What's this?\" 3: \"I don't have time for this.\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startOpenBox();
                break;
            case "2":
                startAskBox2();
                break;
            case "3":
                System.out.println("She gives you a look crossed with displeasure and disappointment. \"Never mind,\" she says, before leaving in a huff, the box unmoved on the table.");
                gameOver();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to repeatedly ask your wife what is in the box.
     */
    public void startAskBox2() {
        handler.highInsult();
        System.out.println("Frustration begins to increasingly cross her features. \"Open it and you'll find out,\" she says, her voice growing more and more upset.");
        System.out.println("1: Open the box. 2: \"What's this?\" 3: \"I don't have time for this.\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startOpenBox();
                break;
            case "2":
                startAskedTooMuch();
                break;
            case "3":
                System.out.println("She gives you a look crossed with displeasure and disappointment. \"Never mind,\" she says, before leaving in a huff, the box unmoved on the table.");
                gameOver();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method that determines whether or not your wife has gotten too upset from repeated asking; if she is too upset, opens new dialogue boxes.
     * If not, allows user to ask until wife is either too upset or a new option is chosen.
     */
    public void startAskedTooMuch() {
        
        if (handler.getRage() >= 90) {
            System.out.println("\"I can't deal with this right now. Open the box or don't. I don't care anymore,\" she says with anger before leaving the room.");
            System.out.println("1: Open the box. 2: Leave the room.");
            input = scan.next();
            
            while (!input.equals("!q")){
            
                switch (input) {
                    case "1":
                        startOpenBox2();
                        break;
                    case "2":
                        System.out.println("You leave the room and the house, leaving your wife to her anger.");
                        gameOver();
                        break;
                    case "h":
                        handler.help();
                        break;
                    case "w":
                        System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                        break;
                    default:
                        System.out.println("Invalid argument.");
                        break;
                }
        
            input = scan.next();
        
            }
        }
        
        else
            startAskBox2();
    }
    
    /**
     * Method to handle opening the box.
     */
    public void startOpenBox() {
        System.out.println("You reach for the box and open it. Inside is a pair of very small shoes - the right size for a newborn. You glance up at your wife. She is looking at you with nervous excitement.");
        System.out.println("1: Say nothing. 2: \"Are you...?\" 3: \"What is this?\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startSaidNothingBox();
                break;
            case "2":
                startYes();
                break;
            case "3":
                startShoes();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * An alternate method to open the box; this method slightly reduces your wife's rage.
     */
    public void startOpenBox2() {
        handler.lowCompliment();
        System.out.println("You reach for the box and open it. Inside is a pair of very small shoes - the right size for a newborn. You glance up as your wife walks back into the room, summoned by the noise of the wrapping paper. She looks at you nervously, her anger replaced by anticipation.");
        System.out.println("1: Say nothing. 2: \"Are you...?\" 3: \"What is this?\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startSaidNothingBox();
                break;
            case "2":
                startYes();
                break;
            case "3":
                startShoes();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to handle your wife affirming she's pregnant.
     */
    public void startYes() {
        System.out.println("She glances down and fidgets. \"Yes... I was afraid to tell you...\"");
        System.out.println("1: Say nothing. 2: \"This is wonderful news!\" 3: \"I don't think we're ready for this...\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startSaidNothingYes();
                break;
            case "2":
                handler.highCompliment();
                System.out.println("She gazes at you with relief and joy. \n\"We have so much to do! We'll get started tomorrow.\" She motions for you to come to bed, a smile on her lips.");
                mainGame();
                break;
            case "3":
                System.out.println("She briefly glances back up at you with a heartbroken look. \"I... I'll be right back...\" she mutters before rushing out of the room.");
                gameOver();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to handle your wife telling you what the shoes are.
     */
    public void startShoes() {
        System.out.println("She looks at you nervously. \"Shoes... For a baby...\" she trails off, her voice weak and nervous.");
        System.out.println("1: Say nothing. 2: \"Are you...?\" 3: \"Why are you giving me baby shoes?\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startSaidNothingShoes();
                break;
            case "2":
                startYes();
                break;
            case "3":
                startAskedShoes();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to handle asking your wife why she's giving you baby shoes.
     */
    public void startAskedShoes() {
        System.out.println("Her voice shakes and cracks as she speaks. \"Honey... I'm.. We're having a baby.\"");
        System.out.println("1: Say nothing. 2: \"This is wonderful news!\" 3: \"I don't think we're ready for this...\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                startSaidNothingYes();
                break;
            case "2":
                handler.highCompliment();
                System.out.println("She gazes at you with relief and joy. \"We have so much to do! We'll get started tomorrow.\" She motions for you to come to bed, a smile on her lips.");
                mainGame();
                break;
            case "3":
                System.out.println("She briefly glances back up at you with a heartbroken look. \"I... I'll be right back...\" she mutters before rushing out of the room.");
                gameOver();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to handle saying nothing after opening the box.
     */
    public void startSaidNothingBox() {
        handler.mediumInsult();
        System.out.println("Frustration crosses your wife's face. \"Aren't you going to say anything?\"");
        System.out.println("1: Say nothing. 2: \"Are you...?\" 3: \"What is this?\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                if (handler.getRage() == 100) {
                    System.out.println("Your wife silently leaves the room, her face marked with anger.");
                    gameOver();
                }
                else
                    startSaidNothingBox();
                break;
            case "2":
                startYes();
                break;
            case "3":
                startShoes();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to handle saying nothing after your wife affirms she's pregnant.
     */
    public void startSaidNothingYes() {
        handler.mediumInsult();
        System.out.println("Frustration crosses your wife's face. \"Aren't you going to say anything?\"");
        System.out.println("1: Say nothing. 2: \"This is wonderful news!\" 3: \"I don't think we're ready for this...\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                if (handler.getRage() == 100) {
                    System.out.println("Your wife looks at you with a heartbroken yet angry look and silently leaves the room.");
                    gameOver();
                }
                else
                    startSaidNothingYes();
                break;
            case "2":
                handler.highCompliment();
                System.out.println("She gazes at you with relief and joy. \n\"We have so much to do! We'll get started tomorrow.\" She motions for you to come to bed, a smile on her lips.");
                mainGame();
                break;
            case "3":
                System.out.println("She briefly glances back up at you with a heartbroken look. \"I... I'll be right back...\" she mutters before rushing out of the room.");
                gameOver();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to handle saying nothing after your wife says that the contents of the box are shoes.
     */
    public void startSaidNothingShoes() {
        handler.mediumInsult();
        System.out.println("Frustration crosses your wife's face. \"Aren't you going to say anything?\"");
        System.out.println("1: Say nothing. 2: \"Are you...?\" 3: \"Why are you giving me baby shoes?\"");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                if (handler.getRage() == 100) {
                    System.out.println("Your wife looks at you with a heartbroken yet angry look and silently leaves the room.");
                    gameOver();
                }
                else
                    startSaidNothingShoes();
                break;
            case "2":
                startYes();
                break;
            case "3":
                startAskedShoes();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Method to handle a night event in which your wife asks you to pick up pickles from the store.
     */
    public void pickleJuiceNightEvent() {
        handler.setTime("2:00 AM");
        System.out.println("Your wife nudges you awake. \"Honey... We're out of pickles.\"");
        System.out.println("1: \"What time is it?\" 2: Get dressed and head to the store. 3: Ignore your wife and go back to sleep.");
        input = scan.next();
        
        while (!input.equals("q")){
           
        switch (input) {
            case "1":
                pickleJuice2AM();
                break;
            case "2":
                pickleJuiceGoToStore();
                break;
            case "3":
                handler.highInsult();
                System.out.println("You ignore your wife and quickly fall back asleep. You might regret this...");
                mainGame();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Sub-method for the pickle juice event method. Handles asking your wife what time it is.
     */
    public void pickleJuice2AM() {
        System.out.println("She looks at you pleadingly. \"It's 2:00 AM...\"");
        System.out.println("1: \"What do you want me to do? It's too late to go out and get pickles.\" 2: Get dressed and head to the store. 3: Ignore your wife and go back to sleep.");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                handler.highInsult();
                System.out.println("Your wife looks at you with disdain. \"Fine,\" she says, \"I'll just wait until the morning.\"\nMaybe you should have gone to get her pickles...");
                mainGame();
                break;
            case "2":
                pickleJuiceGoToStore();
                break;
            case "3":
                handler.highInsult();
                System.out.println("You ignore your wife and quickly fall back asleep. You might regret this...");
                mainGame();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
    }
    
    /**
     * Sub-method for the pickle juice event method. Handles going to the store to pick up pickle juice.
     */
    public void pickleJuiceGoToStore() {
        System.out.println("You head out to the store.");
        
        //Calls the event to have your car break down if an RNG is > 95.
        if (random.nextInt(100) > 95) {
            carBrokeDown();
            
            //Calls the event to have the store be sold out of an item if an RNG is > 98.
            if (random.nextInt(100) > 98) {
                soldOut();
                    if (soldOut() == true)
                        pickleJuiceGoToStore();
            }
        
        }
        
        else {
        System.out.println("You pick up your wife's pickles and head to the checkout line.");
        handler.buyItem(5);
        
        //Calls the event to trigger a long line if an RNG is > 95.
        if (random.nextInt(100) > 95)
            longLine();
        
        //Sets the time taken to 15 minutes if no long line.
        else {
            handler.setTimeTaken(15);
            handler.setTime("2:15 AM");
        }
        
        //If unable to get the item, goes home empty-handed.
        if (!handler.gotItem()) {
            System.out.println("Unable to acquire the item, you leave the store, preparing for the wrath of your wife.");
            cameHomeEmptyHanded();
        }

        //Otherwise, goes home successfully.
        else {
            System.out.println("Pickles in hand, you head home to your wife.");
            pickleJuiceGotItem();
        }
        }
    }
    
    /**
     * Sub-method for the pickle juice event method. Handles the successful retrieval of the pickles.
     */
    public void pickleJuiceGotItem() {
        if (handler.getTimeTaken() > 35) {
            handler.mediumInsult();
            System.out.println("You come home to find your wife awaiting your arrival. With a sour look on her face, she asks, \"What took you so long?\"");
            System.out.println("1: Hand your wife the pickles and apologize. 2: Hand your wife the pickles and say nothing.");
            input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                handler.lowCompliment();
                System.out.println("You hand your wife the pickles and apologize for taking so long, explaining your reasons. She seems to calm down, albeit slightly.");
                mainGame();
                break;
            case "2":
                handler.highInsult();
                System.out.println("You silently hand your wife the pickles and leave the room, leaving her to her anger... And her pickles.");
                mainGame();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
        }
        
        else {
            handler.highCompliment();
            System.out.println("You come home to find your wife eagerly awaiting your arrival. You hand her the pickles.");
            System.out.println("\"Thank you!\" she exclaims, pleased with the timely delivery of her pickles.");
            mainGame();
        }

    }
    
    /**
     * Generic method to handle coming home without your wife's requested item.
     */
    public void cameHomeEmptyHanded() {
        handler.highInsult();
        System.out.println("You return home empty-handed, your task failed. Your wife glares at you, her face full of anger rather than disappointment.");
        System.out.println("1: Apologize to your wife. 2: Say nothing.");
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                handler.lowCompliment();
                System.out.println("You apologize to your wife for having failed, and attempt to explain your reasons for having done so. She seems to calm down, albeit slightly.");
                mainGame();
                break;
            case "2":
                handler.highInsult();
                System.out.println("You say nothing to your wife, leaving her to her anger.");
                mainGame();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
      }  
    }
    
    /**
     * Generic method to handle your car breaking down on the way to perform a task for your wife.
     */
    public void carBrokeDown() {
        System.out.println("As you drive to your destination, your car makes a feeble stutter and slows to a halt.");
        System.out.println("With no other option, you call a tow truck... And your wife. Hopefully she'll be understanding.");
        handler.subtractCash(500);
    }
    
    /**
     * Generic method to handle a long line at the store.
     */
    public void longLine() {
        System.out.println("The line at the store is long. Hopefully it will move quickly... And that your wife will forgive you for the delay.");
        handler.randomHourTaken();
    }
    
    /**
     * Generic method to handle the item being sold out at the store.
     * @return Returns a boolean indicated whether or not the user chose to drive to another store or go home empty-handed.
     */
    public boolean soldOut() {
        System.out.println("The store is sold out of the item you're after. Should you check another store... Or return home empty-handed?");
        System.out.println("1: Drive to another store. 2: Return home empty-handed.");
        
        input = scan.next();
        
        while (!input.equals("q")){
            
        switch (input) {
            case "1":
                return true;
            case "2":
                cameHomeEmptyHanded();
                break;
            case "h":
                handler.help();
                break;
            case "w":
                System.out.println("You look in your wallet. You currently have $" + handler.getCash() + ".");
                break;
            default:
                System.out.println("Invalid argument.");
                break;
        }
        
        input = scan.next();
        
      }
        return false;
    }
    
    /**
     * Method to handle being sent to sleep in the car. Called when the rage meter reaches 100.
     * Calls gameOver() to end the game.
     */
    public void sleepInCar() {
        System.out.println("Your wife leers at you with hatred. You're sleeping in your car tonight - there's no avoiding it.");
        
        gameOver();
    }
    
    /**
     * Method to handle being sent to sleep on the couch. Only runs if there are less than 280 days on the timer.
     */
    public void sleepOnCouch() {
        while (handler.getDay() < 280) {
            handler.lowCompliment();
            
            System.out.println("Your wife leers at you with disdain. It would probably be best to sleep on the couch tonight - perhaps in the morning you can make amends for what has upset her this time.");
            
            mainGame();
        }
    }
    
    /**
     * Method to choose and call a random workday event.
     */
    public void randomWorkEvent() {
        int eventNumber = random.nextInt(3);
        
        switch (eventNumber) {
            case 0:
                System.out.println("First Work Event Placeholder");
                break;
            case 1:
                System.out.println("Second Work Event Placeholder");
                break;
            case 2:
                System.out.println("Third Work Event Placeholder");
                break;
        }
    }
    
    /**
     * Method to choose and call a random nighttime event.
     */
    public void randomNightEvent() {
        int eventNumber = random.nextInt(3);
     
        switch (eventNumber) {
            case 0:
                pickleJuiceNightEvent();
                break;
            case 1:
                System.out.println("Second Night Event Placeholder");
                break;
            case 2:
                System.out.println("Third Night Event Placeholder");
                break;
        }
    }
    
    /**
     * Method to choose and call a random weekend event.
     */
    public void randomWeekendEvent() {     
        switch (random.nextInt(3)) {
            case 0:
                System.out.println("First Weekend Event Placeholder");
                break;
            case 1:
                System.out.println("Second Weekend Event Placeholder");
                break;
            case 2:
                System.out.println("Third Weekend Event Placeholder");
                break;
        }
    }
    
    /**
     * Method to handle giving the player a break from events.
     */
    public void playerBreak() {
        System.out.println("Your day goes by surprisingly uneventfully.");
        mainGame();
    }
    
    /**
     * Method to handle winning the game.
     */
    public void wonGame() {
        //Variable to hold the gender of the child for fluff purposes.
        String gender = "";
        
        //Randomly selects the gender of the child because why not?
        switch (random.nextInt(1)) {
            case 0:
                gender = "boy";
                break;
            case 1:
                gender = "girl";
                break;
        }
        
        System.out.println("After a long, eventful pregnancy, your wife gives birth to a healthy baby " + gender + ".");
        System.out.println("ONE MONTH LATER:");
        System.out.println("You are sitting at the dinner table with your wife and child. She looks at you nervously and says, \"Honey, we need to talk...\" \nGAME OVER. PLAY AGAIN? Y/N");
        input = scan.next();
        
        switch (input) {
            case "Y":
            case "y":
                intro();
                break;
            case "N":
            case "n":
                System.exit(0);
                break;
            }
    }
    
    /**
     * Ends game. If the player chooses to start a new game, runs intro() again.
     */
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
