package com.ark.kesmith.repositories;

import com.ark.kesmith.models.Investor;
import org.springframework.data.repository.CrudRepository;

public interface InvestorRepository extends CrudRepository<Investor, Integer> {
    Investor findById(int id);


}
