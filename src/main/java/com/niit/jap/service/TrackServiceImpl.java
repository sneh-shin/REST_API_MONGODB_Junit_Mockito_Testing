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
        return repository.save(track);
    }

    @Override
    public boolean deleteTrack(int trackId) {
        repository.deleteById(trackId);
        return true;
    }

    @Override
    public List<Track> getTracks() {
        return repository.findAll();
    }

    @Override
    public List<Track> getAllTrackFromTrackRating(double trackRating) {
        return repository.findAllTrackFromTrackRating(trackRating);
    }

    @Override
    public List<Track> getAllTrackFromArtistName(String artistName) {
        return repository.findAllTrackFromArtistName(artistName);
    }
}
