/*
 *Author Name: Sneha Shinde
 *Date: 11/25/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.test;

import com.niit.jap.domain.Artist;
import com.niit.jap.domain.Track;
import com.niit.jap.exception.TrackAlreadyExist;
import com.niit.jap.repository.TrackRepository;
import com.niit.jap.service.TrackServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TrackServiceTest {
    @InjectMocks
    TrackServiceImpl service;
    @Mock
    private TrackRepository repository;
    private Track track;
    private Artist artist;

    @BeforeEach
    public void setUp() {
        artist = new Artist(1, "shaan");
        track = new Track(7, "toxic", 3.1, artist);
    }

    @AfterEach
    public void tearDown() {
        artist = null;
        track = null;
    }

    @Test
    void saveSuccess() throws TrackAlreadyExist {
        when(repository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(null));
        when(repository.save(any())).thenReturn(track);
        assertEquals(track, service.saveTrack(track));
        verify(repository, times(1)).save(any());
        verify(repository, times(1)).findById(any());
    }

    @Test
    void saveFailure() throws TrackAlreadyExist {
        when(repository.findById(track.getTrackId())).thenReturn(Optional.ofNullable(track));
        assertThrows(TrackAlreadyExist.class, () -> service.saveTrack(track));
        verify(repository, times(0)).save(any());
    }
}
