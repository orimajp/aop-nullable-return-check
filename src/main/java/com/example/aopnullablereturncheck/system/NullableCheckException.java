package com.example.aopnullablereturncheck.system;

/**
 * Nullableチェック例外クラス
 */
public class NullableCheckException extends RuntimeException {

    public NullableCheckException(String message) {
        super(getErrorMessage(message));
    }

    private static String getErrorMessage(String message) {
        return String.format("Nullableチェックエラーです: %s", message);
    }

}
