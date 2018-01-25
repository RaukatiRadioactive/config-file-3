package br.com.seudominio.config;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import br.com.seudominio.template.Main;

public class MsgConfig {

	Main plugin;

	public void createConfig(Main plugin) {
		if (!plugin.getDataFolder().exists()) {
			plugin.getDataFolder().mkdirs();
		}
		File file = new File(plugin.getDataFolder(), "config.yml");
		if (!file.exists()) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[Template] " + ChatColor.YELLOW + "Arquivo <config.yml> nao encontrado. Criando estrutura default.");
			plugin.saveDefaultConfig();
		} else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[Template] " + ChatColor.YELLOW + "Arquivo <config.yml> encontrado! Carregando estrutura default.");
		}
	}

	public String getMsgLogin(Main plugin) {
		String s = plugin.getConfig().getString("messages.login");
		return s;
	}

	public String getMsgLogout(Main plugin) {
		String s = plugin.getConfig().getString("messages.logout");
		return s;
	}

	public String getMsgDeath(Main plugin) {
		String s = plugin.getConfig().getString("messages.death");
		return s;
	}

	public void setMsgLogin(Main plugin, String s) {
		plugin.getConfig().set("messages.login", s);
		plugin.saveConfig();
	}

	public void setMsgLogout(Main plugin, String s) {
		plugin.getConfig().set("messages.logout", s);
		plugin.saveConfig();
	}

	public void setMsgDeath(Main plugin, String s) {
		plugin.getConfig().set("messages.death", s);
		plugin.saveConfig();
	}
}
