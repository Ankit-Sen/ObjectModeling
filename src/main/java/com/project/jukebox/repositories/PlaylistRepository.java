package com.project.jukebox.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.project.jukebox.entities.Playlist;

public class PlaylistRepository implements IPlaylistRepository {

    private final Map<String,Playlist> playlistMap;
    private Integer autoIncrement = 0;

    
    
    public PlaylistRepository() {
        playlistMap = new HashMap<String,Playlist>();
    }

    public PlaylistRepository(Map<String, Playlist> playlistMap) {
        this.playlistMap = playlistMap;
        this.autoIncrement = playlistMap.size();
    }

    @Override
    public Playlist save(Playlist entity) {
        
        if( entity.getId() == null ){
            autoIncrement++;
            Playlist c = new Playlist(Integer.toString(autoIncrement),entity.getPlaylistName(),entity.getPlaySongs());
            playlistMap.put(c.getId(),c);
            return c;
        }
        playlistMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Playlist findById(String id){
       return playlistMap.getOrDefault(id, null);
    }

    @Override
    public boolean existsById(String id) {
        
        if(playlistMap.containsKey(id))
        return true;
        return false;
        
    }

    @Override
    public void delete(Playlist entity) {
        
        if(playlistMap.containsValue(entity)){
            String foundKey = null;
            for (Map.Entry<String, Playlist> entry : playlistMap.entrySet()) {
                if (entry.getValue().equals(entity)) {
                    foundKey = entry.getKey();
                    break;
                }
            }
            playlistMap.remove(foundKey);
            } 
    }

    @Override
    public void deleteById(String id) {
        
        for(Playlist each : playlistMap.values()){
            if(each.getId().equals(id)){
                String foundKey = null;
            for (Map.Entry<String, Playlist> entry : playlistMap.entrySet()) {
                if (entry.getValue().getId().equals(id)) {
                    foundKey = entry.getKey();
                    break;
                }
            }
            playlistMap.remove(foundKey);
        }   
    }
    }

    @Override
    public long count() {
        
        return playlistMap.size();
    }

    @Override
    public Optional<Playlist> findByName(String name) {
        for(Playlist playlist : playlistMap.values()){
            if(playlist.getPlaylistName()==name)
            return Optional.of(playlist);
        }
 return Optional.ofNullable(null);
}

    @Override
    public List<Playlist> findAll() {

        List<Playlist> allPlaylists = new ArrayList<>();
            for(Playlist each : playlistMap.values()){
                allPlaylists.add(each);
            }
     return allPlaylists;
    }
}

