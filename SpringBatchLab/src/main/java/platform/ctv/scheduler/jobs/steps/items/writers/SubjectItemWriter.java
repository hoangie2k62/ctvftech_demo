package platform.ctv.scheduler.jobs.steps.items.writers;

import org.springframework.batch.item.ItemWriter;
import platform.ctv.api.dto.SubjectDTO;
import platform.ctv.api.repository.impl.SubjectDTORepository;
import platform.ctv.scheduler.jobs.steps.items.AbstractItem;

import java.util.List;

//Đóng vai trò ghi dữ liệu đã bị chuyển đổi nhờ Processor sang nơi mong muốn.
public class SubjectItemWriter extends AbstractItem implements ItemWriter<List<SubjectDTO>> {

    private SubjectDTORepository repository;

    public SubjectItemWriter(SubjectDTORepository outputRepository) {
        super();
        this.repository = outputRepository;
    }

    @Override
    public void write(List<? extends List<SubjectDTO>> documents) throws Exception {

        repository.write(documents);
    }
}
