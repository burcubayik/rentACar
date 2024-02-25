package com.kodlamaio.rentACar.entities.concretes;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "invoice_number")
	private String invoiceNumber;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "state")
	private int state;

	@ManyToOne
	@JoinColumn(name = "rental_id")
	private Rental rental;

}
