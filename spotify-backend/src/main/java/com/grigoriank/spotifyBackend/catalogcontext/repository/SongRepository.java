package com.grigoriank.spotifyBackend.catalogcontext.repository;

import com.grigoriank.spotifyBackend.catalogcontext.domain.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Song, Long> {
}
