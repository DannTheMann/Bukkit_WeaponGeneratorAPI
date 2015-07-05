package org.hcraid.weapongen;

import java.util.ArrayList;
import java.util.Random;

import org.apache.commons.lang.WordUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemGeneratorAPI {
	
	private static Random random = new Random();
	private static ArrayList<WeaponDrop> weapons = new ArrayList<WeaponDrop>(){/**
		 * 
		 */
		private static final long serialVersionUID = 8391794233508660678L;

	{
		//add(new WeaponDrop(Material.GOLD_SWORD, 0.5));
		add(new WeaponDrop(Material.DIAMOND_SWORD, 0.5));
		add(new WeaponDrop(Material.DIAMOND_AXE, 0.7));
		add(new WeaponDrop(Material.DIAMOND_HOE, 0.8));
		//add(new WeaponDrop(Material.IRON_SWORD, 1));
		//add(new WeaponDrop(Material.IRON_AXE, 1));
		//add(new WeaponDrop(Material.IRON_HOE, 1));
		add(new WeaponDrop(Material.BOW, 0.33));
		add(new WeaponDrop(Material.DIAMOND_CHESTPLATE, 0.5));
		add(new WeaponDrop(Material.DIAMOND_HELMET, 0.7));
		add(new WeaponDrop(Material.DIAMOND_LEGGINGS, 0.6));
		add(new WeaponDrop(Material.DIAMOND_BOOTS, 0.7));
		add(new WeaponDrop(Material.GOLD_CHESTPLATE, 0.7));
		add(new WeaponDrop(Material.GOLD_HELMET, 0.9));
		add(new WeaponDrop(Material.GOLD_LEGGINGS, 0.8));
		add(new WeaponDrop(Material.GOLD_BOOTS, 0.9));
		//add(new WeaponDrop(Material.IRON_HELMET, 1));
		//add(new WeaponDrop(Material.IRON_CHESTPLATE, 1));
		//add(new WeaponDrop(Material.IRON_LEGGINGS, 1));
		//add(new WeaponDrop(Material.IRON_BOOTS, 1));
		add(new WeaponDrop(Material.DIAMOND_PICKAXE, 0.5));
		//add(new WeaponDrop(Material.IRON_PICKAXE, 1));
	}};
	private static ArrayList<ItemDrop> items = new ArrayList<ItemDrop>(){/**
		 * 
		 */
		private static final long serialVersionUID = 7258928643115349880L;

	{
		add(new ItemDrop(Material.MOB_SPAWNER, 0.5, (short) 93, 3, ChatColor.BOLD + "Chicken Spawner")); // Chicken Spawner
		add(new ItemDrop(Material.MOB_SPAWNER, 0.5, (short) 92, 3, ChatColor.BOLD + "" + ChatColor.GRAY + "Cow Spawner")); // Cow Spawner
		add(new ItemDrop(Material.MOB_SPAWNER, 0.5, (short) 91, 3,  "Sheep Spawner")); // Sheep Spawner
		add(new ItemDrop(Material.MOB_SPAWNER, 0.2, (short) 54, 2, ChatColor.DARK_GREEN + "Zombie Spawner")); // Skeleton Spawner
		add(new ItemDrop(Material.MOB_SPAWNER, 0.2, (short) 51, 2, ChatColor.GRAY + "Skeleton Spawner")); // Skeleton Spawner
		//add(new ItemDrop(Material.MOB_SPAWNER, 0.05, (short) 60, 1, ChatColor.DARK_GRAY + "Silverfish Spawner")); // Silverfish Spawner
		//add(new ItemDrop(Material.MOB_SPAWNER, 0.05, (short) 61, 1, ChatColor.YELLOW + "Blaze Spawner")); // Zombie Spawner
		add(new ItemDrop(Material.MOB_SPAWNER, 0.1, (short) 50, 1, ChatColor.GREEN + "Creeper Spawner")); // CreBlazeeper Spawner
		add(new ItemDrop(Material.MOB_SPAWNER, 0.05, (short) 55, 2, ChatColor.GREEN + "Slime Spawner")); // Slime Spawner
		add(new ItemDrop(Material.MOB_SPAWNER, 0.05, (short) 57, 1, ChatColor.GOLD + "Zombie Pigman Spawner")); // Pig Man
		add(new ItemDrop(Material.MOB_SPAWNER, 0.14285, (short) 100, 2, ChatColor.DARK_PURPLE + "Horse Spawner")); // Horse
		add(new ItemDrop(Material.MOB_SPAWNER, 0.2, (short) 52, 2, ChatColor.DARK_GRAY + "Spider Spawner")); // Spider
		//add(new ItemDrop(Material.MOB_SPAWNER, 5, (short) 54, 1).getItem());
		add(new ItemDrop(Material.DIAMOND, 1, (short) 0, new Random().nextInt(20)+1, null));
		add(new ItemDrop(Material.DIAMOND, 0.33, (short) 0, 5 + new Random().nextInt(30)+1, null));
		add(new ItemDrop(Material.DIAMOND, 0.125, (short) 0, 15 + new Random().nextInt(40)+1, null));
		add(new ItemDrop(Material.DIAMOND, 0.05, (short) 0, 40 + new Random().nextInt(50)+1, null));
		add(new ItemDrop(Material.DIAMOND_BLOCK, 0.05, (short) 0, new Random().nextInt(60)+1, null));
		//add(new ItemDrop(Material.ENDER_PEARL, 0.2, (short) 0, 4 + new Random().nextInt(4)+1, null));
		add(new ItemDrop(Material.MUSHROOM_SOUP, 1, (short) 0, 14 + new Random().nextInt(30)+1, null));
		//add(new ItemDrop(Material.MONSTER_EGG, 0.1, (short) 96, 1, null));
		add(new ItemDrop(Material.EXP_BOTTLE, 0.1, (short) 0, 64, null));
		add(new ItemDrop(Material.GOLDEN_APPLE, 0.05, (short) 2, 3, ChatColor.GOLD + "God Apple"));
		add(new ItemDrop(Material.GOLDEN_APPLE, 0.2, (short) 0, 16, null));
		add(new ItemDrop(Material.MOB_SPAWNER, 0.03, (short) 96, 1, ChatColor.RED + "Mooshroom Spawner")); // Mushroom Cow
		
		add(new ItemDrop(Material.GHAST_TEAR, 0.1, (short) 0, 6 + new Random().nextInt(20)+1, null));
		add(new ItemDrop(Material.NETHER_STALK, 0.5, (short) 0, 30 + new Random().nextInt(33)+1, null));
		add(new ItemDrop(Material.BLAZE_POWDER, 0.2, (short) 0, 14 + new Random().nextInt(24)+1, null));
		add(new ItemDrop(Material.MAGMA_CREAM, 0.2, (short) 0, 4 + new Random().nextInt(24)+1, null));
		add(new ItemDrop(Material.REDSTONE, 1, (short) 0, 16 + new Random().nextInt(30)+1, null));
		add(new ItemDrop(Material.GLOWSTONE_DUST, 0.2, (short) 0, 16 + new Random().nextInt(36)+1, null));
		add(new ItemDrop(Material.SULPHUR, 0.1, (short) 0, 16 + new Random().nextInt(35)+1, null));
		add(new ItemDrop(Material.SUGAR, 0.5, (short) 0, 32 + new Random().nextInt(41)+1, null));
		add(new ItemDrop(Material.FERMENTED_SPIDER_EYE, 0.25, (short) 0, 10 + new Random().nextInt(20)+1, null));
		add(new ItemDrop(Material.SPIDER_EYE, 0.5, (short) 0, 24 + new Random().nextInt(24)+1, null));
		add(new ItemDrop(Material.SPECKLED_MELON, 0.3, (short) 0, 24 + new Random().nextInt(24)+1, null));
		
		add(new ItemDrop(Material.GOLD_BLOCK, 0.066, (short) 0, 1 + new Random().nextInt(5)+1, null));
		
		add(new ItemDrop(Material.SKULL_ITEM, 0.1, (short) 3, 1, null)); // Steve head
		add(new ItemDrop(Material.SKULL_ITEM, 0.02, (short) 0, 1, null)); // Skele Head
		add(new ItemDrop(Material.SKULL_ITEM, 0.0333, (short) 2, 1, null)); // Zomb Head
		add(new ItemDrop(Material.SKULL_ITEM, 0.01, (short) 1, 1, null)); // Wither Skele head
		add(new ItemDrop(Material.SKULL_ITEM, 0.005, (short) 3, 1, null)); // Creeper Head
		
		add(new ItemDrop(Material.IRON_CHESTPLATE, 0.75, (short) 0, 1, null));
		add(new ItemDrop(Material.IRON_LEGGINGS, 0.8, (short) 0, 1, null));
		add(new ItemDrop(Material.IRON_HELMET, 0.9, (short) 0, 1, null));
		add(new ItemDrop(Material.IRON_BOOTS, 0.9, (short) 0, 1, null));
		add(new ItemDrop(Material.DIAMOND_CHESTPLATE, 0.3, (short) 0, 1, null));
		add(new ItemDrop(Material.DIAMOND_LEGGINGS, 0.4, (short) 0, 1, null));
		add(new ItemDrop(Material.DIAMOND_HELMET, 0.5, (short) 0, 1, null));
		add(new ItemDrop(Material.DIAMOND_BOOTS, 0.5, (short) 0, 1, null));
		
		add(new ItemDrop(Material.IRON_SWORD, 0.75, (short) 0, 1, null));
		add(new ItemDrop(Material.IRON_AXE, 0.8, (short) 0, 1, null));
		add(new ItemDrop(Material.DIAMOND_SWORD, 0.6, (short) 0, 1, null));
		add(new ItemDrop(Material.DIAMOND_AXE, 0.7, (short) 0, 1, null));
		add(new ItemDrop(Material.IRON_PICKAXE, 0.9, (short) 0, 1, null));

		
		
		add(new ItemDrop(Material.OBSIDIAN, 0.3, (short) 0, 16 + new Random().nextInt(31)+1, null));
		add(new ItemDrop(Material.TNT, 0.3, (short) 0, 16 + new Random().nextInt(31)+1, null));
		
		add(new ItemDrop(Material.POTION, 0.3, (short) 8193, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8225, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8257, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16385, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16417, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8194, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8226, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8258, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16386, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16418, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16450, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8227, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8259, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8258, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16419, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16451, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8196, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8228, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8258, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8260, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16388, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16420, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16452, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8261, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8229, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16453, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16421, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8230, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8262, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16422, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16454, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16424, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16456, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8201, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8233, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8265, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16393, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16425, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16457, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16460, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 16428, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8237, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8269, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8238, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 8270, 8, null));
		add(new ItemDrop(Material.POTION, 0.3, (short) 0, 64, null));
		
	}};

	public static final double UNCOMMON = 0.8; // 1/2
	public static final double RARE = 0.4; // 1/5
	public static final double HEROIC = 0.1; // 1/20
	public static final double LEGENDARY = 0.05; // 1/50
	
	public static ItemStack getCase(short id){
		
		ItemStack is = new ItemStack(Material.BOOK);
		
		Case cas = Main.cases.get(0);
		
		for(Case cas2 : Main.cases){
			if(cas2.getMarker() == id){
				cas = cas2;
				break;
			}
		}
		
		is.setDurability(cas.getMarker());
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(cas.getName());
		im.setLore(new ArrayList<String>(){/**
			 * 
			 */
			private static final long serialVersionUID = 9144496150514808307L;

		{
			add(ChatColor.GRAY + " Right-click to open this case.");
			add(ChatColor.GRAY + " You can potentially win a large");
			add(ChatColor.GRAY + " items or rare goods from this.");
		}});
		is.setItemMeta(im);
		return is;
		
	}
	
	public static Case getCaseFromItemStack(ItemStack is){
		
		if(is.getItemMeta() != null){
			
			if(is.getItemMeta().getDisplayName() != null){

				for(Case cas : Main.cases){
					if(cas.getMarker() == is.getDurability()
							&& is.getType() == Material.BOOK){
						return cas;
					}
				}
				
			}
			
		}
		
		return null;
		
	}
	
	public static ItemStack generateItem(){
		
		regenerateRandom();
		
		if(Math.random() <= 0.3){
			return generateRandomWeapon();
		}else{
			return generateItemStack();
		}
		
	}
	
	private static void regenerateRandom() {
		
		items = new ArrayList<ItemDrop>(){/**
			 * 
			 */
			private static final long serialVersionUID = 9144496150514808307L;

		{
			add(new ItemDrop(Material.MOB_SPAWNER, 0.5, (short) 93, 3, ChatColor.BOLD + "Chicken Spawner")); // Chicken Spawner
			add(new ItemDrop(Material.MOB_SPAWNER, 0.5, (short) 92, 3, ChatColor.BOLD + "" + ChatColor.GRAY + "Cow Spawner")); // Cow Spawner
			add(new ItemDrop(Material.MOB_SPAWNER, 0.5, (short) 91, 3,  "Sheep Spawner")); // Sheep Spawner
			add(new ItemDrop(Material.MOB_SPAWNER, 0.2, (short) 54, 2, ChatColor.DARK_GREEN + "Zombie Spawner")); // Skeleton Spawner
			add(new ItemDrop(Material.MOB_SPAWNER, 0.2, (short) 51, 2, ChatColor.GRAY + "Skeleton Spawner")); // Skeleton Spawner
			//add(new ItemDrop(Material.MOB_SPAWNER, 0.05, (short) 60, 1, ChatColor.DARK_GRAY + "Silverfish Spawner")); // Silverfish Spawner
			//add(new ItemDrop(Material.MOB_SPAWNER, 0.05, (short) 61, 1, ChatColor.YELLOW + "Blaze Spawner")); // Zombie Spawner
			add(new ItemDrop(Material.MOB_SPAWNER, 0.1, (short) 50, 1, ChatColor.GREEN + "Creeper Spawner")); // CreBlazeeper Spawner
			add(new ItemDrop(Material.MOB_SPAWNER, 0.05, (short) 55, 2, ChatColor.GREEN + "Slime Spawner")); // Slime Spawner
			add(new ItemDrop(Material.MOB_SPAWNER, 0.05, (short) 57, 1, ChatColor.GOLD + "Zombie Pigman Spawner")); // Pig Man
			add(new ItemDrop(Material.MOB_SPAWNER, 0.14285, (short) 100, 2, ChatColor.DARK_PURPLE + "Horse Spawner")); // Horse
			add(new ItemDrop(Material.MOB_SPAWNER, 0.2, (short) 52, 2, ChatColor.DARK_GRAY + "Spider Spawner")); // Spider
			//add(new ItemDrop(Material.MOB_SPAWNER, 5, (short) 54, 1).getItem());
			add(new ItemDrop(Material.DIAMOND, 1, (short) 0, new Random().nextInt(20)+1, null));
			add(new ItemDrop(Material.DIAMOND, 0.33, (short) 0, 5 + new Random().nextInt(30)+1, null));
			add(new ItemDrop(Material.DIAMOND, 0.125, (short) 0, 15 + new Random().nextInt(40)+1, null));
			add(new ItemDrop(Material.DIAMOND, 0.05, (short) 0, 40 + new Random().nextInt(50)+1, null));
			add(new ItemDrop(Material.DIAMOND_BLOCK, 0.05, (short) 0, new Random().nextInt(60)+1, null));
			//add(new ItemDrop(Material.ENDER_PEARL, 0.2, (short) 0, 4 + new Random().nextInt(4)+1, null));
			add(new ItemDrop(Material.MUSHROOM_SOUP, 1, (short) 0, 14 + new Random().nextInt(30)+1, null));
			//add(new ItemDrop(Material.MONSTER_EGG, 0.1, (short) 96, 1, null));
			add(new ItemDrop(Material.EXP_BOTTLE, 0.1, (short) 0, 64, null));
			add(new ItemDrop(Material.GOLDEN_APPLE, 0.05, (short) 2, 3, ChatColor.GOLD + "God Apple"));
			add(new ItemDrop(Material.GOLDEN_APPLE, 0.2, (short) 0, 16, null));
			add(new ItemDrop(Material.MOB_SPAWNER, 0.03, (short) 96, 1, ChatColor.RED + "Mooshroom Spawner")); // Mushroom Cow
			
			add(new ItemDrop(Material.GHAST_TEAR, 0.1, (short) 0, 6 + new Random().nextInt(20)+1, null));
			add(new ItemDrop(Material.NETHER_STALK, 0.5, (short) 0, 30 + new Random().nextInt(33)+1, null));
			add(new ItemDrop(Material.BLAZE_POWDER, 0.2, (short) 0, 14 + new Random().nextInt(24)+1, null));
			add(new ItemDrop(Material.MAGMA_CREAM, 0.2, (short) 0, 4 + new Random().nextInt(24)+1, null));
			add(new ItemDrop(Material.REDSTONE, 1, (short) 0, 16 + new Random().nextInt(30)+1, null));
			add(new ItemDrop(Material.GLOWSTONE_DUST, 0.2, (short) 0, 16 + new Random().nextInt(36)+1, null));
			add(new ItemDrop(Material.SULPHUR, 0.1, (short) 0, 16 + new Random().nextInt(35)+1, null));
			add(new ItemDrop(Material.SUGAR, 0.5, (short) 0, 32 + new Random().nextInt(41)+1, null));
			add(new ItemDrop(Material.FERMENTED_SPIDER_EYE, 0.25, (short) 0, 10 + new Random().nextInt(20)+1, null));
			add(new ItemDrop(Material.SPIDER_EYE, 0.5, (short) 0, 24 + new Random().nextInt(24)+1, null));
			add(new ItemDrop(Material.SPECKLED_MELON, 0.3, (short) 0, 24 + new Random().nextInt(24)+1, null));
			
			add(new ItemDrop(Material.GOLD_BLOCK, 0.066, (short) 0, 1 + new Random().nextInt(5)+1, null));
			
			add(new ItemDrop(Material.SKULL_ITEM, 0.1, (short) 3, 1, null)); // Steve head
			add(new ItemDrop(Material.SKULL_ITEM, 0.02, (short) 0, 1, null)); // Skele Head
			add(new ItemDrop(Material.SKULL_ITEM, 0.0333, (short) 2, 1, null)); // Zomb Head
			add(new ItemDrop(Material.SKULL_ITEM, 0.01, (short) 1, 1, null)); // Wither Skele head
			add(new ItemDrop(Material.SKULL_ITEM, 0.005, (short) 3, 1, null)); // Creeper Head
			
			add(new ItemDrop(Material.IRON_CHESTPLATE, 0.75, (short) 0, 1, null));
			add(new ItemDrop(Material.IRON_LEGGINGS, 0.8, (short) 0, 1, null));
			add(new ItemDrop(Material.IRON_HELMET, 0.9, (short) 0, 1, null));
			add(new ItemDrop(Material.IRON_BOOTS, 0.9, (short) 0, 1, null));
			add(new ItemDrop(Material.DIAMOND_CHESTPLATE, 0.3, (short) 0, 1, null));
			add(new ItemDrop(Material.DIAMOND_LEGGINGS, 0.4, (short) 0, 1, null));
			add(new ItemDrop(Material.DIAMOND_HELMET, 0.5, (short) 0, 1, null));
			add(new ItemDrop(Material.DIAMOND_BOOTS, 0.5, (short) 0, 1, null));
			
			add(new ItemDrop(Material.IRON_SWORD, 0.75, (short) 0, 1, null));
			add(new ItemDrop(Material.IRON_AXE, 0.8, (short) 0, 1, null));
			add(new ItemDrop(Material.DIAMOND_SWORD, 0.6, (short) 0, 1, null));
			add(new ItemDrop(Material.DIAMOND_AXE, 0.7, (short) 0, 1, null));
			add(new ItemDrop(Material.IRON_PICKAXE, 0.9, (short) 0, 1, null));

			
			
			add(new ItemDrop(Material.OBSIDIAN, 0.3, (short) 0, 16 + new Random().nextInt(31)+1, null));
			add(new ItemDrop(Material.TNT, 0.3, (short) 0, 16 + new Random().nextInt(31)+1, null));
			
			add(new ItemDrop(Material.POTION, 0.3, (short) 8193, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8225, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8257, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16385, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16417, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8194, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8226, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8258, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16386, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16418, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16450, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8227, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8259, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8258, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16419, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16451, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8196, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8228, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8258, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8260, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16388, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16420, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16452, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8261, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8229, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16453, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16421, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8230, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8262, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16422, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16454, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16424, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16456, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8201, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8233, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8265, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16393, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16425, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16457, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16460, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 16428, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8237, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8269, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8238, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 8270, 8, null));
			add(new ItemDrop(Material.POTION, 0.3, (short) 0, 64, null));
		}};
		
	}

	public static ItemStack generateItemStack() {
		
		//Main.log("Generating new Item!");
		
		ItemDrop id = null;
		
		//int breakCount = 0;
		
		while(true){
			
			id = items.get(new Random().nextInt(items.size()-1));
			
			double chance = new Random().nextDouble();
			
			//Main.log("Chance: " + chance + " , Rare: " + id.getRarity());
			 
			//Bukkit.broadcastMessage(id.getType() + " - Rarity = " + id.getRarity() + ", Chance = " + chance);
			
			ItemStack i = id.getItem();
			
			if(id.getType() == Material.MOB_SPAWNER && id.getItem().getDurability() == 96){
				i.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
			}	
			
			if(chance <= id.getRarity()){
				return i;
			}
			
			//breakCount++;
			
		}
		
	}

	public static ItemStack generateRandomWeapon(){
		
		WeaponRarity wr = getRarity();
		
		if(wr == null){
			return null;
		}
		
		if(items == null){
			return null;
		}
		
		return generateRandomWeapon(wr);
		
	}
	
	private static WeaponRarity getRarity(){
		
		double chance = random.nextDouble();
		
		if(chance <= LEGENDARY){
			return WeaponRarity.LEGENDARY;
		}else if(chance <= HEROIC){
			return WeaponRarity.HEROIC;
		}else if(chance <= RARE){
			return WeaponRarity.RARE;
		}else if(chance <= UNCOMMON){
			return WeaponRarity.UNCOMMON;
		}
		
		return WeaponRarity.COMMON;
	}
	
	private static String generateName(WeaponDrop wd){
		
		if(wd.validDefaultEnchantments().contains(Enchantment.ARROW_DAMAGE)){
			
			String[] header = {"Powerful", "Aweful", "Blighting", "Kickass", "Devastating", "Accurate",
							"Aphrodite's", "Ivory", "Putrid", "Feathered"};
			String[] middle = {"Bow", "Long Bow", "Torque Bow", "Olden Bow", "Magic Bow", "Elven Bow",
					"Compound Bow", "Short Bow", "Mystic Bow", "Arch Bow", "Compact Bow", "Orcish Bow",
					"Recurve Bow"};
			String[] end = {"of The Universe", "of the World", "of Ages", "", "of the Legends", "of Time", 
					"of an Otaku's Basement", "of Billy Mitchell", "of eZ Win",""};
			
			return header[random.nextInt(header.length)] + " " + middle[random.nextInt(middle.length)]
					+ " " + end[random.nextInt(end.length)];
			
		}else if(wd.validDefaultEnchantments().contains(Enchantment.DAMAGE_ALL)){
			
			String[] header = {"Famas DoomKitty", "StatTrak Fade (FACTORY NEW)" ,"Incredible", "Amazing", "Destroying", "Kickass", "Legendary", "Fortold"
					, "Royal", "Magical", "Feared", "Reaped", "Forbidden", "Insane", "eZ", "Randi Slaying"
					, "Loyal", "Mystic", "Mythical", "Emerald", "Ruby", "Onyx", "Mithril", "Ancient", "War"
					, "Deadly", "Rustic", "Enlightened"};
			String[] middle = {"Longsword", "Cleaver", "Katana", "Cutlass", "Scimitar","Brand"
					,"Edge","Bayonet","Cutter","Lance"};
			String[] end = {"of Punishment","of Light","of Darkness","of Goodness","of Anger","of Revenge","of Happiness",
					"of Sorrow","of Melancholy","of Destruction","of Insanity","of Retribution","of Kindness","of Love",
					"of Sin","of Gluttony","of Wrath","of Envy","of Pride", "of Jeremy Kyle", ""};
			
			return header[random.nextInt(header.length)] + " " + middle[random.nextInt(middle.length)]
					+ " " + end[random.nextInt(end.length)];
			
		}else if(wd.validDefaultEnchantments().contains(Enchantment.PROTECTION_ENVIRONMENTAL)){
			
			String[] header = {"Citrine","Pearl","Topaz","King's","Legendary","Prince's",
					"Scrubs","Bishop's","Rook's","Turquoise","Randi's","Mercury's","Aphrodite's","Mars's","Jupiter's",
					"Saturn's","Neptune's","Skeleton","Bone","Poison","Unknown","Battle","Mythril","Earth","Gale","Rune",
					"Regal","Infamous","danslayerx's","Alucard's"};
			String middle = WordUtils.capitalize(wd.getItemStack().getType().toString().replaceAll("_", " ").toLowerCase());
			String[] end = {"of Punishment","of Light","of Darkness","of Goodness","of Anger","of Revenge","of Happiness",
					"of Sorrow","of Melancholy","of Destruction","of Insanity","of Hellfire","of Iron","of HcRaid","of Beowulf",
					"of Death","of Truth","of Silence","of the Untold","of the Abyss","of Swiftness","of Harmony", ""};
			
			return header[random.nextInt(header.length)] + " " + middle + " " + end[random.nextInt(end.length)];
			
		}else if(wd.validDefaultEnchantments().contains(Enchantment.SILK_TOUCH)){
			
			String[] header = {"Miners", "eZ Diamond Finder", "Demotah's Destiny Drill", "Mine Dectecting", "Ore Detecting", "Huntress"
					, "Dwarf's", "Ultimate", "Pristine", "Galaxy", "Confisicated", "Reddit's"};
			String middle = WordUtils.capitalize(wd.getItemStack().getType().toString().replaceAll("_", " ").toLowerCase());
			String[] end = {"of Integrity", "for Classification", "of Ofcom", "of BBC", "of Fox", "of Scrubs Delight"};
			
			return header[random.nextInt(header.length)] + " " + middle + " " + end[random.nextInt(end.length)];
			
		}else{
			return "Some Magical Weapon!";
		}
	
	}

	public static ItemStack generateRandomWeapon(WeaponRarity rarity) {
		
		WeaponRarity wr = rarity;
		
		//Main.log("Generating new WEAPON, Rarity - " + wr.toString());
		
		//WeaponDrop drop = weapons.get(random.nextInt(weapons.size()));
		
		ItemStack itemstack = null;
		
		WeaponDrop drop = null;
		
		//int breakCount = 0;
		
		while(true){
			
			drop = weapons.get(random.nextInt(weapons.size()-1));
			
			double chance = new Random().nextDouble();
			
			//Main.log("Chance: " + chance + " , Rare: " + drop.getRarity());
			
			if(chance <= drop.getRarity()){
				itemstack = drop.getItemStack();
				break;
			}
			
		}
		
		if(itemstack == null || drop == null){
			drop = weapons.get(random.nextInt(weapons.size()-1));
			itemstack = drop.getItemStack();
		}

		Random r = new Random();
		
		int maxEnchantments = (r.nextInt(wr.lowMaxLevel() * (wr.getMaxEnchantments() + 1)) /wr.lowMaxLevel()) + 1; 
		int rand = random.nextInt(drop.validDefaultEnchantments().size());
		int randCount = 0;
		int scape = 0;	
		
		int max = wr.getMaxEnchantments();
		int min = wr.lowMaxLevel();
		
		int totalEnchants = r.nextInt(min * max)+1;
		int outcome = totalEnchants / min;
		
		if(outcome < min){
			outcome = min;
		}
		
		maxEnchantments = outcome;
		
		while(itemstack.getEnchantments().size() < maxEnchantments && scape < 1000){
			
			randCount = 0;
			
			for(Enchantment enc : drop.validDefaultEnchantments()){
				
				if( ! itemstack.containsEnchantment(enc) && rand == randCount){
					
					int maxEnchant = wr.lowMaxLevel();
					
					if(combatEnchantment(enc) && wr == WeaponRarity.LEGENDARY){
						maxEnchant = 5;
					}
					
					itemstack.addUnsafeEnchantment(enc, random.nextInt(maxEnchant) + 1);
					break;
				}else if(rand == randCount){
					break;
				}			
				
				
				randCount++;
				
			}
			
			rand = random.nextInt(drop.validDefaultEnchantments().size());
			
			scape++;
			
		}	
		
		if(scape > 1000){
			Main.log("Failed on loop, escaping...");
		}
		
		Main.nameItem(itemstack, wr.weaponName() + " " + generateName(drop));
		Main.loreItemStack(itemstack, wr.weaponName() + " weapon.");
		
		return itemstack;
		
	}

	private static boolean combatEnchantment(Enchantment enc) {
		
		Enchantment[] enchants = {Enchantment.DAMAGE_ALL, Enchantment.KNOCKBACK, Enchantment.FIRE_ASPECT, Enchantment.ARROW_DAMAGE};
		
		for(Enchantment e : enchants){
			if(e == enc){
				return true;
			}
		}
		
		return false;
	}

	public static Case getRandomCase() {
		
		Case c = null;
		
		while(c == null){
			
			c = Main.cases.get(new Random().nextInt(Main.cases.size()));
			
			int chance = new Random().nextInt(c.getRarity());
			
			if(chance != 1){
				c = null;
			}
			
		}
		
		return c;
		
	}

}
