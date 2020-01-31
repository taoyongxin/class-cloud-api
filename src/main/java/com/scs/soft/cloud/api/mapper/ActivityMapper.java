package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;

/**
 * @author Tao
 */
public interface ActivityMapper {
    /**
     * 创建活动
     * @param activity
     * @throws SQLException
     */
     @Insert("INSERT INTO t_activity VALUES (null,#{groupId},#{userId},#{name},#{type},#{status},#{theme}," +
             "#{beginTime},#{endTime},#{joinPersonNumber},#{experience},#{thumbnail},#{purpose})")
     @Options(useGeneratedKeys = true,keyProperty = "id")
     void insert(Activity activity) throws SQLException;

    /**
     * 通过活动id查询活动
     * @param id
     * @return
     * @throws SQLException
     */
     @Select("SELECT * FROM t_activity WHERE id=#{id}")
     Activity getActivityById(int id) throws SQLException;

    /**
     * 修改活动信息
     * @param activity
     * @throws SQLException
     */
     @Update("UPDATE t_activity SET group_id = #{groupId} , name = #{name} , status = #{status} , begin_time = #{beginTime}" +
             ", end_time = #{endTime},purpose = #{purpose} WHERE id = #{id} ")
    void update(Activity activity) throws SQLException;


}
