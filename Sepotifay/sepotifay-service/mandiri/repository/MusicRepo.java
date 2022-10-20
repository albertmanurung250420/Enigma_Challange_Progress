package com.mandiri.repository;

import com.mandiri.entity.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface MusicRepo extends JpaRepository<Music, String>, JpaSpecificationExecutor<Music> {
}