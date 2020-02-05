package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.dto.PageDto;
import com.scs.soft.cloud.api.domain.entity.UserClass;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    /**
     * 通过班课id查询班课所有成员信息数据
     * @param classId
     * @return
     * @throws SQLException
     */
    @Select("SELECT t1.*,t2.name,t2.avatar,t2.job_number " +
            "FROM t_user_class t1 " +
            "LEFT JOIN t_user t2 " +
            "ON t1.user_id = t2.id " +
            "WHERE t1.class_id = #{classId} AND t1.role_id != 1 " +
            "ORDER BY t1.experience DESC")
    List<Map> getUserClassByClassId(int classId) throws SQLException;

    /**
     * 查询用户数据（分页）
     * @param pageDto
     * @return
     * @throws SQLException
     */
    @Select("SELECT t1.*,t2.name,t2.avatar,t2.job_number " +
            "FROM t_user_class t1 " +
            "LEFT JOIN t_user t2 " +
            "ON t1.user_id = t2.id " +
            "WHERE t1.class_id = #{pageDto.field} AND t1.role_id != 1 " +
            "ORDER BY t1.experience DESC " +
            "LIMIT ${pageDto.pageSize*(pageDto.currentPage-1)},#{pageDto.pageSize}")
    List<Map> getUserMessageByClassId(@Param("pageDto") PageDto pageDto) throws SQLException;
}
