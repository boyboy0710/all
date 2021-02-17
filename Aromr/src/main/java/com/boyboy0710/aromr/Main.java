package com.boyboy0710.aromr;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin implements Listener{

    public void onEnable() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("            armor 를러그인을 성공적으로 불러왔습니다");
        System.out.println("               플러그인 제작자ㅣ:booyboy0710");
        System.out.println("    죄신버전 다운사이트 : https://github.com/boyboy0710/Armor");
        System.out.println(" 선택 플러그인 : mob (다운사이트 : https://github.com/boyboy0710/mob)");
        System.out.println("----------------------------------------------------------------------");
    }
    @Override
    public void onDisable() {
        System.out.println("mob 플러그인이 비활성화 되었습니다");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        p.sendMessage("최신버전 다운사이트 : https://github.com/boyboy0710/Armor");
    }

    //------------------------------------------------------------------------------------------------------------------------------------
    //player
    int h = 0;
    int c = 0;
    int b = 0;
    int l = 0;
    int hp = 20;
    int e = 0;



    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if(cmd.getName().equalsIgnoreCase("time_and_weather")) {
            World w = p.getWorld();
            w.setStorm(false);
            w.setThundering(false);
            w.setTime(0);
            System.out.println("날씨가 맑아집니다");
            System.out.println("낮이 됩니다");
        }

        if(cmd.getName().equalsIgnoreCase("test")) {
            p.setHealth(1);
        }

        if(cmd.getName().equalsIgnoreCase("reloed_Health")) {
            if(Objects.requireNonNull(p.getInventory().getBoots()).getType() == Material.NETHERITE_BOOTS) {
                b = 4;
            }
            if(p.getInventory().getBoots().getType() == Material.DIAMOND_BOOTS) {
                b = 3;
            }
            if(p.getInventory().getBoots().getType() == Material.GOLDEN_BOOTS) {
                b = 2;
            }
            if(p.getInventory().getBoots().getType() == Material.IRON_BOOTS) {

                b = 2;
            }
            if(p.getInventory().getBoots().getType() == Material.CHAINMAIL_BOOTS) {
                b = 1;
            }
            if(p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS) {
                b = 1;
            }
            if(p.getInventory().getBoots().getType() == Material.AIR) {
                b = 0;
            }


            if(Objects.requireNonNull(p.getInventory().getChestplate()).getType() == Material.NETHERITE_CHESTPLATE) {
                c = 4;
            }
            if(p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE) {
                c = 3;
            }
            if(p.getInventory().getChestplate().getType() == Material.GOLDEN_CHESTPLATE) {
                c = 2;
            }
            if(p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE) {
                c = 2;
            }
            if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE) {
                c = 1;
            }
            if(p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE) {
                c = 1;
            }
            if(p.getInventory().getChestplate().getType() == Material.AIR) {
                c = 0;
            }

            if(Objects.requireNonNull(p.getInventory().getHelmet()).getType() == Material.AIR) {
                h = 0;
            }
            if(p.getInventory().getHelmet().getType() == Material.NETHERITE_HELMET) {
                h = 4;
            }
            if(p.getInventory().getHelmet().getType() == Material.DIAMOND_HELMET) {
                h = 3;
            }
            if(p.getInventory().getHelmet().getType() == Material.GOLDEN_HELMET) {
                h = 2;
            }
            if(p.getInventory().getHelmet().getType() == Material.IRON_HELMET) {
                h = 2;
            }
            if(p.getInventory().getHelmet().getType() == Material.CHAINMAIL_HELMET) {
                h = 1;
            }
            if(p.getInventory().getHelmet().getType() == Material.LEATHER_HELMET) {
                h = 1;
            }


            if(Objects.requireNonNull(p.getInventory().getLeggings()).getType() == Material.AIR) {
                l = 0;
            }
            if(p.getInventory().getLeggings().getType() == Material.NETHERITE_LEGGINGS) {
                l = 4;
            }
            if(p.getInventory().getLeggings().getType() == Material.DIAMOND_LEGGINGS) {
                l = 3;
            }
            if(p.getInventory().getLeggings().getType() == Material.GOLDEN_LEGGINGS) {
                l = 2;
            }
            if(p.getInventory().getLeggings().getType() == Material.IRON_LEGGINGS) {
                l = 2;
            }
            if(p.getInventory().getLeggings().getType() == Material.CHAINMAIL_LEGGINGS) {
                l = 1;
            }
            if(p.getInventory().getLeggings().getType() == Material.LEATHER_LEGGINGS) {
                l = 1;
            }
            e = l+h+c+b + hp;
            p.setMaxHealth(e);
        }

        if(cmd.getName().equalsIgnoreCase("MaxHealth")) {
            p.sendMessage("체력회복중......");
            ItemStack head =  p.getInventory().getHelmet();
            int ph = (int) p.getHealth();
            p.setHealth(ph);
            p.getInventory().setHelmet(new ItemStack(Material.GOLD_BLOCK));
            if(p.getHealth() != e) {
                ph = ph + 1;
                p.setHealth(ph);
                p.getInventory().setHelmet(new ItemStack(Material.AIR));
            }
            if(p.getHealth() == e) {
                p.getInventory().setHelmet(head);
            }
        }
        return false;
    }

    @EventHandler
    public void onInteract(PlayerLevelChangeEvent ev) {
        Player p = ev.getPlayer();
        int level = p.getLevel();
        e = l+h+c+b+ level + hp;
        p.setMaxHealth(e);
    }

    @EventHandler
    public void onInteract(PlayerRespawnEvent ev) {
        Player p = ev.getPlayer();
        if(Objects.requireNonNull(p.getInventory().getBoots()).getType() == Material.NETHERITE_BOOTS) {
            b = 4;
        }
        if(p.getInventory().getBoots().getType() == Material.DIAMOND_BOOTS) {
            b = 3;
        }
        if(p.getInventory().getBoots().getType() == Material.GOLDEN_BOOTS) {
            b = 2;
        }
        if(p.getInventory().getBoots().getType() == Material.IRON_BOOTS) {
            b = 2;
        }
        if(p.getInventory().getBoots().getType() == Material.CHAINMAIL_BOOTS) {
            b = 1;
        }
        if(p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS) {
            b = 1;
        }
        if(p.getInventory().getBoots().getType() == Material.AIR) {
            b = 0;
        }


        if(Objects.requireNonNull(p.getInventory().getChestplate()).getType() == Material.NETHERITE_CHESTPLATE) {
            c = 4;
        }
        if(p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE) {
            c = 3;
        }
        if(p.getInventory().getChestplate().getType() == Material.GOLDEN_CHESTPLATE) {
            c = 2;
        }
        if(p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE) {
            c = 2;
        }
        if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE) {
            c = 1;
        }
        if(p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE) {
            c = 1;
        }
        if(p.getInventory().getChestplate().getType() == Material.AIR) {
            c = 0;
        }

        if(Objects.requireNonNull(p.getInventory().getHelmet()).getType() == Material.AIR) {
            h = 0;
        }
        if(p.getInventory().getHelmet().getType() == Material.NETHERITE_HELMET) {
            h = 4;
        }
        if(p.getInventory().getHelmet().getType() == Material.DIAMOND_HELMET) {
            h = 3;
        }
        if(p.getInventory().getHelmet().getType() == Material.GOLDEN_HELMET) {
            h = 2;
        }
        if(p.getInventory().getHelmet().getType() == Material.IRON_HELMET) {
            h = 2;
        }
        if(p.getInventory().getHelmet().getType() == Material.CHAINMAIL_HELMET) {
            h = 1;
        }
        if(p.getInventory().getHelmet().getType() == Material.LEATHER_HELMET) {
            h = 1;
        }


        if(Objects.requireNonNull(p.getInventory().getLeggings()).getType() == Material.AIR) {
            l = 0;
        }
        if(p.getInventory().getLeggings().getType() == Material.NETHERITE_LEGGINGS) {
            l = 4;
        }
        if(p.getInventory().getLeggings().getType() == Material.DIAMOND_LEGGINGS) {
            l = 3;
        }
        if(p.getInventory().getLeggings().getType() == Material.GOLDEN_LEGGINGS) {
            l = 2;
        }
        if(p.getInventory().getLeggings().getType() == Material.IRON_LEGGINGS) {
            l = 2;
        }
        if(p.getInventory().getLeggings().getType() == Material.CHAINMAIL_LEGGINGS) {
            l = 1;
        }
        if(p.getInventory().getLeggings().getType() == Material.LEATHER_LEGGINGS) {
            l = 1;
        }
        e =l+h+c+b+ hp;
        p.setMaxHealth(e);
    }

}
