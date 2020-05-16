package com.evillcat.chorusapp.service;

import com.evillcat.chorusapp.model.Member;
import com.evillcat.chorusapp.repository.MemberRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Data
@RequiredArgsConstructor
public class SubscriptionService {

    private final MemberRepository memberRepository;

    public boolean subscribeMember(Member member) {
        memberRepository.save(member);
        return member.equals(memberRepository.getOne(member.getId()));
    }

    public boolean unsubscribe(Member member) {
        memberRepository.delete(member);
        return !member.equals(memberRepository.getOne(member.getId()));
    }
}
