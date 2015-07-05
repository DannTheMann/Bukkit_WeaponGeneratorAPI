package org.hcraid.weapongen;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.milkbowl.vault.economy.Economy;

import org.apache.commons.lang.WordUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creature;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import aog.hcraid.parkour.instance.PRunner;

public class Main extends JavaPlugin implements CommandExecutor, Listener{

	public static String logDir;
	public static String logCustomDir;
	public static Plugin m;
	public static boolean parkour;
	public static boolean funbocks;
	public static ArrayList<String> hasVoted;
	public static Economy economy = null;
	public static HashMap<String, Integer> payout = new HashMap<String, Integer>();
	@SuppressWarnings("serial")
	public static ArrayList<Case> cases = new ArrayList<Case>(){{
		add(new Case(ChatColor.GREEN + "Ｃｌａｓｓｉｃ Ｃａｓｅ", "Classic Case", null, 6, (short) 110));
		add(new Case(ChatColor.GOLD + "Ｓｐａｗｎｅｒ Ｃａｓｅ", "Spawner Case", new ArrayList<Material>(){{
			add(Material.MOB_SPAWNER);
			add(Material.MONSTER_EGG);
			add(Material.SKULL_ITEM);
		}}, 50, (short) 111));
		/*
		add(new Case(ChatColor.LIGHT_PURPLE + "Ｐｏｔｉｏｎ Ｃａｓｅ", "Potion Ingredients Case", new ArrayList<Material>(){{
			add(Material.NETHER_STALK);
			add(Material.GHAST_TEAR);
			add(Material.BLAZE_POWDER);
			add(Material.MAGMA_CREAM);
			add(Material.REDSTONE);
			add(Material.GLOWSTONE_DUST);
			add(Material.SULPHUR);
			add(Material.SUGAR);
			add(Material.FERMENTED_SPIDER_EYE);
			add(Material.SPIDER_EYE);
			add(Material.SPECKLED_MELON);
		}}, 3, (short) 112));
		*/
		add(new Case(ChatColor.BLUE + "Ａｒｍｏｕｒ Ｃａｓｅ", "Armour Case", new ArrayList<Material>(){{
			add(Material.DIAMOND_HELMET);
			add(Material.DIAMOND_CHESTPLATE);
			add(Material.DIAMOND_LEGGINGS);
			add(Material.DIAMOND_BOOTS);
			add(Material.IRON_HELMET);
			add(Material.IRON_CHESTPLATE);
			add(Material.IRON_LEGGINGS);
			add(Material.IRON_BOOTS);
		}}, 9, (short) 113));
		add(new Case(ChatColor.RED + "Ｗｅａｐｏｎ Ｃａｓｅ", "Weapon Case", new ArrayList<Material>(){{
			add(Material.DIAMOND_SWORD);
			add(Material.DIAMOND_AXE);
			add(Material.DIAMOND_HOE);
			add(Material.IRON_SWORD);
			add(Material.IRON_AXE);
			add(Material.IRON_HOE);
			add(Material.BOW);
		}}, 9, (short) 114));
		add(new Case(ChatColor.AQUA + "Ｒｅｓｏｕｒｃｅ Ｃａｓｅ", "Resource Case", new ArrayList<Material>(){{
			add(Material.DIAMOND_PICKAXE);
			add(Material.IRON_PICKAXE);
			add(Material.TNT);
			add(Material.OBSIDIAN);
			add(Material.IRON_AXE);
			add(Material.DIAMOND_AXE);
		}}, 5, (short) 115));
		add(new Case(ChatColor.AQUA + "Ｘｔｒｅｍｅ Ｐｏｔｉｏｎ Ｃａｓｅ", "Potion Case", new ArrayList<Material>(){{
			add(Material.POTION);
		}}, 5, (short) 117));
	}};
	
	//private int scheduleCount;
	//private HashMap<String, Integer> caseAwards = new HashMap<String, Integer>();
	
	public static boolean voting;

