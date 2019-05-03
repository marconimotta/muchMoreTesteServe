package com.muchmoretest.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ResourceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 9201818288976729224L;
	
	private String resourceName;
    private String fieldName1;
    private Object fieldName2;

    public ResourceNotFoundException( String resourceName, String fieldName1, Object fieldName2) {
        super(String.format("%s not found. %s %s", resourceName, fieldName1, fieldName2));
        this.resourceName = resourceName;
        this.fieldName1 = fieldName1;
        this.fieldName2 = fieldName2;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieldName1() {
        return fieldName1;
    }

    public Object getFieldName2() {
        return fieldName2;
    }
}