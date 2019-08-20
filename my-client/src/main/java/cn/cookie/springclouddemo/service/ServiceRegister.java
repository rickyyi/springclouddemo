package cn.cookie.springclouddemo.service;

import cn.cookie.springclouddemo.annotation.RPCClient;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * Created by yizhiqiang on 2019/7/29.
 */
public class ServiceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware, ResourceLoaderAware {

    private Environment environment;

    private ResourceLoader resourceLoader;

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        ClassPathScanningCandidateComponentProvider scanner = getScanner();
        scanner.setResourceLoader(this.resourceLoader);

        AnnotationTypeFilter annotationTypeFilter = new AnnotationTypeFilter(RPCClient.class);
        scanner.addIncludeFilter(annotationTypeFilter);

        String basePackage = "cn.cookie";

        Set<BeanDefinition> candidateComponents = scanner.findCandidateComponents(basePackage);

        for (BeanDefinition candidateComponent : candidateComponents) {
            if (candidateComponent instanceof AnnotatedBeanDefinition) {
                AnnotatedBeanDefinition beanDefinition = (AnnotatedBeanDefinition) candidateComponent;
                AnnotationMetadata annotationBeanMetadata = beanDefinition.getMetadata();

                String className = annotationBeanMetadata.getClassName();

                BeanDefinitionBuilder definition = BeanDefinitionBuilder.genericBeanDefinition(ServiceFactoryBean.class);
                try {
                    definition.addPropertyValue("aClassName", Class.forName(className));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                definition.setAutowireMode(AbstractBeanDefinition.AUTOWIRE_BY_TYPE);
                AbstractBeanDefinition beanDefinition1 = definition.getBeanDefinition();

                BeanDefinitionHolder holder = new BeanDefinitionHolder(beanDefinition1, className, new String[] { "hello" });
                BeanDefinitionReaderUtils.registerBeanDefinition(holder, registry);
            }
        }
    }

    protected ClassPathScanningCandidateComponentProvider getScanner() {
        return new ClassPathScanningCandidateComponentProvider(false, this.environment) {
            @Override
            protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
                boolean isCandidate = false;
                if (beanDefinition.getMetadata().isIndependent()) {
                    if (!beanDefinition.getMetadata().isAnnotation()) {
                        isCandidate = true;
                    }
                }
                return isCandidate;
            }
        };
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
