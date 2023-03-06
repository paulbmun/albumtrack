package com.cooksys.springMock.dtos;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TrackRequestDto {
	
	private String name;
	
	private double length;

}
