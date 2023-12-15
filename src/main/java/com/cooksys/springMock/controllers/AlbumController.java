package com.cooksys.springMock.controllers;

import com.cooksys.springMock.dtos.AlbumRequestDto;
import com.cooksys.springMock.dtos.AlbumResponseDto;
import com.cooksys.springMock.dtos.TrackRequestDto;
import com.cooksys.springMock.services.AlbumService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
@RequiredArgsConstructor
public class AlbumController {
	
	private final AlbumService albumService;

	@GetMapping
	public List<AlbumResponseDto> getAllAlbums() {
		return albumService.getAllAlbums();
	}

	@GetMapping("/albumName")
	public List<AlbumResponseDto> getAlbumsByArtist(@PathVariable String artistName) {
		return albumService.geAlbumsByArtist(artistName);
	}

	@PatchMapping("/albumId/addTrack")
	public AlbumResponseDto addTrackToAlbum(@PathVariable Long albumId, @RequestBody TrackRequestDto trackRequestDto) {
		return albumService.addTrackToAlbum(albumId, trackRequestDto);
	}

	@PostMapping
	public AlbumResponseDto createAlbum(@RequestBody AlbumRequestDto albumRequestDto) {
		return albumService.createAlbum(albumRequestDto);
	}

	@DeleteMapping("/albumId")
	public AlbumResponseDto deleteAlbum(@PathVariable Long albumId) {
		return albumService.deleteAlbum(albumId);
	}
}
