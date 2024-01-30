package com.crio.jukebox.entities;

import java.util.List;

public class Song extends BaseEntity {
    
    private String name;
    private Genre genre;
    private String album;
    private List<String> artist;
    private ArtistType artistType;
    private SongStatus songStatus;

    public Song(Song song){
        this(song.id,song.name,song.genre,song.album,song.artist,song.artistType,SongStatus.NOT_PLAYING);
    }

    public Song(String id,String name, Genre genre, String album, List<String> artist,ArtistType artistType,SongStatus songStatus){
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.album=album;
        this.artist=artist;
        this.artistType=artistType;
        this.songStatus=SongStatus.NOT_PLAYING;
    }

    public Song(String name, Genre genre, String album, List<String> artist,ArtistType artistType){
        this.name=name;
        this.genre=genre;
        this.album=album;
        this.artist=artist;
        this.artistType=artistType;
    }

    public Song(String id,String name, Genre genre, String album, List<String> artist){
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.album=album;
        this.artist=artist;
    }

    public String getAlbumName(){
        return album;
    }
    
    public Genre getGenre(){
        return genre;
    }

    public List<String> getArtistName(){
        return artist;
    }

    public String getName(){
        return name;
    }

    public ArtistType getArtistType(){
        return artistType;
    }

    public SongStatus getSongStatus(){
        return songStatus;
    }

    public void setSongStatus(SongStatus songStatus){
        this.songStatus=songStatus;
    }
    

    @Override
    public String toString() {
        return  "Song - " + name +  "\nAlbum - " + album + "\nArtists - " + artist;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Song other = (Song) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}