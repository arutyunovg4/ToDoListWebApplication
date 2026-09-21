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
                    new Record("Take a shower", RecordStatus.Active),
                    new Record("Buy flowers", RecordStatus.Active),
                    new Record("Go to the GYM", RecordStatus.Active)
            )
    );

    public List<Record> findAllRecords(){
        return new ArrayList<>(records) ;
    }
}
