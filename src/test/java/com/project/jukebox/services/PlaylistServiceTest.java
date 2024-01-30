package com.project.jukebox.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import com.project.jukebox.entities.ArtistType;
import com.project.jukebox.entities.Genre;
import com.project.jukebox.entities.Playlist;
import com.project.jukebox.entities.Song;
import com.project.jukebox.entities.SongStatus;
import com.project.jukebox.repositories.IPlaylistRepository;
import com.project.jukebox.repositories.ISongRepository;
import com.project.jukebox.repositories.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("PlaylistServiceTest")
@ExtendWith(MockitoExtension.class)
public class PlaylistServiceTest {

    @Mock
    private IUserRepository userRepositoryMock;

    @Mock
    private Playlist playlistMock;

    @Mock
    private IPlaylistRepository playlistRepositoryMock;

    @Mock
    private ISongRepository songRepositoryMock;

    @Mock
    private IUserService userServiceMock;

    @InjectMocks
    private PlaylistService playlistService;


    // @Test
    // @DisplayName("deletePlaylist method should delete")
    // public void deletePlaylist(){
    //     Playlist item=new Playlist("1","test123",new ArrayList<>());
    //     playlistRepositoryMock.save(item);
    //     when(playlistRepositoryMock.findById(anyString())).thenReturn(item);
    //     doNothing().when(playlistRepositoryMock).deleteById(anyString());

    //     Assertions.assertTrue(this.playlistService.deletePlaylist("1"));

    //     verify(playlistRepositoryMock, times(1)).existsById(anyString());

    // }

    @Test
    @DisplayName("addPlaylist method should add new playlist")
    public void addPlaylist(){
        Playlist item=new Playlist("1","test123",new ArrayList<>());
        when(playlistRepositoryMock.save(any(Playlist.class))).thenReturn(item);
        Playlist actuaPlaylist=playlistService.create("test123", new ArrayList<>());

        Assertions.assertEquals(item,actuaPlaylist);
        verify(playlistRepositoryMock, times(0)).findById(anyString());

    }

