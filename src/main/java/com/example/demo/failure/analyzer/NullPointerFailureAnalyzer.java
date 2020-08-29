package com.example.demo.failure.analyzer;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**
 * 空指针异常
 * @author didi
 */
@Log4j2
public class NullPointerFailureAnalyzer extends AbstractFailureAnalyzer<NullPointerException> {
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, NullPointerException cause) {
        log.info(rootFailure);
        return new FailureAnalysis(cause.getMessage(),"Demo 应用启动出现空指针异常！",cause);
    }
}
