# farmville

Welcome to Crops, a farmville aspiring application!

This application is a farm plot generator. Given a field layout and a list of crops, all possible combinations are listed.listed

The usage instructions are as follows:

> javac *.java
> java Crops -N <number> 

<number> represents the chosen number of fields to use for arranging the crops. 

Restrictions: The chosen number of fields must be less than or equal to the specified list of Crops. 

A default hardcoded list of 7 Crops is baked into the application. 

Usage example with output (using default input of {"Wheat", "Corn", "Barley", "Rye", "Oats", "Soybeans", "Canola"}):

> java Crops -N 3

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

BETA Feature:

A file can be passed into the application to specify the Crops available for use. 
The file must be a line delimited text file, containing one Crop (1 word) per line. 