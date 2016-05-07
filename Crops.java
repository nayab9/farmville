
import java.util.*;

public class Crops
{
    public static ArrayList<String[]> myList = new ArrayList<String[]>();
    
	public static void main(String[] args) {
		
		String[] crops = {"Wheat", "Corn", "Barley", "Rye", "Oats", "Soybeans", "Canola"};
		
		int field_number = Integer.parseInt(args[0]);
		
		CropType wheat = new CropType(crops[0]);
		
		Field myField = new Field(field_number);

		String[] subList = Arrays.copyOfRange(crops, 0, field_number);
		
		for (String item : (Arrays.copyOfRange(crops, 0, field_number)) ) {
		    myField.insertCropNoSubfield(new CropType(item));
		    myField.printFields();
		    System.out.println();
		    myField.clearCrops();
		}
		
	    for (int i = 0; i < subList.length; i++) {
		    for (int j = 0; j < subList.length; j++) {
		        if (!subList[i].equals(subList[j])) {
    		        myField.insertCropNoSubfield(new CropType(subList[i]));
    		        myField.insertCropNoSubfield(new CropType(subList[j]));
    		        myField.printFields();
    		        System.out.println();
    		        myField.clearCrops();
		        }
		    }
		    myField.clearCrops();
		}
		
	    for (int i = 0; i < subList.length; i++) {
		    for (int j = i+1; j < subList.length; j++) {
		        myField.insertCrop(new CropType(subList[i]));
		        myField.insertCrop(new CropType(subList[j]));
		        myField.printFields();
		        System.out.println();
		        myField.clearCrops();
		    }
		    myField.clearCrops();
		}
		
		permute2(Arrays.copyOfRange(crops, 0, field_number), 0);
		
		for (String[] item : myList) {
		    //System.out.println(item[0] + " " + item[1] + " " + item[2]);
		    for (int i = 0; i < item.length; i++) {
		       myField.insertCropNoSubfield(new CropType(item[i])); 
		    }
		    myField.printFields();
		    System.out.println();
		    myField.clearCrops();
		}
		
		for (String[] item : myList) {
		    //System.out.println(item[0] + " " + item[1] + " " + item[2]);
		    for (int i = 0; i < item.length; i++) {
		       myField.insertCrop(new CropType(item[i])); 
		    }
		    myField.printFields();
		    System.out.println();
		    myField.clearCrops();
		}
		
		
	
	public static void permute2(String[] a, int k) 
    {
        if (k == a.length) 
        {
            String[] temp = new String[a.length];
            for (int i = 0; i < a.length; i++) 
            {
                //System.out.print(" [" + a[i] + "] ");
                temp[i] = a[i];
                
            }
            myList.add(temp);
            //System.out.println();
        } 
        else 
        {
            for (int i = k; i < a.length; i++) 
            {
                String temp = a[k];
                a[k] = a[i];
                a[i] = temp;
 
                permute2(a, k + 1);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
}