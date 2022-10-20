package com.mandiri.service;

import com.mandiri.dto.ArtistsSearchCriteria;
import com.mandiri.dto.MusicSearchCriteria;
import com.mandiri.entity.Artists;
import com.mandiri.entity.Music;
import com.mandiri.repository.ArtistRepo;
import com.mandiri.spesification.ArtistSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ArtistsService implements CRUDService<Artists, String> {
    @Autowired
    ArtistRepo artistRepo;

    @Override
    public Page<Artists> findAll(Pageable pageable) {
        return artistRepo.findAll(pageable);
    }

    public Page<Artists> findAll(Pageable pageable, ArtistsSearchCriteria artistsSearchCriteria) {
        Specification<Artists> specification = ArtistSpecification.getSpecification(artistsSearchCriteria);
        return artistRepo.findAll(specification,pageable);
    }

    @Override
    public Artists getById(String id) {
        if (!artistRepo.findById(id).isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return artistRepo.findById(id).get();
    }

    @Override
    public void createNew(Artists artists) {
        artistRepo.save(artists);
    }

    @Override
    public void update(Artists artists) {
        getById(artists.getId());
        artistRepo.save(artists);
    }

    @Override
    public void deleteById(String s) {
        artistRepo.deleteById(s);
    }
}
