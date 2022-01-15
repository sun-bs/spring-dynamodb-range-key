package com.example.springdynamodbrangekey.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PkEntity {

    /**
     * Hash Key (partition key)
     */
    @DynamoDBHashKey
    private String sampleHashKey;

    /**
     * Range Key (sort key)
     */
    @DynamoDBRangeKey
    private String sampleRangeKey;
}
