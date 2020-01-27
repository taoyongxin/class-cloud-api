package com.scs.soft.cloud.api.mapper;

import com.scs.soft.cloud.api.CloudApiApplication;
import com.scs.soft.cloud.api.domain.dto.RegisterDto;
import com.scs.soft.cloud.api.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
@SpringBootTest(classes = CloudApiApplication.class)
class UserMapperTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private CommonMapper commonMapper;


    @Test
    void findUserByMobile() throws SQLException {
        RegisterDto registerDto = RegisterDto.builder().mobile("17826012341").build();
        User user = userMapper.findUserByMobile(registerDto);
        if (user != null){
            System.out.println(user);
        } else {
            System.out.println("未找到");
        }
    }

    @Test
    void insert() throws SQLException{
        User user = User.builder()
                .mobile("13270003511")
                .nickname("测试昵称")
                .email("1427177855@qq.com")
                .name("tyx")
                .gender("男")
                .school("南工院")
               /* .faculty("计软院")
                .jobNumber("1802333117")*/
                .experience(0)
                .charisma(0)
                .joinClassNumber(0)
                .createClassNumber(0)
                .resourceNumber(0)
                .activityNumber(0)
                .createTime(LocalDateTime.now())
                .avatar("1.jpg")
                .profession("学生")
                .birthday(LocalDate.now())
                .build();
        userMapper.insert(user);
    }

    @Test
    void update() throws SQLException{
        RegisterDto registerDto = RegisterDto.builder()
                .mobile("17826012341")
                .build();
        User user = userMapper.findUserByMobile(registerDto);
        user.setName("Tao.");
        user.setNickname("许卿以沫");
        user.setGender("男");
        user.setBirthday(LocalDate.parse("2000-01-01"));
        user.setProfession("老师");
        user.setJobNumber("123456789");
        user.setSchool("南京工业职业技术大学");
        user.setFaculty("计软院");
        user.setAvatar("1.jpg");
        userMapper.update(user);
    }


}