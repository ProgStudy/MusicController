# MusicController
## This plugin allows you to control sounds in players

--------------------------------------------

#### Permissions:
music.command.play:
<br>default: op
<br>music.command.stop:
<br>default: op

-----------------------------------------------------

#### Commands:
/music-start <song> <player> - starts the sound, if the additional argument <player> is specified, then the sound will be launched only for a specific player.
<br>/music-stop <song> <player> - stops the sound, if the optional argument <player> is specified, the sound will be stopped only for a specific player.

-----------------------------------------------------

#### Other information:
- it is possible to control sounds using the API, for example, to cause all players to sound
examples start sound API:
```java
MusicControllerApi.play('random.hurt'); // send start sound all players

MusicControllerApi.play(player, 'random.explode'); // send start sound only player

MusicControllerApi.stop('random.hurt'); // send stop sound all players

MusicControllerApi.stop(player, 'random.explode'); // send stop sound only player
```
- at the moment the sound can be started and stopped, there is no pause of sound yet
- you can play sounds or music from the resource pack downloaded by the player (.mcpack) from the server, for example take my resource pack with music, it will be in the root of the project (github), this resource pack is called EpicMusic.mcpack
```txt
music tracks in the resource pack EpicMusic.mcpack:
- song.login
- song.waitgame
- song.alpha1
- song.alpha2
- song.alpha3
- song.alpha4
- song.alpha5

example command the start music - /music-start song.login

this server-side resourcepack (EpicMusic.mcpack) must be put in the resource_packs directory.
```
