package com.project.jukebox.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.project.jukebox.entities.ArtistType;
import com.project.jukebox.entities.Genre;
import com.project.jukebox.entities.Playlist;
import com.project.jukebox.entities.Song;
import com.project.jukebox.entities.SongStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlaylistRepositoryTest {
    
    private PlaylistRepository playlistRepository;
    @BeforeEach
    void setup(){
        List<String> Artist=new ArrayList<String>() {
            {
                add("Artist1");
            }
           };
        List<Song> songs=new ArrayList<>();
        songs.add(new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        songs.add(new Song("2", "Song2",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        songs.add(new Song("3", "Song3",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        
        final Map<String,Playlist> playlistMap = new HashMap<String,Playlist>(){
            {
                put("1",new Playlist("1", "Playlist1",songs));
                put("2",new Playlist("2", "Playlist2",songs));
                put("3",new Playlist("3", "Playlist3",songs));
            }
        };
        playlistRepository = new PlaylistRepository(playlistMap);
    }

    @Test
    @DisplayName("findById method should return Playlist Given Id")
    public void findById_ShouldReturnPlaylist_GivenPlaylistId(){
        //Arrange
        String expectedPlaylistId = "1";
        //Act
        Playlist actualPlaylist = playlistRepository.findById(expectedPlaylistId);
        String actualPlaylistId=actualPlaylist.getId();
        System.out.println(actualPlaylistId);
        //Assert
        Assertions.assertEquals(expectedPlaylistId,actualPlaylistId);

    }

    @Test
    @DisplayName("findById method should return empty if Playlist Not Found")
    public void findById_ShouldReturnEmptyIfPlaylistNotFound(){
        //Act
        Playlist actual = playlistRepository.findById("5");
        //Assert
        Assertions.assertNull(actual);
    }

    @Test
    @DisplayName("findByName method should return Playlist Given Name")
    public void findByName_ShouldReturnPlaylist_GivenPlaylistId(){
        //Arrange
        String expectedPlaylistName = "Playlist1";
        //Act
        Optional<Playlist> actualPlaylist = playlistRepository.findByName(expectedPlaylistName);
        //Assert
        Assertions.assertEquals(expectedPlaylistName,actualPlaylist.get().getPlaylistName());
        
    }

    @Test
    @DisplayName("findByName method should return empty if Playlist Not Found")
    public void findByName_ShouldReturnEmptyIfPlaylistNotFound(){
        //Arrange
        Optional<Playlist> expected = Optional.empty();
        //Act
        Optional<Playlist> actual = playlistRepository.findByName("Playlist5");
        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("findAll method should return all Playlists")
    public void findAll_ShouldReturnAllPlaylists(){
        //Arrange
        List<String> Artist=new ArrayList<String>() {
            {
                add("Artist1");
            }
           };
        List<Song> songs=new ArrayList<>();
        songs.add(new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        songs.add(new Song("2", "Song2",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        songs.add(new Song("3", "Song3",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        List<Playlist> expected = new ArrayList<>();
        expected.add(new Playlist("1", "Playlist1", songs));
        expected.add(new Playlist("2", "Playlist2", songs));
        expected.add(new Playlist("3", "Playlist3", songs));

        //Act
        List<Playlist> actual = playlistRepository.findAll();
        //Assert
        Assertions.assertEquals(expected,actual);
    }
}
