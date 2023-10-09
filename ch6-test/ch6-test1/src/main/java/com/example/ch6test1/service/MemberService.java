package com.example.ch6test1.service;


<<<<<<< HEAD
import com.example.ch6test1.dto.MemberFormDto;
import com.example.ch6test1.dto.MemberSearchDto;
import com.example.ch6test1.entity.Member;
import com.example.ch6test1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
=======
import com.example.ch6test1.entity.Member;
import com.example.ch6test1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
>>>>>>> origin/ljs_0927
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import javax.persistence.EntityNotFoundException;

=======
>>>>>>> origin/ljs_0927
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public Member saveMember(Member member){
        validateDuplicateMember(member);
        return memberRepository.save(member);
    }

    private void validateDuplicateMember(Member member){
        Member findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember != null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Member member = memberRepository.findByEmail(email);

        if(member == null){
            throw new UsernameNotFoundException(email);
        }

        return User.builder()
                .username(member.getEmail())
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }

<<<<<<< HEAD
    @Transactional(readOnly = true)
    public Page<Member> getAdminMemberPage(MemberSearchDto memberSearchDto, Pageable pageable){
        return memberRepository.getAdminMemberPage(memberSearchDto, pageable);
    }

    @Transactional(readOnly = true)
    public MemberFormDto getMemberDtl(Long memberId){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(EntityNotFoundException::new);
        MemberFormDto memberFormDto = MemberFormDto.of(member);
        return memberFormDto;
    }
    //회원정보 수정 처리 로직
    public Long updateMember(MemberFormDto memberFormDto) throws Exception{
        //회원정보 수정,
        // 기존 회원 정보를 불러오기.
        Member member = memberRepository.findById(memberFormDto.getId())
                .orElseThrow(EntityNotFoundException::new);
        // 기존 아이템에 내용에 , 더티 체킹. 변경사항에 대해서, 영속성이 알아서 자동으로 처리.
        member.updateMember(memberFormDto);
        memberRepository.save(member);


        return member.getId();
    }

=======
>>>>>>> origin/ljs_0927
}