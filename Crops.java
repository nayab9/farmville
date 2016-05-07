/** 
 * Crops - This app made me nostalgic for Harvest Moon.
 * 
 * This class will start the crop simulation,
 * It will read inputs passed into the command line,
 * and delegate tasks accordingly.
 */
 
public class Crops {
    
	public static void main(String[] args) {

        // Send arguments to the io manager class
        IOManager ioManager = new IOManager(args);
        
        // If arguments are valid, proceed with the simulation
        if (ioManager.parseArgs()) {
            CropManager cropManager = new CropManager(ioManager.getCropList());
            cropManager.runCropSimulation();
        }
	}
}