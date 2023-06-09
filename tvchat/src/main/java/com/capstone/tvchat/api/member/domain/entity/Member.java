package com.capstone.tvchat.api.member.domain.entity;

import com.capstone.tvchat.api.bookmark.domain.entity.Bookmark;
import com.capstone.tvchat.api.member.domain.entity.enumerate.Authority;
import com.capstone.tvchat.common.BaseEntity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String email;
    private String password;
    private String nickname;
    @Enumerated(EnumType.STRING)
    private Authority authority;
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Bookmark> bookmarkList = new ArrayList<>();

    @Builder(builderClassName = "memberSignupBuilder", builderMethodName = "memberSignupBuilder")
    public Member(Long id, String email, String password, String nickname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
}
