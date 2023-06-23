package com.example.payroll.repo;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.payroll.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
	
	@Query("SELECT p FROM Payment p WHERE p.userId = ?1")
	public List<Payment> getPaymentByUser(String userId, Pageable pageable);

}
