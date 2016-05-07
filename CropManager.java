/** 
 * The CropManager class will manage how 
 * the crops are inserted into the field.
 * 
 * Given a specific set of inputs, specifying
 * which crops are to be planted, the CropManager
 * will call upon other classes needed to plant
 * the crops to specifications.
 */
 
 import java.util.*;
 
 public class CropManager {
     private Field myField;
     private String[] myCropList;
     
     public CropManager(String[] cropList) {
         myField = new Field(cropList.length);
         this.myCropList = cropList;
     }
     
     public void runCropSimulation() {
        singleCrops();
        doubleCrops();
        moreCrops();
     }
     
     // Prints out the 'single crop only' scenario
     // Effectively isolating a single crop from the 
     // Specified group of crops, and planting it by its lonesome
     private void singleCrops() {
		for (String item : this.myCropList ) {
		    myField.insertCropNoSubfield(new CropType(item));
		    myField.printFields();
		    System.out.println();
		    myField.clearCrops();
		}
     }
     
     // Prints out a 'double crop' scenario, effectively 
     // pairing up one crop with every other crop until they each 
     // have experienced what its like to be planted with one another
     private void doubleCrops() {
	    for (int i = 0; i < this.myCropList.length; i++) {
		    for (int j = 0; j < this.myCropList.length; j++) {
		        if (!this.myCropList[i].equals(this.myCropList[j])) {
    		        myField.insertCropNoSubfield(new CropType(this.myCropList[i]));
    		        myField.insertCropNoSubfield(new CropType(this.myCropList[j]));
    		        myField.printFields();
    		        System.out.println();
    		        myField.clearCrops();
		        }
		    }
		    myField.clearCrops();
		}
	
	    for (int i = 0; i < this.myCropList.length; i++) {
		    for (int j = i+1; j < this.myCropList.length; j++) {
		        myField.insertCrop(new CropType(this.myCropList[i]));
		        myField.insertCrop(new CropType(this.myCropList[j]));
		        myField.printFields();
		        System.out.println();
		        myField.clearCrops();
		    }
		    myField.clearCrops();
		}
     }
     
     // Prints out all combinations of crops in groups of 3 and beyond. 
     // This case requires finding all permutations of the given crop list, 
     // Then, effectively planting them in every arrangement possible. 
     private void moreCrops() {
        for (int index = 3; index <= this.myCropList.length; index++) {
		    
		    // Find all combinations possible with the given crop list
		    ComboBreaker myCombos = new ComboBreaker(this.myCropList);
		    ArrayList<String[]> myList = myCombos.getList();
		    
		    // Plant each crop arrangement in the fields, ignoring subfields
    		for (String[] item : myList) {
    		    for (int i = 0; i < item.length; i++) {
    		       myField.insertCropNoSubfield(new CropType(item[i])); 
    		    }
    		    myField.printFields();
    		    System.out.println();
    		    myField.clearCrops();
    		}
    		
    		// Plant each crop arragement in the fields, including subfields
    		for (String[] item : myList) {
    		    for (int i = 0; i < item.length; i++) {
    		       myField.insertCrop(new CropType(item[i])); 
    		    }
    		    myField.printFields();
    		    System.out.println();
    		    myField.clearCrops();
    		}
    		
    		// Plant drops using a 'rolling window' of subfield size. 
    		// Effectively attempting to create every scenario possible when 
    		// Planting all combinations and utilizing the subfield possibilites
    		if (index > 3) {
    		    for (String[] item: myList) {
    		        for (int i = 0; i < item.length-1; i++) {
    		            //int counter = 0;
        		        for (int j = 0; j < item.length; j++) {
        		            if (j == i || j == i+1) {
        		                myField.insertCrop(new CropType(item[j]));
        		                //counter++;
        		            } else if (j != i || j != i+1) {
        		                myField.insertCropNoSubfield(new CropType(item[j]));
        		            }
        		        }
        		        myField.printFields();
        		        System.out.println();
        		        myField.clearCrops();
    		        }
    		    }
    		}
		}
     }
 }