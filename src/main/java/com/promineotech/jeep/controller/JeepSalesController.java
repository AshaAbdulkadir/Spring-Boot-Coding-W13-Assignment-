package com.promineotech.jeep.controller;

import java.util.List;
import com.promineotech.jeep.entity.Jeep;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
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
					@ApiResponse(responseCode = "200", description = "A list of jeeps is returned"),
					@ApiResponse(responseCode = "400", description = "The request parameters are invalid"),
					@ApiResponse(responseCode = "404", description = "No jeeos were found with input criteria"),
					@ApiResponse(responseCode = "500", description = "An unplanned error occured.")
			},
			parameters = {
					
			}
	)
	// @formatter:on
	
	List<Jeep> fetchJeeps(String model, String trim);

}
