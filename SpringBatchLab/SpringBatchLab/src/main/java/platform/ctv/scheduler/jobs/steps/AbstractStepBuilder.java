package platform.ctv.scheduler.jobs.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractStepBuilder {

    @Value("${platform.ctv.subjectChunk}")
    protected int subjectChunk;
}
