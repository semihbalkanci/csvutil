package com.gerimedica.csvutil.business;

import com.gerimedica.csvutil.data.CsvData;
import com.gerimedica.csvutil.data.CsvDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CsvServiceImpl implements CsvService {

    private final CsvDataRepository csvDataRepository;

    @Override
    public void uploadData(List<CsvData> csvDataList) {
        csvDataRepository.saveAll(csvDataList);
    }

    @Override
    public List<CsvData> FetchData() {
        return (List<CsvData>) csvDataRepository.findAll();
    }

    @Override
    public List<CsvData> FetchByCode(String code) {
        return csvDataRepository.findAllByCode(code);
    }

    @Override
    public void DeleteData() {
        csvDataRepository.deleteAll();
    }
}
