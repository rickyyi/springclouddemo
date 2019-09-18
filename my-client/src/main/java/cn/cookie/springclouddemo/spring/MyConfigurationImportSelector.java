package cn.cookie.springclouddemo.spring;

import cn.cookie.springclouddemo.annotation.ImportSelectorAnno;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.AdviceModeImportSelector;

/**
 * Created by yizhiqiang on 2019/9/18.
 */
public class MyConfigurationImportSelector extends AdviceModeImportSelector<ImportSelectorAnno> {

    @Override
    protected String[] selectImports(AdviceMode adviceMode) {
        return new String[0];
    }
}
