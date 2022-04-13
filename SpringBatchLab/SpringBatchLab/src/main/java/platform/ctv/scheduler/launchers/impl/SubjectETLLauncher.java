package platform.ctv.scheduler.launchers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import platform.ctv.scheduler.jobs.IJobBuilder;
import platform.ctv.scheduler.jobs.JobBuilder;
import platform.ctv.scheduler.launchers.AbstractLauncher;

@Service
@RequiredArgsConstructor
public class SubjectETLLauncher extends AbstractLauncher {

    @Override
    public void init() {

        IJobBuilder job = new JobBuilder(jobBuilderFactory, subjectStepsBuilder);

        try{

            jobLauncher.run(job.buildETlJob(), newExecution());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
