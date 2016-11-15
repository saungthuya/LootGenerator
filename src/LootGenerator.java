/**
 * The loot generator program lets the user play a game in which the user slays a randomly 
 * generated monster. When the monster is slain, the program will show the type of armor 
 * that belongs to a treasure class, the defense level of that armor, statistic of that armor, 
 * prefix and/or suffix and their statistic of that armor. 
 * @author Saung Thuya [thuyasau]
 * @author JongHoon Bae [baejongh]
 *  resources:(to use HashMap) https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html 
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class LootGenerator {
	
	private static Scanner in;
	
	/**
	 * 
	 * @param file, the file monstats.txt
	 * @return a list of monsters in List<Monster> format
	 * @throws FileNotFoundException
	 */
	public static List<Monster> getMonsterList(File file) throws FileNotFoundException{
		Scanner in = new Scanner(file);
		List<Monster> ret = new ArrayList<Monster>();
		while(in.hasNext()){
			ret.add(new Monster(in.nextLine()));
		}
		in.close();
		return ret;
	}
		
	/**
	 * 
	 * @param file, the file monstats.txt
	 * @return a random monster in Monster form
	 * @throws FileNotFoundException
	 */
	public static Monster pickMonster(File file) throws FileNotFoundException {
		Scanner in = new Scanner(file);
		Random rand = new Random();
		Map<Integer, Monster> map = new HashMap<Integer, Monster>();

		int n = 0;
		for(;in.hasNext();) {
			Monster m = new Monster(in.nextLine());
			map.put(n, m);
			n++;
		}
		Monster ret = map.get(rand.nextInt(n));
		in.close();
		return ret;
	}
	
	/**
	 * 
	 * @param file, the TreasureClassEx.txt file
	 * @return a list of TreasureClasses in List<TreasureClass> form
	 * @throws FileNotFoundException
	 */
	public static List<TreasureClass> getTreasureClassList(File file) throws FileNotFoundException{
		Scanner in = new Scanner(file);
		List<TreasureClass> ret = new ArrayList<TreasureClass>();
		while(in.hasNext()){
			ret.add(new TreasureClass(in.nextLine()));
		}
		in.close();
		return ret;
	}
	
	/**
	 * 
	 * @param file, the MagicPrefix.txt file
	 * @return a prefix in Prefix form
	 * @throws FileNotFoundException
	 */
	public static Prefix getPrefix(File file) throws FileNotFoundException{
		Scanner in = new Scanner(file);
		Random rand = new Random();
		Map<Integer, Prefix> map = new HashMap<Integer, Prefix>();
		int n = 0;
		for(;in.hasNext();) {
			Prefix p = new Prefix(in.nextLine());
			map.put(n, p);
			n++;
		}
		Prefix ret = map.get(rand.nextInt(n));
		in.close();
		return ret;
	}
	
	/**
	 * 
	 * @param file, the MagicSuffix.txt file
	 * @return a suffix in Suffix form
	 * @throws FileNotFoundException
	 */
	public static Suffix getSuffix(File file) throws FileNotFoundException{
		Scanner in = new Scanner(file);
		Random rand = new Random();
		Map<Integer, Suffix> map = new HashMap<Integer, Suffix>();
		int n = 0;
		for(;in.hasNext();) {
			Suffix s = new Suffix(in.nextLine());
			map.put(n, s);
			n++;
		}
		Suffix ret = map.get(rand.nextInt(n));
		in.close();
		return ret;
	}
	
	/**
	 * 
	 * @param file, the armor.txt file
	 * @return a armor list in List<Armor> format
	 * @throws FileNotFoundException
	 */
	public static List<Armor> getArmorList(File file) throws FileNotFoundException{
		Scanner in = new Scanner(file);
		List<Armor> ret = new ArrayList<Armor>();
		while(in.hasNext()){
			ret.add(new Armor(in.nextLine()));
		}
		in.close();
		return ret;
	}
	
	/**
	 * gets the Treasure class of an monster
	 * @param m, a monster
	 * @param treasureList, a list of TreasureClasses
	 * @return a TreasureClass that matches with the monster
	 */
	public static TreasureClass fetchTreasureClass(Monster m, List<TreasureClass> treasureList){
		String name =  m.getTreasureClass();
		Iterator<TreasureClass> iter = treasureList.iterator();
		TreasureClass cur;
		while(iter.hasNext()){
			cur = iter.next();
			if(cur.getName().equals(name)){
				return cur;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param treasure, a TreasureClass
	 * @param armorList, an armor list
	 * @param treasureList, a list of TreasureClasses
	 * @return an armor that is in the treasure class or treasure list
	 */
	public static Armor generateBaseItem(TreasureClass treasure, List<Armor> armorList, List<TreasureClass> treasureList){
		String name = treasure.getRandomItem();
		Iterator<Armor> iter = armorList.iterator();
		Armor cur;
		while(iter.hasNext()){
			cur = iter.next();
			if(cur.getName().equals(name)){
				return cur;
			}
		}
		Iterator<TreasureClass> iter2 = treasureList.iterator();
		TreasureClass cur2;
		while(iter2.hasNext()){
			cur2 = iter2.next();
			if(cur2.getName().equals(name)){
				return generateBaseItem(cur2, armorList, treasureList);
			}
		}
		return null;
	}
	
	/**
	 * 
	 * @param baseItem, a base armor item 
	 * @return the string of the defense statistic
	 */
	public static String generateBaseStat(Armor baseItem) {
		String ret = "Defense: " + baseItem.getDefense();
		return ret;
	}
	
	/**
	 * 
	 * @param baseItem, a base armor item
	 * @return a string of either just the prefix or suffix classes or both of them
	 * @throws FileNotFoundException
	 */
	public static String generateAffixAndStats(Armor baseItem) throws FileNotFoundException {
		String ret;
		Random rand = new Random();
		int randNum = rand.nextInt(2);
		if (randNum == 0) {
			File prefixFile = new File("src/data/large/MagicPrefix.txt");
			Prefix pre = getPrefix(prefixFile);
			ret = pre.getName() + " " + baseItem.getName() + "\n" + generateBaseStat(baseItem)
				+ "\n" + pre.getStatistic() + " " + pre.getMod1Code();
			return ret;
		} else if (randNum == 1) {
			File suffixFile = new File("src/data/large/MagicSuffix.txt");
			Suffix suf = getSuffix(suffixFile);
			ret = baseItem.getName() + " " + suf.getName() + "\n" + generateBaseStat(baseItem)
				+ "\n" + suf.getStatistic() + " " + suf.getMod1Code();
			return ret;
		} else {
			File prefixFile = new File("src/data/large/MagicPrefix.txt");
			Prefix pre = getPrefix(prefixFile);
			File suffixFile = new File("src/data/large/MagicSuffix.txt");
			Suffix suf = getSuffix(suffixFile);
			ret = pre.getName() + " " + baseItem.getName() + " " + suf.getName() + "\n" 
				+ generateBaseStat(baseItem) + "\n" + suf.getStatistic() + " " + suf.getMod1Code();
			return ret;
		}
		
	}
	

	
	public static void main(String[] argc) throws FileNotFoundException  {
		
		String resp = "y";
		do {
		File monsterFile = new File("src/data/large/monstats.txt");
		Monster m = pickMonster(monsterFile);
		File treasureClassFile = new File("src/data/large/TreasureClassEx.txt");
		File armorFile = new File("src/data/large/armor.txt");
		System.out.println("Fighting " + m.getName());
		System.out.println("You have slain " + m.getName());
		System.out.println(m.getName() + " dropped: \n \n");
		List<TreasureClass> treasureList = getTreasureClassList(treasureClassFile);
		List<Armor> armorList = getArmorList(armorFile);
		TreasureClass treasure = fetchTreasureClass(m, treasureList);
		Armor baseItem = generateBaseItem(treasure, armorList, treasureList);
		System.out.println(generateAffixAndStats(baseItem));
		System.out.println("\n");
		System.out.println("Fight again [y/n]?");
		in = new Scanner(System.in);
		resp = in.nextLine();
		if (resp.equalsIgnoreCase("n") || resp.equalsIgnoreCase("no")) {
			return;
		} 
		} while (resp.equalsIgnoreCase("y") || resp.equalsIgnoreCase("yes"));

	}
}