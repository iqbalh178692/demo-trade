package com.example.demotrade.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demotrade.model.Trade;

/**
 * @author iqbalhussain
 *
 */
public interface TradeRepository extends JpaRepository<Trade, Long> {

}
