package com.project.jukebox.commands;

import java.io.FileNotFoundException;
import java.util.List;
import com.project.jukebox.services.ILoadDataService;

public class LoadDataCommand implements ICommand {

    private ILoadDataService loadDataService;

        public LoadDataCommand (ILoadDataService loadDataService){
            this.loadDataService=loadDataService;
        } 

    @Override
    public void execute(List<String> tokens) {
        
        String fileName=tokens.get(1);
        try{
            System.out.println("Songs Loaded successfully");
            loadDataService.loadData(fileName);
        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
    
}
