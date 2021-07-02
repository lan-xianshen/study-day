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
 *
 * AOP原理：【看给容器中注册了什么组件，这个组件什么时候工作，这个组建的功能是什么】
 *      @EnableAspectJAutoProxy
 *    1、@EnableAspectJAutoProxy是什么
 *          @Import(AspectJAutoProxyRegistrar.class)
 *              利用AspectJAutoProxyRegistrar 自定义给容器注册bean
 *              internalAutoProxyCreator = AnnotationAwareAspectJAutoProxyCreator
 *          给容器中注册一个 AnnotationAwareAspectJAutoProxyCreator（自动代理创建器）
 *    2、AnnotationAwareAspectJAutoProxyCreator:
 *          AnnotationAwareAspectJAutoProxyCreator
 *              ->AspectJAwareAdvisorAutoProxyCreator
 *                  ->AbstractAdvisorAutoProxyCreator
 *                      ->AbstractAutoProxyCreator
 *                          implements SmartInstantiationAwareBeanPostProcessor, BeanFactoryAware
 *                          关注 后置处理器（在bean初始化完成前后做事情）、自动注入BeanFactory
 *         AbstractAutoProxyCreator.setBeanFactory()
 *         AbstractAutoProxyCreator.postProcessXXX()[有后置处理器的逻辑]
 *
 *         AbstractAdvisorAutoProxyCreator.setBeanFactory() ->initBeanFactory
 *         AbstractAdvisorAutoProxyCreator.
 *
 *         AnnotationAwareAspectJAutoProxyCreator.initBeanFactory()
 *
 * 流程：
 *      1、传入配置类，创建IOC容器
 *      2、注册配置类，调用refresh()刷新容器【把容器中的所有bean创建出来，初B始化容器】
 *      3、registerBeanPostProcessors(beanFactory);注册bean的后置处理器来方便拦截bean的创建
 *           3.1、现获取IOC容器中已经定义了的需要创建对象的所有BeanPostProcessor
 *           3.2、给容器中加别的BeanPostProcessor
 *           3.3、优先注册实现PriorityOrdered接口的BeanPostProcessor
 *           3.4、再给容器中注册实现了Ordered接口的BeanPostProcessor
 *           3.5、注册没实现优先级接口的BeanPostProcessor
 *           3.6、注册BeanPostProcessor，实际上就是创建BeanPostProcessor对象，保存在容器中
 *                  创建internalAutoProxyCreator的BeanPostProcessor【AnnotationAwareAspectJAutoProxyCreator】
 *                   3.6.1、创建Bean的实例
 *                   3.6.2、populateBean：给bean的各种属性赋值
 *                   3.6.3、initializeBean：初始化bean
 *                      1)、invokeAwareMethods():处理Aware接口的方法回调
 *                      2）、applyBeanPostProcessorsBeforeInitialization():应用后置处理器的PostProcessorsBeforeInitialization()
 *                      3)、invokeInitMethods():执行自定义的初始化方法
 *                      4）、applyBeanPostProcessorsAfterInitialization():执行后置处理器的postProcessAfterInitialization
 *                   3.6.4、BeanPostProcessor（AnnotationAwareAspectJAutoProxyCreator）创建成功；-->>aspectJAdvisorsBuilder
 *            3.7、把BeanPostProcessor注册到BeanFactory中：
 *                  beanFactory.addBeanPostProcessor(postProcessor)
 *         ============以上就是创建和注册  AnnotationAwareAspectJAutoProxyCreator 的过程===========
 *                  AnnotationAwareAspectJAutoProxyCreator => InstantiationAwareBeanPostProcessor
 *      4、 finishBeanFactoryInitialization(beanFactory);完成beanFactory的初始化工作：创建剩下的单实例bean
 *              4.1、遍历获取容器中所有的Bean，依次创建对象
 *                  getBean() -> doGetBean() ->getSingleton()
 *              4.2、创建bean
 *                  【AnnotationAwareAspectJAutoProxyCreator 在所有bean创建之前会有一个拦截，InstantiationAwareBeanPostProcessor
 *                  会调用postProcessBeforeInstantiation()】
 *                  4.2.1、先从缓存中获取当前bean,如果能获取到，说明bean是之前被创建过的，直接使用；否则再创建
 *                      只要创建好的bean都会被缓存起来
 *                  4.2.2、createBean（）：创建bean：AnnotationAwareAspectJAutoProxyCreator 任何bean创建之前先尝试返回bean
 *                   【BeanPostProcessor是在Bean对象创建完成初始化前后调用的】
 *                   【InstantiationAwareBeanPostProcessor 是在创建Bean实例之前先尝试用后置处理器返回对象的】
 *                      4.2.2.1、resolveBeforeInstantiation(beanName, mbdToUse);解析BeforeInstantiation
 *                          希望后置处理器在此能返回一个代理对象：如果能返回代理对象就返回；如果不能就继续
 *                          1）、后置处理器先尝试返回对象：
 *                              bean = applyBeanPostProcessorsBeforeInstantiation(targetType, beanName);
 *                                      拿到所有后置处理器，如果是InstantiationAwareBeanPostProcessor;
 *                                      就执行 postProcessBeforeInstantiation
 * 					            if (bean != null) {
 * 						            bean = applyBeanPostProcessorsAfterInitialization(bean, beanName);
 *                               }
 *                      4.2.2.2、doCreateBean(beanName, mbdToUse, args)：真正的去创建一个bean示例，和3.6流程一样
 *                      4.2.2.3
 *
 *  AnnotationAwareAspectJAutoProxyCreator【InstantiationAwareBeanPostProcessor】的作用；
 *      1、每一个bean创建之前，调用postProcessBeforeInstantiation()
 *          关心MathCacultaor和LogAspects的创建
 *          1.1、判断当前bean是否在advisedBeans中(保存了所有需要增强的bean)
 *          1.2、判断当前bean是否基础类型的 Advice、Pointcut、Advisor、AopInfrastructureBean，
 *                或者是否是切面(@Aspect)
 *          1.3、是否需要跳过
 *              1.3.1、获取候选的增强器（切面里面的通知方法）【List<Advisor> candidateAdvisors】
 *                  每一个封装的通知方法的增强器是 InstantiationModelAwarePointcutAdvisor
 *                  判断每一个增强器是否是 AspectJPointcutAdvisor 类型的：返回true
 *              1.3.2、永远返回false
 *      2、创建对象
 *          postProcessAfterInitialization
 *              return wrapIfNecessary(bean, beanName, cacheKey);//包装如果需要的情况下
 *              2.1、获取当前bean的所有增强器（通知方法）
 *                      1）、找到候选的所有的增强器（找到哪些方法是需要切入当前bean方法的）
 *                      2）、获取到能在bean使用的增强器
 *                      3）、给增强器排序
 *              2.2、保存当前bean在 advisedBeans
 *              2.3、如果当前bean需要增强，创建当前bean的代理对象
 *                     1）、获取所有增强器（通知方法）
 *                     2）、保存到 proxyFactory
 *                     3)、创建代理对象：Spring自动决定
 *                          new JdkDynamicAopProxy(config)：jdk动态代理
 *                          new ObjenesisCglibAopProxy(config)：cglib的动态代理
 *             2.4、给容器中返回当前组件使用cglib增强的代理对象
 *             2.5、以后容器中获取到的就是这个组件的代理对象，执行目标方法的时候，代理对象就会执行通知方法的流程
 *
 *      3、目标方法执行：
 *          容器中保存了组件的代理对象（cglib增强后的对象），这个对象里面保存了详细信息（如 增强器，目标对象）
 *          3.1、CglibAopProxy.intercept();拦截目标方法的执行
 *          3.2、根据 ProxyFactory 对象获取将要执行的目标方法拦截器链
 *             	List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method,targetClass);
 *              3.2.1、List<Object> interceptorList 保存所有拦截器（长度为5）
 *                      一个默认的 ExposeInvocationInterceptor 和4个增强器
 *              3.2.2、遍历所有的增强器，将其转为 Interceptor:
 *                          registry.getInterceptors(advisor)
 *              3.2.3、将增强器转为 List<MethodInterceptor>
 *                     如果是 MethodInterceptor，直接加入到集合中
 *                     如果不是，使用 AdvisorAdapter 将增强器转为 MethodInterceptor；转换完成返回MethodInterceptor数组
 *          3.3、如果没有拦截器链，直接执行目标方法
 *                  拦截器链（每一个通知方法又被包装为拦截器，利用 MethodInterceptor 机制）
 *          3.4、如果有拦截器链，把需要执行的目标方法、目标对象、拦截器链等所有信息传入来创建一个 CglibMethodInvocation 对象，
 *              并调用 Object retVal= new CglibMethodInvocation(...).proceed()方法
 *          3.5、拦截器链的触发过程
 *              3.5.1、如果没有拦截器 直接执行目标方法，或者拦截器的索引和拦截器数组-1大小一样（指定到了最后一个拦截器）
 *              3.5.2、链式获取每一个拦截器，拦截器执行invoke方法，每一个拦截器等待下一个拦截器执行完成返回之后再来执行
 *                      拦截器的机制:保证通知方法与目标方法的执行顺序[见图]
 *
 *
 *总结：
 *  1、@EnableAspectJAutoProxy 开启AOP功能
 *  2、@EnableAspectJAutoProxy 会给容器中注册一个组件 AnnotationAwareAspectJAutoProxyCreator
 *  3、AnnotationAwareAspectJAutoProxyCreator 是一个后置处理器
 *  4、容器的创建流程
 *      4.1、registerBeanPostProcessors(beanFactory);注册后置处理器，创建 AnnotationAwareAspectJAutoProxyCreator 对象
 *      4.2、finishBeanFactoryInitialization(beanFactory);初始化剩下的单实例bean
 *          4.2.1、创建业务逻辑组件和切面组件
 *          4.2.2、AnnotationAwareAspectJAutoProxyCreator 拦截创建的过程
 *          4.2.3、组件创建完成之后，判断组件是否需要增强
 *              是：将切面的通知方法包装成增强器（Advisor）,给业务逻辑组件创建一个代理对象[cglib]
 *   5、执行目标方法
 *       5.1、代理对象执行目标方法
 *       5.2、CglibAopProxy.intercept();
 *          5.2.1、得到目标方法的拦截器链（增强器包装成拦截器 MethodInterceptor）
 *          5.2.2、利用拦截器的链式机制，依次进入每一个拦截器进行执行
 *          5.2.3、效果：
 *              正常执行：前置通知-》目标方法-》后置通知-》返回通知
 *              出现异常：前置通知-》目标方法-》后置通知-》异常通知
 *
 *
 *
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
