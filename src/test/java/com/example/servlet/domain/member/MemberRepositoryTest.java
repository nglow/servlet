package com.example.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // Given
        var member   = new Member("nam", 32);

        // When
        memberRepository.save(member);

        // Then
        var memberRetrieved = memberRepository.findBy(member.getId());
        System.out.println(member); // 16진수
        System.out.println(memberRetrieved);
        System.out.println();
        System.out.println(System.identityHashCode(member)); // 10진수
        System.out.println(System.identityHashCode(memberRetrieved));

        assertThat(memberRetrieved).isEqualTo(member);
    }

    @Test
    void findAll() {
        // Given
        var member1 = new Member("member1", 20);
        var member2 = new Member("member2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);

        // When
        var all = memberRepository.findAll();

        // Then
        assertThat(all.size()).isEqualTo(all.size());

    }

}