	@Override
	public boolean onCommand(CommandSender s, Command c, String l,
			String[] args) {
		
		Player p = null;
		
		if(s instanceof Player){
			p = (Player)s;
		}
	
		
		
		if (c.getName().equalsIgnoreCase("weapon")) {

			if(!p.isOp()){
				return true;
			}
			
			if (args.length == 0) {

				p.sendMessage(" /weapon <l|h|r|u|c|random> - Drop a generated weapon of said standard.");
				return true;
			} else if (args[0].equalsIgnoreCase("legendary")
					|| args[0].equalsIgnoreCase("l")) {

				p.getInventory().addItem(
						ItemGeneratorAPI
								.generateRandomWeapon(WeaponRarity.LEGENDARY));

			} else if (args[0].equalsIgnoreCase("heroic")
					|| args[0].equalsIgnoreCase("h")) {

				p.getInventory().addItem(
						ItemGeneratorAPI
								.generateRandomWeapon(WeaponRarity.HEROIC));

			} else if (args[0].equalsIgnoreCase("rare")
					|| args[0].equalsIgnoreCase("r")) {

				p.getInventory().addItem(
						ItemGeneratorAPI
								.generateRandomWeapon(WeaponRarity.RARE));

			} else if (args[0].equalsIgnoreCase("uncommon")
					|| args[0].equalsIgnoreCase("u")) {

				p.getInventory().addItem(
						ItemGeneratorAPI
								.generateRandomWeapon(WeaponRarity.UNCOMMON));

			} else if (args[0].equalsIgnoreCase("common")
					|| args[0].equalsIgnoreCase("c")) {

				p.getInventory().addItem(
						ItemGeneratorAPI
								.generateRandomWeapon(WeaponRarity.COMMON));

			} else if (args[0].equalsIgnoreCase("random")
					|| args[0].equalsIgnoreCase("ra")) {

				p.getInventory().addItem(
						ItemGeneratorAPI.generateRandomWeapon());

			} else if (args[0].equalsIgnoreCase("sim")
					|| args[0].equalsIgnoreCase("s")) {
				
				p.sendMessage("Simulating case.");
				
				new CaseSimulator(p, 100, cases.get(0));
				
			} else {
				p.sendMessage(" /rdebug weapon <l|h|r|u|c|random |sim> - Drop a generated weapon of said standard.");
			}

		}else if(c.getName().equalsIgnoreCase("case")){
			
			if(p.isOp()){
				
				if (args.length == 0) {

					p.sendMessage(" /case <name / list / simulate> ");
					return true;
				} else if (args[0].equalsIgnoreCase("list")){
					
					for(Case c2 : cases){
						p.sendMessage(c2.getName() + ", 1/" + c2.getRarity());
					}
					
				}else if(args[0].equalsIgnoreCase("cases")){
					
					for(Case c2 : cases){
						p.getInventory().addItem(ItemGeneratorAPI.getCase(c2.getMarker()));
					}
					
				}else if(args[0].equalsIgnoreCase("sch")){
					
					for(Player p2 : Bukkit.getOnlinePlayers()){	
						if(Math.random() <= getConfig().getDouble("ScheduleAwards.Chance to win case")){
							
							Case cas = ItemGeneratorAPI.getRandomCase();
							
							if(inventoryIsEmpty(p.getInventory())){
								p2.getInventory().addItem(ItemGeneratorAPI.getCase(cas.getMarker()));
							}else{
								p2.getWorld().dropItem(p2.getLocation(), ItemGeneratorAPI.getCase(cas.getMarker()));
							}
							p2.sendMessage(ChatColor.GREEN + "You've received a " + cas.getName() + ".");
							p.sendMessage(ChatColor.DARK_GREEN + "Right-click to open this case.");
						}
					}
					
				}else if(args[0].equalsIgnoreCase("vote")){
				
					VoteEvent.vote(p);
					
				}else if(args[0].equalsIgnoreCase("reload")){
					
					saveConfig();
					reloadConfig();
					
					loadConfig();
					
					p.sendMessage("Configuration file reloaded!");
					
				}else if(args[0].equalsIgnoreCase("simulate")){
					
					p.sendMessage("Simulating cases.");
					
					int x = 100;
					
					if(args.length > 1){
						x = Integer.parseInt(args[1]);						
					}
					
					for (Case cas : cases) {

						HashMap<String, Integer> chances = new HashMap<String, Integer>();
						
						for (int z = 0; z < x; z++) {

							ArrayList<ItemStack> items = new ArrayList<ItemStack>();

							for (int i = 0; i < 100; i++) {

								ItemStack item = ItemGeneratorAPI
										.generateItem();

								if (cas.isAllowedItems(item.getType())) {
									items.add(item);
								} else {
									i--;
								}

								// Main.log("i = " + i + " Size: " +
								// items.size());
							}

							int r = new Random().nextInt(80) + 1;

							while (r < 60) {
								r = new Random().nextInt(80);
							}
							
							ItemStack is = items.get(r);

							WeaponRarity wr = getWeaponRarity(is);
							
							String name = is.getType() + ":"
									+ is.getDurability() + " #" + wr.toString();

							if (chances.containsKey(name)) {
								chances.put(name, chances.get(name) + 1);
							} else {
								chances.put(name, 1);
							}

						}
						
						logToCustomFile(cas.getRawName()+ "=" + cas.getRarity() + ", Report", x + " cases generated for " + cas.getRawName()); 
						logToCustomFile(cas.getRawName()+ "=" + cas.getRarity() + ", Report","");
						
						for(String u : chances.keySet()){
							
							logToCustomFile(cas.getRawName()+ "=" + cas.getRarity() + ", Report", 
									u + " --- " + chances.get(u) + "%");
							
						}
					}
					
					p.sendMessage("Simulated " + x + " amount of cases for every case. Recorded to " + logCustomDir);
					
					
				}else{
					
					String caseName = args[0];
					
					Case cas = null;
					
					for(Case c2 : cases){
						if(c2.getName().replaceAll(" ", "").equalsIgnoreCase(caseName)){
							cas = c2;
							break;
						}
					}
					
					if(cas == null){
						p.sendMessage("Error: No case called '" + caseName + "'.");
						for(Case c2 : cases){
							p.sendMessage(c2.getName() + ", 1/" + c2.getRarity());
						}
						return true;
					}
					
					p.sendMessage("Simulating case '" + cas.getName() + "'.");
					
					new CaseSimulator(p, 500, cas);
					
				}
				
			}
			
		}else if(c.getName().equalsIgnoreCase("vote")){
			
			p.sendMessage(ChatColor.GOLD + " - - - - - -> Voting Links!");
			
			for(String u : votingLinks){
				
				p.sendMessage(" - " + ChatColor.translateAlternateColorCodes('&', u));
				
			}
			
		} else if (c.getName().equalsIgnoreCase("reward")) {

			if (s.isOp()) {

				int amount = 0;

				String userName = "";

				if (args.length > 1) {

					amount = Integer.parseInt(args[0]);
					userName = args[1];

					Player p2 = Bukkit.getPlayer(userName);

					if (p2 != null && p2.isOnline()) {

						for (int i = 0; i < amount; i++) {

							Case cas = ItemGeneratorAPI.getRandomCase();

							if (inventoryIsEmpty(p2.getInventory())) {
								p2.getInventory().addItem(
										ItemGeneratorAPI.getCase(cas
												.getMarker()));
							} else {
								p2.getWorld().dropItem(
										p2.getLocation(),
										ItemGeneratorAPI.getCase(cas
												.getMarker()));
							}
							p2.sendMessage(ChatColor.GREEN + "Received "
									+ cas.getName() + " from BuyCraft!");
							logToFile(p2.getName()
									+ " received from BUYCRAFT - "
									+ cas.getRawName());
						}

					} else {
						
						if(payout.containsKey(userName)){
							
							payout.put(userName, payout.get(userName) + amount);
							Main.log("player not online, waiting for them come online.");
							
						}else{
							payout.put(userName, amount);
						}
						
					}
					
				}
				
			}
			
		}
		return false;
		
	}
	
