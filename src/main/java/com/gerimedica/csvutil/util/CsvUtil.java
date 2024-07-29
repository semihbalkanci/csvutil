package com.gerimedica.csvutil.util;

import com.gerimedica.csvutil.data.CsvData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CsvUtil {

    public List<CsvData> uploadData(MultipartFile file) throws IOException, ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        CSVParser csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT
                .withHeader("source","codeListCode","code","displayValue","longDescription","fromDate","toDate","sortingPriority")
                .withSkipHeaderRecord());

        Iterable<CSVRecord> csvRecords=csvParser.getRecords();
        List<CsvData> csvDataList = new ArrayList<>();

        for (CSVRecord csvRecord:csvRecords)
        {
            CsvData csvData = new CsvData();
            csvData.setSource(csvRecord.get("source"));
            csvData.setCodeListCode(csvRecord.get("codeListCode"));
            csvData.setCode(csvRecord.get("code"));
            csvData.setDisplayValue(csvRecord.get("displayValue"));
            csvData.setLongDescription(csvRecord.get("longDescription"));
            csvData.setFromDate(getDate(csvRecord.get("fromDate")));
            csvData.setToDate(getDate(csvRecord.get("toDate")));
            csvData.setSortingPriority(getInteger(csvRecord,"sortingPriority"));

            csvDataList.add(csvData);
        }

        return csvDataList;
    }

    private Date getDate(String value) throws ParseException {

        if (value.isEmpty())
            return null;

        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(value);
    }

    public Integer getInteger(CSVRecord csvRecord,String paramName)
    {
        return !csvRecord.get(paramName).trim().isEmpty() ?Integer.parseInt(csvRecord.get(paramName)):null;
    }
}
