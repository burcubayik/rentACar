package com.kodlamaio.rentACar.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "corporate_customer")
@PrimaryKeyJoinColumn(name = "corporate_customer_id", referencedColumnName = "customer_id")
@EqualsAndHashCode(callSuper = true)
public class CorporateCustomer extends Customer {
	@Column(name = "corporate_customer_id", insertable = false, updatable = false)
	private int corporateCustomerId;
	@Column(name = "tax_number")
	private String taxNumber;
	@Column(name = "company_name")
	private String companyName;

}
