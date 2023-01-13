package net.first.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="id")
	private long id;
	@Column(name="name")
private String name;
	@Column(name ="email")
private String email;
    
public Student() {
	super();
	// TODO Auto-generated constructor stub
}

public Student(long id, String name, String email) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
}

public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", email=" + email + "]";
}
}
