package com.exchange.exchangeservice.logic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exchange.exchangeservice.logic.model.db.Exchange;

public interface ExchangeRepository extends JpaRepository<Exchange, String> {

}
