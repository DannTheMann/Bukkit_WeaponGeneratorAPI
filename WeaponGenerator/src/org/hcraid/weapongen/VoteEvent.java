package org.hcraid.weapongen;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import com.vexsoftware.votifier.model.VotifierEvent;

public class VoteEvent implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void castVote(VotifierEvent e){
		
		Main.log("");
		Main.log("RECEIVED VOTE FROM - " + e.getVote().getUsername());
		Main.log("");
		
		vote(Bukkit.getPlayer(e.getVote().getUsername()));
		
	}

	public static void vote(Player p) {
		
		if (p != null) {

			if (p.isOnline()) {

				Case c = null;

				while (c == null) {

					c = Main.cases.get(new Random().nextInt(Main.cases.size()));

					int chance = new Random().nextInt(c.getRarity());

					if (chance != 1) {
						c = null;
					}

				}

				if(Main.economy != null){
					
					Main.economy.depositPlayer(p, Main.toDeposit);
					
				}
				
				p.getInventory().addItem(
						ItemGeneratorAPI.getCase(c.getMarker()));
				p.sendMessage(ChatColor.GOLD + " ---- Thanks for Voting! ---- ");
				p.sendMessage(ChatColor.YELLOW
						+ " Here's a Case, right-click to unlock it!");
				Bukkit.broadcastMessage(ChatColor.YELLOW + " > > "
						+ p.getName() + " voted for the servers and received "
						+ c.getName() + ChatColor.YELLOW + " for his vote!");
				
				if(!Main.hasVoted.contains(p.getUniqueId().toString())){
					Main.hasVoted.add(p.getUniqueId().toString());
				}

			}

		}
		
	}
	
	@EventHandler
	public void respawn(){
		
	}
}
