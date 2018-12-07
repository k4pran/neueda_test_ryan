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
		System.out.printf("The average length of the whales is %.2f meters \n", getAverageLength(whales));
		
		ArrayList<Whale> heaviestWhales = getHeaviestWhales(whales);
		System.out.printf("The heaviest whales are: \n");
		for (Whale whale : heaviestWhales) {
			System.out.printf("\t%s at %d tonnes\n", whale.getName(), whale.getWeight());
		}
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
	 * Gets average length of whales
	 * @param whales
	 * @return average length of a list of whales
	 */
	public static double getAverageLength(ArrayList<Whale> whales) {
	
		double lengthSum = 0;
		for (Whale whale : whales) {
			lengthSum += whale.getLength();
		}
		return lengthSum / whales.size();
	}
	
	/**
	 * Finds heaviest whales
	 * @param whales
	 * @return list of heaviest whales
	 */
	public static ArrayList<Whale> getHeaviestWhales(ArrayList<Whale> whales) {
	
		ArrayList<Whale> heaviestWhales = new ArrayList<Whale>();
		Whale heaviest = whales.get(0);
		for (Whale whale : whales) {
			if (whale.getWeight() > heaviest.getWeight()) {
				heaviest = whale;
			}
		}
		
		// Check for any equally long whales - ignoring whale already added to list
		heaviestWhales.add(heaviest);
		for (Whale whale : whales) {
			if (whale.getWeight() == heaviest.getWeight() && 
					!whale.getName().equalsIgnoreCase(heaviest.getName())) {
				heaviestWhales.add(whale);
			}
		}
		return heaviestWhales;
	}
}
