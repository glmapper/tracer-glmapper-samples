package com.glmapper.bridge.boot.flexible.controller;

import com.alipay.common.tracer.core.span.SofaTracerSpan;
import com.alipay.sofa.tracer.plugin.flexible.FlexibleTracer;
import com.glmapper.bridge.boot.flexible.service.HelloService;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/9/4 5:18 PM
 * @since:
 **/
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    Tracer tracer;

    @RequestMapping("hello")
    public String testHello(){

        testManual();

        return helloService.hello("world");

    }

    private void testManual(){
        try {
            SofaTracerSpan sofaTracerSpan = ((FlexibleTracer) tracer).beforeInvoke("testManual");
            sofaTracerSpan.setTag("manualKey","glmapper");
            // do your biz

        } catch (Throwable t){
            ((FlexibleTracer) tracer).afterInvoke(t.getMessage());
        } finally {
            ((FlexibleTracer) tracer).afterInvoke(null);
        }
    }
}
