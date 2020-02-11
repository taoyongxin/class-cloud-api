package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.domain.entity.Permission;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author Tao
 */
public interface PermissionMapper {
    /**
     * 通过父类权限码获取权限数据
     * @param parentId
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_permission WHERE parent_id = #{parentId} ORDER BY sort ASC")
    List<Map> getPermissionByParentId(int parentId) throws SQLException;

    /**
     * 根据id查询权限
     * @param id
     * @return
     * @throws SQLException
     */
    @Select("SELECT * FROM t_permission WHERE id = #{id}")
    Permission getPermissionById(int id) throws SQLException;

    /**
     * 修改style
     * @param permission
     * @throws SQLException
     */
    @Update("UPDATE t_permission SET style = #{style} WHERE id = #{id} ")
    void updateStyle(Permission permission) throws SQLException;
}
