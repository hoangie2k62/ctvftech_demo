package platform.ctv.scheduler.jobs.steps.items.readers;

import org.springframework.batch.item.ItemReader;
import org.springframework.util.CollectionUtils;
import platform.ctv.jdbc.entity.SubjectDocument;
import platform.ctv.jdbc.repository.AbstractFileRepository;

import java.util.List;

//Chịu trách nhiệm đọc, việc quy định đọc ở đâu để lấy dữ liệu subject là do cái này quy định.
public class SubjectItemReader implements ItemReader<List<SubjectDocument>> {

    private AbstractFileRepository repository;

    public SubjectItemReader(AbstractFileRepository inputRepository) {

        this.repository = inputRepository;
    }

    @Override
    public List<SubjectDocument> read() throws Exception{

        List<SubjectDocument> datas = repository.read();

        return datas;
    }
}
