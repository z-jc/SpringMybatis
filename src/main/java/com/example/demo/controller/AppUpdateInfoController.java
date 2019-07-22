package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @ClassName AppUpdateInfoController
 * @Description TODO
 * @Author ZJC
 * @Date 2019\7\22 0022 18:41
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api/android")
public class AppUpdateInfoController {

    @RequestMapping("/updateInfo")
    public String getAppUpdateInfo() {
        return getFileString(new File("F:/update.txt"));
    }

    /**
     * 读取日志文件
     *
     * @param file 本地txt或log文件
     * @return 返回读取到的文件内容
     */
    public static String getFileString(File file) {
        String content = "";
        try {
            InputStream is = new FileInputStream(file);
            InputStreamReader reader = new InputStreamReader(is, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content = content + line + "\n";
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.toString();
        }
        return content;
    }

}