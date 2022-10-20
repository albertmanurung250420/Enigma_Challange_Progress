package com.mandiri.controller;

import com.mandiri.dto.MusicRegisterDto;
import com.mandiri.dto.MusicSearchCriteria;
import com.mandiri.entity.Music;
import com.mandiri.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class MusicController {
    @Autowired
    MusicService musicService;

    @GetMapping("/music")
    public Page<Music> getAllMusic(@RequestParam(defaultValue = "1") Integer page,
                                   @RequestParam(defaultValue = "5") Integer size,
                                   @RequestParam(required = false) String title,
                                   @RequestParam(required = false) String composer,
                                   @RequestParam(required = false) String studio,
                                   @RequestParam(required = false) String artistName){
        Pageable pageable = PageRequest.of(page-1,size);
        return musicService.findAll(pageable, new MusicSearchCriteria(title,composer,studio, artistName));
    }

    @PostMapping("/music")
    public void createNewMusic(@Validated @RequestBody MusicRegisterDto musicRegisterDto){
        musicService.createNew(musicRegisterDto);
    }

    @GetMapping("/music/{id}")
    public Music getById(@PathVariable String id){
        return musicService.getById(id);
    }

    @PutMapping("/music")
    public void update(@RequestBody Music music){
        musicService.update(music);
    }

    @DeleteMapping("/music/{id}")
    public void delete(@PathVariable String id){
        musicService.deleteById(id);
    }

}
