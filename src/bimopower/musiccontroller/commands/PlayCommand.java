package bimopower.musiccontroller.commands;

import bimopower.musiccontroller.MusicController;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.plugin.Plugin;

public class PlayCommand extends Command{

    Plugin plugin;

    public PlayCommand(Plugin plugin) {
        super("music-start");
        this.description = "Play the music";
        this.usageMessage = "/music start <song> <player>";
        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{new CommandParameter("song", CommandParamType.STRING, false),new CommandParameter("player", CommandParamType.TARGET, false)});
        this.setPermission("music.command.play");
        this.plugin = plugin;

    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {
            sender.sendMessage("denied not access the permission");
            return true;
        }

        if(args.length < 1){
            sender.sendMessage("/music start <song> <player>");
            return true;
        }

        if(args.length > 1){
            Player player = plugin.getServer().getPlayer(args[1]);
            if(player == null){
                sender.sendMessage("not found the player");
                return true;
            }
            MusicController.playSound(player, args[0]);
        }
        else MusicController.playSound(args[0]);

        sender.sendMessage("ok");
        return true;
    }
}
