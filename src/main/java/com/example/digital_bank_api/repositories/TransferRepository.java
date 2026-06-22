package com.example.digital_bank_api.repositories;

import com.example.digital_bank_api.entities.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;


public interface TransferRepository extends JpaRepository<Transfer, Long> {

    @Query("select t from Transfer t order by t.createDt")
    List<Transfer> findAllOrderByCreateDtAsc();
}
