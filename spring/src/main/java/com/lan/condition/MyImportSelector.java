package com.lan.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author jianglin.lan
 * @title: MyImportSelector
 * @projectName study-day
 * @description: TODO
 * @date 2021/5/1817:58
 */
public class MyImportSelector implements ImportSelector {
    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @return
     */
    @Override
    public String[] selectImports (AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.lan.bean.Selector01","com.lan.bean.Selector02"};
    }
}
