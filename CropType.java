/** 
 * The CropType class allows the creation of a specific
 * type of crop, specified and passed into the constructor
 * 
 * This class has potential!
 * Time permitting, this will be a generic class,
 * and children classes will inherit from this class.
 * For now, we use strings =o
 */

public class CropType {
    
    private boolean isPlanted;
    private boolean isWatered;
    private String name;
    
    public CropType(String type) {
        this.name = type;
        isPlanted = false;
        isWatered = false;
    }
    
    public boolean isPlanted() {
        return isPlanted;
    }
    
    public boolean isWatered() {
        return isWatered;
    }
    
    public void plant() {
        isPlanted = true;
    }
    
    public void water() {
        isWatered = true;
    }
    
    public String name() {
        return name;
    }
}