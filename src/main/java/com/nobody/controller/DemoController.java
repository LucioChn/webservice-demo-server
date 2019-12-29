package com.nobody.controller;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @GetMapping("test")
    public String test(@RequestParam String username, @RequestParam int age) {

        String result = null;

        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/UserService?wsdl");

        // 如果需要密码时加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USERNAME,PASSWORD));

        // 接受返回值对象
        Object[] objects = new Object[0];

        try {
            // 调用
            objects = client.invoke("addUser", username, age);
            result = "调用webservice接口返回数据：" + objects[0];
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
