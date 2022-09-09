package com.ark.kesmith.repositories;

import com.ark.kesmith.models.Fund;
import org.springframework.data.repository.CrudRepository;

public interface FundRepository extends CrudRepository<Fund, Integer> {
}
