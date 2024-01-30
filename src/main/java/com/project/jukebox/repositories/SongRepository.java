package com.project.jukebox.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.project.jukebox.entities.Song;
import com.project.jukebox.entities.SongStatus;

public class SongRepository implements ISongRepository{
    
    private final Map<String,Song> songMap;
    private Integer autoIncrement = 0;

    public SongRepository(){
        songMap = new HashMap<String,Song>();
    }

    public SongRepository(Map<String, Song> songMap) {
        this.songMap = songMap;
        this.autoIncrement = songMap.size();
    }

    @Override
    public Song save(Song entity) {

        if( entity.getId() == null ){
            autoIncrement++;
            Song q = new Song(Integer.toString(autoIncrement),entity.getName(),entity.getGenre(),entity.getAlbumName(),entity.getArtistName(),entity.getArtistType(),SongStatus.NOT_PLAYING);
            songMap.put(q.getId(),q);
            return q;
        }
        songMap.put(entity.getId(),entity);
        return entity;
    }

    @Override
    public Song findById(String id) {
        if(existsById(id))
        return songMap.get(id);
        else
        return null;
    }

    @Override
    public boolean existsById(String id) {
        
        if(songMap.containsKey(id))
        return true;
        else
        return false;
    }

    @Override
    public void delete(Song entity) {
        
        if(songMap.containsValue(entity)){
            String foundKey = null;
            for (Map.Entry<String, Song> entry : songMap.entrySet()) {
                if (entry.getValue().equals(entity)) {
                    foundKey = entry.getKey();
                    break;
                }
            }
            songMap.remove(foundKey);
            } 
    }

    @Override
    public void deleteById(String id) {
        // TODO Auto-generated method stub
        if(songMap.containsKey(id)){
            songMap.remove(id);
        }
    }

    @Override
    public long count() {
        return songMap.size();
    }

    @Override
    public Optional<Song> findByName(String name) {
        for(Song song : songMap.values()){
            if(name.equals(song.getName()))
            return Optional.of(song);
        }
 return Optional.ofNullable(null);
    }

    @Override
    public List<Song> findAll() {
        List<Song> allSongs = new ArrayList<>();
            for(Song each : songMap.values()){
                allSongs.add(each);
            }  
     return allSongs;
    }

    public List<Song> findAllSongsArtistWise(String artistName){

        List<Song> allSongs = new ArrayList<>();
        for(Song each : songMap.values()){
            if(each.getArtistName().equals(artistName))
            allSongs.add(each);
        }
        return allSongs;
    }

    public void readAll(List<Song> songs){
        for(Song song : songs){
            save(song);
        }
    }
   

}
