
/**
+ * The definition for Monster which holds all of the monster names,
+ * types, levels, and treasureClass,
+ * for LootGenerator.
+ */
public class Monster {
	private String monsterName;
	private String type;
	private int level;
	private String treasureClass;

/**
 * 
 * @param s string of inputs from monstats.txt
 */
	public Monster(String s){	
		String[] inputs = s.split("\t");
		this.monsterName = inputs[0];
		this.type = inputs[1];
		this.level = Integer.parseInt(inputs[2]);
		this.treasureClass = inputs[3];
	}

	/**
	 * 
	 * @return the monster name
	 */
	public String getName(){
		return this.monsterName;
	}
	
	/**
	 * 
	 * @return the TreasureClass of the monster
	 */
	public String getTreasureClass(){
		return this.treasureClass;
	}
}