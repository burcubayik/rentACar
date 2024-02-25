package com.kodlamaio.rentACar.entities.concretes;

import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cities")
public class City {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "pickUpCity")
    private List<Rental> pickUpCities;

    @OneToMany(mappedBy = "returnCity")
    private List<Rental> returnCities;
    

}
