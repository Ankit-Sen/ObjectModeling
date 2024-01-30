package com.crio.jukebox.entities;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlaylistTest {
    
   @Test
   @DisplayName("checkIfSongExists should Return true If Song is Found")
   public void checkIfSongExists_ShouldReturnTrue_GivenSong(){
       //Arrange
       String id = "1";
       String name = "Favourite";
       List<String> Artist=new ArrayList<String>() {
        {
            add("Artist1");
        }
       };
       List<Song> Songs =  new ArrayList<Song>(){
           {
           add(new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
           add(new Song("2", "Song2",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
           add(new Song("3", "Song3",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
           }
       };
       Song song1=new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING);
       Playlist playlist = new Playlist(id, name, Songs);
       //Act
       Assertions.assertTrue(playlist.checkIfSongExists(song1.getId()));
   }

   @Test
   @DisplayName("checkIfSonglistExists should Return False If No Song is Found")
   public void checkIfSongExists_ShouldReturnFalse_GivenSong(){
       //Arrange
       String id = "1";
       String name = "Favourite";
       List<String> Artist=new ArrayList<String>() {
        {
            add("Artist1");
        }
       };
       List<Song> Songs =  new ArrayList<Song>(){
           {
           add(new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
           add(new Song("2", "Song2",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
           add(new Song("3", "Song3",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
           }
       };
       Song song1=new Song("4", "Song4",Genre.POP,"Album",Artist,ArtistType.BAND,SongStatus.NOT_PLAYING);
       Playlist playlist = new Playlist(id, name, Songs);
       //Act
       Assertions.assertFalse(playlist.checkIfSongExists(song1.getId()));
       //Assertions.assertThrows(SongNotFoundException.class,() -> new Contest(name, questions, level, creator, contestStatus));
   }

}
