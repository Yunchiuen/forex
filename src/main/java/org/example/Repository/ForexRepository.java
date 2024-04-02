package org.example.Repository;


import org.example.bean.Forex;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ForexRepository extends MongoRepository<Forex, String> {

    @Query(value = "{'Date': {$gte: ?0, $lte: ?1}}")
    List<Forex> findForexBetweenDates(String startDate, String endDate);
}
