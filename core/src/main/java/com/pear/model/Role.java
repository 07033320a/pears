package com.pear.model;

import lombok.Data;

import java.util.List;

@Data
public class Role {

	private Long id;
	private String name;

	private List<Resource> resources;

}
