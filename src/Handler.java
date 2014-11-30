import java.util.Random;
/**
 * @author Lauren Moore
 * @version 1.0
 * Project 5
 * Handler class for Project 5.
 */
public class Handler {
    
    Random random = new Random();

    //Variable for the current level of the rage meter.
    private int rageLevel;
    //Variable to contain the current time as a String.
    private String time = "";
    //Variable to contain the amount of cash in the wallet.
    private int wallet;
    //Variable to keep track of the current day.
    private int day = 1;
    //Variable to keep track of the day of the week as a String.
    private String weekday = "";
    //Variable to represent the day of the week as an integer.
    private int weekdayInt;
    //Variable to denote the time taken to perform a task in minutes.
    private int timeTaken;
    //Variable to denote whether the item-getting event was successful.
    private boolean gotItem;
    //Variable to contain the weekly paycheck.
    private int payCheck;
    
    /**
     * Constructor method for the Handler class.
     */
    public Handler() {  
    }
    
    /**
     * Method to set the rage level to a predefined value.
     * @param rage Integer to set the rage level to.
     * @return Returns the rage level.
     */
    public int setRage(int rage) {
        rageLevel = rage;
        
        return rageLevel;
    }
    
    /**
     * Method to add to the rage level.
     * @param toAdd Integer to be added to the rage level.
     * @return Returns the rage level.
     */
    public int addRage(int toAdd) {
        rageLevel += toAdd;
        
        return rageLevel;
    }
    
    /**
     * Method to subtract from the rage level.
     * @param toSubtract Integer to be subtracted from the rage level.
     * @return Returns the rage level.
     */
    public int subtractRage(int toSubtract) {
        rageLevel -= toSubtract;
        
        return rageLevel;
        
    }
    
    /**
     * Randomly adds a value between 0-65 to the rage level via addRage().
     */
    public void randomAddRage() {
        int toAdd = random.nextInt(66);
        
        addRage(toAdd);
    }
    
    /**
     * Method to handle a minor insult to your wife - adds a random value between 0-25 to the rage level via addRage().
     */
    public void lowInsult() {
        int toAdd = random.nextInt(26);
        
        addRage(toAdd);
    }
    
    /**
     * Method to handle a moderate insult to your wife - adds a random value between 0-50 to the rage level via addRage().
     */
    public void mediumInsult() {
        int toAdd = random.nextInt(51);
        
        addRage(toAdd);
    }
    
    /**
     * Method to handle a severe insult to your wife - adds a random value between 0-75 to the rage level via addRage().
     */
    public void highInsult() {
        int toAdd = random.nextInt(76);
        
        addRage(toAdd);
    }
    
    /**
     * Randomly subtracts a value between 0-65 from the rage level via subtractRage().
     */
    public void randomSubtractRage() {
        int toSubtract = random.nextInt(66);
        
        subtractRage(toSubtract);
    }
    
    /**
     * Method to handle a small compliment to your wife - subtracts a random value between 0-25 from the rage level via subtractRage().
     */
    public void lowCompliment() {
        int toSubtract = random.nextInt(26);
        
        subtractRage(toSubtract);
    }
    
    /**
     * Method to handle a medium compliment to your wife - subtracts a random value between 0-50 from the rage level via subtractRage().
     */
    public void mediumCompliment() {
        int toSubtract = random.nextInt(51);
        
        subtractRage(toSubtract);
    }
    
    /**
     * Method to handle a large compliment to your wife - subtracts a random value between 0-75 from the rage level via subtractRage().
     */
    public void highCompliment() {
        int toSubtract = random.nextInt(76);
        
        subtractRage(toSubtract);
    }
    
    /**
     * Gets the current rage level.
     * @return Returns the rage level.
     */
    public int getRage() {
        return rageLevel;
    }
    
    /**
     * Method to print out help dialogue.
     */
    public void help() {
        System.out.println("q: Quit the game. \nh: List commands. \nw: Look in your wallet. \n1-3: Perform an action.");
    }
    
    /**
     * Sets the time to a predefined value.
     * @param newTime String to set time to, preferred in "0:00 PM" format.
     * @return Returns the time variable.
     */
    public String setTime(String newTime) {
        time = newTime;
        
        return time;
    }
    
    /**
     * Gets the current time.
     * @return Returns the time variable.
     */
    public String getTime() {
        return time;
    }
    
    /**
     * Method to set the contents of the wallet to a predefined value.
     * @param newWallet Integer to set the wallet variable to.
     * @return Returns the wallet.
     */
    public int setWallet(int newWallet) {
        wallet = newWallet;
        
        return wallet;
    }
    
    /**
     * Method to add cash to the wallet.
     * @param toAdd Amount to add to the wallet.
     * @return Returns the wallet.
     */
    public int addCash(int toAdd) {
        wallet += toAdd;
        
        return wallet;
    }
    
    /**
     * Method to subtract cash from the wallet.
     * @param toSubtract Amount to subtract from the wallet.
     * @return Returns the wallet.
     */
    public int subtractCash(int toSubtract) {
        if (wallet >= toSubtract)
            wallet -= toSubtract;
        
        else
            System.out.println("You don't have enough money for that.");
        
        return wallet;
    }
    
