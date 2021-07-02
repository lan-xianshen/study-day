package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jianglin.lan
 * @title: ProxyFactory
 * @projectName study-day
 * @description: TODO
 * @date 2021/6/24 11:24
 */
public class ProxyFactory {

    private Object target;

    public ProxyFactory (Object target) {
        this.target = target;
    }

    public Object getProxyInstance () {
        return Proxy.newProxyInstance (target.getClass ().getClassLoader (),
                target.getClass ().getInterfaces (),
                new InvocationHandler () {
                    @Override
                    public Object invoke (Object proxy, Method method, Object[] args) throws Throwable {
                        Object o = method.invoke (target, args);
                        System.out.println ("代理o=" + o);
                        return o;
                    }
                });
    }
}
