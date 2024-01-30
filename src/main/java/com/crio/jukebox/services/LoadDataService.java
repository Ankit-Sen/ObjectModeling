package com.crio.jukebox.services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.crio.jukebox.entities.Genre;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.repositories.ISongRepository;

public class LoadDataService implements ILoadDataService{

    ISongRepository songRepository;

    public LoadDataService(ISongRepository songRepository){
        this.songRepository=songRepository;
    }

    public void loadData(String fileName) throws FileNotFoundException{
    
        //String csvFilePath = "/home/crio-user/workspace/ankitsenchowdhury-ME_OBJECT_MODELING_V2/songs.csv";
        List<Song> songs=new ArrayList<>();
            try {
                //String file="/home/crio-user/workspace/ankitsenchowdhury-ME_OBJECT_MODELING_V2/songs.csv";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                String id = values[0];
                String title = values[1];
                Genre genre = getGenre(values[2]);  
                String album = values[3];
                List<String> artist = new ArrayList<>(Arrays.asList(values[5].split("#")));
                // ArtistType artistType = ArtistType.valueOf(values[5]);  
                // SongStatus songStatus = SongStatus.valueOf(values[6]);  

                Song song = new Song(id, title, genre, album, artist);
                songs.add(song);
            }
            songRepository.readAll(songs); 
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    private Genre getGenre(String gen){
        if(gen.equals("Pop"))
        return Genre.POP;
        else if(gen.equals("Electronic Dance Music"))
        return Genre.ELECTRONIC_DANCE_MUSIC;
        else if(gen.equals("Rock"))
        return Genre.ROCK;
        else if(gen.equals("Hip-Hop"))
        return Genre.HIP_HOP;
        else
        return Genre.JAZZ;
    }         
}
