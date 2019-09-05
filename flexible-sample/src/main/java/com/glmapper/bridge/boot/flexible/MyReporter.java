package com.glmapper.bridge.boot.flexible;

import com.alipay.common.tracer.core.reporter.facade.Reporter;
import com.alipay.common.tracer.core.span.SofaTracerSpan;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/9/5 10:50 AM
 * @since:
 **/
public class MyReporter implements Reporter {

    @Override
    public String getReporterType() {
        return "myReporter";
    }

    @Override
    public void report(SofaTracerSpan sofaTracerSpan) {
        System.out.println("this is my custom reporter");
    }

    @Override
    public void close() {
        // ignore
    }
}
