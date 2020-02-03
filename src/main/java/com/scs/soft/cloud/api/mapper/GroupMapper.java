package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.Group;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;

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
}
