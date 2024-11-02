package com.springboot.rest.webservices.rest_full_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringControler {
	
	
//	si queremos hacer dinamico lo que queremos mostrar en cada llamada al controler lo hacemos directo en el controler 
	
	
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		
		// definimos la variable filter de tipo SimpleBeanPropertyFilter y generamos una instancia  del SimpleBeanPropertyFilter dicendole los filtros de deseemos incluir
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		
//		definimos la variable que contendra todos los filtros que deseamos, en el primer 
//		parametro del addFilter definimos la key de donde estaremos obteniendo el nombre de los filtros
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		
//		seteamos los filtros en el mappingJacksonFilter, que esto es lo que va a retornar
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
		
	}
	
	
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		
		List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"), new SomeBean("value4", "value5", "value6"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
		

		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		
		

		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
		
		
	}
	
	
	

}
