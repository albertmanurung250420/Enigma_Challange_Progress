package com.mandiri.service;

import com.mandiri.dto.ArtistsSearchCriteria;
import com.mandiri.dto.MusicRegisterDto;
import com.mandiri.dto.MusicSearchCriteria;
import com.mandiri.entity.Artists;
import com.mandiri.entity.Music;
import com.mandiri.repository.MusicRepo;
import com.mandiri.spesification.MusicSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class MusicService implements CRUDService<Music, String> {

    @Autowired
    MusicRepo musicRepo;

    @Autowired
    ArtistsService artistsService;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return musicRepo.findAll(pageable);
    }

    public Page<Music> findAll(Pageable pageable, MusicSearchCriteria musicSearchCriteria) {
        Specification<Music> specification = MusicSpecification.getSpecification(musicSearchCriteria);
        return musicRepo.findAll(specification,pageable);
    }

    @Override
    public Music getById(String id) {
        if (!musicRepo.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return musicRepo.findById(id).get();
    }

    @Override
    public void createNew(Music music) {
        musicRepo.save(music);
    }
    public void createNew(MusicRegisterDto musicRegisterDto) {
        Music music = new Music(musicRegisterDto);
        Artists artist = artistsService.getById(musicRegisterDto.getArtistId());
        music.setArtist(artist);
        musicRepo.save(music);
    }

    @Override
    public void update(Music music) {
        artistsService.getById(music.getId());
        getById(music.getId());
        musicRepo.save(music);
    }

    @Override
    public void deleteById(String s) {
        musicRepo.deleteById(s);
    }
}
