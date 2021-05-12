package com.example.aopnullablereturncheck.application;

import com.example.aopnullablereturncheck.domain.dummy.Dummy;
import com.example.aopnullablereturncheck.domain.dummy.DummyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DummyApplicationServiceImpl implements DummyApplicationService {

    private final DummyRepository dummyRepository;

    /**
     * Null許容ダミー結果取得
     *
     * @return DummyResult
     */
    @Override
    public DummyResult getNullableDummyResult() {
        final Dummy dummy = dummyRepository.getNullableDummyData();
        if (dummy == null) {
            return new DummyResult("値がnullです。");
        }
        return new DummyResult(dummy.getData());
    }

    /**
     * Null不許容ダミー結果取得
     *
     * @return DummyResult
     */
    @Override
    public DummyResult getNotNullDummyResult() {
        // ここはnullが返らない想定
        final Dummy dummy = dummyRepository.getNotNullDummyData();
        if (dummy == null) {
            return new DummyResult("値がnullです。");
        }
        return new DummyResult(dummy.getData());
    }

}
