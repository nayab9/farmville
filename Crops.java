
import java.util.*;

public class Crops
{
    public static ArrayList<String[]> myList = new ArrayList<String[]>();
    
	public static void main(String[] args) {
		
		String[] crops = {"Wheat", "Corn", "Barley", "Rye", "Oats", "Soybeans", "Canola"};
		
		int field_number = Integer.parseInt(args[0]);
		
		CropType wheat = new CropType(crops[0]);
		
		Field myField = new Field(field_number);
		
		//myField.printFieldSize();
		
		//combinations(crops);
		
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
		
		//myList.clear();
		
		
		/*
		permute2(Arrays.copyOfRange(crops, 0, field_number-1), 0);
		
		for (String[] item : myList) {
		    System.out.println(item[0] + " " + item[1]);
		}
		
		myList.clear();
		
		permute2(Arrays.copyOfRange(crops, 0, field_number-2), 0);
		
		for (String[] item : myList) {
		    System.out.println(item[0]);
		}
		*/
		//benjamins(Arrays.copyOfRange(crops, 0, field_number));
		
		//List<String> list = Arrays.asList(Arrays.copyOfRange(crops, 0, field_number));
               
        //next, reverse the list using Collections.reverse method
        //Collections.reverse(list);
               
                //next, convert the list back to String array
        //benjamins( (String[]) list.toArray());
		//myField.insertCrop(wheat);
		
	//	myField.printFields();
		
		//myField.insertCrop(new CropType(crops[1]));
		
	//	myField.printFields();
		
		// Create n x 2 field 2d array
		//String[][] fields = new String[field_number][2];


		//System.out.println(wheat.isPlanted());
		//System.out.println(wheat.name());
		//wheat.plant();
		//System.out.println(wheat.isPlanted());
		
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
	
	public static void benjamins(String[] input) {
	    for (int i = 0; i < input.length; i++) {
	        for (int j = i; j < input.length+i; j++) {
	            //System.out.println("i is: " + i + " j is: " + j + " j % input.length is " + j%input.length);
	            System.out.print(input[j%input.length]);
	        }
	        System.out.println();
	    }
	}
	

	
	public static long factorial( int n )
    {
        if( n <= 1 )     // base case
            return 1;
        else
            return n * factorial( n - 1 );
    }
    
	public static void permute( String[] input)
    {
      int inputLength = input.length;
      boolean[ ] used = new boolean[ inputLength ];
      StringBuffer outputString = new StringBuffer();
      //char[ ] in = input.toCharArray( );
      
      doPermute ( input, outputString, used, inputLength, 0 );
    
    }
    
    public static void doPermute ( String[ ] in, StringBuffer outputString, 
                        boolean[ ] used, int inputLength, int level)
    {
         if( level == inputLength) {
            System.out.println ( outputString.toString()); 
            return;
         }
    
        for( int i = 0; i < inputLength; ++i )
        {       
    
           if( used[i] ) continue;
    
           outputString.append( in[i] );      
           used[i] = true;       
           doPermute( in,   outputString, used, inputLength, level + 1 );       
           used[i] = false;       
             outputString.setLength(   outputString.length() - 1 );   
        }
    }

	
	public static ArrayList<String> combinations ( String[] ports ) {

        ArrayList<String> combinationList = new ArrayList<String>();
        // Start i at 1, so that we do not include the empty set in the results
        for ( long i = 1; i < Math.pow(2, ports.length); i++ ) {
            for ( int j = 0; j < ports.length; j++ ) {
                if ( (i & (long) Math.pow(2, j)) > 0 ) {
                    // Include j in set
                    combinationList.add(ports[j]);
                    System.out.println(ports[j]);
                }
            }
            
        }
        return combinationList;
    }
    
    public static void combination(String[]  elements, int K){
 
        // get the length of the array
        // e.g. for {'A','B','C','D'} => N = 4 
        int N = elements.length;
         
        if(K > N){
            System.out.println("Invalid input, K > N");
            return;
        }
        // calculate the possible combinations
        // e.g. c(4,2)
        c(N,K);
         
        // get the combination by index 
        // e.g. 01 --> AB , 23 --> CD
        int combination[] = new int[K];
         
        // position of current index
        //  if (r = 1)              r*
        //  index ==>        0   |   1   |   2
        //  element ==>      A   |   B   |   C
        int r = 0;      
        int index = 0;
         
        while(r >= 0){
            // possible indexes for 1st position "r=0" are "0,1,2" --> "A,B,C"
            // possible indexes for 2nd position "r=1" are "1,2,3" --> "B,C,D"
             
            // for r = 0 ==> index < (4+ (0 - 2)) = 2
            if(index <= (N + (r - K))){
                    combination[r] = index;
                     
                // if we are at the last position print and increase the index
                if(r == K-1){
 
                    //do something with the combination e.g. add to list or print
                    print(combination, elements);
                    index++;                
                }
                else{
                    // select index for next position
                    index = combination[r]+1;
                    r++;                                        
                }
            }
            else{
                r--;
                if(r > 0)
                    index = combination[r]+1;
                else
                    index = combination[0]+1;   
            }           
        }
    }
    public static int c(int n, int r){
		int nf=fact(n);
		int rf=fact(r);
		int nrf=fact(n-r);
		int npr=nf/nrf;
		int ncr=npr/rf; 
		
		System.out.println("C("+n+","+r+") = "+ ncr);

		return ncr;
	}
	
	public static int fact(int n)
	{
		if(n == 0)
			return 1;
		else
			return n * fact(n-1);
	}
	

	public static void print(int[] combination, Object[] elements){

		String output = "";
		for(int z = 0 ; z < combination.length;z++){
			output += elements[combination[z]] + " ";
		}
		System.out.println(output);
	}
}