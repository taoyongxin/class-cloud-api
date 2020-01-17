package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.dto.QueryDto;
import com.scs.soft.cloud.api.domain.entity.UserLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;

/**
 * @author Tao
 */
public interface UserLoginMapper {
    /**
     * 根据id或手机号查询用户自身信息
     * @param queryDto
     * @return
     * @throws SQLException
     */
    @Select({"<script>",
            "SELECT * FROM t_user_login ",
            "WHERE 1=1 ",
            "<when test='queryDto.id!=null'> ",
            "AND id = #{queryDto.id} ",
            "</when> ",
            "<when test='queryDto.equalsString!=null'> ",
            "AND mobile = #{queryDto.equalsString} ",
            "</when> ",
            "</script>"})
    UserLogin findUserBy(@Param("queryDto") QueryDto queryDto) throws SQLException;

    /**
     * 新增用户（t_user_login表）
     * @param userLogin
     * @throws SQLException
     */
    @Insert("INSERT INTO t_user_login (mobile,password,code,status)" +
            "VALUES (#{mobile},#{password},#{code},#{status})" )
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(UserLogin userLogin) throws SQLException;


}
