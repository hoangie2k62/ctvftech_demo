package platform.ctv.scheduler.jobs.steps;

import org.springframework.batch.core.Step;

public interface IStepBuilder {

    int CHUNK_SIZE_DEFAULT = 50000;

    String getStepName();

    default Integer queryTimeout(){

        return 10*60;
    }

    Step buildStep();
}
