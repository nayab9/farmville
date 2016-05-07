/** 
 * The Field class manages the farmers field.
 * 
 * Initialization, insertion, removal of CropTypes
 * within the field is controlled by this class.
 */

public class Field {

    // Subfield size is hardcoded, no reason we can't
    // Expand this in the future, though. 
    // Unfortunately, deadlines are always looming...
    private final int subfield_size = 2;
    private int field_size = 0;
    
    // Our field grid
    private CropType[][] fieldLayout;
    
    public Field(int size) {
        this.field_size = size;
        this.fieldLayout = new CropType[field_size][subfield_size];
    }
    
    public void printFieldSize() {
        System.out.println("Field size: " + field_size + " / subfield size: " + subfield_size);
    }
    
    // Insert a crop into the field, anywhere a spot is available
    public boolean insertCrop(CropType newCrop) {
        boolean return_value = false;
        
        for (int i = 0; i < this.field_size; i++) {
            for (int j = 0; j < this.subfield_size; j++) {
                
                if (this.fieldLayout[i][j] == null) {
                    this.fieldLayout[i][j] = newCrop;
                    return_value = true;
                    return return_value;
                }
            }
        }
        
        return return_value;
    }
    
    // Insert a crop into the field, anywhere available, 
    // Except for subfields, these are 'reserved'
    public boolean insertCropNoSubfield(CropType newCrop) {
        boolean return_value = false;
        
        for (int i = 0; i < this.field_size; i++) {
            if (this.fieldLayout[i][0] == null) {
                this.fieldLayout[i][0] = newCrop;
                this.fieldLayout[i][1] = new CropType("Reserved");
                return_value = true;
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
                if (this.fieldLayout[i][j] != null && this.fieldLayout[i][j].name() != "Reserved") {
                    System.out.print(this.fieldLayout[i][j].name());
                    if (j+1 < subfield_size && this.fieldLayout[i][j+1] != null && this.fieldLayout[i][j+1].name() != "Reserved") {
                        System.out.print("+");  
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}