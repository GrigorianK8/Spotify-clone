package com.grigoriank.spotifyBackend.catalogcontext.repository;

import com.grigoriank.spotifyBackend.catalogcontext.domain.Favorite;
import com.grigoriank.spotifyBackend.catalogcontext.domain.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {
}
