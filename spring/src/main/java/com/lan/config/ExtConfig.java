package com.lan.config;

import com.lan.bean.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author jianglin.lan
 * @title: ExtConfig
 * @projectName study-day
 * @description: TODO
 * @date 2021/7/8 13:47
 * <p>
 * 拓展原理：
 * BeanPostProcessor : bean后置处理器，bean创建对象初始化前后进行拦截工作的
 *1、BeanFactoryPostProcessor:beanFactory 后置处理器
 *          在 beanFactory 标准初始化之后调用，所有的 bean定义已经保存加载到 beanFactory ，但是bean的实例还没有创建
 *
 *      1.1、ioc容器创建对象
 *      1.2、invokeBeanFactoryPostProcessors(beanFactory); 执行 BeanFactoryPostProcessors
 *           如何找到所有的 BeanFactoryPostProcessor并执行他们的方法
 *           1.2.1、直接在 beanFactory 中找到所有类型是  BeanFactoryPostProcessor 的组件，并执行他们的方法
 *           1.2.2、在初始化创建其它组件之前执行
 *2、BeanDefinitionRegistryPostProcessor extends BeanFactoryPostProcessor
 *      postProcessBeanDefinitionRegistry()
 *      在所有的bean定义信息将要被加载，bean实例还未创建
 *
 *      优先于 BeanFactoryPostProcessor 执行
 *      利用 BeanDefinitionRegistryPostProcessor 给容器中再额外添加一些组件
 *
 *      2.1、ioc创建对象
 *      2.2、refresh()->invokeBeanFactoryPostProcessors(beanFactory)
 *      2.3、从日其中获取到所有 BeanDefinitionRegistryPostProcessor 组件，
 *          1）、依次触发所有的 postProcessBeanDefinitionRegistry() 方法
 *          2）、再来触发 postProcessBeanFactory() 方法
 *      2.4、再来从容器中找到 BeanDefinitionRegistryPostProcessor 组件，然后依次触发postProcessBeanFactory（）方法
 *3、ApplicationListener ：监听容器中发布的事件。事件驱动模型开发；
 *  public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
 *  监听 ApplicationEvent 及其下面的子事件
 *
 *  步骤：
 *      3.1、写一个监听器（ApplicationListener实现类）来监听某个事件（ApplicationEvent 及其子类）
 *      3.2、把监听器加入到容器
 *      3.3、只要容器中有相关事件的发布，我们就能监听到这个事件
 *              ContextRefreshedEvent： 容器刷新完成（所有的bean都完全创建）会发布这个事件
 *              ContextClosedEvent：关闭容器会发布这个事件
 *
 *原理：
 *    1、ContextRefreshedEvent 事件
 *          1.1、容器创建对象：refresh()
 *          1.2、finishRefresh();容器刷新完成会发布 ContextRefreshedEvent 事件
 *    2、自己发布事件
 *    3、容器关闭会发布 ContextClosedEvent
 *
 *    【事件发布流程】：
 *          1.3、publishEvent(new ContextRefreshedEvent(this))
 *                  1.3.1、获取事件的多多播器（派发器）：getApplicationEventMulticaster()
 *                  1.3.2、multicastEvent 派发事件
 *                  1.3.3、获取到所有的 ApplicationListener
 *                      for (final ApplicationListener<?> listener : getApplicationListeners(event, type))
 *                      1）、如果有 Executor，可以使用 Executor 进行异步派发 ；Executor executor = getTaskExecutor();
 *                      2）、否则 同步的方式直接执行 listener 方法： invokeListener(listener, event);
 *                          拿到 listener回调 onApplicationEvent 方法
 *   【事件多播器（派发器）获取流程】
 *          1.4、容器创建对象： refresh()
 *          1.5、initApplicationEventMulticaster();初始化 ApplicationEventMulticaster
 *              1.5.1、先去 容器中（beanFactory） 找有没有 id="applicationEventMulticaster" 的组件
 *                      如果没有 就创建一个 this.applicationEventMulticaster = new SimpleApplicationEventMulticaster
 *                      (beanFactory); 并且加入到容器中（beanFactory.registerSingleton（）），我们就可以在其它组件要派发事件，自动注入
 *                      applicationEventMulticaster 就行
 *   【如何知道容器中有哪些监听器】
 *          1、6、容器创建对象： refresh()
 *          1.7、registerListeners();
 *              从容器中拿到所有的监听器，把他们注册到 applicationEventMulticaster 中
 *              String[] listenerBeanNames = getBeanNamesForType(ApplicationListener.class, true, false);
 *              //将listener 注册到 ApplicationEventMulticaster 中
 *              getApplicationEventMulticaster().addApplicationListener(listener);
 *
 * SmartInitializingSingleton 原理 -》afterSingletonsInstantiated()
 *      1、ioc容器创建对象并  refresh()
 *      2、finishBeanFactoryInitialization(beanFactory); 初始化剩下的单实例 bean
 *          2.1、先创建所有的单实例 bean: getBean()
 *          2.1、获取所有创建好的单实例 bean,判断是否是 SmartInitializingSingleton 类型的
 *              如果是就调用 afterSingletonsInstantiated() 方法
 *
 *
 *
 */
@ComponentScan("com.lan.ext")
@Configuration
public class ExtConfig {
    @Bean
    public School school () {
        return new School ();
    }
}
