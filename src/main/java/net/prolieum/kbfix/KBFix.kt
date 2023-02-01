package net.prolieum.kbfix

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class KBFix : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic

        Bukkit.getPluginManager().registerEvents(Listener(), this)
        logger.info("Ready!")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}