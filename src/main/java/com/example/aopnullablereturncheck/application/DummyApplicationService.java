package com.example.aopnullablereturncheck.application;

public interface DummyApplicationService {

    /**
     * Null許容ダミー結果取得
     *
     * @return DummyResult
     */
    DummyResult getNullableDummyResult();

    /**
     * Null不許容ダミー結果取得
     *
     * @return DummyResult
     */
    DummyResult getNotNullDummyResult();

}
