package org.hcraid.weapongen;

import java.util.ArrayList;

import org.bukkit.Material;

public class Case {
	
	private String name;
	private String rawName;
	private ArrayList<Material> allowedItems;
	private int rarity;
	private Material item;
	private short marker;
	
	public Case(String name, String rawName, ArrayList<Material> allowedItems, int rarity, short marker){
		this.name = name;
		this.rawName = rawName;
		this.allowedItems = allowedItems;
		this.rarity = rarity;
		this.marker = marker;
		//this.item = type;
	}
	
	public String getName(){
		return name;
	}
	
	public String getRawName(){
		return rawName;
	}
	
	public int getRarity(){
		return rarity;
	}
	
	public short getMarker(){
		return marker;
	}
	
	public boolean isAllowedItems(Material m){
		
		if(m == Material.POTION && allowedItems == null){
			return false;
		}
		
		if(allowedItems == null){
			return true;
		}
		
		if(allowedItems.contains(m)){
			return true;	
		}else{
			return false;
		}
		
		
	}

}
