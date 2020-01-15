package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.UserDev;
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
}
