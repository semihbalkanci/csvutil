package com.gerimedica.csvutil.business;

import com.gerimedica.csvutil.data.CsvData;
import java.util.List;

public interface CsvService {
    void uploadData(List<CsvData> csvDataList);
    List<CsvData> FetchData();
    List<CsvData> FetchByCode(String code);
    void DeleteData();
}
