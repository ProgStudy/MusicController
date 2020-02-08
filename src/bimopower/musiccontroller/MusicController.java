package bimopower.musiccontroller;

import bimopower.musiccontroller.commands.PlayCommand;
import bimopower.musiccontroller.commands.StopCommand;
import cn.nukkit.Player;
import cn.nukkit.command.CommandMap;
import cn.nukkit.network.protocol.PlaySoundPacket;
import cn.nukkit.network.protocol.StopSoundPacket;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.MainLogger;

public class MusicController extends PluginBase {

    private static MusicController instance;

    @Override
    public void onLoad() {
        sendLog("Loading...",false);
        instance = this;
    }

    private void registerCommands() {
        CommandMap map = getServer().getCommandMap();
        map.register("MusicController", new PlayCommand(this));
        map.register("MusicController", new StopCommand(this));
    }

    @Override
    public void onEnable() {
        super.onEnable();
        sendLog("Registering commands...",false);
        registerCommands();
        sendLog("Registering commands (OK)",false);
        sendLog("Enabled plugin",false);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        sendLog("Disabled plugin",false);
    }

    public static void playSound(Player player, String song) {
        PlaySoundPacket playSoundPacket = new PlaySoundPacket();
        playSoundPacket.name = song;
        playSoundPacket.x = (int) player.x;
        playSoundPacket.y = (int) player.y;
        playSoundPacket.z = (int) player.z;

        playSoundPacket.volume = 1;
        playSoundPacket.pitch = 1;

        player.dataPacket(playSoundPacket);
    }

    public static void playSound(String song) {

        for(Player player : MusicController.instance.getServer().getOnlinePlayers().values()) {
            PlaySoundPacket playSoundPacket = new PlaySoundPacket();
            playSoundPacket.name = song;
            playSoundPacket.x = (int) player.x;
            playSoundPacket.y = (int) player.y;
            playSoundPacket.z = (int) player.z;

            playSoundPacket.volume = 1;
            playSoundPacket.pitch = 1;

            player.dataPacket(playSoundPacket);
        }
    }

    public static void stopSound(Player player, String song) {
        StopSoundPacket stopSoundPacket = new StopSoundPacket();

        stopSoundPacket.name = song;
        stopSoundPacket.stopAll = false;

        player.dataPacket(stopSoundPacket);
    }

    public static void stopSound(String song) {
        for(Player player : MusicController.instance.getServer().getOnlinePlayers().values()) {
            StopSoundPacket stopSoundPacket = new StopSoundPacket();

            stopSoundPacket.name = song;
            stopSoundPacket.stopAll = false;

            player.dataPacket(stopSoundPacket);
        }
    }


    private static void sendLog(String s, boolean err){
        if(err) MainLogger.getLogger().alert(s);
        else MainLogger.getLogger().info(s);
    }

    public static MusicController getInstance() {
        return instance;
    }
}
