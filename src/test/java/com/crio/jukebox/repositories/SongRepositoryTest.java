package com.crio.jukebox.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.crio.jukebox.entities.ArtistType;
import com.crio.jukebox.entities.Genre;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.SongStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SongRepositoryTest {
    private SongRepository songRepository;
    @BeforeEach
    void setup(){
        List<String> Artist=new ArrayList<String>() {
            {
                add("Artist1");
            }
           };
        final Map<String,Song> songMap = new HashMap<String,Song>(){
            {
                put("1",new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
                put("2",new Song("2", "Song2",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
                put("3",new Song("3", "Song3",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
            }
        };
        songRepository = new SongRepository(songMap);
    }

    @Test
    @DisplayName("findById method should return song Given Id")
    public void findById_ShouldReturnsong_GivensongId(){
        //Arrange
        String expectedsongId = "3";
        //Act
        Song actualSong = songRepository.findById(expectedsongId);
        //Assert
        Assertions.assertEquals(expectedsongId,actualSong.getId());
    }

    @Test
    @DisplayName("findById method should return empty if song Not Found")
    public void findById_ShouldReturnEmptyIfsongNotFound(){
        //Arrange
        Song expected = null;
        //Act
        Song actual = songRepository.findById("5");
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("findByName method should return song Given Name")
    public void findByName_ShouldReturnsong_GivensongId(){
        //Arrange
        String expectedsongName = "Song1";
        //Act
        Optional<Song> actualsong = songRepository.findByName(expectedsongName);
        //Assert
        Assertions.assertEquals(expectedsongName,actualsong.get().getName());
        
    }

    @Test
    @DisplayName("findByName method should return empty if song Not Found")
    public void findByName_ShouldReturnEmptyIfsongNotFound(){
        //Arrange
        Optional<Song> expected = Optional.empty();
        //Act
        Optional<Song> actual = songRepository.findByName("song5");
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("findAll method should return all Songs")
    public void findAll_ShouldReturnAllSongs(){
        //Arrange
        List<String> Artist=new ArrayList<String>() {
            {
                add("Artist1");
            }
           };
        List<Song> expected = new ArrayList<>();
        expected.add(new Song("1", "Song1", Genre.POP, "Album", Artist, ArtistType.SOLO, SongStatus.NOT_PLAYING));
        expected.add(new Song("2", "Song2", Genre.POP, "Album", Artist, ArtistType.SOLO, SongStatus.NOT_PLAYING));
        expected.add(new Song("3", "Song3", Genre.POP, "Album", Artist, ArtistType.SOLO, SongStatus.NOT_PLAYING));

        //Act
        List<Song> actual = songRepository.findAll();
        //Assert
        Assertions.assertEquals(expected,actual);
    }
}
