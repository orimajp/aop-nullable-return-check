package com.example.aopnullablereturncheck.domain.dummy;

public interface DummyRepository {

    /**
     * Null許容ダミーデータ取得
     *
     * @return Dummy or null
     */
    Dummy getNullableDummyData();

    /**
     * Null不許容ダミーデータ取得
     *
     * @return Dummy
     */
    Dummy getNotNullDummyData();

}
