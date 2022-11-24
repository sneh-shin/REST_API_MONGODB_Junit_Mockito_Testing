/*
 *Author Name: Sneha Shinde
 *Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.domain;

public class Artist {
    private int artistId;
    private String ArtistName;

    public Artist() {
    }

    public Artist(int artistId, String artistName) {
        this.artistId = artistId;
        ArtistName = artistName;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return ArtistName;
    }

    public void setArtistName(String artistName) {
        ArtistName = artistName;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", ArtistName='" + ArtistName + '\'' +
                '}';
    }
}
