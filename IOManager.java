/** 
 * The IOManager class will handle the 
 * inputs provided to the application
 * 
 * If a file is provided, a list is created from that file. 
 * If no file is provided, a default backup list is used. 
 * 
 * An input to specify how many fields are required is also parsed. 
 */
 
 import java.util.*;
 import java.io.*;
 
 class IOManager {
     private int numberOfFields;
     private String[] myCropList;
     private String[] myArgs;
     
     private String[] fullCropList;
     
     // Hardcoded default backup, in case a file is not specified
     private final String[] crops = {"Wheat", "Corn", "Barley", "Rye", "Oats", "Soybeans", "Canola"};
     
     public IOManager(String[] args) {
        this.myArgs = args;
     }
     
     // Simple command line parsing - not much input sanitization here.
     public boolean parseArgs() {
        boolean returnValue = false;
        
        if (this.myArgs.length < 2) {
            returnValue = false;
        } else {
            for (int i = 0; i < this.myArgs.length; i++) {
                if (this.myArgs[i].equals("-n")) {
                    this.numberOfFields = Integer.parseInt(this.myArgs[i+1]);
                    if (this.fullCropList != null) {
                        this.myCropList = Arrays.copyOfRange(this.fullCropList, 0, numberOfFields);
                    } else {
                        this.myCropList = Arrays.copyOfRange(crops, 0, numberOfFields);
                    }
                    returnValue = true;
                } else if (this.myArgs[i].equals("-f")) {
                   readFromFile(this.myArgs[i+1]);
                }
            }

        }
        if (!returnValue) {
            System.out.println("Please specify at least the number of fields wanted: -n <number>");
        }
        return returnValue;
     }
     
     public String[] getCropList() {
         return this.myCropList;
     }
     
     private void readFromFile(String filename) {
        try {
            Scanner in = new Scanner(new FileReader(filename));
            List<String> crops = new ArrayList<String>();
            
            while (in.hasNextLine()) {
                crops.add(in.next());
            }
            
            this.fullCropList = crops.toArray(new String[0]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
     }
 }