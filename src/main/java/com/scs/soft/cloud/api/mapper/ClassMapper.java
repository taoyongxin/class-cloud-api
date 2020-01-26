package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.Class;
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
            "WHERE t3.user_id = #{userId} AND t3.role_id != 1")
    List<Map> getClassByUserId(@Param("userId") int userId) throws SQLException;

    /**
     * 通过创建者id查询用户创建的班课
     * @param creatorId
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_class WHERE creator_id=#{creatorId} ORDER BY ID DESC")
    List<Class> getClassByCreatorId(int creatorId) throws SQLException;

    /**
     * 通过班课id查询
     * @param id
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_class WHERE id = #{id}")
    Class getClassById(int id) throws SQLException;
    /**
     * 通过班课邀请码查询班课信息
     * @param invitationCode
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_class WHERE invitation_code=#{invitationCode} ORDER BY ID DESC")
    @Results({
            @Result(property = "userList",column = "creator_id",
                    many = @Many(select = "com.scs.soft.cloud.api.mapper.UserMapper.getUserById")
            )
    })
    Map<String,Object> getClassByInvitationCode(@Param("invitationCode") int invitationCode) throws SQLException;

    /**
     * 新增班课
     * @param class1
     * @throws SQLException
     */
    @Insert("INSERT INTO t_class VALUES (null,#{creatorId},#{classType},#{thumbnail},#{name}" +
            ",#{invitationCode},#{status},#{resourceNumber},#{activityNumber},#{messageNumber},#{memberNumber},#{semester}," +
            "#{joinPermission},#{school},#{faculty},#{studyRequirement},#{teachingProgress},#{examArrangement})" )
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Class class1)throws SQLException;


}
