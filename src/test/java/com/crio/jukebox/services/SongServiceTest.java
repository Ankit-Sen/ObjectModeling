package com.crio.jukebox.services;

import com.crio.jukebox.entities.ArtistType;
import com.crio.jukebox.entities.Genre;
import com.crio.jukebox.entities.Song;
import com.crio.jukebox.entities.SongStatus;
import com.crio.jukebox.repositories.ISongRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

@DisplayName("UserServiceTest")
@ExtendWith(MockitoExtension.class)
public class SongServiceTest {
    @InjectMocks
    SongService songService;

    @Mock
    ISongRepository songRepositoryMock;

    @Test
    @DisplayName("create method should create Song")
    public void create_ShouldReturnSong(){
        //Arrange
        List<String> Artist=new ArrayList<String>() {
            {
                add("Artist1");
            }
           };
        Song expectedSong = new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING);
        when(songRepositoryMock.save(any(Song.class))).thenReturn(expectedSong);

        //Act
        Song actualSong = songService.add("Song1",Genre.POP,"Album",Artist,ArtistType.SOLO);

        //Assert
        Assertions.assertEquals(expectedSong,actualSong);
        verify(songRepositoryMock,times(1)).save(any(Song.class));
    }
    
    @Test
    @DisplayName("getSongById method should return List of Song if input is null")
    public void getAllSongLevelWise_ShouldReturnAllSongList(){
        //Arrange
        List<String> Artist=new ArrayList<String>() {
            {
                add("Artist1");
            }
           };
        Song expectedSong = new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING);
        when(songRepositoryMock.findById(anyString())).thenReturn(expectedSong);

        //Act
        Song actualSong = songService.getSongById("1");

        //Assert
        Assertions.assertEquals(expectedSong,actualSong);
        verify(songRepositoryMock,times(1)).findById(anyString());
    }
}
