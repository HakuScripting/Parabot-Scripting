package autopowerfisher.Data;

import java.util.ArrayList;
import java.util.Random;

import org.parabot.environment.scripts.framework.Strategy;
import org.rev317.api.wrappers.interactive.Npc;
import org.rev317.api.wrappers.scene.Area;
import org.rev317.api.wrappers.scene.Tile;

public class Variables {

	public static ArrayList<Strategy> strategies = new ArrayList<Strategy>();

	public static String status;
	public static String funny;
	public static int Level;
	public static long startTime;
	public static int fishingExp;

	public static int caught = 0;
	public static int dropped = 0;
	
	public static Npc npc32;

	public int startExp;
	public int currentExp;
	public int startLevel;

	public static int fishChosen;
	public static int inventoryFish;

	public static boolean hidePaint;
	public static boolean closePaint;

	public static boolean bankMode = false;
	public static boolean powerMode = false;
	public static boolean m1d1Mode = false;

	public static boolean walkToFish = false;
	public static boolean walkToBank = false;

	public static boolean antiBan = false;

	Random generator = new Random();

	public static int randomNumber;

	public static Area BANKAREA = new Area(new Tile(2813, 3437, 0), new Tile(
			2813, 3446, 0), new Tile(2805, 3446, 0), new Tile(2805, 3437, 0));

	// Path's
	public static Tile[] PATH_TO_BANK = { new Tile(2827, 3436, 0),
			new Tile(2817, 3437, 0), new Tile(2811, 3441, 0) };
	public static Tile[] PATH_TO_FISH = { new Tile(2815, 3437, 0),
			new Tile(2824, 3437, 0), new Tile(2835, 3434, 0) };

	public static int shrimp = 316;
	public static int sword = 324;
	public static int lob = 324;
	public static int bass = 316;
	public static int swordFish = 324;
	public static int monkFish = 326;
	public static int shark = 334;

	// Equipment check
	public static int[] eqipmentID = { 303, 311, 301 };

	// Fish ID's
	public static int shrimpID = 317;
	public static int bassID = 363;
	public static int lobsterID = 377;
	public static int swordFishID = 371;
	public static int monkFishID = 7944;
	public static int sharkID = 0;

	public static int[] fishIDs = { 317, 363, 377, 371, 7944 };

	public static int bankID = 2213;

	public static int fishToCatch = 0;

	static String getStatus() {
		return status;
	}

	static String getFunny() {
		return funny;
	}

	static int getLevel() {
		return Level;
	}

	static long getStartTime() {
		return startTime;
	}

	static int getFishingExp() {
		return fishingExp;
	}

	int getCaught() {
		return caught;
	}

	int getDropped() {
		return dropped;
	}

	int getStartExp() {
		return startExp;
	}

	int getCurrentExp() {
		return currentExp;
	}

	int getStartLevel() {
		return startLevel;
	}

	int getFishChosen() {
		return fishChosen;
	}

	int getInventoryFish() {
		return inventoryFish;
	}

	static boolean isBankMode() {
		return bankMode;
	}

	static boolean isPowerMode() {
		return powerMode;
	}

	static boolean isWalkToFish() {
		return walkToFish;
	}

	static boolean isWalkToBank() {
		return walkToBank;
	}

	Random getGenerator() {
		return generator;
	}

	static Area getBANKAREA() {
		return BANKAREA;
	}

	Tile[] getPATH_TO_BANK() {
		return PATH_TO_BANK;
	}

	Tile[] getPATH_TO_FISH() {
		return PATH_TO_FISH;
	}

	int getShrimp() {
		return shrimp;
	}

	int getSword() {
		return sword;
	}

	int getLob() {
		return lob;
	}

	int getBass() {
		return bass;
	}

	int getSwordFish() {
		return swordFish;
	}

	int getMonkFish() {
		return monkFish;
	}

	int getShark() {
		return shark;
	}

	int[] getEqipmentID() {
		return eqipmentID;
	}

	int getShrimpID() {
		return shrimpID;
	}

	int getBassID() {
		return bassID;
	}

	int getLobsterID() {
		return lobsterID;
	}

	int getSwordFishID() {
		return swordFishID;
	}

	int getMonkFishID() {
		return monkFishID;
	}

	int getSharkID() {
		return sharkID;
	}

	int[] getFishIDs() {
		return fishIDs;
	}

	int getBankID() {
		return bankID;
	}

	int getFishToCatch() {
		return fishToCatch;
	}

	static void setStatus(String status) {
		Variables.status = status;
	}

