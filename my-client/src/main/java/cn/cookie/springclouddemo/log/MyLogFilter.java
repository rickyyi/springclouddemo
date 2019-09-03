package cn.cookie.springclouddemo.log;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * Created by yizhiqiang on 2019/9/3.
 */
public class MyLogFilter extends Filter<ILoggingEvent> {

    private static final String[] IGNORE_LOG_STRING = new String[]{"/enabledappconfigs", "/enabledapprules", "/enabledmobileconfigs", "/mobileconfigchangerecords", "/enabledmobilerules", "/urlAllowedPaths", "/haproxy", "HomeController.home()", "/rsrc/", "HomeMapper"};

    @Override
    public FilterReply decide(ILoggingEvent event) {
        for (String ignoreString : IGNORE_LOG_STRING) {
            if (event.getMessage().contains(ignoreString)) {
                return FilterReply.DENY;
            }
        }
        return FilterReply.NEUTRAL;
    }

}
