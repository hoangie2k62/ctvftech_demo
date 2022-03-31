package platform.ctv.scheduler.jobs;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import platform.ctv.scheduler.jobs.steps.IStepBuilder;

public class JobBuilder extends AbstractJobBuilder implements IJobBuilder{

    private JobBuilderFactory jobBuilderFactory;

    private IStepBuilder steps;

    public JobBuilder(JobBuilderFactory jobBuilderFactory, IStepBuilder steps){

        super();
        this.jobBuilderFactory = jobBuilderFactory;
        this.steps = steps;
    }

    @Override
    public String getJobName(){

        return this.getClass().getSimpleName();
    }

    @Override
    public Job buildETlJob(){

        return jobBuilderFactory
                .get(getJobName())
                .incrementer(new RunIdIncrementer())
                .flow(steps.buildStep())
                .end().build();
    }
}
