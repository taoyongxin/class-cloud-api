package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.dto.QueryDto;
import com.scs.soft.cloud.api.domain.entity.UserDev;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 */
public interface UserDevMapper {
    /**
     * 根据id降序查找所有用户
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_user_dev ORDER BY id DESC ")
    List<UserDev> selectAll() throws SQLException;

    /**
     * 根据id或手机号查询用户自身信息
     * @param queryDto
     * @return
     * @throws SQLException
     */
    @Select({"<script>",
            "SELECT * FROM t_user_dev ",
            "WHERE 1=1 ",
            "<when test='queryDto.id!=null'> ",
            "AND id = #{queryDto.id} ",
            "</when> ",
            "<when test='queryDto.equalsString!=null'> ",
            "AND mobile = #{queryDto.equalsString} ",
            "</when> ",
            "</script>"})
    UserDev findUserBy(@Param("queryDto") QueryDto queryDto) throws SQLException;
}
