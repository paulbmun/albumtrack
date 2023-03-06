package com.cooksys.springMock;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cooksys.springMock.entities.Album;
import com.cooksys.springMock.entities.Track;
import com.cooksys.springMock.repositories.AlbumRepository;
import com.cooksys.springMock.repositories.TrackRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Seeder implements CommandLineRunner {
	
	private final AlbumRepository albumRepository;
	private final TrackRepository trackRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Album album1 = new Album();
		album1.setName("Album 1");
		album1.setArtist("The Real MC");
		
		Track track1 = new Track();
		track1.setName("Song1");
		track1.setArtist("The Real MC");
		track1.setLength(2.20);
		
		Track track2 = new Track();
		track2.setName("Song2");
		track2.setArtist("The Real MC");
		track2.setLength(2.40);
				
		Track track3 = new Track();
		track3.setName("Song3");
		track3.setArtist("The Real MC");
		track3.setLength(3.20);
		
		albumRepository.save(album1);
		trackRepository.saveAll(Arrays.asList(track1, track2, track3));
		track1.setAlbum(album1);
		track2.setAlbum(album1);
		track3.setAlbum(album1);
		album1.setTracks(Arrays.asList(track1, track2, track3));
		
		albumRepository.saveAndFlush(album1);
		trackRepository.saveAndFlush(track1);
		
	}

}
