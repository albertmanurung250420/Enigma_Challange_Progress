package com.mandiri.repository;

import com.mandiri.entity.Artists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ArtistRepo extends JpaRepository<Artists, String>, JpaSpecificationExecutor<Artists> {

}