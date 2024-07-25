package com.grigoriank.spotifyBackend.catalogcontext.repository;

import com.grigoriank.spotifyBackend.catalogcontext.domain.Favorite;
import com.grigoriank.spotifyBackend.catalogcontext.domain.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {

    List<Favorite> findAllByUserEmailAndSongPublicIdIn(String email, List<UUID> songPublicIds);
}
