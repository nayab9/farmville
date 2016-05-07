/** 
 * The COMBOBREAKER!!!!!! class tries to find all permutations
 * of a given array of strings.
 * 
 * The combinations will be stored as seperate
 * string arrays in an ArrayList.
 */
 
import java.util.*;

public class ComboBreaker {
    private ArrayList<String[]> myList = new ArrayList<String[]>();
    private int element = 0;

    public ComboBreaker(String[] list) {
        comboFinder(list, this.element);
    }
    
    // This function will recursively generate a list of possible
    // combinations of a given string array
    public void comboFinder(String[] cropList, int element) {
        if (element == cropList.length) {
            String[] temp = new String[cropList.length];
            for (int i = 0; i < cropList.length; i++) {
                temp[i] = cropList[i];
                
            }
            myList.add(temp);
        } 
        else {
            for (int i = element; i < cropList.length; i++) {
                String temp = cropList[element];
                cropList[element] = cropList[i];
                cropList[i] = temp;
 
                comboFinder(cropList, element + 1);
 
                temp = cropList[element];
                cropList[element] = cropList[i];
                cropList[i] = temp;
            }
        }
    }
    
    public ArrayList<String[]> getList() {
        return myList;
    }
}