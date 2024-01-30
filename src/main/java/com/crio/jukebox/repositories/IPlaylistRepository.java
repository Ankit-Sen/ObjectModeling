package com.crio.jukebox.repositories;

import java.util.Optional;
import com.crio.jukebox.entities.Playlist;

public interface IPlaylistRepository extends CRUDRepository<Playlist,String> {

    public Optional<Playlist> findByName(String name);
    
}
