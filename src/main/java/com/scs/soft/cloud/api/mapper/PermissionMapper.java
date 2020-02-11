package com.scs.soft.cloud.api.mapper;

import org.apache.ibatis.annotations.Select;

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
}
