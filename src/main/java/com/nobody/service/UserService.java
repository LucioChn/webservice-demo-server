package com.nobody.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 测试接口
 * 
 * @author Μr.ηobοdy
 *
 * @date 2019-12-29
 *
 */
@WebService(name = "UserService", // 暴露服务名称
        targetNamespace = "http://service.nobody.com" // 命名空间,一般是接口的包名倒序
)
public interface UserService {

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String addUser(@WebParam(name = "username") String username, @WebParam(name = "age") int age);
}
