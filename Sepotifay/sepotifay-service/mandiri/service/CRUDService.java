package com.mandiri.service;

import com.mandiri.dto.MusicSearchCriteria;
import com.mandiri.entity.Artists;
import com.mandiri.dto.ArtistsSearchCriteria;
import com.mandiri.entity.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CRUDService<T,ID> {
    public Page<T> findAll(Pageable pageable);
    public T getById(ID id);
    public void createNew(T t);
    public void update(T t);
    public void deleteById(ID id);
}
