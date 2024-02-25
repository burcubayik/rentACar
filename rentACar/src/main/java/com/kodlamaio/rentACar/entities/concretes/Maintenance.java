package com.kodlamaio.rentACar.entities.concretes;

import java.time.LocalDate;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "maintenances")
public class Maintenance {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "date_sent")
	private LocalDate dateSent;

	@Column(name = "date_returned")
	private LocalDate dateReturned;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

}
