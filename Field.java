public class Field {
    //private bool isPlanted;
    //private String name;
    private final int subfield_size = 2;
    private int field_size = 0;
    
    private CropType[][] fieldLayout;
    
    public Field(int size) {
        this.field_size = size;
        this.fieldLayout = new CropType[field_size][subfield_size];
    }
    
    public void printFieldSize() {
        System.out.println("Field size: " + field_size + " / subfield size: " + subfield_size);
    }
    
    public boolean insertCrop(CropType newCrop) {
        boolean return_value = false;
        
        for (int i = 0; i < this.field_size; i++) {
            for (int j = 0; j < this.subfield_size; j++) {
                //System.out.println(i + " " + j);
                if (this.fieldLayout[i][j] == null) {
                    this.fieldLayout[i][j] = newCrop;
                    return_value = true;
                    break;
                }
            }
            if (return_value = true) {
                break;
            }
        }
        
        return return_value;
    }
    
    public void clearCrops() {
        for (int i = 0; i < this.field_size; i++) {
            for (int j = 0; j < this.subfield_size; j++) {
                this.fieldLayout[i][j] = null;
            }
        }
    }
    
    public void printFields() {
        for (int i = 0; i < this.field_size; i++) {
            for (int j = 0; j < this.subfield_size; j++) {
                if (this.fieldLayout[i][j] != null) {
                    System.out.print(this.fieldLayout[i][j].name());
                   // if (j+1 != subfield_size) {
                        System.out.print("+");  
                   // }
                }
            }
            System.out.println();
        }
    }
}