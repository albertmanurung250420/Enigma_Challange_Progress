package com.mandiri.controller;

import com.mandiri.dto.ArtistsSearchCriteria;
import com.mandiri.entity.Artists;
import com.mandiri.service.ArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Date;

@RestController
public class ArtistsController {
    @Autowired
    ArtistsService artistsService;

    @PostMapping("/artist")
    public void registerArtist(@Validated @RequestBody Artists artists){
        artistsService.createNew(artists);
    }

    @GetMapping("/artist")
    public Page<Artists> findAll(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "5") Integer size,
                                @RequestParam(required = false) String name,
                                @RequestParam(required = false) String birthPlace,
                                @RequestParam(required = false) Date startBirthDate,
                                @RequestParam(required = false) Date endBirthDate,
                                @RequestParam(required = false) String email,
                                @RequestParam(required = false) String phone,
                                @RequestParam(required = false) String gender){
        Pageable pageable = PageRequest.of(page-1,size);
        return artistsService.findAll(pageable, new ArtistsSearchCriteria(name, birthPlace, startBirthDate, endBirthDate, email, phone, gender));
    }

    @GetMapping("/artist/{id}")
    public Artists getById(@PathVariable String id){
        return artistsService.getById(id);
    }

    @PutMapping("/artist")
    public void update(@RequestBody Artists artist){
        artistsService.update(artist);
    }

    @DeleteMapping("/artist/{id}")
    public void delete(@PathVariable String id){
        artistsService.deleteById(id);
    }

}
