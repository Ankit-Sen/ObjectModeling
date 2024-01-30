package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.exceptions.SongNotFoundException;
import com.crio.jukebox.services.IPlaylistService;

public class PlayPlaylistCommand implements ICommand{
    IPlaylistService playlistService;

    public PlayPlaylistCommand(IPlaylistService playlistService){
        this.playlistService=playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        
        String playlistId=tokens.get(1);
        String songId=tokens.get(2);

        try{
                System.out.println("Current Song Playing");
                Song showSong=playlistService.playPlaylist(playlistId,songId);
                System.out.print("Song - "+showSong.getName()+"\nAlbum - "+showSong.getAlbumName()+"\nArtists - ");
                List<String> artistName=showSong.getArtistName();
                for(int i=0;i<artistName.size()-1;i++)
                System.out.print(artistName.get(i)+",");
                System.out.print(artistName.get(artistName.size()-1)); 
                System.out.println();
            }catch(SongNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        
    }
