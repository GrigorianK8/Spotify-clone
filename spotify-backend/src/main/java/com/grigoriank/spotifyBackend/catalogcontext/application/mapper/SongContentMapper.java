package com.grigoriank.spotifyBackend.catalogcontext.application.mapper;

import com.grigoriank.spotifyBackend.catalogcontext.application.dto.SaveSongDTO;
import com.grigoriank.spotifyBackend.catalogcontext.application.dto.SongContentDTO;
import com.grigoriank.spotifyBackend.catalogcontext.domain.SongContent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongContentMapper {

    @Mapping(source = "song.publicId", target = "publicId")
    SongContentDTO songContentToSongContentDTO(SongContent songContent);

    SongContent saveSongDTOToSong(SaveSongDTO songDTO);
}
