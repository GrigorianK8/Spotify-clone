package com.grigoriank.spotifyBackend.catalogcontext.repository;

import com.grigoriank.spotifyBackend.catalogcontext.domain.SongContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongContentRepository extends JpaRepository<SongContent, Long> {
}