	public WeaponRarity getWeaponRarity(ItemStack is) {
		
		String item = getItemStackName(is);
		
		if(item == null){
			return WeaponRarity.NOTHING;
		}else if(item.startsWith(ChatColor.DARK_PURPLE + "۞")){
			return WeaponRarity.LEGENDARY;
		}else if(item.startsWith(ChatColor.LIGHT_PURPLE + "*")){
			return WeaponRarity.HEROIC;
		}else if(item.startsWith(ChatColor.BLUE + "*")){
			return WeaponRarity.RARE;
		}else if(item.startsWith(ChatColor.DARK_AQUA + "*")){
			return WeaponRarity.UNCOMMON;
		}else if(item.startsWith(ChatColor.AQUA + "*")){
			return WeaponRarity.COMMON;
		}
		return WeaponRarity.NOTHING;
	}

	public String getItemStackName(ItemStack is) {
	
		if(is != null && is.getItemMeta() != null){
			
			ItemMeta im = is.getItemMeta();
			
			return im.getDisplayName();
		}
		
		return "";
		
	}
	
	@SuppressWarnings("unchecked")
	private void loadConfig() {
		
		getConfig().addDefault("Voting.Enabled", true);
		getConfig().addDefault("Voting.Money reward", 500.0);
		getConfig().addDefault("Voting.Links", new ArrayList<String>(){/**
			 * 
			 */
			private static final long serialVersionUID = -3145029628279462999L;

		{
			add("&a PlanetMinecraft - http://www.planetminecraft.com/server/hcraid-overkill-2747027/vote/");
			add("&a MinecraftServers - http://minecraftservers.org/vote/67872");
			add("&a MineStatus - https://minestatus.net/101235-hcraid/vote");
		}});
		getConfig().addDefault("Cases.Enabled", true);
		getConfig().addDefault("ScheduleAwards.Enabled", true);
		getConfig().addDefault("ScheduleAwards.Refresh", 120);
		getConfig().addDefault("ScheduleAwards.Chance to win case", 0.33);
		getConfig().addDefault("Book Given.Block Chance", 0.00133);
		getConfig().addDefault("Book Given.Mob Chance", 0.0033);
		getConfig().addDefault("GeneratedItem ID", 0.0000001);
		getConfig().addDefault("God Apples.Disabled", true);
		
		getConfig().options().copyDefaults(true);
		
		saveConfig();
		
		voting = getConfig().getBoolean("Voting.Enabled");
		block_break_chance = getConfig().getDouble("Book Given.Block Chance");
		mob_kill_chance = getConfig().getDouble("Book Given.Mob Chance");
		toDeposit = getConfig().getDouble("Voting.Money reward");
		votingLinks = (List<String>) getConfig().getList("Voting.Links");
	}
	private static double block_break_chance;
	private static double mob_kill_chance;
	private static List<String> votingLinks;
	public static double toDeposit;
	private static boolean stopApples;
	private static boolean casesEnabled;
	
