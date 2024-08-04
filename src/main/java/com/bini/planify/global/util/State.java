package com.bini.planify.global.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-04
 */


@RequiredArgsConstructor
@Getter
public enum State {
    Y (1, true),
    N (0, false);

    private final int numeric;
    private final boolean condition;

    /**
     * 파라미터로 전달받은 정수형의 값을 true 또는 false로 변환
     *
     * @return  {@code true} 또는 {@code false}
     */
    public static boolean toBoolean(int flag) {
        return Arrays.stream(values())
                .filter(state -> state.getNumeric() == flag)
                .findFirst()
                .map(State::isCondition)
                .orElseThrow(() -> new IllegalArgumentException("This '" + flag + "' is not valid value!"));
    }
}
