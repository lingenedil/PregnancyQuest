import java.util.Random;

/**
 *
 * @author lingenedil
 */
public class Handler {
    
    protected int rageLevel;
    Random random = new Random();
    
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
    
    public void randomSubtractRage() {
        int toSubtract = random.nextInt(66);
        
        subtractRage(toSubtract);
    }
    
    
}
