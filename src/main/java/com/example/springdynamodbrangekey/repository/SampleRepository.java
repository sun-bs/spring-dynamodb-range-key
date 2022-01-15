package com.example.springdynamodbrangekey.repository;

import com.example.springdynamodbrangekey.entity.Entity;
import com.example.springdynamodbrangekey.entity.PkEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SampleRepository extends CrudRepository<Entity, PkEntity> {
}
