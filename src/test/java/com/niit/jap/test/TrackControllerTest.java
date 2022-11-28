/*
 *Author Name: Sneha Shinde
 *Date: 11/28/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.jap.controller.TrackController;
import com.niit.jap.domain.Artist;
import com.niit.jap.domain.Track;
import com.niit.jap.exception.TrackAlreadyExist;
import com.niit.jap.service.TrackServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class TrackControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Mock
    private TrackServiceImpl service;
    @InjectMocks
    private TrackController controller;
    private Track track;
    private Artist artist;

    @BeforeEach
    public void setUp() {
        artist = new Artist(1, "sneha");
        track = new Track(1, "dukh", 5.5, artist);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @AfterEach
    public void tearDown() {
        track = null;
        artist = null;
    }

    @Test
    public void givenEmployeetoSaveandReturnSuccesscode() throws Exception {
        when(service.saveTrack(any())).thenReturn(track);
        mockMvc.perform(post("/api/v1/saveEmp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(track)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
        verify(service, times(1)).saveTrack(any());
    }

    @Test
    public void givenEmployeetoSaveandReturnErrorcode() throws Exception {
        when(service.saveTrack(any())).thenThrow(TrackAlreadyExist.class);
        mockMvc.perform(post("/api/v1/saveEmp")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsBytes(track)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());
        verify(service, times(1)).saveTrack(any());
    }

}

