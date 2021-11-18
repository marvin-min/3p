package com.sb.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParametersTestController {
    @GetMapping("/car/{id}/brand/{brand}")
    public Map<String,Object> getCard(@PathVariable("id") Integer id,
                                      @PathVariable("brand")String brand,
                                      @RequestHeader Map<String,String> headers,
                                      @RequestParam("color")String color,
                                      @RequestParam("bb") List<String> bb,
                                      @RequestParam Map<String,Object> params,
                                      @CookieValue(value = "_ga", required = false) Cookie ga,
                                      HttpServletResponse response){
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("brand",brand);
        map.put("header", headers);
        map.put("color",color);
        map.put("bb",bb);
        map.put("params",params);
        map.put("cookies",ga);
        response.addCookie(new Cookie("_ga","hell()"));
        return map;
    }

    /**
     * http://localhost:8080/mxt/hi;low=1000;brand=tsl
     * <p>
     * 矩阵变量 必须有url 路径变量
     */
    @GetMapping("/mxt/{there}")
    public Map matrixVariable(@MatrixVariable("low")Integer low,
                              @MatrixVariable("brand")String brand,
                              @PathVariable("there") String there){
        Map<String,Object> map = new HashMap<>();
        map.put("low",low);
        map.put("brand",brand);
        map.put("there",there);
        return map;
    }
}
