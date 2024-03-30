package org.example.Repository;


import org.example.bean.Forex;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Map;

public interface ForexRepository extends MongoRepository<Forex, String> {

}
