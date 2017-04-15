package com.github.dwesolowski.clearweather.listeners;

import com.github.dwesolowski.clearweather.ClearWeather;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class OnWeatherChangeEvent implements Listener {

    private final ClearWeather plugin;

    public OnWeatherChangeEvent(ClearWeather plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onWeatherChangeEvent(WeatherChangeEvent e) {
        if (this.plugin.allowedWorlds.contains(e.getWorld().getName())) {
            if (e.toWeatherState()) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onThunderChange(ThunderChangeEvent e) {
        if (this.plugin.allowedWorlds.contains(e.getWorld().getName())) {
            if (e.toThunderState()) {
                e.setCancelled(true);
            }
        }
    }
}