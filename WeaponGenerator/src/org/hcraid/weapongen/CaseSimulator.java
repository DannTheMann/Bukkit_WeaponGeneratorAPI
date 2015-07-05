package org.hcraid.weapongen;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class CaseSimulator implements Listener{
	
	public static HashMap<String, CaseSimulator> cases = new HashMap<>();
	
	private Player p;
	private BukkitTask task;
	private int speed;
	private int size;
	private ArrayList<ItemStack> items = new ArrayList<ItemStack>();
	private boolean finished;
	private Inventory inventory;
	private int count;
	private ItemStack winningItem;
	private Case cas;
	
	public CaseSimulator(Player p, int size, Case cas){
		
		ItemStack cover = new ItemStack(Material.STAINED_GLASS_PANE);
		
		ItemMeta im = cover.getItemMeta();
		cover.setDurability((short)8);
		im.setDisplayName(".");
		cover.setItemMeta(im);
		
		if(cases.containsKey(p.getUniqueId().toString())){
			return;
		}
		
		this.cas = cas;
		
		inventory = Bukkit.createInventory(null, 18, ChatColor.DARK_RED + "Unlocking an item!");
		
		for(int i = 0; i < p.getInventory().getSize(); i++){
			
			if(p.getInventory().getItem(i) == null){
				p.getInventory().setItem(i, cover);
			}
			
		}
		
		speed = 3;
		
		this.size = size;
		
		for(int i = 0; i < size; i++){
			
			ItemStack item = ItemGeneratorAPI.generateItem();
			
			if(cas.isAllowedItems(item.getType())){
				items.add(item);
			}else{
				i--;
			}
			
			//Main.log("i = " + i + " Size: " + items.size());
		}
		
		cases.put(p.getUniqueId().toString(), this);
		
		ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE);
		i.setDurability((short) 5);
		
		for(int i2 = 9; i2 < inventory.getSize(); i2++){
			inventory.setItem(i2, i);
		}
		
		ItemStack arrow = new ItemStack(Material.SULPHUR);
		
		inventory.setItem(13, arrow);
		
		p.openInventory(inventory);
		
		this.p = p;
		
		beginSimulation();
	}
	
	private void beginSimulation() {
		
		task = new BukkitRunnable() {
			
			@Override
			public void run() {
				
				if(count % ((50/speed)) == 0){
					speed++;
					cancelTask();
					//beginSimulation();
					//return;
				}else{
				
					update();

					if (speed >= 10) {
						winningItem = inventory.getItem(4);
						awardItem();
						cancel();
					}

				}
				
				count++;
				
			}
		}.runTaskTimer(Main.m, 1, speed);
		
	}

	protected void cancelTask() {
		task.cancel();
		beginSimulation();
	
	}

	protected void awardItem() {
		
		finished = true;
		
		task = new BukkitRunnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				
				ItemStack cover = new ItemStack(Material.STAINED_GLASS_PANE);
				cover.setDurability((short)8);
				
				ItemMeta im = cover.getItemMeta();
				im.setDisplayName(".");
				cover.setItemMeta(im);

				inventory.clear();
				
				ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE);
				i.setDurability((short) 5);
				
				for(int i2 = 9; i2 < inventory.getSize(); i2++){
					inventory.setItem(i2, i);
				}
				
				ItemStack arrow = new ItemStack(Material.SULPHUR);
				
				inventory.setItem(13, arrow);

				inventory.setItem(4, winningItem);
				
				String itemName = ChatColor.GOLD + Main.getItemName(winningItem);
				
				if(winningItem.getAmount() > 1){		
					Bukkit.broadcastMessage(ChatColor.YELLOW + p.getName() + " opened a case and received " 
							+	  itemName + " x" + winningItem.getAmount() + ".");
				}else{
					Bukkit.broadcastMessage(ChatColor.YELLOW + p.getName() + " opened a case and received " + itemName + ".");
				}
				
				Main.logToFile(p.getName() + " opened a " + cas.getRawName() + " and received " + itemName + ":" +
				 winningItem.getDurability() + " x" + winningItem.getAmount());
				
				for(ItemStack is : p.getInventory()){
					
					if(is != null && is.getType() == Material.STAINED_GLASS_PANE 
							&& Main.getItemName(is).equalsIgnoreCase(".")){
						p.getInventory().remove(is);
					}
					
				}
				
				p.updateInventory();
				
				
				
			
			}
		}.runTaskLater(Main.m, 60);
		
	}

	public boolean hasFinished(){
		return finished;
	}
	
	private void update(){
		
		inventory.clear();
		
		int counter = 0;
		
		for(int i = count; i < items.size(); i++){
			
			inventory.setItem(counter, items.get(i));
			counter++;
			if(counter >= 9){
				break;
			}
		}
		
		ItemStack i = new ItemStack(Material.STAINED_GLASS_PANE);
		i.setDurability((short) 5);
		
		for(int i2 = 9; i2 < inventory.getSize(); i2++){
			inventory.setItem(i2, i);
		}
		
		ItemStack arrow = new ItemStack(Material.SULPHUR);
		
		inventory.setItem(13, arrow);
		//p.updateInventory();
		
	}


	public ItemStack getWinningItem() {
		return winningItem;
	}

	public boolean hasTakenItem() {
		if(inventory.contains(winningItem)){
			return false;
		}
		return true;
	}

	public void playerCancelled() {
		task.cancel();
		p.closeInventory();
	}

	public void cancelAll() {
		task.cancel();
	}
	
	
	

}
