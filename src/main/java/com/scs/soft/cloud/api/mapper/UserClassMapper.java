package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.UserClass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

import java.sql.SQLException;

/**
 * @author Tao
 */
public interface UserClassMapper {
    /**
     * 用户加入班课
     * @param userClass
     * @throws SQLException
     */
    @Insert("INSERT INTO t_user_class VALUES " +
            "(null,#{userId},#{roleId},#{classId},#{experience})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(UserClass userClass) throws SQLException;
}
