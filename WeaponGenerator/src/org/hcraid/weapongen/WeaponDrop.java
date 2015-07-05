package org.hcraid.weapongen;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class WeaponDrop{
	
	private Material type;
	private double rarity;
	private ArrayList<Enchantment> validEnchantments;
	
	@SuppressWarnings("serial")
	public WeaponDrop(Material type, double rare){
		this.type = type;
		this.rarity = rare;
		
		Material[][] items = {{Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE
			, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS
			, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS
			, Material.IRON_BOOTS, Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS
			, Material.GOLD_BOOTS, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, 
			Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS},{Material.DIAMOND_SWORD, Material.DIAMOND_AXE
			, Material.IRON_AXE, Material.IRON_SWORD, Material.IRON_HOE, Material.DIAMOND_HOE, Material.GOLD_SWORD,
			Material.GOLD_AXE, Material.GOLD_HOE}
			,{Material.BOW}, {Material.DIAMOND_PICKAXE, Material.IRON_PICKAXE}};
		
		int validation = 0;
		
		flag:
		
		for(Material[] item : items){
			
			for(int i = 0; i < item.length; i++){
				if(item[i] == type){
					break flag;
				}
			}
			
			validation++;
			
		}
		
		validEnchantments = new ArrayList<Enchantment>();
		
		switch(validation){
		
		case 0:
			validEnchantments = new ArrayList<Enchantment>(){{
				add(Enchantment.PROTECTION_ENVIRONMENTAL);
				add(Enchantment.PROTECTION_EXPLOSIONS);
				add(Enchantment.PROTECTION_FALL);
				add(Enchantment.PROTECTION_FIRE);
				add(Enchantment.THORNS);
				add(Enchantment.WATER_WORKER);
				add(Enchantment.OXYGEN);
			}};
			break;
		case 1:
			validEnchantments = new ArrayList<Enchantment>(){{
				add(Enchantment.DAMAGE_ALL);
				add(Enchantment.DAMAGE_ARTHROPODS);
				add(Enchantment.DAMAGE_UNDEAD);
				add(Enchantment.FIRE_ASPECT);
				add(Enchantment.KNOCKBACK);
				add(Enchantment.LOOT_BONUS_MOBS);
			}};
			break;
		case 2:
			validEnchantments = new ArrayList<Enchantment>(){{
				add(Enchantment.ARROW_DAMAGE);
				add(Enchantment.ARROW_FIRE);
				add(Enchantment.ARROW_INFINITE);
				add(Enchantment.ARROW_KNOCKBACK);
			}};
			break;
		case 3:
			validEnchantments = new ArrayList<Enchantment>(){{
				add(Enchantment.DIG_SPEED);
				add(Enchantment.SILK_TOUCH);
				add(Enchantment.LOOT_BONUS_BLOCKS);
				add(Enchantment.LOOT_BONUS_MOBS);
			}};
			break;
		
		}
		
		validEnchantments.add(Enchantment.DURABILITY);
		
	}
	
	public ItemStack getItemStack(){
		return new ItemStack(type);
	}
	
	public double getRarity(){
		return rarity;
	}

	public ArrayList<Enchantment> validDefaultEnchantments(){
		return validEnchantments;
	}
	
}
