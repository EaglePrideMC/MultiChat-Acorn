package com.olivermartin410.plugins.commands;

import com.olivermartin410.plugins.MultiChat;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

/**
 * Local Chat Command
 * <p>Players can use this command to only see the chat sent from players on their current server</p>
 * 
 * @author Oliver Martin (Revilo410)
 *
 */
public class LocalCommand extends Command {

	private static String[] aliases = new String[] {};

	public LocalCommand() {
		super("local", "multichat.chat.mode", aliases);
	}

	public void execute(CommandSender sender, String[] args) {

		if ((sender instanceof ProxiedPlayer)) {

			MultiChat.globalplayers.remove(((ProxiedPlayer)sender).getUniqueId());
			MultiChat.globalplayers.put(((ProxiedPlayer)sender).getUniqueId(), Boolean.valueOf(false));

			sender.sendMessage(new ComponentBuilder("LOCAL CHAT ENABLED").color(ChatColor.DARK_AQUA).create());
			sender.sendMessage(new ComponentBuilder("You will only see messages from players on the same server!").color(ChatColor.AQUA).create());

		} else {
			sender.sendMessage(new ComponentBuilder("Only players can change their chat state").color(ChatColor.RED).create());
		}
	}
}
