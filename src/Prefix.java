import java.util.Random;

/**
+ * The definition for Prefix which holds all of the prefix names,
+ * mod1Code, and statistics for LootGenerator.
+ */
public class Prefix {
	private String prefixName;
	private String mod1Code;
	private int mod1Min;
	private int mod1Max;
	
	/**
	 * 
	 * @param s string of inputs from MagicSuffix.txt
	 */
	public Prefix(String s) {
		String[] inputs = s.split("\t");
		this.prefixName = inputs[0];
		this.mod1Code = inputs[1];
		this.mod1Min = Integer.parseInt(inputs[2]);
		this.mod1Max = Integer.parseInt(inputs[3]);
	}
	
	/**
	 * 
	 * @return get the prefix name
	 */
	public String getName() {
		return this.prefixName;
		
	}
	
	/**
	 * 
	 * @return get the mod1Code
	 */
	public String getMod1Code() {
		return this.mod1Code;
	}
	
	/**
	 * 
	 * @return get the magic statistic
	 */
	public int getStatistic() {
		Random rand = new Random();
		int diff = this.mod1Max-this.mod1Min;
		if (diff > 0) {
		int ret = rand.nextInt(diff);
		return this.mod1Min + ret;
		} else {
			return this.mod1Min; 
		}
	}

}