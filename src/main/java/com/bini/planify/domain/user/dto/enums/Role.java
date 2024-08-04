package com.bini.planify.domain.user.dto.enums;

import com.bini.planify.global.common.mybatis.CodeEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-04
 */

@RequiredArgsConstructor
@Getter
public enum Role implements CodeEnum {
    USER ("ROLE_USER", "일반사용자"),
    ADMIN ("ROLE_ADMIN", "관리자");

    private final String code;
    private final String label;

    @Override
    public String getCodeEnum() {
        return code;
    }
}
