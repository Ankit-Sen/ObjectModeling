package com.project.jukebox.entities;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseEntity {

    private String name;
    private List<Playlist> playlists;
    private UserPlaylistSongs userPlaylistSongs;
    private Playlist currentPlaylist;

    public User(String id,String name, List<Playlist> playlists){
        this(id,name);
        this.playlists=playlists;
    }

    public User(User user){
        this(user.id,user.name,user.playlists);
        this.userPlaylistSongs=user.userPlaylistSongs;
    }

    public User(String id,String name){
        this(name);
        this.id=id;
        this.playlists=new ArrayList<>();
        this.userPlaylistSongs=new UserPlaylistSongs();
    }

    public User(String name){
        this.name=name;
    }

    public void setCurrentPlaylist(Playlist currePlaylist){
        this.currentPlaylist=currePlaylist;
    }

    public Playlist getCurrentPlaylist(){
        return currentPlaylist;
    }

    public String getName(){
        return name;
    }

    public void addPlaylist(Playlist playlist){
        playlists.add(playlist);
    }

    public void deletePlaylist(Playlist playlist){
        playlists.removeIf(c -> c.getId() == playlist.getId());
    }

    public boolean checkIfPlaylistExists(Playlist playlist){
        if(playlists.contains(playlist))
        return true;
        else
        return false;
    }

    public List<Song> getSongsByPlaylist(Playlist playlist){
        return userPlaylistSongs.getSongsByPlaylists(playlist);
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
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
        User other = (User) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
