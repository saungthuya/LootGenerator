import java.util.Random;

/**
+ * The definition for TreasureClass which holds all of the treasure class names,
+ * and list of items for the LootGenerator.
+ */
public class TreasureClass {
	private String className;
	private String[] items;
	
	/**
	 * 
	 * @param str string of inputs from TreasureClassEx.txt
	 */
	public TreasureClass(String str) {
		String[] inputs = str.split("\t");
		this.className = inputs[0];
		this.items = new String[3];
		for(int i = 0; i < 3; i++){
			this.items[i] = inputs[i+1];
		}
	}
	
	/**
	 * 
	 * @return get the class name of the Treasure
	 */
	public String getName() {
		return this.className;
	}
	
	/**
	 * 
	 * @return a random item from the treasure class
	 */
	public String getRandomItem() {
		Random rand = new Random();
		return this.items[rand.nextInt(3)];
	}
}