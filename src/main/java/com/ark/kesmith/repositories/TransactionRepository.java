package com.ark.kesmith.repositories;

import com.ark.kesmith.models.Transaction;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
//    List<Article> findAllByPublicationTimeBetween( // saving, this may be useful later
//            Date publicationTimeStart,
//            Date publicationTimeEnd);
}
