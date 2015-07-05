package org.hcraid.weapongen;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemDrop{

	private Material type;
	private double rare;
	private short dura;
	private int amount;
	private String name;
	
	public ItemDrop(Material type, double rare, short dura, int amount, String name) {
		this.type = type;
		this.rare = rare;
		this.amount = amount;
		this.dura = dura;
		this.name = name;
	}
	
	public ItemStack getItem(){
		ItemStack is = new ItemStack(type, amount);
		is.setDurability(dura);
		
		if(name != null){
			ItemMeta im = is.getItemMeta();
			im.setDisplayName(name);
			is.setItemMeta(im);
		}
		
		return is;
	}
	
	public double getRarity(){
		return rare;
	}
	
	public Material getType(){
		return type;
	}

}
