package com.example.aopnullablereturncheck.application;

public interface DummyApplicationService {

    /**
     * Null許容ダミー結果取得
     *
     * @return DummyResult or null
     */
    DummyResult getNullableDummyResult();

    /**
     * Null不許容ダミー結果取得
     *
     * @return DummyResult
     */
    DummyResult getNotNullDummyResult();

}
