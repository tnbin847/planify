package com.bini.planify.domain.user.dto;

import com.bini.planify.domain.user.dto.enums.Role;
import com.bini.planify.global.util.State;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-04
 */

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserAuthorityRequest {
    private Long userId;
    private Role role;
    private String usedAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public UserAuthorityRequest(Long userId, Role role, State usedAt) {
        this.userId = userId;
        this.role = role;
        this.usedAt = usedAt.name();
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
}
