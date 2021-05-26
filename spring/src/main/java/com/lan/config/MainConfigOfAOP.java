package com.lan.config;

import com.lan.aop.LogAspects;
import com.lan.aop.MathCacultaor;
import com.lan.bean.Person;
import org.springframework.context.annotation.*;

/**
 * @author jianglin.lan
 * @title: BeanConfig
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/17 17:31
 * <p>
 * AOP:(动态代理)
 * 指在程序运行期间动态的将某段代码切入到指定方法位置进行运行的编程方式
 * <p>
 * 1）、导入AOP
 * 2）、定义一个业务逻辑类(MathCacultaor)
 * 3)、定义一个日志切面类(LogAspects)
 *      通知方法：
 *          前置通知（@Before）:logStart()：在目标方法（div）运行之前运行
 *          后置通知(@After)：logEnd():在目标方法（div）运行结束之后运行
 *          返回通知(@AfterReturning)：logReturn():在目标方法（div）正常返回之后运行
 *          异常通知(@AfterThrowing):logThrow():在目标方法（div）出现异常之后运行
 *          环绕通知(@Around)：动态代理，手动推进目标方法运行（jointPoint.procced()）
 *
 * 4、给切面类的目标方法标注何时运行
 * 5、将业务逻辑类和切面类加入到容器中
 * 6、告诉Spring那个类是切面类（给切面类加上注解@Aspect）
 * 7、开启AOP(@EnableAspectJAutoProxy)
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {

    @Bean
    public MathCacultaor mathCacultaor () {
        return new MathCacultaor ();
    }

    @Bean
    public LogAspects logAspects () {
        return new LogAspects ();
    }
}
