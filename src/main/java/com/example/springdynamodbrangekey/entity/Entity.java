package com.example.springdynamodbrangekey.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@DynamoDBTable(tableName = "sample-table")
@AllArgsConstructor
@NoArgsConstructor
public class Entity {

    @Id
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private PkEntity pkEntity;

    @DynamoDBHashKey(attributeName = "sampleHashKey")
    public String getSampleHashKey() {
        return pkEntity != null ? pkEntity.getSampleHashKey() : null;
    }

    public void setSampleHashKey(String sampleHashKey) {
        if (pkEntity == null) {
            pkEntity = new PkEntity();
        }
        pkEntity.setSampleHashKey(sampleHashKey);
    }

    @DynamoDBRangeKey(attributeName = "sampleRangeKey")
    public String getSampleRangeKey() {
        return pkEntity != null ? pkEntity.getSampleRangeKey() : null;
    }

    public void setSampleRangeKey(String sampleRangeKey) {
        if (pkEntity == null) {
            pkEntity = new PkEntity();
        }
        pkEntity.setSampleRangeKey(sampleRangeKey);
    }

    private String sampleAttribute;

}
