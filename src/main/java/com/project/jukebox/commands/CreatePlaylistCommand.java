package com.project.jukebox.commands;

import java.util.ArrayList;
import java.util.List;
import com.project.jukebox.exceptions.SongNotFoundException;
import com.project.jukebox.services.IPlaylistService;

public class CreatePlaylistCommand implements ICommand {

    IPlaylistService playlistService;

    public CreatePlaylistCommand(IPlaylistService playlistService){
        this.playlistService=playlistService;
    }

    @Override
    public void execute(List<String> tokens) {
        String playlistName=tokens.get(2);
        List<String> songIds=new ArrayList<>();
        for(int i=3;i<tokens.size();i++){
            songIds.add(tokens.get(i));
        }
        try{
            System.out.println(playlistService.create(playlistName, songIds));
        }catch(SongNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
}
