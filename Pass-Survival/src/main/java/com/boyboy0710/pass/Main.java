package com.boyboy0710.pass;

import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import net.minecraft.server.v1_16_R2.ItemMapEmpty;

public final class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        System.out.println("----------------------------------------------------------");
        System.out.println("    pass 를러그인을 성공적으로 불러왔습니다");
        System.out.println("        플러그인 제작자ㅣ:boyboy0710");
        System.out.println("----------------------------------------------------------");

        ItemStack wood = new ItemStack(Material.PAPER, 1);
        ItemMeta wood_meta = wood.getItemMeta();
        wood_meta.setDisplayName("나무 세트 이용권");
        wood_meta.setLore(Arrays.asList("우클릭하면 아이템이 나옵니다"));
        wood.setItemMeta(wood_meta);

        ItemStack stone = new ItemStack(Material.PAPER, 1);
        ItemMeta stone_meta = stone.getItemMeta();
        stone_meta.setDisplayName("돌 세트 이용권");
        stone_meta.setLore(Arrays.asList("우클릭하면 아이템이 나옵니다"));
        stone.setItemMeta(stone_meta);

        ItemStack iron_armor = new ItemStack(Material.PAPER, 1);
        ItemMeta iron_armor_meta = iron_armor.getItemMeta();
        iron_armor_meta.setDisplayName("철 갑옷 세트 이용권");
        iron_armor_meta.setLore(Arrays.asList("우클릭하면 아이탬이 나옵니다"));
        iron_armor.setItemMeta(iron_armor_meta);

        ItemStack iron = new ItemStack(Material.PAPER, 1);
        ItemMeta iron_Meta = iron.getItemMeta();
        iron_Meta.setDisplayName("철 도구 이용권");
        iron_Meta.setLore(Arrays.asList("우클릭하면 아이템이 나옵니다"));
        iron.setItemMeta(iron_Meta);

        ItemStack diamond = new ItemStack(Material.PAPER, 1);
        ItemMeta dia_meta = diamond.getItemMeta();
        dia_meta.setDisplayName("다이아도구 이용권");
        dia_meta.setLore(Arrays.asList("우클릭하면 아이템이 나옵니다"));
        diamond.setItemMeta(dia_meta);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe wood_pass1 = new ShapedRecipe(new ItemStack(wood)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.ACACIA_WOOD, 5).setIngredient('B', Material.PAPER);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe wood_pass2 = new ShapedRecipe(new ItemStack(wood)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.BIRCH_WOOD, 5).setIngredient('B', Material.PAPER);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe wood_pass3 = new ShapedRecipe(new ItemStack(wood)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.DARK_OAK_WOOD, 5).setIngredient('B', Material.PAPER);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe wood_pass4 = new ShapedRecipe(new ItemStack(wood)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.JUNGLE_WOOD, 5).setIngredient('B', Material.PAPER);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe wood_pass5 = new ShapedRecipe(new ItemStack(wood)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.OAK_WOOD, 5).setIngredient('B', Material.PAPER);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe wood_pass6 = new ShapedRecipe(new ItemStack(wood)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.SPRUCE_WOOD, 5).setIngredient('B', Material.PAPER);


        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe stone_pass1 = new ShapedRecipe(new ItemStack(stone)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.STONE, 5).setIngredient('B', Material.PAPER);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe stone_pass2 = new ShapedRecipe(new ItemStack(stone)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.COBBLESTONE, 5).setIngredient('B', Material.PAPER);


        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe iron_armor_pass1 = new ShapedRecipe(new ItemStack(iron_armor)).shape(new String[] {"AAA","   ","   "})
                .setIngredient('A', Material.IRON_BLOCK);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe iron_armor_pass2 = new ShapedRecipe(new ItemStack(iron_armor)).shape(new String[] {"   ","AAA","   "})
                .setIngredient('A', Material.IRON_BLOCK);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe iron_armor_pass3 = new ShapedRecipe(new ItemStack(iron_armor)).shape(new String[] {"   ","   ","AAA"})
                .setIngredient('A', Material.IRON_BLOCK);

        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe iron_pass = new ShapedRecipe(new ItemStack(iron)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.IRON_INGOT, 5).setIngredient('B', Material.PAPER);


        getServer().getPluginManager().registerEvents(this, this); //플러그인 시작 시, 만든 이벤트 작동하도록 함.
        ShapedRecipe dia_pass = new ShapedRecipe(new ItemStack(diamond)).shape(new String[] {"AAA","ABA","AAA"})
                .setIngredient('A', Material.DIAMOND, 5).setIngredient('B', Material.PAPER);

        getServer().addRecipe(wood_pass1);
        getServer().addRecipe(wood_pass2);
        getServer().addRecipe(wood_pass3);
        getServer().addRecipe(wood_pass4);
        getServer().addRecipe(wood_pass5);
        getServer().addRecipe(wood_pass6);
        getServer().addRecipe(stone_pass1);
        getServer().addRecipe(stone_pass2);
        getServer().addRecipe(iron_armor_pass1);
        getServer().addRecipe(iron_armor_pass2);
        getServer().addRecipe(iron_armor_pass3);
        getServer().addRecipe(iron_pass);
        getServer().addRecipe(dia_pass);
    }

    @Override
    public void onDisable() {
        System.out.println("pass 플러그인이 비활성화 되었습니다");
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        ItemStack wood = new ItemStack(Material.PAPER, 1);
        ItemMeta wood_meta = wood.getItemMeta();
        wood_meta.setDisplayName("나무 세트 이용권");
        wood_meta.setLore(Arrays.asList("우클릭하면 아이템이 나옵니다"));
        wood.setItemMeta(wood_meta);

        ItemStack stone = new ItemStack(Material.PAPER, 1);
        ItemMeta stone_meta = stone.getItemMeta();
        stone_meta.setDisplayName("돌 세트 이용권");
        stone_meta.setLore(Arrays.asList("우클릭하면 아이템이 나옵니다"));
        stone.setItemMeta(stone_meta);

        ItemStack iron_armor = new ItemStack(Material.PAPER, 1);
        ItemMeta iron_armor_meta = iron_armor.getItemMeta();
        iron_armor_meta.setDisplayName("철 갑옷 세트 이용권");
        iron_armor_meta.setLore(Arrays.asList("우클릭하면 아이탬이 나옵니다"));
        iron_armor.setItemMeta(iron_armor_meta);

        ItemStack iron = new ItemStack(Material.PAPER, 1);
        ItemMeta iron_Meta = iron.getItemMeta();
        iron_Meta.setDisplayName("철 도구 이용권");
        iron_Meta.setLore(Arrays.asList("우클릭하면 아이템이 나옵니다"));
        iron.setItemMeta(iron_Meta);

        ItemStack diamond = new ItemStack(Material.PAPER, 1);
        ItemMeta dia_meta = diamond.getItemMeta();
        dia_meta.setDisplayName("다이아도구 이용권");
        dia_meta.setLore(Arrays.asList("우클릭하면 아이템이 나옵니다"));
        diamond.setItemMeta(dia_meta);

        if(e.getAction() == Action.RIGHT_CLICK_AIR|| e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(e.getItem() == wood) {
                p.getInventory().removeItem(wood);
                p.sendMessage(ChatColor.GREEN + "나무세트를 지급하였습니다");
                p.getInventory().addItem(new ItemStack(Material.WOODEN_AXE));
                p.getInventory().addItem(new ItemStack(Material.WOODEN_HOE));
                p.getInventory().addItem(new ItemStack(Material.WOODEN_PICKAXE));
                p.getInventory().addItem(new ItemStack(Material.WOODEN_SHOVEL));
                p.getInventory().addItem(new ItemStack(Material.WOODEN_SWORD));
            }
            if(e.getItem() == stone) {
                p.getInventory().removeItem(stone);
                p.sendMessage(ChatColor.GREEN + "돌 세트를 지급했습니다");
                p.getInventory().addItem(new ItemStack(Material.STONE_AXE));
                p.getInventory().addItem(new ItemStack(Material.STONE_HOE));
                p.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE));
                p.getInventory().addItem(new ItemStack(Material.STONE_SHOVEL));
                p.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
            }
            if(e.getItem() == iron_armor) {
                p.getInventory().removeItem(iron_armor);
                p.sendMessage(ChatColor.GREEN + "철 갑옷 세트를 지급하였습니다");
                p.getInventory().addItem(new ItemStack(Material.IRON_BOOTS));
                p.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE));
                p.getInventory().addItem(new ItemStack(Material.IRON_HELMET));
                p.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS));
            }
            if(e.getItem() == iron) {
                p.getInventory().removeItem(iron);
                p.sendMessage(ChatColor.GREEN + "철 세트를 지급했습니다");
                p.getInventory().addItem(new ItemStack(Material.IRON_AXE));
                p.getInventory().addItem(new ItemStack(Material.IRON_HOE));
                p.getInventory().addItem(new ItemStack(Material.IRON_PICKAXE));
                p.getInventory().addItem(new ItemStack(Material.IRON_SHOVEL));
                p.getInventory().addItem(new ItemStack(Material.IRON_SWORD));
            }
            if(e.getItem() == diamond) {
                p.getInventory().removeItem(diamond);
                p.sendMessage(ChatColor.GREEN + "나무세트를 지급하였습니다");
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_HOE));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_SHOVEL));
                p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD));
            }
        }
    }

}
