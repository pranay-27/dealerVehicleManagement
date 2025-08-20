package com.taskApi.demo.repository;

import com.taskApi.demo.entity.Dealer;
import com.taskApi.demo.enums.SubscriptionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DealerRepository extends JpaRepository<Dealer,Long> {

    List<Dealer> findBySubscriptionType(SubscriptionType subscriptionType);
}
