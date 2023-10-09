package com.example.ch6test1.repository;

import com.example.ch6test1.dto.MemberSearchDto;
import com.example.ch6test1.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRepositoryCustom {
    Page<Member> getAdminMemberPage(MemberSearchDto memberSearchDto, Pageable pageable);
}
