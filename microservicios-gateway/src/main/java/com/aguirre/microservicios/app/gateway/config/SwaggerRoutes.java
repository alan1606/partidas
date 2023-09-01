package com.aguirre.microservicios.app.gateway.config;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerRoutes {

	@Autowired
	RouteDefinitionLocator locator;

	@Bean
	public List<GroupedOpenApi> apis() {
	   List<GroupedOpenApi> groups = new ArrayList();
	   List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
	   definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches("microservicio-.*")).forEach(routeDefinition -> {
	      String name = routeDefinition.getId().replaceAll("microservicio-", "");
	      System.out.println(name);
	      GroupedOpenApi.builder().pathsToMatch("/api/" + name + "/**").group(name)
	      .build();
	   });
	   return groups;
	}
	
}

