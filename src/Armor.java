import java.util.Random;

public class Armor {
	private String armorName;
	private int minac;
	private int maxac;
	

	public Armor(String s) {	
		String[] inputs = s.split("\t");
		this.armorName = inputs[0];
		this.minac = Integer.parseInt(inputs[1]);
		this.maxac = Integer.parseInt(inputs[2]);
	}

	public String getName() {
		return this.armorName;
	}

	public int getDefense() {
		Random rand = new Random();
		int ret = rand.nextInt(this.maxac - this.minac);
		return this.minac + ret ;
	}
}
