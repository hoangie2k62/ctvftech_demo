package platform.ctv.scheduler.launchers;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import platform.ctv.scheduler.jobs.steps.impl.SubjectStepBuilder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public abstract class AbstractLauncher {

    @Autowired
    @Qualifier("jobLauncher")
    protected JobLauncher jobLauncher;

    @Autowired
    protected JobBuilderFactory jobBuilderFactory;

    @Autowired
    protected SubjectStepBuilder subjectStepsBuilder;

    protected JobParameters newExecution(){
        Map<String, JobParameter> parameters = new HashMap<>();
        JobParameter parameter = new JobParameter(new Date());
        parameters.put("currentTime", parameter);

        return new JobParameters(parameters);
    }

    public abstract void init();
}
