package com.boyboy0710.mob;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public final class Main extends JavaPlugin implements Listener{

    private Scoreboard board;
    private Objective obj;
    private Score sc;

    public void onEnable() {
        System.out.println("----------------------------------------------------------");
        System.out.println("    mob 를러그인을 성공적으로 불러왔습니다");
        System.out.println("        플러그인 제작자ㅣ:boyboy0710");
        System.out.println("   최신버전 다운 사이트 : https://github.com/boyboy0710/mob");
        System.out.println("----------------------------------------------------------");

        ItemStack settings = new ItemStack(Material.PAPER, 1);
        ItemMeta st_meta = settings.getItemMeta();
        st_meta.setDisplayName("설정권");
        st_meta.setLore(Arrays.asList("custom_mob를 설정할때 필요합니다"));
        settings.setItemMeta(st_meta);

        ItemStack spawn = new ItemStack(Material.BOOK, 1);
        ItemMeta spawn_meta = spawn.getItemMeta();
        spawn_meta.setDisplayName("스폰권");
        spawn_meta.setLore(Arrays.asList("custom_mob를 스폰할때 필요합니다"));
        spawn.setItemMeta(spawn_meta);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe cr_settings = new ShapedRecipe(new ItemStack(settings)).shape(new String[] {"BBB","BAB","BBB"})
                .setIngredient('A', Material.DIAMOND).setIngredient('B', Material.PAPER);

        ShapedRecipe cr_spawn = new ShapedRecipe(new ItemStack(spawn)).shape(new String[] {"CCC","CAC","CCC"})
                .setIngredient('A', Material.DIAMOND).setIngredient('C', Material.BOOK);

        getServer().addRecipe(cr_spawn);
        getServer().addRecipe(cr_settings);

    }
    @Override
    public void onDisable() {
        System.out.println("mob 플러그인이 비활성화 되었습니다");
    }

    public void scboard(Player player) {
        ScoreboardManager sm = Bukkit.getScoreboardManager();
        board = sm.getNewScoreboard();
        obj = board.registerNewObjective("mob", "dummy");
        obj.setDisplayName("mob_plugin");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score settings_score = obj.getScore("설정권");

        settings_score.setScore(spawn_cb);

        player.setScoreboard(board);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("최신버전 다운사이트 : https://github.com/boyboy0710/mob");
        p.setScoreboard(board);
    }
    int spawn_cb = 0;
    int settings_cb = 0;

    public boolean zombie = false;
    public boolean skeleton = false;
    public boolean creeper = false;
    public boolean Wither_Skeleton = false;
    public boolean witch = false;

    //Custom mob
    public boolean custom_bat_ai = true;
    public boolean custom_bat_glowing = false;

    int bat_max_hp = 6;
    int bat_speed = 0;

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        ItemStack settings = new ItemStack(Material.PAPER, 1);
        ItemMeta st_meta = settings.getItemMeta();
        st_meta.setDisplayName("설정권");
        st_meta.setLore(Arrays.asList("custom_mob를 설정할때 필요합니다"));
        settings.setItemMeta(st_meta);

        ItemStack spawn = new ItemStack(Material.BOOK, 1);
        ItemMeta spawn_meta = spawn.getItemMeta();
        spawn_meta.setDisplayName("스폰권");
        spawn_meta.setLore(Arrays.asList("custom_mob를 스폰할때 필요합니다"));
        spawn.setItemMeta(spawn_meta);

        if (e.getAction() == Action.RIGHT_CLICK_AIR
                || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getItem() == settings) {
                settings_cb = settings_cb + 1;
            }

            if (e.getItem().getType() == Material.NETHER_STAR) {
                Player p = e.getPlayer();
                Inventory inv = Bukkit.createInventory(null, 9, "기본");

                ItemStack cr =  new ItemStack(Material.CRAFTING_TABLE);
                ItemMeta cr_mata = cr.getItemMeta();
                cr_mata.setDisplayName("조합법");
                cr_mata.setLore(Arrays.asList("조합법을 볼수 있습니다"));
                cr.setItemMeta(cr_mata);
                inv.setItem(3, cr);

                p.openInventory(inv);
            }
        }
    }
    @EventHandler
    public void Inven(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();
        Inventory inv = e.getClickedInventory();
        e.getView().getTitle().equalsIgnoreCase("");


        ItemStack settings = new ItemStack(Material.PAPER, 1);
        ItemMeta st_meta = settings.getItemMeta();
        st_meta.setDisplayName("설정권");
        st_meta.setLore(Arrays.asList("custom_mob를 설정할때 필요합니다"));
        settings.setItemMeta(st_meta);

        ItemStack spawn = new ItemStack(Material.BOOK, 1);
        ItemMeta spawn_meta = spawn.getItemMeta();
        spawn_meta.setDisplayName("스폰권");
        spawn_meta.setLore(Arrays.asList("custom_mob를 스폰할때 필요합니다"));
        spawn.setItemMeta(spawn_meta);

        ItemStack cr =  new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta cr_mata = cr.getItemMeta();
        cr_mata.setDisplayName("조합법");
        cr_mata.setLore(Arrays.asList("조합법을 볼수 있습니다"));
        cr.setItemMeta(cr_mata);

        ItemStack gsgp =  new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        ItemMeta gsgp_meta = cr.getItemMeta();
        gsgp_meta.setDisplayName("");
        gsgp_meta.setLore(Arrays.asList(""));
        gsgp.setItemMeta(gsgp_meta);

        ItemStack paper = new ItemStack(Material.PAPER);
        ItemStack book = new ItemStack(Material.BOOK);
        ItemStack diamond = new ItemStack(Material.DIAMOND);
        ItemStack crafting_table = new ItemStack(Material.CRAFTING_TABLE);
        ItemStack exit = new ItemStack(Material.BARRIER);
//-------------------------------------------------------------------------------------------

        Inventory crafting = Bukkit.createInventory(null, 54, "조합법");
        crafting.setItem(1, settings);
        crafting.setItem(2, spawn);

        Inventory cr_settings = Bukkit.createInventory(null, 54, "설정권 조합법");
        cr_settings.setItem(1, gsgp);
        cr_settings.setItem(2, gsgp);
        cr_settings.setItem(3, gsgp);
        cr_settings.setItem(4, gsgp);
        cr_settings.setItem(5, gsgp);
        cr_settings.setItem(6, gsgp);
        cr_settings.setItem(7, gsgp);
        cr_settings.setItem(8, gsgp);
        cr_settings.setItem(9, gsgp);
        cr_settings.setItem(10, gsgp);
        cr_settings.setItem(11, paper);
        cr_settings.setItem(12, paper);
        cr_settings.setItem(13, paper);
        cr_settings.setItem(14, gsgp);
        cr_settings.setItem(15, gsgp);
        cr_settings.setItem(16, gsgp);
        cr_settings.setItem(17, gsgp);
        cr_settings.setItem(18, gsgp);
        cr_settings.setItem(19, gsgp);
        cr_settings.setItem(20, paper);
        cr_settings.setItem(21, diamond);
        cr_settings.setItem(22, paper);
        cr_settings.setItem(23, gsgp);
        cr_settings.setItem(24, crafting_table);
        cr_settings.setItem(25, gsgp);
        cr_settings.setItem(26, settings);
        cr_settings.setItem(27, gsgp);
        cr_settings.setItem(28, gsgp);
        cr_settings.setItem(29, paper);
        cr_settings.setItem(30, paper);
        cr_settings.setItem(31, paper);
        cr_settings.setItem(32, gsgp);
        cr_settings.setItem(33, gsgp);
        cr_settings.setItem(34, gsgp);
        cr_settings.setItem(35, gsgp);
        cr_settings.setItem(36, gsgp);
        cr_settings.setItem(37, gsgp);
        cr_settings.setItem(38, gsgp);
        cr_settings.setItem(39, gsgp);
        cr_settings.setItem(40, gsgp);
        cr_settings.setItem(41, gsgp);
        cr_settings.setItem(42, gsgp);
        cr_settings.setItem(43, gsgp);
        cr_settings.setItem(44, gsgp);
        cr_settings.setItem(45, gsgp);
        cr_settings.setItem(46, gsgp);
        cr_settings.setItem(47, gsgp);
        cr_settings.setItem(48, gsgp);
        cr_settings.setItem(49, gsgp);
        cr_settings.setItem(50, exit);
        cr_settings.setItem(52, gsgp);
        cr_settings.setItem(53, gsgp);
        cr_settings.setItem(54, gsgp);

        Inventory cr_spawn = Bukkit.createInventory(null, 54, "스폰권 조합법");
        cr_settings.setItem(1, gsgp);
        cr_settings.setItem(2, gsgp);
        cr_settings.setItem(3, gsgp);
        cr_settings.setItem(4, gsgp);
        cr_settings.setItem(5, gsgp);
        cr_settings.setItem(6, gsgp);
        cr_settings.setItem(7, gsgp);
        cr_settings.setItem(8, gsgp);
        cr_settings.setItem(9, gsgp);
        cr_settings.setItem(10, gsgp);
        cr_settings.setItem(11, book);
        cr_settings.setItem(12, book);
        cr_settings.setItem(13, book);
        cr_settings.setItem(14, gsgp);
        cr_settings.setItem(15, gsgp);
        cr_settings.setItem(16, gsgp);
        cr_settings.setItem(17, gsgp);
        cr_settings.setItem(18, gsgp);
        cr_settings.setItem(19, gsgp);
        cr_settings.setItem(20, book);
        cr_settings.setItem(21, diamond);
        cr_settings.setItem(22, book);
        cr_settings.setItem(23, gsgp);
        cr_settings.setItem(24, crafting_table);
        cr_settings.setItem(25, gsgp);
        cr_settings.setItem(26, settings);
        cr_settings.setItem(27, gsgp);
        cr_settings.setItem(28, gsgp);
        cr_settings.setItem(29, book);
        cr_settings.setItem(30, book);
        cr_settings.setItem(31, book);
        cr_settings.setItem(32, gsgp);
        cr_settings.setItem(33, gsgp);
        cr_settings.setItem(34, gsgp);
        cr_settings.setItem(35, gsgp);
        cr_settings.setItem(36, gsgp);
        cr_settings.setItem(37, gsgp);
        cr_settings.setItem(38, gsgp);
        cr_settings.setItem(39, gsgp);
        cr_settings.setItem(40, gsgp);
        cr_settings.setItem(41, gsgp);
        cr_settings.setItem(42, gsgp);
        cr_settings.setItem(43, gsgp);
        cr_settings.setItem(44, gsgp);
        cr_settings.setItem(45, gsgp);
        cr_settings.setItem(46, gsgp);
        cr_settings.setItem(47, gsgp);
        cr_settings.setItem(48, gsgp);
        cr_settings.setItem(49, gsgp);
        cr_settings.setItem(50, exit);
        cr_settings.setItem(52, gsgp);
        cr_settings.setItem(53, gsgp);
        cr_settings.setItem(54, gsgp);

        if(!((World) inv).getName().equals("기본")) return;


        if(e.getCurrentItem().getItemMeta() == cr) {
            e.setCancelled(true);
            p.openInventory(crafting);
        }

        if(e.getCurrentItem().getItemMeta() == spawn) {
            e.setCancelled(true);
            p.openInventory(cr_spawn);
        }

        if(e.getCurrentItem().getItemMeta() == settings) {
            e.setCancelled(true);
            p.openInventory(cr_settings);
        }
        if(e.getCurrentItem().getItemMeta() == exit) {
            e.setCancelled(true);
            p.closeInventory();
        }
        if(e.getCurrentItem().getItemMeta() == diamond) {
            e.setCancelled(true);
        }
        if(e.getCurrentItem().getItemMeta() == crafting_table) {
            e.setCancelled(true);
        }
        if(e.getCurrentItem().getItemMeta() == gsgp) {
            e.setCancelled(true);
        }
        if(e.getCurrentItem().getItemMeta() == paper) {
            e.setCancelled(true);
        }
        if(e.getCurrentItem().getItemMeta() == book) {
            e.setCancelled(true);
        }
    }



    public void setcustombatStats(LivingEntity entity) {
        entity.setAI(custom_bat_ai);
        entity.setMaxHealth(bat_max_hp);
        entity.setHealth(bat_max_hp);
        entity.setGlowing(custom_bat_glowing);
        if(bat_speed != 0) {
            entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000000, bat_speed));
        }
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        ItemStack settings = new ItemStack(Material.PAPER, 1);
        ItemMeta st_meta = settings.getItemMeta();
        st_meta.setDisplayName("설정권");
        st_meta.setLore(Arrays.asList("custom_mob를 설정할때 필요합니다"));
        settings.setItemMeta(st_meta);

        ItemStack spawn = new ItemStack(Material.BOOK, 1);
        ItemMeta spawn_meta = spawn.getItemMeta();
        spawn_meta.setDisplayName("스폰권");
        spawn_meta.setLore(Arrays.asList("custom_mob를 스폰할때 필요합니다"));
        spawn.setItemMeta(spawn_meta);

        if(cmd.getName().equalsIgnoreCase("test")) {
            p.getInventory().addItem(settings);
            p.getInventory().addItem(spawn);
            p.getInventory().addItem(new ItemStack(Material.DIAMOND, 2));
            p.getInventory().addItem(new ItemStack(Material.PAPER, 8));
            p.getInventory().addItem(new ItemStack(Material.BOOK, 8));
        }
        if(cmd.getName().equalsIgnoreCase("custom_mob")) {
            if(args.length == 0) {
                sender.sendMessage("커맨드를 끝까지 쳐주세요");
                p.sendMessage("/custom_mob help 명령어로 사용 방법을 알수있습니다");
                p.sendMessage("설정을 변경하려면 설정권이 필요합니다");
                p.sendMessage("커스텀 몹을 스폰하려면 스폰권이 필요합니다");
            }

            else if(args[0].equalsIgnoreCase("help")) {
                if(settings_cb == 0) {
                    p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                }
                else {
                    settings_cb = settings_cb - 1;
                    p.sendMessage("스폰 명령어 : /custom_mob [몹이름] spwan");
                    p.sendMessage("몹 설정 변경 : /custom_mob [몹이름] [설정] [값 또는 true 또는 false]");
                    p.sendMessage("현재 사용할수 있는 몹은 /custom_mob help mob 명령어로 확인할수 있습니다");
                    p.sendMessage("현재 사용할수 있는 설정은 /custom_mob help Settings 명령어로 확인할수 있습니다");
                }
                if(args[1].equalsIgnoreCase("mob")) {
                    if(settings_cb == 0) {
                        p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                    }
                    else {
                        settings_cb = settings_cb - 1;
                        p.sendMessage("현재 사용할수 있는 몹");
                        p.sendMessage("bat");
                    }
                }

                if(args[1].equalsIgnoreCase("Settings")) {
                    if(settings_cb == 0) {
                        p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                    }
                    else {
                        settings_cb = settings_cb - 1;
                        p.sendMessage("사용할수 있는 설정");
                        p.sendMessage("max_hp : 몹의 채력을 설정합니다");
                        p.sendMessage("사용법: /custom_mob [몹이름] max_hp [값]");
                        p.sendMessage("");
                        p.sendMessage("reset : 설정이 초기화 됩니다");
                        p.sendMessage("사용법: /custom_mob [몹이름] reset");
                        p.sendMessage("");
                        p.sendMessage("ai : ai 유무를 결정합니다");
                        p.sendMessage("사용법: /custom_mob [몹이름] ai [true or false]");
                    }
                }
            }

            else if(args[0].equalsIgnoreCase("bat")) {
                Player player = (Player) sender;

                if(args[1].equalsIgnoreCase("reset")) {
                    if(settings_cb == 0) {
                        p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                    }
                    else {
                        settings_cb = settings_cb - 1;
                        p.sendMessage(ChatColor.GREEN + "custom_bat 설정이 초기화 되었습니다");
                        bat_max_hp = 6;
                        custom_bat_ai = true;
                    }
                }

                else if(args[1].equalsIgnoreCase("spawn")) {
                    if(spawn_cb == 0) {
                        p.sendMessage(ChatColor.RED + "스폰권이 없습니다");
                    }
                    else {
                        spawn_cb = spawn_cb - 1;
                        setcustombatStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.BAT));
                        p.sendMessage(ChatColor.GREEN + "커스텀 박쥐를 스폰하였습니다");
                        p.sendMessage(ChatColor.GREEN + "기본설정은 true입니다");

                    }
                }

                else if(args[1].equalsIgnoreCase("max_hp")) {
                    if(args[2].length() !=0) {
                        if(settings_cb == 0) {
                            p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                        }
                        else {
                            settings_cb = settings_cb - 1;
                            bat_max_hp = Integer.parseInt(args[2]);
                            p.sendMessage(ChatColor.GREEN + "custom_bat 체력을" + ChatColor.GREEN + bat_max_hp + ChatColor.GREEN + " 로 설정했습니다");
                        }
                    }

                }

                else if(args[1].equalsIgnoreCase("ai")) {
                    if(args[2].equalsIgnoreCase("true")) {
                        if(settings_cb == 0) {
                            p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                        }
                        else {
                            settings_cb = settings_cb - 1;
                            custom_bat_ai = true;
                            p.sendMessage(ChatColor.GREEN + "박쥐 ai를 true로 설정했습니다");
                        }
                    }
                    else if(args[2].equalsIgnoreCase("false")) {
                        if(settings_cb == 0) {
                            p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                        }
                        else {
                            settings_cb = settings_cb - 1;
                            custom_bat_ai = false;
                            p.sendMessage(ChatColor.GREEN + "박쥐 ai를 false로 설정했습니다");
                        }
                    }
                }
            }

            else if(args[1].equalsIgnoreCase("glowing")) {
                if(args[2].equalsIgnoreCase("true")) {
                    if(settings_cb == 0) {
                        p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                    }
                    else {
                        settings_cb = settings_cb - 1;
                        custom_bat_glowing = true;
                        p.sendMessage(ChatColor.GREEN + "박쥐 glowing를 true로 설정했습니다");
                    }
                }
                else if(args[2].equalsIgnoreCase("false")) {
                    if(settings_cb == 0) {
                        p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                    }
                    else {
                        settings_cb = settings_cb - 1;
                        custom_bat_glowing = false;
                        p.sendMessage(ChatColor.GREEN + "박쥐 glowing를 false로 설정했습니다");
                    }
                }
            }

            else if(args[1].equalsIgnoreCase("speed")) {
                if(args[2].length() != 0) {
                    if(p.getInventory().getItemInHand().getType() != Material.PAPER) {
                        p.sendMessage(ChatColor.RED + "설정권이 없습니다");
                    }
                    else {
                        settings_cb = settings_cb - 1;
                        bat_max_hp = Integer.parseInt(args[2]);
                        p.sendMessage(ChatColor.GREEN + "박쥐 speed를" + ChatColor.GREEN + "로 설정했습니다");
                    }
                }
            }

        }
