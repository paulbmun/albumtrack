package com.cooksys.springMock.services.impl;

import com.cooksys.springMock.dtos.AlbumRequestDto;
import com.cooksys.springMock.dtos.AlbumResponseDto;
import com.cooksys.springMock.dtos.TrackRequestDto;
import com.cooksys.springMock.entities.Album;
import com.cooksys.springMock.entities.Track;
import com.cooksys.springMock.mappers.AlbumMapper;
import com.cooksys.springMock.mappers.TrackMapper;
import com.cooksys.springMock.repositories.AlbumRepository;
import com.cooksys.springMock.repositories.TrackRepository;
import com.cooksys.springMock.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumMapper albumMapper;
    private final AlbumRepository albumRepository;

    private final TrackMapper trackMapper;
    private final TrackRepository trackRepository;

    @Override
    public List<AlbumResponseDto> getAllAlbums() {
        return albumMapper.entitiesToDtos(albumRepository.findAll());
    }

    @Override
    public List<AlbumResponseDto> getAlbumsByArtist(String artistName) {
        List<Album> albums = albumRepository.findByArtist(artistName);

        return albumMapper.entitiesToDtos(albums);
    }


    @Override
    public AlbumResponseDto createAlbum(AlbumRequestDto albumRequestDto) {
        Album album = albumMapper.dtoToEntity(albumRequestDto);
        album.setArtist(album.getArtist());
        albumRepository.saveAndFlush(album);
        return albumMapper.entityToDto(album);
    }

    @Override
    public AlbumResponseDto deleteAlbum(Long albumID) {
        Optional<Album> optionalAlbum = albumRepository.findById(albumID);
        Album album = optionalAlbum.get();
        albumRepository.delete(album);
        return albumMapper.entityToDto(albumRepository.saveAndFlush(album));
    }

    @Override
    public AlbumResponseDto addTrackToAlbum(Long albumID, TrackRequestDto trackRequestDto) {
        Album album = albumRepository.findById(albumID).get();
        Track track = trackMapper.dtoToEntity(trackRequestDto);

        album.setArtist(album.getArtist());
        track.setAlbum(album);

        trackRepository.saveAndFlush(track);

        album.getTracks().add(track);

        return albumMapper.entityToDto(albumRepository.saveAndFlush(album));
    }
}