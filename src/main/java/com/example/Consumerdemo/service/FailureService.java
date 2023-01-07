package com.example.Consumerdemo.service;

import com.example.Consumerdemo.entity.FailureRecord;
import com.example.Consumerdemo.jpa.FailureRecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FailureService {

    private FailureRecordRepository failureRecordRepository;

    public FailureService(FailureRecordRepository failureRecordRepository) {
        this.failureRecordRepository = failureRecordRepository;
    }

    public void saveFailedRecord(ConsumerRecord<Integer, String> consumerRecord, Exception e, String status) {

        var failureRecord = new FailureRecord(null, consumerRecord.topic(),
                consumerRecord.key(), consumerRecord.value(), consumerRecord.partition()
        ,consumerRecord.offset(), e.getCause().getMessage(), status);

        failureRecordRepository.save(failureRecord);

    }
}
