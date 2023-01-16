package com.microservice.movies.resource;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.movies.model.CatalogItems;
import com.microservice.movies.model.Movie;
import com.microservice.movies.model.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItems> getCatalog(@PathVariable("userId")String userId)
	{
		//get all rated movies Ids
		List<Rating> ratingsList=Arrays.asList(new Rating("101",3),
				                              new Rating("102",4),
				                              new Rating("103",2),
				                              new Rating("104",5),
				                              new Rating("105",4),
				                              new Rating("106",1)
				                              ); 
		
		//For eache movie ID, call movie-information-service and get details
		
		return ratingsList.stream().map( rating -> {
			Movie movie = restTemplate.getForObject("http://localhost:9092/movies/"+rating.getMovieId(), Movie.class);
			
			//put them all together
			return new CatalogItems(movie.getName(),"Desc",rating.getRating());
		})
		.collect(Collectors.toList());
		
		
		
		
		
		//return Collections.singletonList(new CatalogItems("Transformers","Test",4));
		
	}
	
}
