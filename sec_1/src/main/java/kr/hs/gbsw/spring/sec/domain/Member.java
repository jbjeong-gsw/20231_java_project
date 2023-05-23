package kr.hs.gbsw.spring.sec.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Member {
    //private int userIdx;

    private String email;

    private String password;

    private String name;

    private String phoneNumber;

    private int grade;
}
