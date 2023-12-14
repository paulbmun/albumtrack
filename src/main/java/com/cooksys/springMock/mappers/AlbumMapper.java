package com.cooksys.springMock.mappers;

import com.cooksys.springMock.dtos.AlbumRequestDto;
import com.cooksys.springMock.dtos.AlbumResponseDto;
import com.cooksys.springMock.entities.Album;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

	AlbumResponseDto entityToDto(Album album);
	
	List<AlbumResponseDto> entitiesToDtos(List<Album> albums);
	
	Album dtoToEntity(AlbumRequestDto album);
	
}
