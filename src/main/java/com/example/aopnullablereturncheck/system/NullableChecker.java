package com.example.aopnullablereturncheck.system;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

// https://stackoverflow.com/questions/21275819/how-to-get-a-methods-annotation-value-from-a-proceedingjoinpoint
@Aspect
@Component
public class NullableChecker {

    /** Nullableチェック例外クラス */
    public static class NullableCheckException extends RuntimeException {}

//    @Around("@within(org.springframework.stereotype.Component)")
    @Around("@within(org.springframework.stereotype.Repository)")
    // TODO 他のアノテーションも対象に加える
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        final Method method = methodSignature.getMethod();
        final NullableReturn nullableReturn = method.getAnnotation(NullableReturn.class);

        if (nullableReturn != null) {
            return pjp.proceed();
        }

        final Object result = pjp.proceed();

        if (result == null) {
            throw new NullableCheckException();
        }

        return result;
    }

}
