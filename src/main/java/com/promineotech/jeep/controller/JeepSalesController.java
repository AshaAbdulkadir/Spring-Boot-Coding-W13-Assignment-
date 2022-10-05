package com.promineotech.jeep.controller;

import java.util.List;
import com.promineotech.jeep.entity.Jeep;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(info = @Info(title = "Jeep Sales Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local server.")})
public interface JeepSalesController {
	
	// @formatter:off
	@Operation(
			summary = "Returns a list of jeeps",
			description = "Returnsa list of Jeeps given an optional model and /or trim",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A list of jeeps is returned", 
							content = @Content(mediaType = "application/json", 
							schema = @Schema(implementation = Jeep.class))),
					@ApiResponse(
							responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "404", 
							description = "No jeeos were found with input criteria", 
							content = @Content(mediaType = "application/json")),
					@ApiResponse(
							responseCode = "500", 
							description = "An unplanned error occured.", 
							content = @Content(mediaType = "application/json"))
			},
			parameters = {
					@Parameter(
							name = "model", 
							allowEmptyValue = false, 
							required = false, 
							description = "The model name (i.e 'WRANGLER')"),
					@Parameter(
							name = "trim", 
							allowEmptyValue = false, 
							required = false, 
							description = "The trim level (i.e 'sport')")
			}
	)
	// @formatter:on
	
	List<Jeep> fetchJeeps(String model, String trim);

}
