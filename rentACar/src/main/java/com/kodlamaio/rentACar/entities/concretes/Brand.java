package com.kodlamaio.rentACar.entities.concretes;

import java.util.List;




import com.kodlamaio.rentACar.business.request.brands.CreateBrandRequest;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "brands")
public class Brand {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "brand")
	List<Car> cars;

}
