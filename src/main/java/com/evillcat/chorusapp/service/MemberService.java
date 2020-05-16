package com.evillcat.chorusapp.service;

import com.evillcat.chorusapp.model.Member;
import com.evillcat.chorusapp.repository.MemberRepository;
import java.util.List;
import java.util.Optional;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class MemberService {

    private final MemberRepository memberRepository;

    public void create(Member member) {
        memberRepository.save(member);
    }

    public List<Member> getAll() {
        return memberRepository.findAll();
    }

    public Member getById(long id) {
        return memberRepository.getOne(id);
    }

    /**
     *
     * @param member
     * @return null если пользователь не находится в базе.
     */
    public Member update(Member member) {
        Optional optionalMember = memberRepository.findById(member.getId());
        if (optionalMember.isPresent()) {
            memberRepository.save(member);
            return member;
        } else {
            return null;
        }
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }

}
