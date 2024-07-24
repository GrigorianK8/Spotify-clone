package com.grigoriank.spotifyBackend.catalogcontext.application;

import com.grigoriank.spotifyBackend.catalogcontext.application.dto.ReadSongInfoDTO;
import com.grigoriank.spotifyBackend.catalogcontext.application.dto.SaveSongDTO;
import com.grigoriank.spotifyBackend.catalogcontext.application.dto.SongContentDTO;
import com.grigoriank.spotifyBackend.catalogcontext.application.mapper.SongContentMapper;
import com.grigoriank.spotifyBackend.catalogcontext.application.mapper.SongMapper;
import com.grigoriank.spotifyBackend.catalogcontext.domain.Song;
import com.grigoriank.spotifyBackend.catalogcontext.domain.SongContent;
import com.grigoriank.spotifyBackend.catalogcontext.repository.SongContentRepository;
import com.grigoriank.spotifyBackend.catalogcontext.repository.SongRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SongService {

    private final SongMapper songMapper;
    private final SongRepository songRepository;
    private final SongContentRepository songContentRepository;
    private final SongContentMapper songContentMapper;

    public SongService(SongMapper songMapper, SongRepository songRepository,
                       SongContentRepository songContentRepository, SongContentMapper songContentMapper) {
        this.songMapper = songMapper;
        this.songRepository = songRepository;
        this.songContentRepository = songContentRepository;
        this.songContentMapper = songContentMapper;
    }

    public ReadSongInfoDTO create(SaveSongDTO saveSongDTO) {
        Song song = songMapper.saveSongDTOToSong(saveSongDTO);
        Song songSaved = songRepository.save(song);

        SongContent songContent = songContentMapper.saveSongDTOToSong(saveSongDTO);
        songContent.setSong(songSaved);

        songContentRepository.save(songContent);
        return songMapper.songToReadSongInfoDTO(songSaved);
    }

    @Transactional(readOnly = true)
    public List<ReadSongInfoDTO> getAll() {
        return songRepository.findAll()
                .stream()
                .map(songMapper::songToReadSongInfoDTO)
                .toList();
    }

    public Optional<SongContentDTO> getOneByPublicId(UUID publicId) {
        Optional<SongContent> songByPublicId = songContentRepository.findOneBySongPublicId(publicId);
        return songByPublicId.map(songContentMapper::songContentToSongContentDTO);
    }
}
