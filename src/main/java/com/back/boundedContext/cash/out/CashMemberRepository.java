package com.back.boundedContext.cash.out;

import com.back.boundedContext.cash.domain.CashMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CashMemberRepository extends JpaRepository<CashMember, Integer> {
    Optional<CashMember> findByUsername(String username);
}
