    package com.project.jukebox.entities;

import java.util.ArrayList;
import java.util.List;

public class Playlist extends BaseEntity {

    private String name;
    private List<Song> songs;
    private PlaylistStatus playlistStatus;
     

    public Playlist(Playlist playlist){
        this(playlist.name,playlist.songs);
        this.id=playlist.id;

    }

    public Playlist(String id, String name, List<Song> songs) {
        this(name, songs);
        this.id = id;
        this.playlistStatus = PlaylistStatus.NOT_ACTIVE;
    }
    
    public Playlist(String name, List<Song> songs) {
        this.name = name;
        this.songs = (songs != null) ? songs : new ArrayList<>();
        this.playlistStatus = PlaylistStatus.NOT_ACTIVE;
    }
    

    public String getPlaylistName(){
        return this.name;
    }

    public List<Song> getPlaySongs(){
        return this.songs;
    }

    public PlaylistStatus getPlaylistStatus(){
        return this.playlistStatus;
    }

    public void setPlaylistName(String name){
        this.name=name;
    }

    public void setPlaylistStatus(PlaylistStatus playlistStatus){
        this.playlistStatus=playlistStatus;
    }

    public void addSong(Song song) {
        if (songs != null) {
            songs.add(song);
        }
    }
    
    public void removeSong(Song song) {
        if (songs != null) {
            songs.remove(song);
        }
    }
    

    public boolean checkIfSongExists(String id){
        for(Song song : songs){
            if((song.getId()).equals(id))
            return true;
        }
        return false;
    }

    public int getSongCount(){
        return songs.size();
    }


    @Override
    public String toString() {
        return "Playlist ID - "+this.id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Playlist other = (Playlist) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
