package com.bilicraft.blockpartyteleporttospectator;

import com.gmail.nossr50.events.party.McMMOPartyTeleportEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockPartyTeleportToSpectator extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getPluginManager().registerEvents(this,this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = true)
    public void onPartyTeleport(McMMOPartyTeleportEvent event){
        if(event.getTarget().getGameMode() == GameMode.SPECTATOR){
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED+"您无法使用队内传送功能传送到处于旁观模式的玩家位置");
        }
    }
}
