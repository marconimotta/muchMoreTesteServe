package com.muchmoretest.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.muchmoretest.payload.generico.ApiResponse;

public class Utils {
	
	@Value("${api.external.moviedb.url}")
	private static String apiExternalMovieDbUrl;

	
	/**
	 * Método de retorno com ResponseEntity para o tipo created
	 * @param success
	 * @param message
	 * @return ResponseEntity<?>
	 */
	
	public static ResponseEntity<?> created(Boolean sucess, String message) {
		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(sucess, message));
	}
	
	/**
	 * Método de retorno com ResponseEntity para o tipo Ok
	 * @param success
	 * @param message
	 * @return ResponseEntity<?>
	 */

	public static ResponseEntity<?> ok(Boolean sucess, String message) {
		return ResponseEntity.ok().body(new ApiResponse(sucess, message));
	}

	/**
	 * Método de retorno com ResponseEntity para o tipo Bad Request
	 * @param success
	 * @param message
	 * @return ResponseEntity<?>
	 */

	public static ResponseEntity<?> badRequest(Boolean sucess, String message) {
		return ResponseEntity.badRequest().body(new ApiResponse(sucess, message));
	}
	
	/**
	 * Método de retorno com ResponseEntity para o tipo forbidden
	 * @param success
	 * @param message
	 * @return ResponseEntity<?>
	 */
	
	public static ResponseEntity<?> forbidden(Boolean success, String message){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(new ApiResponse(success, message));
	}
	
	/**
	 * Método de retorno com ResponseEntity para o tipo deleted
	 * @param success
	 * @param message
	 * @return ResponseEntity<?>
	 */
	public static ResponseEntity<?> deleted(Boolean success, String message) {
		return ResponseEntity.status(410).body(new ApiResponse(success, message));
	}

	/**
	 * Metodo responsável por realizar chamada da api externa do MovieDb e fornecer retorno de um objeto.
	 * @param url
	 * @param t
	 * @return <T> T
	 */
	public static <T> T getExternalService(String url, Class<T> t) {
		RestTemplate restTemplate = new RestTemplate();
		return (T) restTemplate.getForObject(apiExternalMovieDbUrl+url,t);
		
	}
}
