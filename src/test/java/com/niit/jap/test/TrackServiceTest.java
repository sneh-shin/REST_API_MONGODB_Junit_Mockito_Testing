/*
 *Author Name: Sneha Shinde
 *Date: 11/25/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.test;

import com.niit.jap.repository.TrackRepository;
import com.niit.jap.service.TrackServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TrackServiceTest {
    @InjectMocks
    TrackServiceImpl service;
    @Mock
    private TrackRepository repository;
}
