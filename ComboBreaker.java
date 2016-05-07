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
    private int k = 0;

    public ComboBreaker(String[] list) {
        comboFinder(list, this.k);
    }
    
    public void comboFinder(String[] a, int k) 
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
 
                comboFinder(a, k + 1);
 
                temp = a[k];
                a[k] = a[i];
                a[i] = temp;
            }
        }
    }
    
    public ArrayList<String[]> getList() {
        return myList;
    }
}