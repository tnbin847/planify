package com.bini.planify.domain.user.mapper;

import com.bini.planify.domain.user.dto.SignUpRequest;
import com.bini.planify.domain.user.dto.UserAuthorityRequest;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-04
 */

@Mapper
public interface UserMapper {
    /* 아이디 중복 검증 */
    int selectCountById(String loginId);

    /* 이메일 중복 검증 */
    int selectCountByEmail(String email);

    /* 가입 정보 등록 */
    int insertUser(SignUpRequest signUpRequest);

    /* 가입된 사용자의 권한 정보 등록 */
    void insertUserAuthority(UserAuthorityRequest userAuthorityRequest);
}
