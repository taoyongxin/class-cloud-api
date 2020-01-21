package com.scs.soft.cloud.api.service;

import com.scs.soft.cloud.api.common.Result;

/**
 * @author Tao
 */
public interface ClassService {
    /**
     * 通过用户id查询所有班课数据
     * @param id
     * @return
     */
    Result getClassById(int id);
}
