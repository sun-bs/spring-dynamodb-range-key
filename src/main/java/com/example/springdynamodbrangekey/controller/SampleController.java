package com.example.springdynamodbrangekey.controller;

import com.example.springdynamodbrangekey.entity.Entity;
import com.example.springdynamodbrangekey.entity.PkEntity;
import com.example.springdynamodbrangekey.repository.SampleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {
    public SampleController(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    /**
     * dynamoDB repository
     */
    SampleRepository sampleRepository;

    /**
     * get attribute found in DynamoDB by sampleHashKey and sampleRangeKey.
     * @param sampleHashKey hash key (partition key)
     * @param sampleRangeKey range key (sort key)
     * @return attribute
     */
    @GetMapping("/dynamo/{sampleHashKey}/{sampleRangeKey}")
    @ResponseBody
    public String getSampleAttribute(@PathVariable("sampleHashKey") String sampleHashKey,
                                     @PathVariable("sampleRangeKey") String sampleRangeKey) {
        return sampleRepository.findById(new PkEntity(sampleHashKey, sampleRangeKey)).orElse(new Entity()).getSampleAttribute();
    }
}
