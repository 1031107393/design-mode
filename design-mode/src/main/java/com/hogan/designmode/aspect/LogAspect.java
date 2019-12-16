package com.hogan.designmode.aspect;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

/**
 * 日志切面
 * wujun
 * 2019/12/06 16:48
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    public static final ThreadLocal<Long> threadLocal = ThreadLocal.withInitial(() -> System.currentTimeMillis());

    @Pointcut("execution(* com.hogan.designmode.web..*.*(..))")
    public void log() {
    }

    @Before(value = "log() && @annotation(logAnnotation)")
    public void doBore(JoinPoint joinPoint, Log logAnnotation) {

        // 获取入参
        long startTime = System.currentTimeMillis();
        String className = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String fullMethodName = StringUtils.joinWith(".", className, methodName);
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        Arrays.stream(args).forEach(a -> sb.append(a.toString()).append(","));
        // 时间快照
        threadLocal.set(startTime);
        // 打印
        log.info("{}方法入参{}", fullMethodName, sb.toString());
    }

    @AfterReturning(value = "log() && @annotation(logAnnotation)", returning = "res")
    public void doAfterReturning(JoinPoint joinPoint, Log logAnnotation, Object res) {

        try {
            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            String fullMethodName = StringUtils.joinWith(".", className, methodName);
            // 打印
            log.info("{}方法返回{}", fullMethodName, Objects.isNull(res) ? "null" : res.toString());
        } finally {
            threadLocal.remove();
        }
    }

    @AfterThrowing(value = "log() && @annotation(logAnnotation)", throwing = "throwable")
    public void doAfterReturning(JoinPoint joinPoint, Log logAnnotation, Throwable throwable) {

        try {
            String className = joinPoint.getSignature().getDeclaringTypeName();
            String methodName = joinPoint.getSignature().getName();
            String fullMethodName = StringUtils.joinWith(".", className, methodName);
            // 打印
            log.error("{}方法异常{}", fullMethodName, throwable);
        } finally {
            threadLocal.remove();
        }
    }
}
