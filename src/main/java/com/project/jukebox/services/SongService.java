package com.project.jukebox.services;

import java.util.List;
import com.project.jukebox.entities.ArtistType;
import com.project.jukebox.entities.Genre;
import com.project.jukebox.entities.Song;
import com.project.jukebox.entities.SongStatus;
import com.project.jukebox.exceptions.SongNotFoundException;
import com.project.jukebox.repositories.ISongRepository;

public class SongService implements ISongService{
    private final ISongRepository songRepository;

    public SongService(ISongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public Song add(String name,Genre genre,String album,List<String> artist,ArtistType artistType) {
        final Song song = new Song(name,genre,album,artist,artistType);
        return songRepository.save(song);
    }

    @Override
    public void remove(String name)throws SongNotFoundException {
        Song song = songRepository.findByName(name).orElseThrow(() -> new SongNotFoundException("Cannot Remove Playlist. Playlist for given name:"+name+" not found!"));
        songRepository.delete(song);
        
    }

    public SongStatus isActive(Song song){
        return SongStatus.NOT_PLAYING;
    }

    public List<Song> getSongsArtistWise(String name){
        return songRepository.findAllSongsArtistWise(name);
    }

    public Song getSongById(String id){
        return songRepository.findById(id);
    }
    
}
