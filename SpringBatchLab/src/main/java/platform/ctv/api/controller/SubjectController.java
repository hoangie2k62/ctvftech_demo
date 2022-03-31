package platform.ctv.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import platform.ctv.scheduler.launchers.impl.SubjectETLLauncher;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectETLLauncher subjectETLLauncher;

    @PostMapping(value = "/sync")
    public String dataWriter(){

        subjectETLLauncher.init();
        return "success";
    }
}
