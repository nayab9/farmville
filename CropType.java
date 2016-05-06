public class CropType {
    private boolean isPlanted;
    private String name;
    public CropType(String type) {
        this.name = type;
        isPlanted = false;
    }
    
    public boolean isPlanted() {
        return isPlanted;
    }
    
    public void plant() {
        isPlanted = true;
    }
    
    public String name() {
        return name;
    }
}