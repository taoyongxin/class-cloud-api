package com.scs.soft.cloud.api.mapper;

import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 */
public interface AuthorityMapper {
    /**
     * 通过父级权限码查询权限码
     * @param fatherAuthority
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_authority WHERE father_authority=#{fatherAuthority} ")
    List<Map> getAuthorityByFatherAuthority(String fatherAuthority) throws SQLException;

}
