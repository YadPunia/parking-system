package com.yad.parking.parkingsystem.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yad.parking.parkingsystem.model.BillAmountReciept;

@Repository
public interface BillRepository extends MongoRepository<BillAmountReciept, String>{

}
