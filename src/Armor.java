import java.util.Random;

/**
+ * The definition for Armor which holds all of the armor names and statistics
+ * for LootGenerator.
+ */
public class Armor {
	private String armorName;
	private int minac;
	private int maxac;
	
/**
 * 
 * @param s string of inputs from the armor.txt
 */
	public Armor(String s) {	
		String[] inputs = s.split("\t");
		this.armorName = inputs[0];
		this.minac = Integer.parseInt(inputs[1]);
		this.maxac = Integer.parseInt(inputs[2]);
	}

	/**
	 * 
	 * @return the name of the armor
	 */
	public String getName() {
		return this.armorName;
	}

	/**
	 * 
	 * @return the defense statistics of the armor
	 */
	public int getDefense() {
		Random rand = new Random();
		int ret = rand.nextInt(this.maxac - this.minac);
		return this.minac + ret ;
	}
}
