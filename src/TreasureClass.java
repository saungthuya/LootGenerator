import java.util.Random;

public class TreasureClass {
	private String className;
	private String[] items;
	
	
	public TreasureClass(String str) {
		String[] inputs = str.split("\t");
		this.className = inputs[0];
		this.items = new String[3];
		for(int i = 0; i < 3; i++){
			this.items[i] = inputs[i+1];
		}
	}
	
	public String getName() {
		return this.className;
	}
	
	public String getRandomItem() {
		Random rand = new Random();
		return this.items[rand.nextInt(3)];
	}
}