package com.project.jukebox.services;

import java.util.ArrayList;
import java.util.List;
import com.project.jukebox.dtos.ActivePlaylistDto;
import com.project.jukebox.entities.Playlist;
import com.project.jukebox.entities.PlaylistStatus;
import com.project.jukebox.entities.Song;
import com.project.jukebox.entities.SongStatus;
import com.project.jukebox.exceptions.PlaylistNotFoundException;
import com.project.jukebox.exceptions.SongNotFoundException;
import com.project.jukebox.repositories.IPlaylistRepository;
import com.project.jukebox.repositories.ISongRepository;

public class PlaylistService implements IPlaylistService{

    private final IPlaylistRepository playlistRepository;
    private final ISongRepository songRepository;

    public PlaylistService(IPlaylistRepository playlistRepository,ISongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.songRepository=songRepository;
    }

    public boolean deletePlaylist(String Id)throws PlaylistNotFoundException{
        Playlist playlist = playlistRepository.findById(Id);
        if(playlist!=null){
            playlistRepository.deleteById(Id);
            return true;
        }else{
            throw new PlaylistNotFoundException("Playlist Not Found");
        }   
    }

    @Override
    public boolean remove(String id)throws PlaylistNotFoundException{
        // if(playlistRepository.existsById(id)){
        //     playlistRepository.deleteById(id);
        //     return true;
        // }
        // else
        // throw new PlaylistNotFoundException("Playlist not found");
        Playlist playlist = playlistRepository.findById(id);
        if(playlist!=null){
            playlistRepository.deleteById(id);
            return true;
        }else{
            throw new PlaylistNotFoundException("Playlist Not Found");
        }
    }

    @Override
    public Playlist create(String name,List<String> songs) {
        List<Song> songlist=new ArrayList<>();
        for(String s : songs){
            Song so=songRepository.findById(s);
            if(so!=null)
            songlist.add(so);
        }
        Playlist playlist = new Playlist(name,songlist);
        return playlistRepository.save(playlist);
    }

    

    public PlaylistStatus isActive(){
        return PlaylistStatus.NOT_ACTIVE;
    }

    
    @Override
    public Song playPlaylist(String id,String songId)throws PlaylistNotFoundException{
        Playlist playlist = playlistRepository.findById(id);
        if(playlist==null)
        throw new PlaylistNotFoundException("Playlist Not Found");
        else{
            playlist.setPlaylistStatus(PlaylistStatus.ACTIVE);
            if(playlist.checkIfSongExists(songId)){
                List<Song> song=playlist.getPlaySongs();
                for(Song s : song){
                    if(songId.equals(s.getId()))
                    return s;
                }
            }  
        }
        List<Song> song=playlist.getPlaySongs();
                for(Song s : song){
                    return s;
                }
                return null;
    }

    public Song playSong(String playlistId,String songId)throws SongNotFoundException{
        //Should throw song not found  
      for(Playlist p : getAllPlaylist()){
          if(playlistId.equals(p.getId())){
              for(Song song : p.getPlaySongs()){
                  if(songId.equals(song.getId())){
                      song.setSongStatus(SongStatus.PLAYING);
                      return song;
                  }
              }    
          }
      }
      throw new SongNotFoundException("Given song id is not a part of the active playlist");
      }

    public Song playNextSong(String playlistId)throws SongNotFoundException{
        Playlist playlist = playlistRepository.findById(playlistId);
        if(playlist.getSongCount()>1){ 
        int count=0;
        for(Song song : playlist.getPlaySongs()){
            if(song.getSongStatus()==SongStatus.PLAYING){
                song.setSongStatus(SongStatus.NOT_PLAYING);
                break;
            }
            count++;
        }
        Song s=playlist.getPlaySongs().get((count+1)%playlist.getPlaySongs().size());
        return playSong(playlistId, s.getId());
        }else{
            throw new SongNotFoundException("No more Song in Playlist");
        }
        
    }

    public Song playPreviousSong(String playlistId)throws SongNotFoundException{
        Playlist playlist = playlistRepository.findById(playlistId);
        if(playlist.getSongCount()>1){
        int count=0;
        for(Song song : playlist.getPlaySongs()){
            if(song.getSongStatus()==SongStatus.PLAYING){
                song.setSongStatus(SongStatus.NOT_PLAYING);
                break;
            }
            count++;
        }
        count=count-1;
        Song s=playlist.getPlaySongs().get((count<0?playlist.getPlaySongs().size()-1:count)%playlist.getPlaySongs().size());
        return playSong(playlistId, s.getId());
        }else{
            throw new SongNotFoundException("No more Song in Playlist");
        }
        
    }  

    @Override
    public List<Playlist> getAllPlaylist() {
        return playlistRepository.findAll();
    }
    
    @Override
    public ActivePlaylistDto addSongPlaylist(String playlistId,String songId){
        Playlist p=playlistRepository.findById(playlistId);
        boolean flag=false;
        for(Song song:p.getPlaySongs())
        {
                if(songId.equals(song.getId()))
                flag=true;
        }
        if(flag==false)
        p.addSong(songRepository.findById(songId));
        return new ActivePlaylistDto(p.getId(), p.getPlaylistName(), p.getPlaySongs());
    }
    @Override
    public ActivePlaylistDto deleteSongPlaylist(String playlistId,String songId){

        Playlist p=playlistRepository.findById(playlistId);
        boolean flag=false;
        for(Song song:p.getPlaySongs())
        {
                if(songId.equals(song.getId()))
                flag=true;
        }
        if(flag==true)
        p.removeSong(songRepository.findById(songId));
        return new ActivePlaylistDto(p.getId(), p.getPlaylistName(), p.getPlaySongs());
    }
}
