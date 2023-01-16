package com.microservice.movies.resource;


import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.microservice.movies.model.Rating;

@RestController
@RequestMapping("/rating")
public class MovieRatingDataResource {

	@RequestMapping("/{movieId}")
	public List<Rating> getCatalog(@PathVariable("movieId")String movieId)
	{
		return Collections.singletonList(new Rating(movieId,4));
		
	}
	
}
