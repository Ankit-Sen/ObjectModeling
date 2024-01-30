package com.crio.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.crio.jukebox.dtos.ActivePlaylistDto;
import com.crio.jukebox.exceptions.SongNotFoundException;
import com.crio.jukebox.services.IPlaylistService;
import com.crio.jukebox.services.ISongService;
import com.crio.jukebox.services.PlaylistService;

public class ModifyPlaylistCommand implements ICommand {

    IPlaylistService playlistService;
    ISongService songService;

    public ModifyPlaylistCommand(ISongService songService,IPlaylistService playlistService){
        this.songService=songService;
        this.playlistService=playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        // TODO Auto-generated method stub
        String command=tokens.get(1);
        String playlistId=tokens.get(2);
        // List<String> songId=new ArrayList<>();
        // for(int i=3;i<tokens.size();i++){
        //     songId.add(tokens.get(i));
        // }
        String songId=tokens.get(4);
        try{
            if(command.equals("ADD-SONG")){
                ActivePlaylistDto activePlaylistDto=playlistService.addSongPlaylist(playlistId,songId);
                System.out.print("Playlist ID - " + playlistId + "\nPlaylist Name - " + activePlaylistDto.getPlaylistName() + "\nSong IDs - " );
                List<String> songIds=activePlaylistDto.getSongIds();
                for(int i=0;i<songIds.size()-1;i++)
                System.out.print(songIds.get(i)+" ");
                System.out.print(songIds.get(songIds.size()-1)); 
                System.out.println();
            }
            else if(command.equals("DELETE-SONG")){
                ActivePlaylistDto activePlaylistDto=playlistService.deleteSongPlaylist(playlistId, songId);
                System.out.print("Playlist ID - " + playlistId + "\nPlaylist Name - " + activePlaylistDto.getPlaylistName() + "\nSong IDs - " );
                List<String> songIds=activePlaylistDto.getSongIds();
                for(int i=0;i<songIds.size()-1;i++)
                System.out.print(songIds.get(i)+" ");
                System.out.print(songIds.get(songIds.size()-1)); 
                System.out.println();
            }  
        }catch(SongNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