    @Test
    @DisplayName("getPlaylist method should return all playlist")
    public void getAllPlaylist(){

        List<String> Artist=new ArrayList<String>() {
            {
                add("Artist1");
            }
           };

        List<Song> songs=new ArrayList<>();
        songs.add(new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        songs.add(new Song("2", "Song2",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        songs.add(new Song("3", "Song3",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));

        List<Playlist> expectedPlaylists=new ArrayList<Playlist>(){
            {
                add(new Playlist("1","Playlist1",songs));
                add(new Playlist("2","Playlist2",songs));
                add(new Playlist("3","Playlist3",songs));
            }
        };

        when(playlistRepositoryMock.findAll()).thenReturn(expectedPlaylists);

        assertEquals(expectedPlaylists, playlistService.getAllPlaylist());
        verify(playlistRepositoryMock,times(1)).findAll();

    }

    // @Test
    // @DisplayName("playSong method should return current Song Playing")
    // public void playSong_shouldPlaySpecifiedSong(){
    //     List<Song> songs=new ArrayList<>();
    //     songs.add(new Song("1", "Song1",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING));
    //     songs.add(new Song("2", "Song2",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING));
    //     songs.add(new Song("3", "Song3",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING));

    //     List<Playlist> expectedPlaylists=new ArrayList<Playlist>(){
    //         {
    //             add(new Playlist("1","Playlist1",songs));
    //             add(new Playlist("2","Playlist2",songs));
    //             add(new Playlist("3","Playlist3",songs));
    //         }
    //     };

    //     when(playlistRepositoryMock.findAll()).thenReturn(expectedPlaylists);
    //     when(playlistMock.getPlaySongs()).thenReturn(songs);

    //     Song expectedSong=new Song("1", "Song1",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING);
    //     Song actualSong=playlistService.playSong("1", "1");

    //     System.out.println(expectedSong);
    //     System.out.println(actualSong);

    //     assertEquals(expectedSong, actualSong);
    // }

    // @Test
    // @DisplayName("playSong method should throw SongNotFoundException")
    // public void playSong_shouldThrowException(){
    //     List<Song> songs=new ArrayList<>();
    //     songs.add(new Song("1", "Song1",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING));
    //     songs.add(new Song("2", "Song2",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING));
    //     songs.add(new Song("3", "Song3",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING));

    //     List<Playlist> expectedPlaylists=new ArrayList<Playlist>(){
    //         {
    //             add(new Playlist("1","Playlist1",songs));
    //             add(new Playlist("2","Playlist2",songs));
    //             add(new Playlist("3","Playlist3",songs));
    //         }
    //     };

    //     when(playlistRepositoryMock.findAll()).thenReturn(expectedPlaylists);
    //     when(playlistMock.getPlaySongs()).thenReturn(songs);

    //     Song expectedSong=new Song("1", "Song1",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING);
    //     Song actualSong=playlistService.playSong("1", "1");

    //     System.out.println(expectedSong);
    //     System.out.println(actualSong);

    //     assertEquals(expectedSong, actualSong);
    // }

    @Test
    @DisplayName("playPlaylist method should return specified Song Playing")
    public void playPlaylist_shouldPlaySpecifiedSongPlaylistMentioned(){
        List<String> Artist=new ArrayList<String>() {
            {
                add("Artist1");
            }
           };
        List<Song> songs=new ArrayList<>();
        songs.add(new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        songs.add(new Song("2", "Song2",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
        songs.add(new Song("3", "Song3",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));

        Playlist playlist=new Playlist("1","Playlist1",songs);
        when(playlistRepositoryMock.findById(anyString())).thenReturn(playlist);

        Song actualSong=playlistService.playPlaylist("1", "1");

    }

    // @Test
    // @DisplayName("playPlaylist method should throw PlaylistNotFoundException")
    // public void playPlaylist_shouldThrowPlaylistNotFoundException(){
    // }

    // @Test
    // @DisplayName("playNextSong method should return Next Song")
    // public void playNextSong_shouldPlayNextSong(){
    // }

    // @Test
    // @DisplayName("playNextSong method should return SongNotFoundException")
    // public void playNextSong_shouldReturnException(){
    // }

    // @Test
    // @DisplayName("playPreviousSong method should return Previous Song")
    // public void playPreviousSong_shouldPlayPreviousSong(){
    // }

    // @Test
    // @DisplayName("playPreviousSong method should return SongNotFoundException")
    // public void playPreviousSong_shouldReturnException(){
    // }

    // @Test
    // @DisplayName("addSongPlaylist method should add song in playlist")
    // public void addSong_shouldAddSongInPlaylist(){

    //     List<String> Artist=new ArrayList<String>() {
    //         {
    //             add("Artist1");
    //         }
    //        };

    //     List<Song> songs=new ArrayList<>();
    //     songs.add(new Song("1", "Song1",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
    //     songs.add(new Song("2", "Song2",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));
    //     songs.add(new Song("3", "Song3",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING));

    //     Playlist playlist=new Playlist("1","Playlist1",songs);
    //     Song song=new Song("4", "Song4",Genre.POP,"Album",Artist,ArtistType.SOLO,SongStatus.NOT_PLAYING);
    //     when(playlistRepositoryMock.findById(anyString())).thenReturn(playlist);
    // }

    // @Test
    // @DisplayName("deleteSongPlaylist method should delete song in playlist")
    // public void deleteSong_shouldDeleteSongInPlaylist(){

    //     List<Song> songs=new ArrayList<>();
    //     songs.add(new Song("1", "Song1",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING));
    //     songs.add(new Song("2", "Song2",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING));
    //     songs.add(new Song("3", "Song3",Genre.POP,"Album","Artist",ArtistType.SOLO,SongStatus.NOT_PLAYING));

    //     List<String> songsExpect=new ArrayList<>();
    //     songsExpect.add("1");
    //     songsExpect.add("2");

    //     Playlist playlist=new Playlist("1","Playlist1",songs);

    //     when(playlistRepositoryMock.findAll()).thenReturn(expectedPlaylists);

    //     ActivePlaylistDto activePlaylistDto=playlistService.deleteSongPlaylist("1", songsExpect);

    //     assertEquals(expectedPlaylists, playlistService.getAllPlaylist());
    // }


}
