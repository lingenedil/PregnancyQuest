import java.util.Random;

/**
 *
 * @author lingenedil
 */
public class Handler {
    
    Random random = new Random();
    Event event = new Event();
    private int rageLevel;
    private String time = "";
    private int wallet;
    private int day = 1;
    private String weekday = "";
    private int weekdayInt;
    private int randomEvent;
    
    public Handler() {  
    }
    
    public int setRage(int rage) {
        rageLevel = rage;
        
        return rageLevel;
    }
    
    public int addRage(int toAdd) {
        rageLevel += toAdd;
        
        return rageLevel;
    }
    
    public int subtractRage(int toSubtract) {
        rageLevel -= toSubtract;
        
        return rageLevel;
        
    }
    public void randomAddRage() {
        int toAdd = random.nextInt(66);
        
        addRage(toAdd);
    }
    
    public void lowInsult() {
        int toAdd = random.nextInt(26);
        
        addRage(toAdd);
    }
    
    public void mediumInsult() {
        int toAdd = random.nextInt(51);
        
        addRage(toAdd);
    }
    
    public void highInsult() {
        int toAdd = random.nextInt(76);
        
        addRage(toAdd);
    }
    
    public void randomSubtractRage() {
        int toSubtract = random.nextInt(66);
        
        subtractRage(toSubtract);
    }
    
    public void lowCompliment() {
        int toSubtract = random.nextInt(26);
        
        subtractRage(toSubtract);
    }
    
    public void mediumCompliment() {
        int toSubtract = random.nextInt(51);
        
        subtractRage(toSubtract);
    }
    
    public void highCompliment() {
        int toSubtract = random.nextInt(76);
        
        subtractRage(toSubtract);
    }
    
    public int getRage() {
        return rageLevel;
    }
    
    public void help() {
        System.out.println("!q: Quit the game. \n!h: List commands. \n!t: Check your watch for the time and date. \n!w: Look in your wallet. \n!1-3: Perform an action.");
    }
    
    public String setTime(String newTime) {
        time = newTime;
        
        return time;
    }
    
    public String getTime() {
        return time;
    }
    
    public int setWallet(int newWallet) {
        wallet = newWallet;
        
        return wallet;
    }
    
    public int addCash(int toAdd) {
        wallet += toAdd;
        
        return wallet;
    }
    
    public int subtractCash(int toSubtract) {
        wallet -= toSubtract;
        
        return wallet;
    }
    
    public int getCash() {
        return wallet;
    }
    
    public int randomWeekday() {
        weekdayInt = random.nextInt(7);
        
        return weekdayInt;
    }
    
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
    
    public int nextWeekday() {
        if (weekdayInt < 6)
            weekdayInt++;
        else
            weekdayInt = 0;
        
        return weekdayInt;
    }
    
    public String getWeekday() {
        return weekday;
    }
    
    public int setDay(int newDay) {
        day = newDay;
        
        return day;
    }
    
    public int nextDay() {
        return day++;
    }
    
    public int getDay() {
        return day;
    }
    
    public void reset() {
        setRage(0);
        setTime("");
        setWallet(0);
        setDay(1);
        setWeekday(randomWeekday());
    }
    
    public int randomEventGenerator() {
        randomEvent = random.nextInt(event.getNumberOfEvents());
        
        return randomEvent;
    }
}
