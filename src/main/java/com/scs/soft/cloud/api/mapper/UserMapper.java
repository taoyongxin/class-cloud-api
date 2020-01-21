package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.domain.entity.User;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;

/**
 * @author Tao
 */
public interface UserMapper {
    /**
     * 根据手机号查询用户自身信息
     * @param registerDto
     * @return
     * @throws SQLException
     */
    @Select({"<script>",
            "SELECT * FROM t_user ",
            "WHERE 1=1 ",
            "<when test = 'registerDto.mobile!=null'> ",
            "AND mobile = #{registerDto.mobile} ",
            "</when>",
            "</script>"})
    User findUserByMobile(@Param("registerDto") RegisterDto registerDto) throws SQLException;

   /* @Select("SELECT * FROM t_user WHERE mobile=#{mobile}")
    User get(User user) throws SQLException;*/

    /**
     * 新增用户（主表），并返回自增主键
     * @param user
     * @throws SQLException
     */
    @Insert("INSERT INTO t_user (mobile,nickname,email,name,gender,school,faculty,job_number,experience,charisma,join_class_number," +
            "create_class_number,resource_number,activity_number,create_time,avatar,profession,birthday)" +
            "VALUES (#{mobile},#{nickname},#{email},#{name},#{gender},#{school},#{faculty},#{jobNumber},#{experience},#{charisma}," +
            "#{joinClassNumber},#{createClassNumber},#{resourceNumber},#{activityNumber},#{createTime},#{avatar},#{profession},#{birthday})")
    @Options(useGeneratedKeys = true,keyProperty = "mobile")
    void insert(User user) throws SQLException;

    /**
     * 修改用户信息
     * @param user
     * @throws SQLException
     */
    @Update("UPDATE t_user SET name=#{name},nickname=#{nickname},gender=#{gender},birthday=#{birthday},profession=#{profession}" +
            ",job_number=#{jobNumber},school=#{school},faculty=#{faculty},avatar=#{avatar} " +
            "WHERE mobile=#{mobile}")
    void update(User user) throws SQLException;
}
