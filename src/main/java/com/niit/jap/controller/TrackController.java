/*
 *Author Name: Sneha Shinde
 *Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.controller;

import com.niit.jap.domain.Track;
import com.niit.jap.service.TrackServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    private TrackServiceImpl service;

    public TrackController(TrackServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/saveValue")
    public ResponseEntity<?> save(Track track) {
        return new ResponseEntity<>(service.saveTrack(track), HttpStatus.CREATED);
    }

    @GetMapping("/getValue")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(service.getTracks(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteValue")
    public ResponseEntity<?> delete(int id) {
        return new ResponseEntity<>(service.deleteTrack(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getValue/{trackRating}")
    public ResponseEntity<?> getByRating(double trackRating) {
        return new ResponseEntity<>(service.getAllTrackFromTrackRating(trackRating), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getValue/{artistName}")
    public ResponseEntity<?> getByArtist(String artistName) {
        return new ResponseEntity<>(service.getAllTrackFromArtistName(artistName), HttpStatus.ACCEPTED);
    }
}
