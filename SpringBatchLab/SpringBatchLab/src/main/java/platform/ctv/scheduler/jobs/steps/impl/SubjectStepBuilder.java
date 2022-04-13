package platform.ctv.scheduler.jobs.steps.impl;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import platform.ctv.api.dto.SubjectDTO;
import platform.ctv.api.repository.impl.SubjectDTORepository;
import platform.ctv.jdbc.entity.SubjectDocument;
import platform.ctv.jdbc.repository.impl.SubjectFileRepository;
import platform.ctv.scheduler.jobs.steps.AbstractStepBuilder;
import platform.ctv.scheduler.jobs.steps.IStepBuilder;
import platform.ctv.scheduler.jobs.steps.items.processors.SubjectItemProcessor;
import platform.ctv.scheduler.jobs.steps.items.readers.SubjectItemReader;
import platform.ctv.scheduler.jobs.steps.items.writers.SubjectItemWriter;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@EnableBatchProcessing
public class SubjectStepBuilder extends AbstractStepBuilder implements IStepBuilder {

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private SubjectFileRepository inputRepository;

    @Autowired
    private SubjectDTORepository outputRepository;

    @Bean(value = "subjectReader")
    public ItemReader<List<SubjectDocument>> itemReader(){

        return new SubjectItemReader(inputRepository);
    }

    @Bean(value = "subjectProcessor")
    public ItemProcessor<List<SubjectDocument>, List<SubjectDTO>> itemProcessor(){

        return new SubjectItemProcessor();
    }

    @Bean(value = "subjectWriter")
    public ItemWriter<List<SubjectDTO>> itemWriter(){

        return new SubjectItemWriter(outputRepository);
    }

    @Override
    public String getStepName() {

        return "Subject-sync";
    }

    @Override
    public Step buildStep() {

        return stepBuilderFactory
                .get(getStepName())
                .<List<SubjectDocument>, List<SubjectDTO>>chunk(this.subjectChunk)
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }
}
