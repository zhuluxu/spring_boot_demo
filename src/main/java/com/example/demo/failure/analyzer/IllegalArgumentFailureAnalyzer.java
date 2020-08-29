package com.example.demo.failure.analyzer;

import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;

/**创建自己的FailureAnalyzer
 * spring boot 启动异常IllegalArgumentException拦截处理，转换成自己可读的日志出来
 * 启动时拦截异常并将其转换为人类可读消息
 * 其次，在 src/main/resources 路径下新建 META-INF/spring.factories，在 spring.factories 文件中添加一下内容。
 *
 * @author zhuluxu
 */
public class IllegalArgumentFailureAnalyzer extends AbstractFailureAnalyzer<IllegalArgumentException> {

    /**
     *
     * @param rootFailure
     * @param cause
     * @return
     */
    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, IllegalArgumentException cause) {
        return new FailureAnalysis(cause.getMessage(),"请检查启动配置参数！（Please check startup argument!）",cause);
    }
}
