package com.student.dal.studentDAL.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="location")
public class Location {

	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "code" , nullable=false)
	private String Code;
	@Column(name = "name" , nullable=false)
	private String name;
	@Column(name = "type" , nullable=false)
	private String type;
	
	public Location() {
		
	}
	public Location(int id, String code, String name, String type) {
		super();
		this.id = id;
		Code = code;
		this.name = name;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Location [id=" + id + ", Code=" + Code + ", name=" + name + ", type=" + type + "]";
	}

}
