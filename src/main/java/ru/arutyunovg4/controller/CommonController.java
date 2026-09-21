package ru.arutyunovg4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.arutyunovg4.entity.Record;
import ru.arutyunovg4.entity.RecordStatus;
import ru.arutyunovg4.service.RecordService;

import java.util.List;

@Controller
public class CommonController {

    private final RecordService recordService;

    @Autowired
    public CommonController(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping("/home")
    public String getMainPage(Model model) {
        List<Record> records = recordService.findAllRecords();

        int numberOfDoneRecords = (int) records.stream().filter(r->r.getStatus() == RecordStatus.Done).count();
        int numberOfActiveRecords = (int) records.stream().filter(r->r.getStatus() == RecordStatus.Active).count();

        model.addAttribute("numberOfDoneRecords", numberOfDoneRecords);
        model.addAttribute("numberOfActiveRecords", numberOfActiveRecords);

        return "main-page";
    }
}
