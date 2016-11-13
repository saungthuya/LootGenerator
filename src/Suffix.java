import java.util.Random;

public class Suffix {
	private String suffixName;
	private String mod1Code;
	private int mod1Min;
	private int mod1Max;
	
	public Suffix(String s) {
		String[] inputs = s.split("\t");
		this.suffixName = inputs[0];
		this.mod1Code = inputs[1];
		this.mod1Min = Integer.parseInt(inputs[2]);
		this.mod1Max = Integer.parseInt(inputs[3]);
	}
	
	public String getName() {
		return this.suffixName;
		
	}
	
	public String getMod1Code() {
		return this.mod1Code;
	}
	
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