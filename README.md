######Welcome to Crops, an application with a dream (of being farmville)!

This application is intended to provide all possible combinations of a field arrangement of Crops, given a field size and a specific input of Crops.

This application was created and tested on Java version below:
```
java -version
java version "1.7.0_95"
```

Usage instructions are as follows (Where 'number' represents the chosen number of fields to use for arranging the crops):

```
javac *.java
java Crops -n 'number'
```

A default hardcoded list of Crops are baked into the application: {"Wheat", "Corn", "Barley", "Rye", "Oats", "Soybeans", "Canola"}.

Usage example with output (using default input):

```
java Crops -n 3

Wheat 
Corn 
Barley 
Wheat Corn 
Wheat Barley 
Corn Wheat 
Corn Barley 
Barley Wheat 
Barley Corn 
Wheat+Corn 
Wheat+Barley 
Corn+Barley 
Wheat Corn Barley 
Wheat Barley Corn 
Corn Wheat Barley 
Corn Barley Wheat 
Barley Corn Wheat 
Barley Wheat Corn 
Wheat+Corn Barley 
Wheat+Barley Corn 
Corn+Wheat Barley 
Corn+Barley Wheat 
Barley+Corn Wheat 
Barley+Wheat Corn 
```
**BETA Feature:**

A file can be passed into the application to specify the Crops available for use. 
The file must be a line delimited text file, containing one Crop (1 word) per line. 

A sample file is provided in the repository as: ```"CropList.txt"```

Example usage with file input:

```
java Crops -f CropList.txt -n 3

Wheat 
Corn 
Barley 
Wheat Corn 
Wheat Barley 
Corn Wheat 
Corn Barley 
Barley Wheat 
Barley Corn 
Wheat+Corn 
Wheat+Barley 
Corn+Barley 
Wheat Corn Barley 
Wheat Barley Corn 
Corn Wheat Barley 
Corn Barley Wheat 
Barley Corn Wheat 
Barley Wheat Corn 
Wheat+Corn Barley 
Wheat+Barley Corn 
Corn+Wheat Barley 
Corn+Barley Wheat 
Barley+Corn Wheat 
Barley+Wheat Corn 
```
