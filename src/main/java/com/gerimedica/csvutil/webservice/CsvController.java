package com.gerimedica.csvutil.webservice;

import com.gerimedica.csvutil.business.CsvService;
import com.gerimedica.csvutil.data.CsvData;
import com.gerimedica.csvutil.util.CsvUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RequiredArgsConstructor
@RestController  // data?
public class CsvController {
    private final CsvService csvService;

    @Async
    @PostMapping("/upload")
    public void uploadCsvData(@RequestParam(value = "file") MultipartFile file) throws IOException, ParseException
    {
        CsvUtil csvUtil = new CsvUtil();
        List<CsvData> csvDataList = csvUtil.uploadData(file);
        csvService.uploadData(csvDataList);
    }

    @Async
    @GetMapping("/list")
    public List<CsvData> fetchData()
    {
        return csvService.FetchData();
    }

    @Async
    @GetMapping("/listByCode")
    public List<CsvData> fetchDataByCode(@RequestParam(value = "code") String code)
    {
        return csvService.FetchByCode(code);
    }

    @DeleteMapping("/delete")
    public void deleteData()
    {
        csvService.DeleteData();
    }
}
