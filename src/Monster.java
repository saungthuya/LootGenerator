public class Monster {
	private String monsterName;
	private String type;
	private int level;
	private String treasureClass;


	public Monster(String s){	
		String[] inputs = s.split("\t");
		this.monsterName = inputs[0];
		this.type = inputs[1];
		this.level = Integer.parseInt(inputs[2]);
		this.treasureClass = inputs[3];
	}

	
	public String getName(){
		return this.monsterName;
	}
	
	public String getTreasureClass(){
		return this.treasureClass;
	}
}