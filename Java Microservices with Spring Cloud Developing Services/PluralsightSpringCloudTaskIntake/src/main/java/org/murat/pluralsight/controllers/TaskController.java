package org.murat.pluralsight.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private static final Log _logger = LogFactory.getLog(TaskController.class);

    @Autowired
    private TaskProcessor t;

    @RequestMapping(path = "/tasks", method = RequestMethod.POST)
    public @ResponseBody String launchTask(@RequestBody String s){
        t.publishRequest(s);

        _logger.debug("Request made.");

        return "success";
    }
}
