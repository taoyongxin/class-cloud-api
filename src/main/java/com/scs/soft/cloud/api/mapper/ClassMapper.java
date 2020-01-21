package com.scs.soft.cloud.api.mapper;

import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 */
public interface ClassMapper {
    /**
     * 根据用户id查询用户加入的班课
     * @param userId
     * @return
     * @throws SQLException
     */
    @Results({
            @Result(property = "userList",column = "creator_id",
                    many = @Many(select = "com.scs.soft.cloud.api.mapper.UserMapper.getUserById")
            )
    })
    @Select("SELECT t1.id,t1.creator_id,t1.thumbnail,t1.class_type,t1.name as name1,t2.name as name2,t2.avatar " +
            "FROM t_user_class t3 " +
            "LEFT JOIN t_user t2 " +
            "ON t3.user_id = t2.id " +

            "LEFT JOIN t_class t1 " +
            "ON t3.class_id = t1.id " +


            "WHERE t3.user_id = #{userId}")
    List<Map> getClassByUserId(@Param("userId") int userId) throws SQLException;
}
