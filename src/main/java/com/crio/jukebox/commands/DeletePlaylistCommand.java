package com.crio.jukebox.commands;

import java.util.List;
import com.crio.jukebox.exceptions.PlaylistNotFoundException;
import com.crio.jukebox.services.IPlaylistService;

public class DeletePlaylistCommand implements ICommand{

    IPlaylistService playlistService;

    public DeletePlaylistCommand(IPlaylistService playlistService){
        this.playlistService=playlistService;
    }

    @Override
    public void execute(List<String> tokens) {

        String playlistId=tokens.get(2);
        
        try{
            playlistService.remove(playlistId);
            System.out.println("Delete Successful");
        }catch(PlaylistNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
