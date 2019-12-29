package com.nobody.service.impl;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.nobody.service.UserService;

/**
 * 测试接口实现
 * 
 * @author Μr.ηobοdy
 *
 * @date 2019-12-29
 *
 */
@WebService(serviceName = "UserService", // 与接口中指定的name一致
        targetNamespace = "http://service.nobody.com", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.nobody.service.UserService" // 接口地址
)
@Component
public class UserServiceImpl implements UserService {

    @Override
    public String addUser(String username, int age) {
        return "Add user success,username:" + username + ",age:" + age;
    }

}
