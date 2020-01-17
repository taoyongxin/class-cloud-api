package com.scs.soft.cloud.api.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.sql.SQLException;

/**
 * @author Tao
 */
public interface CommonMapper {
    /**
     * 重置指定数据表的主键自增，使之连续
     * @param tableName
     * @throws SQLException
     */
    @Update("ALTER TABLE ${tableName} AUTO_INCREMENT = 1 ")
    void alert(@Param("tableName") String tableName) throws SQLException;
}
