package cn.cookie.springclouddemo.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;
import org.slf4j.MDC;

/**
 * Created by yizhiqiang on 2019/9/3.
 */
public class MyLogPatternLayout extends LayoutBase<ILoggingEvent> {
    @Override
    public String doLayout(ILoggingEvent iLoggingEvent) {
        return null;
    }

    public void putMetric() {
        MDC.put("metric", "metric");
    }

    public void removeMetric() {
        MDC.remove("metric");
    }
}
