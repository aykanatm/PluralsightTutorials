package org.murat.pluralsight.controllers;

import org.murat.pluralsight.models.TollUsage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TollController {
    @RequestMapping("/tolldata")
    public List<TollUsage> getTollData(){
        TollUsage instance1 = new TollUsage("100","station150","B65GT1W","2016-09-30T06:31:22");
        TollUsage instance2 = new TollUsage("101","station119","AHY673B","2016-09-30T06:32:50");
        TollUsage instance3 = new TollUsage("102","station150","ZN2GP0","2016-09-30T06:37:01");

        List<TollUsage> tolls = new ArrayList<>();
        tolls.add(instance1);
        tolls.add(instance2);
        tolls.add(instance3);

        return tolls;
    }
}
