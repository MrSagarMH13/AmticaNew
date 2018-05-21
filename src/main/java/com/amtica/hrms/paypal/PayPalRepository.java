package com.amtica.hrms.paypal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayPalRepository extends JpaRepository<PayPal, Integer> {

}
