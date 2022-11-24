/*
 *Author Name: Sneha Shinde
 *Date: 11/24/2022
 * Created With: IntelliJ IDEA Community Edition
 */
package com.niit.jap.controller;

import com.niit.jap.service.TrackServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TrackController {
    private TrackServiceImpl service;

    public TrackController(TrackServiceImpl service) {
        this.service = service;
    }
}
