/*
 *Author Name: Sneha Shinde
 *Date: 11/25/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.test;

import com.niit.jap.domain.Artist;
import com.niit.jap.domain.Track;
import com.niit.jap.repository.TrackRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class TrackRepositoryTest {
    @Autowired
    private TrackRepository repository;
    private Track track;
    private Artist artist;

    @BeforeEach
    public void setUp() {
        artist = new Artist(1, "Juhi");
        track = new Track(1, "Mera man", 4.0, artist);
    }

    @AfterEach
    public void tearDown() {
        artist = null;
        track = null;
        repository.deleteAll();
    }

    @Test
    public void saveCustomer() {
        repository.save(track);

        Track track1 = repository.findById(track.getTrackId()).get();
        assertNotNull(track1);
        assertEquals(track.getTrackId(), track1.getTrackId());
        Artist artist1 = new Artist(7, "Priya");
        Track track2 = new Track(1002, "Fool", 3.5, artist1);
        repository.save(track2);
        assertEquals(2, repository.count());
    }
}
