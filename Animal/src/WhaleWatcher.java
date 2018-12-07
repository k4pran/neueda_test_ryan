import java.util.ArrayList;

public class WhaleWatcher {

	public static void main(String[] args) {
		
		// Create whale objects
		Whale rightWhale 	= new Whale("Right Whale", "Atlantic", 2001, 21, 16);
		Whale blueWhale 	= new Whale("Blue Whale", "Pacific", 2001, 23, 16);
		Whale spermWhale 	= new Whale("Sperm Whale", "Atlantic", 1900, 20, 40);
		Whale humpbackWhale = new Whale("Humbback Whale", "Antarctic", 919, 13, 13);

		// Add all whale objects to ArrayList
		ArrayList<Whale> whales = new ArrayList<Whale>() {{
			add(rightWhale);
			add(blueWhale);
			add(spermWhale);
			add(humpbackWhale);
		}};
		
		// Printing methods
		System.out.println("\n\n--Whale Info--\n");
		printAllWhalesInfo(whales);
		
		System.out.println("\n\n--Whales that swim in the atlantic--\n");
		printWhalesByOcean(whales, "atlantic");
		
		System.out.println("\n\n--The fastest whale--\n");
		printWhalesByFastest(whales);
		
		System.out.println("\n\n--Statistics--\n");
		System.out.printf("The average length of the whales is %.2f", getAverageLength(whales));

		
	}
	
	/**
	 * Iterates through whale objects and prints all details
	 * @param whales
	 */
	public static void printAllWhalesInfo(ArrayList<Whale> whales) {
		for (Whale whale : whales) {
			System.out.println(whale.toString() + "\n");
		}
	}
	
	/**
	 * Iterates through whale objects and prints details of only those who swim in the atlantic
	 * @param whales
	 */
	public static void printWhalesByOcean(ArrayList<Whale> whales, String ocean) {
		for (Whale whale : whales) {
			if (whale.getMainOcean().equalsIgnoreCase(ocean)) {
				System.out.println(whale.toString() + "\n");
			}
		}
	}
	
	/**
	 * Finds the fastest whale and prints out details
	 * @param whales
	 */
	public static void printWhalesByFastest(ArrayList<Whale> whales) {
		
		Whale fastest = whales.get(0);
		for (Whale whale : whales) {
			if (whale.getMaxSpeed() > fastest.getMaxSpeed()) {
				fastest = whale;
			}
		}
		System.out.println(fastest.toString() + "\n");
	}
	
	/**
	 * Gets the average length of a list of whales
	 * @param whales
	 */
	public static double getAverageLength(ArrayList<Whale> whales) {
	
		double lengthSum = 0;
		for (Whale whale : whales) {
			lengthSum += whale.getLength();
		}
		return lengthSum / whales.size();
	}
}
