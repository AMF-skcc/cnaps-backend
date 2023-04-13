package com.sk.member.repository;

import com.sk.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByUsername(String username);

    Member findByEmail(String email);
}
