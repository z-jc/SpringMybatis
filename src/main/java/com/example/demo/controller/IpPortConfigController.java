package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName IpPortConfigController
 * @Description TODO
 * @Author ZJC
 * @Date 2019\7\22 0022 18:33
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/address")
public class IpPortConfigController {

    @RequestMapping("/ip")
    public String getIpConfig() {
        // TODO: 2019\7\22 0022 数据库查询客户端连接的服务器IP和Port
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "0");
        jsonObject.put("msg", "查询成功");
        JSONObject object = new JSONObject();
        object.put("ip", "tcp://192.168.0.115:1883");
        jsonObject.put("data", object);
        return jsonObject.toString();
    }

}