    public int buyItem(int toSubtract) {
        if (wallet >= toSubtract) {
            wallet -= toSubtract;
            didGetItem();
        }
        
        else {
            System.out.println("You don't have enough money for that.");
            didNotGetItem();
        }
        
        return wallet;
    }
    
    /**
     * Method to return the amount of cash in the wallet.
     * @return Returns the wallet.
     */
    public int getCash() {
        return wallet;
    }
    
    /**
     * Method to randomly select a weekday as represented by an integer.
     * @return Returns the weekday integer.
     */
    public int randomWeekday() {
        weekdayInt = random.nextInt(7);
        
        return weekdayInt;
    }
    
    /**
     * Method to set the weekday's String representation via a switch method.
     * @param variable The integer representation of the weekday, usually picked either by randomWeekday() or nextWeekday().
     * @return Returns the String representation of the weekday.
     */
    public String setWeekday(int variable) {

        switch (variable) {
            case 0:
                weekday = "Monday";
                break;
            case 1:
                weekday = "Tuesday";
                break;
            case 2:
                weekday = "Wednesday";
                break;
            case 3:
                weekday = "Thursday";
                break;
            case 4:
                weekday = "Friday";
                break;
            case 5:
                weekday = "Saturday";
                break;
            case 6:
                weekday = "Sunday";
                break;
        }
        
        return weekday;
    }
    
    /**
     * Method to move forward one weekday via integer representation.
     * @return Returns the integer representation of the weekday.
     */
    public int nextWeekday() {
        //Checks to see if the weekday integer has reached 6 (Sunday).
        if (weekdayInt < 6)
            //Moves forward one day (integer) if not a Sunday.
            weekdayInt++;
        //Sets weekday back to 0 (Monday) if the weekday integer is 6 (Sunday).
        else
            weekdayInt = 0;
        
        return weekdayInt;
    }
    
    /**
     * Method to return the String representation of the weekday.
     * @return Returns the String representation of the weekday.
     */
    public String getWeekday() {
        return weekday;
    }
    
    /**
     * Sets the day counter to a predefined value.
     * @param newDay The value to set the day counter to.
     * @return Returns the day counter integer.
     */
    public int setDay(int newDay) {
        day = newDay;
        
        return day;
    }
    
    /**
     * Method to move forward one day.
     * @return Returns the day counter, moved forward.
     */
    public int nextDay() {
        return day++;
    }
    
    /**
     * Method to return the day.
     * @return Returns the day counter.
     */
    public int getDay() {
        return day;
    }
    
    /**
     * Method to set the time taken to complete a task in minutes.
     * @param minutesTaken The number of minutes to set the time taken to.
     * @return Returns the time taken.
     */
    public int setTimeTaken(int minutesTaken) {
        timeTaken = minutesTaken;
        
        return timeTaken;
    }
    
    /**
     * Method to randomly add up to an hour to the time taken.
     * @return Returns the time taken.
     */
    public int randomHourTaken() {
        timeTaken = random.nextInt(61);
        
        return timeTaken;
    }
    
    /**
     * Method to return the time taken.
     * @return Returns the time taken.
     */
    public int getTimeTaken() {
        return timeTaken;
    }
    
    /**
     * Method to set a flag indicating that the item was retrieved.
     * @return Returns a boolean indicating the item was retrieved.
     */
    public boolean didGetItem() {
        gotItem = true;
        
        return gotItem;
    }
    
    /**
     * Method to set a flag indicating that the item was not retrieved.
     * @return Returns a boolean indicating the item was not retrieved.
     */
    public boolean didNotGetItem() {
        gotItem = false;
        
        return gotItem;
    }
    
    /**
     * Method to return a flag indicating whether or not the item was retrieved.
     * @return Method to set a flag indicating whether or not the item was retrieved.
     */
    public boolean gotItem() {
        return gotItem;
    }
    
    /**
     * Adds money to weekly paycheck.
     * @param toAdd Amount to add.
     * @return Returns the paycheck.
     */
    public int addToPaycheck(int toAdd) {
        payCheck += toAdd;
        
        return payCheck;
    }
    
    /**
     * Removes money from weekly paycheck.
     * @param toSubtract Amount to remove.
     * @return Returns the paycheck.
     */
    public int subtractFromPaycheck(int toSubtract) {
        payCheck -= toSubtract;
        
        return payCheck;
    }
    
    /**
     * Gets the paycheck.
     * @return Returns the paycheck.
     */
    public int getPayCheck() {
        return payCheck;
    }
    
    /**
     * Resets the paycheck to the default value.
     * @return Returns the paycheck.
     */
    public int resetPayCheck() {
        payCheck = 1575;
        
        return payCheck;
    }
    
    /**
     * Pays the bills.
     * @return
     */
    public int payBills() {
        if (wallet >= 850)
            subtractCash(850);
        else {
            System.out.println("You can't afford to pay your bills this month.");
            highInsult();
        }
        
        return wallet;
    }
    
    /**
     * Subtracts money from paycheck if time at work is missed.
     * @param hoursToMiss
     */
    public void missedWork(int hoursToMiss) {
        int lostTime = hoursToMiss * 9;
        
        subtractFromPaycheck(lostTime);
    }
    
    /**
     * Method to reset all variables at new game start.
     */
    public void reset() {
        setRage(0);
        setTime("");
        setWallet(0);
        setDay(1);
        setWeekday(randomWeekday());
        resetPayCheck();
    }
}
