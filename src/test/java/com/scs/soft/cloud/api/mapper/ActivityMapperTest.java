package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.entity.Activity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = CloudApiApplication.class)
class ActivityMapperTest {

    @Resource
    private ActivityMapper activityMapper;
    @Test
    void insert() throws SQLException {
        /*Activity activity = Activity.builder()
                .groupId(1)
                .userId(1)
                .name("头脑风暴")
                .type((short)1)
                .status((short)0)
                .theme("测试标题")
                .experience(3)
                .thumbnail("1.jpg")
                .purpose((short)1)
                .build();
        activityMapper.insert(activity);*/
    }

    @Test
    void getActivityById() throws SQLException{
        System.out.println(activityMapper.getActivityById(2));
    }

    @Test
    void update() throws SQLException{
        Activity activity1 = activityMapper.getActivityById(1);
        activity1.setGroupId(2);
        activity1.setName("111");
        activity1.setStatus((short)3);
        activity1.setBeginTime(LocalDateTime.now());
        activity1.setEndTime(LocalDateTime.now());
        activity1.setPurpose((short)1);
        activityMapper.update(activity1);
    }

    @Test
    void getActivityByUserId() throws SQLException{
        List<Map> activityList = activityMapper.getActivityByUserId(2,1);
        System.out.println(activityList);
    }

    @Test
    void deleteActivity() throws SQLException{
        activityMapper.deleteActivity(4);
    }

    @Test
    void getActivityByGroupId() throws SQLException{
        List<Map> mapList = activityMapper.getActivityByGroupId(1,25);
        System.out.println(mapList);
    }


    @Test
    void updateStyle() throws SQLException{
        Activity activity = activityMapper.getActivityById(1);
        activity.setStyle((short)1);
        activityMapper.updateStyle(activity);
    }
}