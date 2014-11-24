import java.util.Random;

/**
 *
 * @author lingenedil
 */
public class Handler {
    
    private int rageLevel;
    Random random = new Random();
    private String time = "";
    private int wallet;
    private int day = 1;
    
    public Handler() {  
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
        System.out.println("!q: Quit the game. \n !h: List commands. \n !t: Check your watch. \n !w: Look in your wallet. \n !1-3: Perform an action.");
    }
    
    public String setTime(String newTime) {
        time = newTime;
        
        return time;
    }
    
    public String getTime() {
        return time;
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
    
    public int nextDay() {
        return day++;
    }
    
    public int getDay() {
        return day;
    }
}
