package com.cooksys.springMock.services;

import java.util.List;

import com.cooksys.springMock.dtos.AlbumResponseDto;

public interface AlbumService {

	List<AlbumResponseDto> getAllAlbums();


}
