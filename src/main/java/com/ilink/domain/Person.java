package com.ilink.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode

public class Person {
	
	public Integer id;
	private String firstName;
	private String lastName;
	private String contactNo;
	private String email;
	

}