	static void setFunny(String funny) {
		Variables.funny = funny;
	}

	static void setLevel(int level) {
		Level = level;
	}

	static void setStartTime(long startTime) {
		Variables.startTime = startTime;
	}

	static void setFishingExp(int fishingExp) {
		Variables.fishingExp = fishingExp;
	}

	void setCaught(int caught) {
		Variables.caught = caught;
	}

	void setDropped(int dropped) {
		Variables.dropped = dropped;
	}

	void setStartExp(int startExp) {
		this.startExp = startExp;
	}

	void setCurrentExp(int currentExp) {
		this.currentExp = currentExp;
	}

	void setStartLevel(int startLevel) {
		this.startLevel = startLevel;
	}

	void setFishChosen(int fishChosen) {
		Variables.fishChosen = fishChosen;
	}

	void setInventoryFish(int inventoryFish) {
		Variables.inventoryFish = inventoryFish;
	}

	static void setBankMode(boolean bankMode) {
		Variables.bankMode = bankMode;
	}

	static void setPowerMode(boolean powerMode) {
		Variables.powerMode = powerMode;
	}

	static void setWalkToFish(boolean walkToFish) {
		Variables.walkToFish = walkToFish;
	}

	static void setWalkToBank(boolean walkToBank) {
		Variables.walkToBank = walkToBank;
	}

	void setGenerator(Random generator) {
		this.generator = generator;
	}

	static void setBANKAREA(Area bANKAREA) {
		BANKAREA = bANKAREA;
	}

	void setPATH_TO_BANK(Tile[] pATH_TO_BANK) {
		PATH_TO_BANK = pATH_TO_BANK;
	}

	void setPATH_TO_FISH(Tile[] pATH_TO_FISH) {
		PATH_TO_FISH = pATH_TO_FISH;
	}

	void setShrimp(int shrimp) {
		Variables.shrimp = shrimp;
	}

	void setSword(int sword) {
		Variables.sword = sword;
	}

	void setLob(int lob) {
		Variables.lob = lob;
	}

	void setBass(int bass) {
		Variables.bass = bass;
	}

	void setSwordFish(int swordFish) {
		Variables.swordFish = swordFish;
	}

	void setMonkFish(int monkFish) {
		Variables.monkFish = monkFish;
	}

	void setShark(int shark) {
		Variables.shark = shark;
	}

	void setEqipmentID(int[] eqipmentID) {
		Variables.eqipmentID = eqipmentID;
	}

	void setShrimpID(int shrimpID) {
		Variables.shrimpID = shrimpID;
	}

	void setBassID(int bassID) {
		Variables.bassID = bassID;
	}

	void setLobsterID(int lobsterID) {
		Variables.lobsterID = lobsterID;
	}

	void setSwordFishID(int swordFishID) {
		Variables.swordFishID = swordFishID;
	}

	void setMonkFishID(int monkFishID) {
		Variables.monkFishID = monkFishID;
	}

	void setSharkID(int sharkID) {
		Variables.sharkID = sharkID;
	}

	void setFishIDs(int[] fishIDs) {
		Variables.fishIDs = fishIDs;
	}

	void setBankID(int bankID) {
		Variables.bankID = bankID;
	}

	void setFishToCatch(int fishToCatch) {
		Variables.fishToCatch = fishToCatch;
	}

	public ArrayList<Strategy> getStrategies() {
		return strategies;
	}

	static boolean isAntiBan() {
		return antiBan;
	}

	static void setStrategies(ArrayList<Strategy> strategies) {
		Variables.strategies = strategies;
	}

	static void setAntiBan(boolean antiBan) {
		Variables.antiBan = antiBan;
	}

	static int getRandomNumber() {
		return randomNumber;
	}

	static void setRandomNumber(int randomNumber) {
		Variables.randomNumber = randomNumber;
	}

	static boolean isM1d1Mode() {
		return m1d1Mode;
	}

	static void setM1d1Mode(boolean m1d1Mode) {
		Variables.m1d1Mode = m1d1Mode;
	}

	public static void setHidePaint(boolean hidePaint) {
		Variables.hidePaint = hidePaint;
	}

	static void setClosePaint(boolean closePaint) {
		Variables.closePaint = closePaint;
	}

	public static boolean isHidePaint() {
		return hidePaint;
	}

	static boolean isClosePaint() {
		return closePaint;
	}

	Npc getNpc32() {
		return npc32;
	}

	void setNpc32(Npc npc32) {
		Variables.npc32 = npc32;
	}
}