	public void onEnable(){
		logDir = getDataFolder().getAbsolutePath() + File.separator + "Logs" + File.separator;
		
		File f = new File(logDir);
		
		if(!f.exists()){
			f.mkdir();
		}
		
		logCustomDir = getDataFolder().getAbsolutePath() + File.separator + "Custom Logs" + File.separator;
		
		 f = new File(logCustomDir);
		
		if(!f.exists()){
			f.mkdir();
		}

		setUpDependency();
		
		setupEconomy();
		
		m = this;
		log("Enabled!");		
		
		loadConfig();
		
		casesEnabled = getConfig().getBoolean("Cases.Enabled");
		stopApples = getConfig().getBoolean("God Apples.Disabled");
		
		if(!casesEnabled){
			log("Cases are not enabled. Returning.");
			return;
		}
		
		getServer().getPluginCommand("weapon").setExecutor(this);
		getServer().getPluginCommand("vote").setExecutor(this);
		getServer().getPluginCommand("case").setExecutor(this);
		getServer().getPluginCommand("reward").setExecutor(this);
		getServer().getPluginManager().registerEvents(this, this);
		
		final boolean schedule = getConfig().getBoolean("ScheduleAwards.Enabled");
		final int refresh = getConfig().getInt("ScheduleAwards.Refresh");
		final double chance = getConfig().getDouble("ScheduleAwards.Chance to win case");
		
		if(voting){
			getServer().getPluginManager().registerEvents(new VoteEvent(), this);
		}
		
		if(schedule){
			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					
					Bukkit.broadcastMessage(ChatColor.GOLD + "" + ChatColor.BOLD + " --- Dropping Cases! --- ");
					
				for(Player p : Bukkit.getOnlinePlayers()){	
					
					if(!hasVoted.contains(p.getUniqueId().toString())){
						p.sendMessage(ChatColor.GOLD + " Why not vote? You'll always going to get cases from voting! " +
								"" + ChatColor.YELLOW + "" + ChatColor.BOLD + "/vote - It takes 5 seconds!");
					}
					
					if(playerInParkour(p)){
						continue;
					}
					
					Main.log("Checking " + p.getName() + ".");
					if(Math.random() <= (chance/multiplier(p))){
						Main.log(p.getName() + "won a case.");
						Case cas = ItemGeneratorAPI.getRandomCase();
						
						if(inventoryIsEmpty(p.getInventory())){
							p.getInventory().addItem(ItemGeneratorAPI.getCase(cas.getMarker()));
						}else{
							p.getWorld().dropItem(p.getLocation(), ItemGeneratorAPI.getCase(cas.getMarker()));
						}
						p.sendMessage(ChatColor.GREEN + "You've received a " + cas.getName() + ".");
						p.sendMessage(ChatColor.DARK_GREEN + "Right-click to open this case.");
					}else{
						Main.log(p.getName() + "did not win.");
					}
				}
					
				}
			}.runTaskTimer(m, (20 * 60) * refresh, (20 * 60) * refresh);
			
		}
		
	}
	
	private boolean setupEconomy() {
		RegisteredServiceProvider<Economy> economyProvider = getServer()
				.getServicesManager().getRegistration(Economy.class);
		if (economyProvider != null) {
			economy = (Economy) economyProvider.getProvider();
		}
		return economy != null;
	}

	protected int multiplier(Player p) {
		
		int x = 1;
		
		for(int i1 = x; i1 < 100; i1++){
			if(p.hasPermission("WeaponGenerator.ChanceDecrease." + i1) && !p.isOp()){
				x = i1;
			}
		}
		
		return x;
		
	}

	protected boolean playerInParkour(Player p) {
		
		if(parkour){
		
			if(aog.hcraid.parkour.Main.parkour != null){
				
				PRunner pr = aog.hcraid.parkour.Main.players.get(p.getUniqueId().toString());
				
				if(pr != null && pr.getCurrentMap() != null){
					return true;
				}
				
			}
			
		}
		return false;
	}

	public void onDisable(){
		log("Disabled!");
	}
	
	public static void log(String msg){
		System.out.println("[WeaponGenerator] " + msg);
	}

	public static ItemStack nameItem(ItemStack itemstack, String generateName) {
		
		ItemMeta im = itemstack.getItemMeta();
		im.setDisplayName(generateName);
		itemstack.setItemMeta(im);
		
		return itemstack;
		
	}

	public static ItemStack loreItemStack(ItemStack is, String line) {
		List<String> list = null;
		if(is.getItemMeta().getLore() == null)
			list = new ArrayList<String>();
		else
			list = is.getItemMeta().getLore();
		
		line = ChatColor.stripColor(line);
		
		if(line != null){
			
			for(int i = 0; i < line.split("\n").length; i++){
				
				list.add(ChatColor.RESET + " " + ChatColor.GRAY + line.split("\n")[i]);
				
			}

		}
		
		ItemMeta im = is.getItemMeta();
		im.setLore(list);
		is.setItemMeta(im);
		return is;
	}
	

	public static String getItemName(ItemStack is) {
		
		if(is.getItemMeta() != null){
			
			ItemMeta im = is.getItemMeta();
			
			if(im.getDisplayName() != null){
				return im.getDisplayName();
			}
			
		}
		
		return WordUtils.capitalize(is.getType().toString().toLowerCase().replaceAll("_", " "));
		
	}
	
	
	
	@EventHandler
	public void invalidApple(InventoryCloseEvent e){

			if(stopApples){
		
			int c = 0;
			
			if(e == null || e.getInventory() == null){
				return;
			}
			
			for(ItemStack i : e.getInventory()){
				
				if(i == null){
					continue;
				}
				
				if(i.getType() == Material.GOLDEN_APPLE && i.getDurability() == 1){
					e.getInventory().remove(i);
					c++;
				}
				
			}
			
			if(c > 0){
				Main.logToFile(e.getPlayer().getName() + " had " + c + " illegal golden apples in their inventory.");
			}
			

			}
	}
	
	private static final HashMap<Material, Integer> illegal = new HashMap<Material, Integer>(){{
		put(Material.MOB_SPAWNER, 16);
		put(Material.GOLDEN_APPLE, 4);
		put(Material.DIAMOND, 64);
		put(Material.DIAMOND_BLOCK, 32);
		put(Material.MONSTER_EGG, 16);
		put(Material.GOLD_BLOCK, 16);
	}};
	
	//@EventHandler
	public void openChest(InventoryCloseEvent e){
		
		if(e.getPlayer().hasPermission("Case.alert")){
			return;
		}
		
		int flagLevel = calculatePoints(e.getInventory());

		String name = e.getPlayer().getName();

		if (flagLevel >= 15) {
			getServer()
					.dispatchCommand(
							getServer().getConsoleSender(),
							"ban "
									+ name
									+ " pending investigation, please come on ts.hcraid.com \n "
									+ "and contact a member of higher management.");
		} else if (flagLevel >= 10) {
			broadcast(ChatColor.YELLOW
					+ ""
					+ ChatColor.BOLD
					+ name
					+ " PROBABLY has duplicated items, please check their inventory.");
		} else if (flagLevel >= 5) {
			broadcast(ChatColor.RED
					+ ""
					+ ChatColor.BOLD
					+ name
					+ " may have duplicated items, please check their inventory.");

		}

		Main.log("Violation of " + flagLevel + " for " + name
				+ " on inventory close event, nearby chest.");

		flagLevel = calculatePoints(e.getPlayer().getInventory());

		if (flagLevel >= 15) {
			getServer()
					.dispatchCommand(
							getServer().getConsoleSender(),
							"ban "
									+ name
									+ " pending investigation, please come on ts.hcraid.com \n "
									+ "and contact a member of higher management.");
		} else if (flagLevel >= 10) {
			broadcast(ChatColor.YELLOW
					+ ""
					+ ChatColor.BOLD
					+ name
					+ " PROBABLY has duplicated items, please check their inventory.");
		} else if (flagLevel >= 5) {
			broadcast(ChatColor.RED
					+ ""
					+ ChatColor.BOLD
					+ name
					+ " may have duplicated items, please check their inventory.");

		}

		Main.log("Violation of " + flagLevel + " for " + name
				+ " on inventory.");
	}

	private void broadcast(String string) {
		
		for(Player p : Bukkit.getOnlinePlayers()){
			if(p.hasPermission("Case.alert")){
				p.sendMessage(string);
			}
		}
		
	}

	//@EventHandler
	public void login(PlayerJoinEvent e) {

		if(e.getPlayer().hasPermission("Case.alert")){
			return;
		}
		
		int flagLevel = calculatePoints(e.getPlayer().getInventory());

		String name = e.getPlayer().getName();

		if (flagLevel >= 15) {
			getServer()
					.dispatchCommand(
							getServer().getConsoleSender(),
							"ban "
									+ name
									+ " pending investigation, please come on ts.hcraid.com \n "
									+ "and contact a member of higher management.");
		} else if (flagLevel >= 10) {
			broadcast(ChatColor.YELLOW
					+ ""
					+ ChatColor.BOLD
					+ name
					+ " PROBABLY has duplicated items, please check their inventory.");
		} else if (flagLevel >= 5) {
			broadcast(ChatColor.RED
					+ ""
					+ ChatColor.BOLD
					+ name
					+ " may have duplicated items, please check their inventory.");

		}
		
		
		Main.log("Violation of " + flagLevel + " for " + name  + " on login.");
		
	}
	
	public void incrementConfig(){
		getConfig().set("GeneratedItem ID", getConfig().getDouble("GeneratedItem ID") + 0.000001);
	}
	
	private int calculatePoints(Inventory inventory) {
		
		int violation = 0;
		
		for(ItemStack i : inventory){
			
			if(i != null){
				
				for(Material m : illegal.keySet()){
					
					if((i.getType() == m && m != Material.GOLDEN_APPLE) || 
							(i.getType() == Material.GOLDEN_APPLE && i.getDurability() == 1)){
						
						int amount = i.getAmount();
						
						if(amount >= illegal.get(m)){
							violation++;
						}
						
						if(amount >= illegal.get(m) * 2){
							violation += 5;
						}
						
					}
					
				}
				
			}
			
		}
		
		return violation;
	}
	
	@EventHandler
	public void useCase(PlayerInteractEvent e){
		
		if(e.getAction() == Action.RIGHT_CLICK_BLOCK
				|| e.getAction() == Action.RIGHT_CLICK_AIR){
			
			Player p = e.getPlayer();
			
			if(p.getItemInHand() != null){
				
				if(p.hasPermission("Case.use") && stopApples){
				
				if(p.getItemInHand().getType() == Material.GOLDEN_APPLE){
					
					if(p.getItemInHand().getDurability() == 1){
						
						p.setItemInHand(new ItemStack(Material.GOLDEN_APPLE));
						e.setCancelled(true);
						logToFile(p.getName() + " tried to use a god apple!");
						return;
					}
					
				}else if(p.getItemInHand().getType() == Material.ENDER_PEARL){

						
						p.setItemInHand(new ItemStack(Material.SNOW_BALL));
						e.setCancelled(true);
						logToFile(p.getName() + " tried to use an ender pearl!");
						return;
					
					
				}
				
				Case c = ItemGeneratorAPI.getCaseFromItemStack(p.getItemInHand());
				
				if(c == null){
					return;
				}
				
				if(CaseSimulator.cases.containsKey(p.getUniqueId().toString())){
					p.sendMessage(ChatColor.RED + "You're already in the process of opening a case.");
					return;
				}
				
				if(p.getItemInHand().getAmount() > 1){
					p.getItemInHand().setAmount(p.getItemInHand().getAmount()-1);
				}else{
					p.setItemInHand(null);
				}
			
				new CaseSimulator(p, 100, c);
				
				}
				
			}
			
		}
		
	}
	
	@EventHandler
	public void drop(PlayerDropItemEvent e){
		
		Player p = (Player) e.getPlayer();
		
		CaseSimulator cs = CaseSimulator.cases.get(p.getUniqueId().toString());
		
		if(cs != null){
			
			e.setCancelled(true);
			
		}
		
	}
	
	@EventHandler
	public void takeItem(InventoryClickEvent e){
		
		Player p = (Player) e.getWhoClicked();
		
		CaseSimulator cs = CaseSimulator.cases.get(p.getUniqueId().toString());
		
		if(cs != null){
			
			//p.sendMessage("Click! CANCELLED");
			e.setCancelled(true);
			
			if(cs.getWinningItem() != null && cs.getWinningItem() == e.getCurrentItem()){
				CaseSimulator.cases.remove(p.getUniqueId().toString());
			}
			
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void closeInventory(InventoryCloseEvent e){
		
		final Player p = (Player) e.getPlayer();
		
		CaseSimulator cs = CaseSimulator.cases.get(p.getUniqueId().toString());
		
		//p.sendMessage("Closed Inv , CS = " + cs);
		
		if(cs != null){
			
			if(cs.getWinningItem() != null){
				
				if(!cs.hasTakenItem()){
					//p.sendMessage(ChatColor.RED + "You didn't take your reward!");
					
					if(inventoryIsEmpty(p.getInventory())){
						p.getInventory().addItem(cs.getWinningItem());
					}else{
						p.getWorld().dropItem(p.getLocation(), cs.getWinningItem());
					}
					
					CaseSimulator.cases.remove(p.getUniqueId().toString());
					
				}
				
			}
			
			new BukkitRunnable() {
				
				@Override
				public void run() {
					
					for(int x = 0; x < p.getInventory().getSize(); x++){
						
						ItemStack i = p.getInventory().getItem(x);
						
						if(i != null && i.getType() == Material.STAINED_GLASS_PANE 
								&& Main.getItemName(i).equalsIgnoreCase(".")){
							p.getInventory().setItem(x, null);
						}
						
						
					}
					
					p.updateInventory();
				}
			}.runTaskLater(this, 3);
			
		}
		
	}
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void placeSpawner(final BlockPlaceEvent e){
		
		if(e.getBlock().getType() == Material.MOB_SPAWNER){
			
			Player p = e.getPlayer();
			
			if(p.getItemInHand().getType() == Material.MOB_SPAWNER){
				
				@SuppressWarnings("unused")
				final short data = p.getItemInHand().getDurability();
				
				new BukkitRunnable() {
					
					@Override
					public void run() {	
				        final CreatureSpawner cs = (CreatureSpawner) e
				  	          .getBlock().getState();
				  	        cs.setSpawnedType(EntityType.fromId(data));
					}
				}.runTaskLater(this, 1);

				
			}
			
		}
		
	}
	
	@EventHandler
	public void died(PlayerDeathEvent e){
		
		Player p = e.getEntity();
		
		CaseSimulator cs = CaseSimulator.cases.get(p.getUniqueId().toString());
		
		if(cs != null){
	
			cs.cancelAll();
			
			CaseSimulator.cases.remove(p.getUniqueId().toString());
			
		}
		
	}
	
	@EventHandler
	public void quit(PlayerQuitEvent e){
	
		Player p = e.getPlayer();

		CaseSimulator cs = CaseSimulator.cases.get(p.getUniqueId().toString());

		if (cs != null) {

			cs.playerCancelled();
			
			CaseSimulator.cases.remove(p.getUniqueId().toString());

		}

	}
	
	@EventHandler
	public void join(PlayerJoinEvent e){
		
		Player p = e.getPlayer();
		
		CaseSimulator cs = CaseSimulator.cases.get(p.getUniqueId().toString());
		
		if(cs != null){
			
			CaseSimulator.cases.remove(p.getUniqueId().toString());
			
		}
		
		if(payout.containsKey(p.getName())){
			
			payout(p, payout.get(p.getName()));
			
			payout.remove(p.getName());
			
		}
		
	}
	
	
	
	private void payout(Player p, Integer integer) {
		
		Case cas = ItemGeneratorAPI.getRandomCase();
		
		if(inventoryIsEmpty(p.getInventory())){
			p.getInventory().addItem(ItemGeneratorAPI.getCase(cas.getMarker()));
		}else{
			p.getWorld().dropItem(p.getLocation(), ItemGeneratorAPI.getCase(cas.getMarker()));
		}
		
		p.sendMessage(ChatColor.GREEN + "You've received a " + cas.getName() + ".");
		
	}

	@EventHandler
	public void killMob(EntityDeathEvent e){
		
		if(e.getEntity() instanceof Creature){
			
			if(Math.random() <= mob_kill_chance){
				
				if(e.getEntity().getKiller() != null){

					e.getEntity()
							.getLocation()
							.getWorld()
							.dropItem(
									e.getEntity().getLocation(),
									ItemGeneratorAPI.getCase(ItemGeneratorAPI
											.getRandomCase().getMarker()));
				
				}
			}
			
		}
		
	}

	@EventHandler
	public void mine(BlockBreakEvent e){
		
		if(e.getBlock().getType() != Material.NETHERRACK && e.getBlock().getType() != Material.COBBLESTONE){
			
			if(Math.random() <= block_break_chance){
				e.getBlock().getLocation().getWorld().dropItem
				(e.getBlock().getLocation(), ItemGeneratorAPI.getCase(
						ItemGeneratorAPI.getRandomCase().getMarker()));
			}
			
		}
		
	}
	
	private boolean inventoryIsEmpty(PlayerInventory inventory) {
		
		for(ItemStack i : inventory){
			
			if(i == null){
				return true;
			}
			
		}
		
		return false;
	}
	
	//@SuppressWarnings("unused")
	private void setUpDependency() {

		if(getServer().getPluginManager().getPlugin("Parkour") != null){
			parkour = true;
		}
		
		if(getServer().getPluginManager().getPlugin("Funbocks") != null){
			funbocks = true;
		}
		
	}
	
	public static void logToFile(String string) {
		
		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(new Date(System.currentTimeMillis()));
		
		File f = new File(logDir + date + ".txt");

		final SimpleDateFormat sdf3 = new SimpleDateFormat("h:mm a");
		String prefix = sdf3.format(new Date(System.currentTimeMillis()));
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			bw.write(prefix + " === " + string);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			log("Failed to write out the item achieved from the case.");
			e.printStackTrace();
		}
		
	}
	
	public static void logToCustomFile(String fileName, String line) {
		
		final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy-h:mm a");
		String date = sdf.format(new Date(System.currentTimeMillis()));
		
		File f = new File(logCustomDir + date + "-" + fileName + ".txt");

		//final SimpleDateFormat sdf3 = new SimpleDateFormat("h:mm a");
		//String prefix = sdf3.format(new Date(System.currentTimeMillis()));
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			bw.write(line);
			bw.newLine();
			bw.close();
		} catch (IOException e) {
			log("Failed to write out the item achieved from the case.");
			e.printStackTrace();
		}
		
	}
	

}
