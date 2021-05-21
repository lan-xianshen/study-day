package com.lan.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author jianglin.lan
 * @title: MyTypeFilter
 * @projectName study-day
 * @description: TODO 自定义过滤规则
 * @date 2021/5/18 14:15
 */
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader 读取当前类正在扫描的类的信息
     * @param metadataReaderFactory ：获取任何其它类的信息
     * @return
     * @throws IOException
     */

    @Override
    public boolean match (MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //获取当前类的注解信息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata ();
        //获取当前正在扫描的类的类信息
        ClassMetadata classMetadata = metadataReader.getClassMetadata ();
        //获取当前类的资源信息（路径）
        Resource resource = metadataReader.getResource ();

        String className = classMetadata.getClassName ();
        System.out.println ("==>>"+className);

        if(className.contains ("er")){
            return true;
        }
        return false;
    }
}
