package com.cooksys.springMock.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cooksys.springMock.dtos.AlbumResponseDto;
import com.cooksys.springMock.mappers.AlbumMapper;
import com.cooksys.springMock.repositories.AlbumRepository;
import com.cooksys.springMock.services.AlbumService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
	
	private final AlbumRepository albumRepository;
	private final AlbumMapper albumMapper;

	@Override
	public List<AlbumResponseDto> getAllAlbums() {
		return albumMapper.entitiesToDtos(albumRepository.findAll());
	}

}
