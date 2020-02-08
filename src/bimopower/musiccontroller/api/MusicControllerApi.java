package bimopower.musiccontroller.api;

import bimopower.musiccontroller.MusicController;
import cn.nukkit.Player;

public class MusicControllerApi {

    public static boolean play(Player player, String song) {
        if(!player.isOnline()) return false;
        MusicController.playSound(player,song);
        return true;
    }

    public static boolean stop(Player player, String song) {
        if(!player.isOnline()) return false;
        MusicController.stopSound(player,song);
        return true;
    }

    public static void play(String song) {
        MusicController.playSound(song);
    }

    public static void stop(String song) {
        MusicController.stopSound(song);
    }
}
