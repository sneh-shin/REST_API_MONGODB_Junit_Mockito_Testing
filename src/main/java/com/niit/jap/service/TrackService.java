package com.niit.jap.service;

import com.niit.jap.domain.Track;

import java.util.List;

public interface TrackService {
    Track saveTrack(Track track);

    boolean deleteTrack(int trackId);

    List<Track> getTracks();

    List<Track> getAllTrackFromTrackRating(double trackRating);

    List<Track> getAllTrackFromArtistName(String artistName);

}
