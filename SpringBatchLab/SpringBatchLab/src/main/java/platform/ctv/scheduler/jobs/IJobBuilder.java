package platform.ctv.scheduler.jobs;

import org.springframework.batch.core.Job;

public interface IJobBuilder {

    String getJobName();

    default Integer queryTimeout(){

        return 10*60;
    }

    Job buildETlJob();
}
