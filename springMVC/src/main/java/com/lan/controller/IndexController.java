package com.lan.controller;

import com.lan.bean.Book;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Intercepter;
import org.springframework.stereotype.Controller;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @author jianglin.lan
 * @title: IndexController
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/19 14:55
 * <p>
 * 1、运行流程
 * 1.1、客户端发送 http(http://localhost:8080/hello)请求
 * 1.2、请求到tomcat服务器
 * 1.3、SpringMVC的的前端控制器收到所有请求
 * 1.4、进行匹配请求的url地址
 * 1.5、前端控制器找到目标处理器和目标方法，直接利用反射执行目标方法
 * 1.6、方法执行完成以后有返回值，SpringMVC认为这个返回值就是 跳转的jsp页面地址
 * 1.7、拿到方法返回值以后：用视图解析器拼串得到完成的页面地址
 * 1.8、拿到页面地址，前端控制器帮我们转发到页面
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    public String hello () {


        System.out.println ("success...");
        return "success";
    }

    @RequestMapping("updateBook")
    public String updateBook (@RequestParam(value = "name") String name,
                              Map<String, Object> model,
                              HttpServletRequest request,
                              @ModelAttribute("hahe") Book book
    ) {
        System.out.println ("name+++++" + name);
        System.out.println ("book+++++" + book);
        return "success";
    }

    @ModelAttribute
    public void myModelAttribute (Map<String, Object> map) {
        Book book = new Book ("一本书",12,new BigDecimal (111));
        System.out.println ("book=======" + book);
        map.put ("bookName", book);
        System.out.println ("map=====" + map.toString ());



    }



}

