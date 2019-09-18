package cn.cookie.springclouddemo.annotation;

import cn.cookie.springclouddemo.spring.MyConfigurationImportSelector;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Created by yizhiqiang on 2019/9/18.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(MyConfigurationImportSelector.class)
public @interface ImportSelectorAnno {


    boolean proxyTargetClass() default false;

    AdviceMode mode() default AdviceMode.PROXY;

}
