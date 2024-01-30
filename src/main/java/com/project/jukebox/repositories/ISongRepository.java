package com.project.jukebox.repositories;

import java.util.List;
import java.util.Optional;
import com.project.jukebox.entities.Song;

public interface ISongRepository extends CRUDRepository<Song,String>{

    public Optional<Song> findByName(String name);
    public void readAll(List<Song> songs);
    public List<Song> findAllSongsArtistWise(String name);
    
}
