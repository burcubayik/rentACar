package com.kodlamaio.rentACar.entities.concretes;

import java.util.List;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "additional_items")
public class AdditionalItem {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "daily_price")
	private double dailyPrice;
	
	@OneToMany(mappedBy = "additionalItem")
	List<OrderedAdditionalItem> orderedAdditionalItems;

}
