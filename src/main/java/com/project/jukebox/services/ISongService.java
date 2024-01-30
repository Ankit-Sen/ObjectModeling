package com.project.jukebox.services;

import java.util.List;
import com.project.jukebox.entities.ArtistType;
import com.project.jukebox.entities.Genre;
import com.project.jukebox.entities.Song;

public interface ISongService {

    public Song add(String name,Genre genre,String album,List<String> artist,ArtistType artistType);
    public void remove(String name);
    
}
