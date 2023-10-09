package com.example.ch6test1.dto;

import com.example.ch6test1.constant.Role;
import lombok.Getter;
import lombok.Setter;
@Getter@Setter
public class MemberSearchDto {
    private String searchDateType;

    private Role searchRole;

    private String searchBy;

    private String searchQuery = "";
}
