package com.wiley.beginningspring.ch12;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

public class BusinessService {
	@Secured("ROLE_USER")
	public void secureMethod() {
		System.out.println("secure method");
	}
	
	@PreAuthorize("hasRole('ROLE_EDITOR')")
	public void secureMethod2() {
		System.out.println("secure method 2");
	}
	
	public void secureMethod3() {
		System.out.println("secure method 3");
	}
}
