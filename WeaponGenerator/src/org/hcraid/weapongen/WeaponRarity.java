package org.hcraid.weapongen;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;

public enum WeaponRarity {
	
	LEGENDARY(0.002, ChatColor.RED + "۞", 7, true, 200),
	HEROIC(0.003, ChatColor.LIGHT_PURPLE + "*", 6, true, 100),
	RARE(0.005, ChatColor.BLUE + "*", 5, true, 50),
	UNCOMMON(0.01, ChatColor.DARK_AQUA + "*", 3, true, 30),
	COMMON(0.02, ChatColor.AQUA + "*", 2, true, 10),
	NOTHING(0.0, "", 0, true, 0);
	
	private final double chance;
	private final String symbol;
	private final int number_of_enchantments;
	private final int default_max_enchant;
	private final boolean overEnchant;
	
	WeaponRarity(double chance, String symbol, int number_of_enchantments, boolean overStack, int maxLevel){
		this.chance = chance;
		this.default_max_enchant = maxLevel;
		this.symbol = symbol;
		this.number_of_enchantments = number_of_enchantments;
		this.overEnchant = overStack;
	}
	
	boolean chance(double canBeat){
		return chance <= canBeat;
	}
	
	String symbol(){
		return symbol;
	}
	
	int getMaxEnchantments(){
		return number_of_enchantments;
	}
	
	boolean overEnchantItem(){
		return overEnchant;
	}
	
	int lowMaxLevel(){
		return default_max_enchant;
	}
	
	String weaponName(){
		return symbol + WordUtils.capitalize(super.name().toLowerCase());
	}
	
	

}
