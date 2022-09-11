package com.ark.kesmith.repositories;

import com.ark.kesmith.models.TransactionType;
import org.springframework.data.repository.CrudRepository;

public interface TransactionTypeRepository extends CrudRepository<TransactionType, Integer> {
}
