package com.bini.planify.domain.user.dto.enums;

import com.bini.planify.global.common.mybatis.CodeEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-04
 */


@Getter
@RequiredArgsConstructor
public enum LoginType implements CodeEnum {
    GENERAL ("GENERAL", "일반 로그인 사용자"),
    SOCIAL ("OAUTH", "소셜 로그인 사용자");

    private final String code;
    private final String label;

    @Override
    public String getCodeEnum() {
        return code;
    }
}
