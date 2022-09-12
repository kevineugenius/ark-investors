package com.ark.kesmith.repositories;

import com.ark.kesmith.models.Transaction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
    List<Transaction> findByFundId(int fund_id);

    List<Transaction> findByFundIdAndInvestorId(int fundId, int investorId);
//    List<Article> findAllByPublicationTimeBetween( // saving, this may be useful later
//            Date publicationTimeStart,
//            Date publicationTimeEnd);
}
