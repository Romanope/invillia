package com.invillia.acme.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADD_ADDRESS")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TP_ENDERECO", length = 1, discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("P")
public class Address implements Serializable {

	// Ideal seria termos uma entidade país, com seus respectivos UFs, cidade, bairros e códigos postais, para que pudessêmos validar as entradas.
	
	@Id
	@Column(name = "ADD_ID", nullable = false, updatable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ADD_CITY", nullable = false)
	private String city; 
	
	@Column(name = "ADD_STREET", nullable = false)
	private String street;
	
	@Column(name = "ADD_NUMBER", nullable = false)
	private String number;
	
	@Column(name = "ADD_NEIGHBORHOOD", nullable = false)
	private String neighborhood;
	
	@Column(name = "ADD_POSTAL_CODE", nullable = true)
	private String postalCode;

	@Column(name = "ADD_FU", nullable = false)
	private String fu;
	
	@Column(name = "ADD_COUNTRY", nullable = false)
	private String country;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getFu() {
		return fu;
	}

	public void setFu(String fu) {
		this.fu = fu;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
