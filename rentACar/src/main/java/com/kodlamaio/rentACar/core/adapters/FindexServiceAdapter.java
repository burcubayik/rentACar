package com.kodlamaio.rentACar.core.adapters;

import java.util.HashMap;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.kodlamaio.rentACar.business.abstracts.FindexService;
import com.kodlamaio.rentACar.entities.concretes.User;
@Service
public class FindexServiceAdapter implements FindexService {
	Random random = new Random();
	HashMap<String, Integer> findexScores;

	@Override
	public int findexScore(String nationalityId) {
		findexScores = new HashMap<String, Integer>();
		int findexScore = random.nextInt(1900);
		
		findexScores.put(nationalityId, findexScore);
		System.out.println(findexScore);
		return findexScore;
		
	}

}
