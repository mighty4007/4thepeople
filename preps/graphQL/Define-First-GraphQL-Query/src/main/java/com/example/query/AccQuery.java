package com.example.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;



@Component
public class AccQuery implements GraphQLQueryResolver {

	public String firstQuery () {
		return "First Query";
	}
}
