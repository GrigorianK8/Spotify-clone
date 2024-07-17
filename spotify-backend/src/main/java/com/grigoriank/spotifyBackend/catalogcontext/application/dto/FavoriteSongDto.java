package com.grigoriank.spotifyBackend.catalogcontext.application.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record FavoriteSongDto(@NotNull boolean favorite, @NotNull UUID publicId) {
}
