package com.example.aopnullablereturncheck.system;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

// https://stackoverflow.com/questions/21275819/how-to-get-a-methods-annotation-value-from-a-proceedingjoinpoint
@Slf4j
@Aspect
@Component
public class NullableChecker {

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void service() {}

    @Pointcut("@within(org.springframework.stereotype.Repository)")
    private void repository() {}

    @Pointcut("@within(org.springframework.stereotype.Component)")
    private void component() {}

    @Around("service() || repository() || component()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        if (existsNullableReturn(pjp)) {
            return pjp.proceed();
        }

        final Object result = pjp.proceed();

        if (result == null) {
            throw new NullableCheckException(getTarget(pjp));
        }

        return result;
    }

    private boolean existsNullableReturn(ProceedingJoinPoint pjp) {
        final MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        final Method method = methodSignature.getMethod();
        final NullableReturn nullableReturn = method.getAnnotation(NullableReturn.class);
        return nullableReturn != null;
    }

    private String getTarget(ProceedingJoinPoint pjp) {
        final String method = pjp.getSignature().getName();
        final String className = pjp.getTarget().getClass().getName();
        return String.format("%s#%s()", className, method);
    }

}
