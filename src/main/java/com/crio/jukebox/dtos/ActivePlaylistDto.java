package com.crio.jukebox.dtos;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.entities.Song;

public class ActivePlaylistDto {

    private final String playlistName;
    private final String playlistId;
    private final List<Song> songs;

    public ActivePlaylistDto(String Id,String playlistName, List<Song> songResultList) {
        this.playlistId=Id;
        this.playlistName = playlistName;
        this.songs = songResultList;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public String getPlaylistId(){
        return playlistId;
    }

    public List<String> getSongIds(){
        List<String> ids=new ArrayList<>();
        for(Song song:songs)
        ids.add(song.getId());
        return ids;
        }

    @Override
    public String toString() {
        return "Playlist ID - " + playlistId + "\nPlaylist Name -" + playlistName + "\nSong IDs - " + getSongIds();
    }
    
}
