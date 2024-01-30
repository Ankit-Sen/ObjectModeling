package com.project.jukebox.entities;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("UserTest")
public class UserTest {

   @Test
   @DisplayName("checkIfPlaylistExists should Return true If Playlist is Found")
   public void checkIfPlaylistExists_ShouldReturnTrue_GivenPlaylist(){
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
    
       Playlist playlist = new Playlist(id, name, Songs);
       User user = new User("1","name", new ArrayList<Playlist>(){{ add(playlist); }});

       //Act
       Assertions.assertTrue(user.checkIfPlaylistExists(playlist));
   }

   @Test
   @DisplayName("checkIfPlaylistExists should Return False If No Playlist is Found")
   public void checkIfPlaylistExists_ShouldReturnFalse_GivenPlaylist(){
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
    
       Playlist playlist = new Playlist(id, name, Songs);
       User user = new User("1","name");

       //Act
       Assertions.assertFalse(user.checkIfPlaylistExists(playlist));
   }
    
}
