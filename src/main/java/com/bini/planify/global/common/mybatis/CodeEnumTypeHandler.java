package com.bini.planify.global.common.mybatis;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author PARK-SU-BIN
 * @version 0.1
 * @since 2024-08-04
 */

@MappedTypes(CodeEnum.class)
public class CodeEnumTypeHandler<E extends Enum<E> & CodeEnum> extends BaseTypeHandler<E> {
    private final Class<E> type;        // 데이터베이스 작업이 필요한 열거형 클래스
    private final E[] enumConstants;    // 열거형 클래스 내에 정의된 상수값들로 이루어진 배열

    public CodeEnumTypeHandler(Class<E> type) {
        this.type = Objects.requireNonNull(type, "Type argument cannot be null!"); // 인자 값의 null 여부 체크
        this.enumConstants = type.getEnumConstants();
    }

    /**
     * 데이터베이스로부터 가져온 코드를 알맞은 열거형 클래스로 변환한다.
     *
     * @param dbCode    데이터베이스로부터 가져온 코드값
     * @return          {@code E} 열거형
     */
    private E toCodeEnum(final String dbCode) {
        return Arrays.stream(enumConstants)
                .filter(e -> e.getCodeEnum().equals(dbCode))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("This " + dbCode + " is cannot convert to " + type.getSimpleName() + "!"));
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getCodeEnum());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        final String dbCode = rs.getString(columnName);
        return rs.wasNull() ? null : toCodeEnum(dbCode);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        final String dbCode = rs.getString(columnIndex);
        return rs.wasNull() ? null : toCodeEnum(dbCode);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        final String dbCode = cs.getString(columnIndex);
        return cs.wasNull() ? null : toCodeEnum(dbCode);
    }
}