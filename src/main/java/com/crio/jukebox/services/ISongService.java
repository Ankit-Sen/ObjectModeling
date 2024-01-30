package com.crio.jukebox.services;

import java.util.List;
import com.crio.jukebox.entities.ArtistType;
import com.crio.jukebox.entities.Genre;
import com.crio.jukebox.entities.Song;

public interface ISongService {

    public Song add(String name,Genre genre,String album,List<String> artist,ArtistType artistType);
    public void remove(String name);
    
}
