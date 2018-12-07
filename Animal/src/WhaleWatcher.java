import java.util.ArrayList;

public class WhaleWatcher {

	public static void main(String[] args) {
		
		Whale rightWhale 	= new Whale("Right Whale", "Atlantic", 2001, 21, 16);
		Whale blueWhale 	= new Whale("Blue Whale", "Pacific", 2001, 23, 16);
		Whale spermWhale 	= new Whale("Sperm Whale", "Atlantic", 1900, 20, 40);
		Whale humpbackWhale = new Whale("Humbback Whale", "Antarctic", 919, 13, 13);

		ArrayList<Whale> whales = new ArrayList<Whale>() {{
			add(rightWhale);
			add(blueWhale);
			add(spermWhale);
			add(humpbackWhale);
		}};
		
		for (Whale whale : whales) {
			System.out.println(whale.toString() + "\n");
		}
	}
}
