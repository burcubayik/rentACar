package com.kodlamaio.rentACar.entities.concretes;

import java.time.LocalDate;
import java.util.List;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rentals")
public class Rental {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "pick_up_date")
	private LocalDate pickUpDate;

	@Column(name = "return_date")
	private LocalDate returnDate;

	@Column(name = "total_days")
	private int totalDays;

	@Column(name = "total_price")
	private double totalPrice;

	@ManyToOne()	
	@JoinColumn(name = "car_id")
	private Car car;
	
	@ManyToOne
    @JoinColumn(name = "pick_up_city_id") //aynı tablodan
    private City pickUpCity;

    @ManyToOne
    @JoinColumn(name = "return_city_id")
    private City returnCity;
    
    @OneToMany(mappedBy = "rental")
	List<OrderedAdditionalItem> orderedAdditionalItems;
    
    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;
    
    @OneToOne(mappedBy = "rental")
    private Invoice invoice;

}
