package com.project.jukebox.services;

import java.util.List;
import com.project.jukebox.dtos.ActivePlaylistDto;
import com.project.jukebox.entities.Playlist;
import com.project.jukebox.entities.Song;
import com.project.jukebox.exceptions.SongNotFoundException;

public interface IPlaylistService {
    
    public Playlist create(String name,List<String> songs);
    public List<Playlist> getAllPlaylist();
    public Song playSong(String playlistId,String songId)throws SongNotFoundException;
    public Song playNextSong(String playlistId);
    public Song playPreviousSong(String playlistId);
    public boolean remove(String id);
    public Song playPlaylist(String id,String songId);
    public ActivePlaylistDto addSongPlaylist(String playlistId,String songId);
    public ActivePlaylistDto deleteSongPlaylist(String playlistId,String songId);
    
}