//-------------------------------------------------------------------------------------------------------------------------------------
        if(cmd.getName().equalsIgnoreCase("spawn_no_ai")) {
            if(args.length == 0) {
                sender.sendMessage("커맨드를 끝까지 쳐주세요");
            }
            else if(args[0].equalsIgnoreCase("bat")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.BAT));
            }
            else if(args[0].equalsIgnoreCase("bee")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.BEE));
            }
            else if(args[0].equalsIgnoreCase("blaze")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.BLAZE));
            }

            else if(args[0].equalsIgnoreCase("cat")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.CAT));
            }
            else if(args[0].equalsIgnoreCase("cave_spider")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.CAVE_SPIDER));
            }
            else if(args[0].equalsIgnoreCase("chicken")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.CHICKEN));
            }
            else if(args[0].equalsIgnoreCase("cod")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.COD));
            }
            else if(args[0].equalsIgnoreCase("cow")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.COW));
            }
            else if(args[0].equalsIgnoreCase("creeper")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.CREEPER));
            }

            else if(args[0].equalsIgnoreCase("dolphin")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.DOLPHIN));
            }
            else if(args[0].equalsIgnoreCase("donkey")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.DONKEY));
            }
            else if(args[0].equalsIgnoreCase("drowned")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.DROWNED));//드라운드
            }

            else if(args[0].equalsIgnoreCase("ender_guardian")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ELDER_GUARDIAN));
            }
            else if(args[0].equalsIgnoreCase("ENDER_DRAGON")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ENDER_DRAGON));
            }
            else if(args[0].equalsIgnoreCase("enderman")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ENDERMAN));
            }
            else if(args[0].equalsIgnoreCase("endermite")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ENDERMITE));
            }

            else if(args[0].equalsIgnoreCase("fox")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.FOX));
            }

            else if(args[0].equalsIgnoreCase("ghast")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.GHAST));
            }

            else if(args[0].equalsIgnoreCase("mooshroom")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.MUSHROOM_COW));
            }

            else if(args[0].equalsIgnoreCase("ocelot")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.OCELOT));
            }

            else if(args[0].equalsIgnoreCase("parrot")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.PARROT));
            }

            else if(args[0].equalsIgnoreCase("pig")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.PIG));
            }

            else if(args[0].equalsIgnoreCase("rabbit")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.RABBIT));
            }

            else if(args[0].equalsIgnoreCase("skeleton")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SKELETON));
            }


            else if(args[0].equalsIgnoreCase("silverflsh")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SILVERFISH));
            }
            else if(args[0].equalsIgnoreCase("shulker")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SHULKER));
            }

            else if(args[0].equalsIgnoreCase("sheep")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SHEEP));
            }

            else if(args[0].equalsIgnoreCase("strider")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.STRIDER));
            }

            else if(args[0].equalsIgnoreCase("squid")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SQUID));
            }

            else if(args[0].equalsIgnoreCase("snowman")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SNOWMAN));
            }

            else if(args[0].equalsIgnoreCase("salmon")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SALMON));
            }

            else if(args[0].equalsIgnoreCase("tropical_fish")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.TROPICAL_FISH));
            }

            else if(args[0].equalsIgnoreCase("turtle")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.TURTLE));
            }

            else if(args[0].equalsIgnoreCase("wandering_trader")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WANDERING_TRADER));
            }

            else if(args[0].equalsIgnoreCase("witch")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WITCH));
            }
            else if(args[0].equalsIgnoreCase("wither")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WITHER));
            }
            else if(args[0].equalsIgnoreCase("wither_skeleton")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WITHER_SKELETON));
            }

            else if(args[0].equalsIgnoreCase("zombie")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE));
            }
            else if(args[0].equalsIgnoreCase("zoglin")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOGLIN));
            }
            else if(args[0].equalsIgnoreCase("zombie_horse")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE_HORSE));
            }
            else if(args[0].equalsIgnoreCase("zombie_villager")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE_VILLAGER));
            }
            else if(args[0].equalsIgnoreCase("zombified_piglin")) {
                Player player = (Player) sender;
                setentityStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIFIED_PIGLIN));
            }

        }
        if(cmd.getName().equalsIgnoreCase("spawn")) {
            if(args.length == 0) {
                sender.sendMessage("커맨드를 끝까지 쳐주세요");
            }

            else if(args[0].equalsIgnoreCase("king_zombie")) {
                Player player = (Player) sender;
                setZombieStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE));
                zombie = true;
                World world = player.getWorld();
                world.setStorm(true);
                world.setThundering(true);
            }

            else if(args[0].equalsIgnoreCase("king_skeleton")) {
                Player player = (Player) sender;
                setSkeletonStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.SKELETON));
                skeleton = true;
                World world = player.getWorld();
                world.setStorm(true);
                world.setThundering(true);
            }

            else if(args[0].equalsIgnoreCase("king_wither skeleton")) {
                Player player = (Player) sender;
                setWitherSkeletonStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.WITHER_SKELETON));
                Wither_Skeleton = true;
                World world = player.getWorld();
                world.setStorm(true);
                world.setThundering(true);
            }

            else if(args[0].equalsIgnoreCase("king_creeper")) {
                Player player = (Player) sender;
                setCreeperStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.CREEPER));
                creeper = true;
                World world = player.getWorld();
                world.setStorm(true);
                world.setThundering(true);
            }

            else if(args[0].equalsIgnoreCase("king_Iron golem")) {
                Player player = (Player) sender;
                setCreeperStats((LivingEntity) player.getWorld().spawnEntity(player.getLocation(), EntityType.IRON_GOLEM));

            }
        }
        return false;

    }

    public void setentityStats(LivingEntity entity) {
        entity.setAI(false);
        entity.setCustomName("no_ai_mob");
        entity.setMaxHealth(9999.0);//최대 체력 설정
        entity.setHealth(9999.0);//현재 체력 설정
    }

    public void setIrongolemStats(LivingEntity entity) {
        int hp = (int) entity.getHealth();
        int maxhp = (int) entity.getMaxHealth();
        entity.setCustomName("king_Iron golem" + ChatColor.RED   +" ❤" + ChatColor.RED + hp + " / " + ChatColor.GREEN + maxhp);
        entity.setMaxHealth(5000.0);//최대 체력 설정
        entity.setHealth(5000.0);//현재 체력 설정
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000000, 60));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1000000, 3000));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,1000000, 1));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,1000000, 10));
        entity.getEquipment().setItemInHand(new ItemStack(Material.NETHERITE_SWORD));
        entity.getEquipment().setHelmet(new ItemStack(Material.IRON_HELMET));
        entity.getEquipment().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
        entity.getEquipment().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
        entity.getEquipment().setBoots(new ItemStack(Material.IRON_BOOTS));
    }

    public void setWitherSkeletonStats(LivingEntity entity) {
        int hp = (int) entity.getHealth();
        int maxhp = (int) entity.getMaxHealth();
        entity.setCustomName("king_Wither Skeleton" + ChatColor.RED   +" ❤" + ChatColor.RED + hp + " / " + ChatColor.GREEN + maxhp);
        entity.setMaxHealth(5000.0);//최대 체력 설정
        entity.setHealth(5000.0);//현재 체력 설정
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000000, 6));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1000000, 3000));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,1000000, 1));
        entity.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        entity.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
        entity.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
        entity.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
        entity.getEquipment().setItemInHand(new ItemStack(Material.BOW));
        if(hp == 0) {
            Wither_Skeleton = false;
            Location l = entity.getLocation();
            World world = entity.getWorld();
            world.strikeLightning(l);
            if(!zombie) {
                if(!skeleton) {
                    if(!creeper){
                        if(!Wither_Skeleton) {
                            world.setStorm(false);
                            world.setThundering(false);
                        }
                    }
                }
            }
        }
    }


    public void setZombieStats(LivingEntity entity) {
        int hp = (int) entity.getHealth();
        int maxhp = (int) entity.getMaxHealth();
        entity.setCustomName("king_zombie"+ ChatColor.RED   +" ❤" + ChatColor.RED + hp + " / " + ChatColor.GREEN + maxhp);                        // [king_zombie hp:20/20]
        entity.setMaxHealth(1000.0);//최대 체력 설정
        entity.setHealth(1000.0);//현재 체력 설정
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000000, 10));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,1000000, 10));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1000000, 300));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,1000000, 1));
        entity.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        entity.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
        entity.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
        entity.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
        if(hp == 0) {
            zombie = false;
            Location l = entity.getLocation();
            World world = entity.getWorld();
            world.strikeLightning(l);
            if(!zombie) {
                if(!skeleton) {
                    if(!creeper){
                        if(!Wither_Skeleton) {
                            world.setStorm(false);
                            world.setThundering(false);
                        }
                    }
                }
            }
        }
    }

    public void setCreeperStats(LivingEntity entity) {
        int hp = (int) entity.getHealth();
        int maxhp = (int) entity.getMaxHealth();
        entity.setCustomName("king_creeper"+ ChatColor.RED   +" ❤" + ChatColor.RED + hp + " / " + ChatColor.GREEN + maxhp);
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000000, 100));
        entity.getEquipment().setItemInHand(new ItemStack(Material.NETHERITE_SWORD));
        if(hp == 0) {
            creeper = false;
            Location l = entity.getLocation();
            World world = entity.getWorld();
            world.strikeLightning(l);
            if(!zombie) {
                if(!skeleton) {
                    if(!creeper){
                        if(!Wither_Skeleton) {
                            world.setStorm(false);
                            world.setThundering(false);
                        }
                    }
                }
            }
        }
    }

    public void setSkeletonStats(LivingEntity entity) {
        int hp = (int) entity.getHealth();
        int maxhp = (int) entity.getMaxHealth();
        entity.setCustomName("king_skeleton"+ ChatColor.RED   +" ❤" + ChatColor.RED + hp + " / " + ChatColor.GREEN + maxhp);
        entity.setMaxHealth(1000.0);//최대 체력 설정
        entity.setHealth(1000.0);//현재 체력 설정
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000000, 10));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,1000000, 10));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1000000, 100));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,1000000, 1));
        entity.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        entity.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
        entity.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
        entity.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
        entity.getEquipment().setItemInHand(new ItemStack(Material.BOW));
        if(hp == 0) {
            skeleton = false;
            Location l = entity.getLocation();
            World world = entity.getWorld();
            world.strikeLightning(l);
            if(!zombie) {
                if(!skeleton) {
                    if(!creeper){
                        if(!Wither_Skeleton) {
                            world.setStorm(false);
                            world.setThundering(false);
                        }
                    }
                }
            }
        }
    }
    public void setwitchStats(LivingEntity entity) {
        int maxhp = (int) entity.getMaxHealth();
        int hp = (int) entity.getHealth();
        entity.setCustomName("queen_witch"+ ChatColor.RED   +" ❤" + ChatColor.RED + hp + " / " + ChatColor.GREEN + maxhp);
        entity.setMaxHealth(1000.0);//최대 체력 설정
        entity.setHealth(1000.0);//현재 체력 설정
        entity.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,1000000, 10));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,1000000, 10));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST,1000000, 100));
        entity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING,1000000, 1));
        entity.getEquipment().setHelmet(new ItemStack(Material.NETHERITE_HELMET));
        entity.getEquipment().setChestplate(new ItemStack(Material.NETHERITE_CHESTPLATE));
        entity.getEquipment().setLeggings(new ItemStack(Material.NETHERITE_LEGGINGS));
        entity.getEquipment().setBoots(new ItemStack(Material.NETHERITE_BOOTS));
        if(hp == 0) {
            witch = false;
            Location l = entity.getLocation();
            World world = entity.getWorld();
            world.strikeLightning(l);
            if(!zombie) {
                if(!skeleton) {
                    if(!creeper){
                        if(!Wither_Skeleton) {
                            world.setStorm(false);
                            world.setThundering(false);
                        }
                    }
                }
            }
        }
    }
}
