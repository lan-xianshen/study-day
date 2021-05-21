package com.lan.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author jianglin.lan
 * @title: WindowsCondition
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1815:46
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches (ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment ();
        String property = environment.getProperty ("os.name");
        return property.contains ("Windows");
    }
}
