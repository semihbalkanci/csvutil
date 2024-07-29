package com.gerimedica.csvutil.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CsvDataRepository extends CrudRepository<CsvData,Long> {

    List<CsvData> findAllByCode(String code);
}
