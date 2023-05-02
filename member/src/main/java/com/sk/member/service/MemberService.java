package com.sk.member.service;

import com.sk.member.model.Member;
import com.sk.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Method to create and save a new Member entity
    public Member createMember(String username, String nickname, String email, String role, String password) {
        // Perform password hashing and salting
        Member member = new Member(username, nickname, email, role, password);

        // Save the Member entity to the database
        return memberRepository.save(member);
    }

    public Member updateMember(String email, String nickname, String password) {
        Member member = findByEmail(email);
        member.setPassword(password);
        member.setNickname(nickname);
        return memberRepository.save(member);
    }

    public Member findByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public Page<Member> getAllUsers(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }

    public boolean deleteMember(String email) {
        Member member = memberRepository.findByEmail(email);
        memberRepository.delete(member);
        Member deletedMember = memberRepository.findByEmail(email);
        return deletedMember == null;
    }
}
