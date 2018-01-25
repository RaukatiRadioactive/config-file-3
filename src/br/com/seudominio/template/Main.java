package br.com.seudominio.template;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import br.com.seudominio.config.MsgConfig;

public class Main extends JavaPlugin implements Listener {

	public static Main m;
	public PluginManager pm = Bukkit.getPluginManager();
	private MsgConfig cfg;

	MsgConfig mcfg = new MsgConfig();

	public MsgConfig getConfigs() {
		return this.cfg;
	}

	public void onLoad() {
		m = this;
	}

	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[Template] " + ChatColor.GREEN + "Plugin Ativado");
		pm.registerEvents(this, this);
		mcfg.createConfig(m);
		mcfg.setMsgDeath(m, "Morreu por que era desastrado!");
	}

	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[Template] " + ChatColor.RED + "Plugin Desativado");
	}

	@EventHandler
	public void JoinMessage(PlayerJoinEvent e) {
		e.setJoinMessage(ChatColor.AQUA + "[Template] " + e.getPlayer().getDisplayName() + " " + ChatColor.GREEN + mcfg.getMsgLogin(this));
	}

	@EventHandler
	public void QuitMessage(PlayerQuitEvent e) {
		e.setQuitMessage(ChatColor.AQUA + "[Template] " + e.getPlayer().getDisplayName() + " " + ChatColor.GREEN + mcfg.getMsgLogout(this));
	}

	@EventHandler
	public void DeathMessage(PlayerDeathEvent e) {
		e.setDeathMessage(ChatColor.AQUA + "[Template] " + e.getEntity().getDisplayName() + " " + ChatColor.RED + mcfg.getMsgDeath(this));
	}

}