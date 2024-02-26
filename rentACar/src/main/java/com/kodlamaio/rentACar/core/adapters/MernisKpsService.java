package com.kodlamaio.rentACar.core.adapters;

import mernis.RSCKPSPublicSoap;
import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar.business.abstracts.UserCheckService;
import com.kodlamaio.rentACar.entities.concretes.IndividualCustomer;

@Service
public class MernisKpsService implements UserCheckService{

	@Override
	public boolean checkIfRealPerson(IndividualCustomer individualCustomer) {
		try {
			RSCKPSPublicSoap kpsPublicSoapProxy = new RSCKPSPublicSoap();
			boolean isValidPerson = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(individualCustomer.getNationality()),
					individualCustomer.getFirstName().toUpperCase(), individualCustomer.getLastName().toUpperCase(), individualCustomer.getBirthDate());
			return isValidPerson;
		}
		catch (Exception e) {
			System.out.println("Kişi bulunamadı");
		}
		return true;
	}

}
