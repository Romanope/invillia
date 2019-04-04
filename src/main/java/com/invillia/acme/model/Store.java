package com.invillia.acme.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STR_STORE")
public class Store implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STR_ID")
	private Long id;
	
	@Column(name = "STR_NM", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
	private List<StoreAddress> addresses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StoreAddress> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<StoreAddress> addresses) {
		this.addresses = addresses;
	}
}
