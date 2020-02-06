package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.Group;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 */
public interface GroupMapper {
    /**
     * 通过分组id查询分组数据信息
     * @param id
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM  t_group WHERE id = #{id}")
    Group getGroupById(int id) throws SQLException;

    /**
     * 通过班课id查询分组数据
     * @param classId
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_group WHERE class_id = #{classId}")
    List<Group> getGroupByClassId(int classId) throws SQLException;

    /**
     * 修改分组信息
     * @param group
     * @throws SQLException
     */
    @Update("UPDATE t_group SET name = #{name} , class_id = #{classId} , sort_id = #{sortId}," +
            "resource_number = #{resourceNumber} , activity_number = #{activityNumber} WHERE id = #{id} ")
    void update(Group group) throws SQLException;

    /**
     * 新增分组
     * @param group
     * @throws SQLException
     */
    @Insert("INSERT INTO t_group VALUES (null,#{name},#{classId},#{sortId},#{resourceNumber},#{activityNumber})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    void insert(Group group) throws SQLException;

    /**
     * 分组情况
     * @param classId
     * @param userId
     * @return
     * @throws SQLException
     */
    @Select("SELECT t1.id as group_table_id,t1.name as group_name,t1.sort_id,t1.activity_number," +
            "t2.id as activity_table_id,t2.group_id,t2.name as activity_name,t2.type,t2.status,t2.join_person_number,t2.experience," +
            "t3.user_id,t3.activity_id,t3.acquisition_experience,t3.join_status " +
            "FROM t_group t1 " +
            "LEFT JOIN t_activity t2 " +
            "ON t1.id = t2.group_id " +
            "LEFT JOIN t_user_activity t3 " +
            "ON t2.id = t3.activity_id " +
            "WHERE t1.class_id = #{classId} AND t1.activity_number != 0 AND t3.user_id = #{userId}")
    List<Map> getGroupMessage(int classId,int userId) throws SQLException;
}
