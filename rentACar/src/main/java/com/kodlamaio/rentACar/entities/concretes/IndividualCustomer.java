package com.kodlamaio.rentACar.entities.concretes;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "individual_customer")
@PrimaryKeyJoinColumn(name = "individual_customer_id", referencedColumnName = "customer_id")
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class IndividualCustomer extends Customer {
	@Column(name = "individual_customer_id", insertable = false, updatable = false)
	private int individualCustomerId;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "birth_date")
	private int birthDate;



}
