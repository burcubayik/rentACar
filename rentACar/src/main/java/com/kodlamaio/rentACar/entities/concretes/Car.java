package com.kodlamaio.rentACar.entities.concretes;

import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	
	@Column(name = "description")
	
	private String description;

	
	@Column(name = "dailyPrice")
	private double dailyPrice;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToOne
	@JoinColumn(name = "color_id")
	private Color color;

	@Column(name = "state")
	private int state;

	@Column(name = "plate")
	private String plate;
	
	@Column(name = "min_findex")
	private int minFindex;

	
	@Column(name = "kilometer")
	private int kilometer;

	@OneToMany(mappedBy = "car")
	List<Maintenance> maintenances;

	@OneToMany(mappedBy = "car")
	List<Rental> rentals;

}
