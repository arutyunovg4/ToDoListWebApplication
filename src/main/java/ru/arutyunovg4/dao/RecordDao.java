package ru.arutyunovg4.dao;

import org.springframework.stereotype.Repository;
import ru.arutyunovg4.entity.Record;
import ru.arutyunovg4.entity.RecordStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RecordDao {
    private final List<Record> records = new ArrayList<>(
            Arrays.asList(
                    new Record("Take a shower", RecordStatus.ACTIVE),
                    new Record("Buy flowers", RecordStatus.DONE),
                    new Record("Go to the GYM", RecordStatus.ACTIVE)
            )
    );

    public List<Record> findAllRecords(){
        return new ArrayList<>(records) ;
    }

    public void saveRecord(Record record){
        records.add(record);
    }

    public void updateRecordStatus(int id, RecordStatus newStatus){

//        for(Record record : records){
//            if (record.getId() == id){
//                record.setStatus(newStatus);
//                break;
//            }
//        }

        records.stream()
                .filter(r-> r.getId() == id)
                .forEach(r->r.setStatus(newStatus));

    }

    public void deleteRecord(int id){
        records.removeIf(r->r.getId() == id);
    }

}
