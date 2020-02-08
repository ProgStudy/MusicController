package bimopower.musiccontroller.commands;

import bimopower.musiccontroller.MusicController;
import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.command.data.CommandParamType;
import cn.nukkit.command.data.CommandParameter;
import cn.nukkit.plugin.Plugin;

public class StopCommand extends Command {

    Plugin plugin;

    public StopCommand(Plugin plugin) {
        super("music-stop","Stop the music","/music-stop <song>");
        this.commandParameters.clear();
        this.commandParameters.put("default", new CommandParameter[]{new CommandParameter("song", CommandParamType.STRING, false),new CommandParameter("player", CommandParamType.TARGET, false)});
        this.setPermission("music.command.stop");
        this.plugin = plugin;
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!this.testPermission(sender)) {
            sender.sendMessage("denied not access the permission");
            return true;
        }

        if(args.length < 1){
            sender.sendMessage("/music stop <song> <player>");
            return true;
        }

        if(args.length > 1){
            Player player = plugin.getServer().getPlayer(args[1]);

            if(player == null){
                sender.sendMessage("not found the player");
                return true;
            }
            MusicController.stopSound(player, args[0]);
        }
        else MusicController.stopSound(args[0]);

        sender.sendMessage("ok");
        return true;
    }
}
