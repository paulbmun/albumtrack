package com.cooksys.springMock.services;

import com.cooksys.springMock.dtos.AlbumRequestDto;
import com.cooksys.springMock.dtos.AlbumResponseDto;
import com.cooksys.springMock.dtos.TrackRequestDto;

import java.util.List;

public interface AlbumService {

	List<AlbumResponseDto> getAllAlbums();

	List<AlbumResponseDto> geAlbumsByArtist(String artistName);

	AlbumResponseDto addTrackToAlbum(Long albumId, TrackRequestDto trackRequestDto);

	AlbumResponseDto createAlbum(AlbumRequestDto albumRequestDto);

	AlbumResponseDto deleteAlbum(Long albumId);
}
