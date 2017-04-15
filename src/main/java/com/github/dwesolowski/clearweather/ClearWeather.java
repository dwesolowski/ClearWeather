package com.github.dwesolowski.clearweather;

import com.github.dwesolowski.clearweather.listeners.OnWeatherChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ClearWeather extends JavaPlugin {

    public final List<String> allowedWorlds = getConfig().getStringList("Worlds");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OnWeatherChangeEvent(this), this);
        saveDefaultConfig();

        for (World w : Bukkit.getWorlds()) {
            if (allowedWorlds.contains(w.getName())) {
                w.setStorm(false);
            }
        }
    }
}
