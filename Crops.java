

public class Crops
{
	public static void main(String[] args) {
		
		String[] crops = {"Wheat", "Corn", "Barley", "Rye", "Oats", "Soybeans", "Canola"};
		
		int field_number = Integer.parseInt(args[0]);
		
		CropType wheat = new CropType(crops[0]);
		
		Field myField = new Field(field_number);
		
		myField.printFieldSize();
		
		myField.insertCrop(wheat);
		
		myField.printFields();
		
		myField.insertCrop(new CropType(crops[1]));
		
		myField.printFields();
		
		// Create n x 2 field 2d array
		//String[][] fields = new String[field_number][2];


		//System.out.println(wheat.isPlanted());
		//System.out.println(wheat.name());
		//wheat.plant();
		//System.out.println(wheat.isPlanted());
		
	}
}