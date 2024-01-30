package com.project.jukebox.commands;

import java.util.List;

import com.project.jukebox.entities.Song;
import com.project.jukebox.exceptions.SongNotFoundException;
import com.project.jukebox.services.IPlaylistService;

public class PlaySongCommand implements ICommand{

    IPlaylistService playlistService;

    public PlaySongCommand(IPlaylistService playlistService){
        this.playlistService=playlistService;
    }

    @Override
    public void execute(List<String> tokens) {

        String playlistId=tokens.get(1);
        String command=tokens.get(2);
        
        try{
            if(command.equals("NEXT")){
                Song showSong=playlistService.playNextSong(playlistId);
                System.out.println("Current Song Playing");
                System.out.print("Song - "+showSong.getName()+"\nAlbum - "+showSong.getAlbumName()+"\nArtists - ");
                List<String> artistName=showSong.getArtistName();
                for(int i=0;i<artistName.size()-1;i++)
                System.out.print(artistName.get(i)+",");
                System.out.print(artistName.get(artistName.size()-1)); 
                System.out.println();
            }
            else if(command.equals("BACK")){
            Song showSong=playlistService.playPreviousSong(playlistId);
            System.out.println("Current Song Playing");
            System.out.print("Song - "+showSong.getName()+"\nAlbum - "+showSong.getAlbumName()+"\nArtists - ");
            List<String> artistName=showSong.getArtistName();
            for(int i=0;i<artistName.size()-1;i++)
            System.out.print(artistName.get(i)+",");
            System.out.print(artistName.get(artistName.size()-1)); 
            System.out.println();  
            }
            else{
                Song showSong=playlistService.playSong(playlistId,command);
            System.out.println("Current Song Playing");
            System.out.print("Song - "+showSong.getName()+"\nAlbum - "+showSong.getAlbumName()+"\nArtists - ");
            List<String> artistName=showSong.getArtistName();
            for(int i=0;i<artistName.size()-1;i++)
            System.out.print(artistName.get(i)+",");
            System.out.print(artistName.get(artistName.size()-1)); 
            System.out.println();
            }
        }catch(SongNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
}
