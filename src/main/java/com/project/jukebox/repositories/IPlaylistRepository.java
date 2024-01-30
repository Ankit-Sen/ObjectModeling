package com.project.jukebox.repositories;

import java.util.Optional;
import com.project.jukebox.entities.Playlist;

public interface IPlaylistRepository extends CRUDRepository<Playlist,String> {

    public Optional<Playlist> findByName(String name);
    
}
