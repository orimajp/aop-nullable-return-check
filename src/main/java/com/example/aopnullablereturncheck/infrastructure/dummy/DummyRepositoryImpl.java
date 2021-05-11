package com.example.aopnullablereturncheck.infrastructure.dummy;

import com.example.aopnullablereturncheck.domain.dummy.Dummy;
import com.example.aopnullablereturncheck.domain.dummy.DummyRepository;
import com.example.aopnullablereturncheck.system.NullableReturn;
import org.springframework.stereotype.Repository;

@Repository
public class DummyRepositoryImpl implements DummyRepository {

    /**
     * Null許容ダミーデータ取得
     *
     * @return Dummy or null
     */
    @NullableReturn
    @Override
    public Dummy getNullableDummyData() {
        return null;
    }

    /**
     * Null不許容ダミーデータ取得
     *
     * @return Dummy
     */
    @Override
    public Dummy getNotNullDummyData() {
        return null;
    }

}
