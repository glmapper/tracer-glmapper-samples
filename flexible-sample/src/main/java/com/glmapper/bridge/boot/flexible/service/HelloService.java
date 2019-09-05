package com.glmapper.bridge.boot.flexible.service;

import com.alipay.common.tracer.core.tags.SpanTags;
import com.alipay.sofa.tracer.plugin.flexible.annotations.Tracer;
import org.springframework.stereotype.Service;

/**
 * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/9/4 5:17 PM
 * @since:
 **/
@Service
public class HelloService {

    /**
     * use @Tracer to trace current method
     * @param word
     * @return
     */
    @Tracer
    public String hello(String word){
        // 自定义 tag 数据
        SpanTags.putTags("author","glmapper");
        return "glmapper : hello " + word;
    }
}
