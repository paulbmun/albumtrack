package com.cooksys.springMock.services;

import com.cooksys.springMock.dtos.AlbumRequestDto;
import com.cooksys.springMock.dtos.AlbumResponseDto;
import com.cooksys.springMock.dtos.TrackRequestDto;

import java.util.List;

public interface AlbumService {

	List<AlbumResponseDto> getAllAlbums();

	AlbumResponseDto createAlbum(AlbumRequestDto albumRequestDto);

	List<AlbumResponseDto> getAlbumsByArtist(String artistName);

	AlbumResponseDto deleteAlbum(Long albumID);

	AlbumResponseDto addTrackToAlbum(Long albumID, TrackRequestDto trackRequestDto);
}
