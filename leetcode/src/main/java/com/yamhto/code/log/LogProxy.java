package com.yamhto.code.log;

import com.sun.deploy.util.StringUtils;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author yamhto
 * @className: LogProxy.java
 * @package com.yamhto.code.log
 * @description:
 * @date 2020/5/19 9:34
 */
public class LogProxy implements MethodInterceptor {

    public DebugLevel debugLevel;

    public LogProxy(DebugLevel debugLevel) {
        this.debugLevel = debugLevel;
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        //System.out.println(o.getClass().getName());
        String methodName = method.getName();


        if (DebugLevel.getDebugLevel(methodName).getLevel() <= this.debugLevel.getLevel()) {
            return methodProxy.invokeSuper(o, objects);

        }

        return null;
    }


}
