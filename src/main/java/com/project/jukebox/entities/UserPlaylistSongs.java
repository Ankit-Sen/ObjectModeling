package com.project.jukebox.entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserPlaylistSongs {
    
    private final Map<Playlist,List<Song>> playlistSongsMap;

    public UserPlaylistSongs(){
        playlistSongsMap = new HashMap<Playlist,List<Song>>();
    }

    public UserPlaylistSongs(Map<Playlist, List<Song>> contestQuestionsMap) {
        this.playlistSongsMap = contestQuestionsMap;
    }

    public void addPlaylistSongs(Playlist playlist, List<Song> pList){
        playlistSongsMap.putIfAbsent(playlist, pList);
    }

    public List<Song> getSongsByPlaylists(Playlist playlist){
        return playlistSongsMap.get(playlist);
    }


    @Override
    public String toString() {
        return "UserPlaylistSongs [playlistSongsMap=" + playlistSongsMap + "]";
    }

}
