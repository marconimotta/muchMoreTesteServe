package com.muchmoretest.job;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.muchmoretest.payload.movie.MovieImport;
import com.muchmoretest.repository.movie.MovieRepository;
import com.muchmoretest.util.Utils;
/** Classe responsável por realizar importação utilizando o @Scheduled do Spring 
 * com um cron definido de 1 em 1 minuto (Apenas exemplo).
 * 
 */
@Component
public class ImportMoviesJob {

	@Autowired
	MovieRepository movieRepository;
	
	@Scheduled(cron = "0 */2 * ? * *")
	public void importMovies() {
		try {
			MovieImport movies = Utils.getExternalService("/movie/now_playing?api_key=738887c441178634b4f3c49a8b776d16", MovieImport.class);
			if(Objects.nonNull(movies.getResults()) && movies.getResults().size() > 0) {
				movieRepository.deleteAll();
				movieRepository.saveAll(movies.getResults());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
