package ru.arutyunovg4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.arutyunovg4.dao.RecordDao;
import ru.arutyunovg4.entity.Record;

import java.util.List;

@Service
public class RecordService {
    private final RecordDao recordDao;

    @Autowired
    public RecordService(RecordDao recordDao) {
        this.recordDao = recordDao;
    }

    public List<Record> findAllRecords(){
        return  recordDao.findAllRecords();
    }
}
