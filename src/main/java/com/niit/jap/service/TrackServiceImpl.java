/*
 *Author Name: Sneha Shinde
 *Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.service;

import com.niit.jap.domain.Track;
import com.niit.jap.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository repository;

    @Autowired
    public TrackServiceImpl(TrackRepository repository) {
        this.repository = repository;
    }

    @Override
    public Track saveTrack(Track track) {
        return null;
    }

    @Override
    public boolean deleteTrack(int trackId) {
        return false;
    }

    @Override
    public List<Track> getTracks() {
        return null;
    }

    @Override
    public List<Track> getAllTrackFromTrackRating(double trackRating) {
        return null;
    }

    @Override
    public List<Track> getAllTrackFromArtistName(String artistName) {
        return null;
    }
}
