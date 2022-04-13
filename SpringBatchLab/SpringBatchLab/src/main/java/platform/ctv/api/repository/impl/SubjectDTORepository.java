package platform.ctv.api.repository.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import platform.ctv.api.dto.SubjectDTO;
import platform.ctv.api.repository.AbstractDTORepository;

@Repository
public class SubjectDTORepository extends AbstractDTORepository<SubjectDTO> {

    @Value("${platform.ctv.subjectChunk}")
    private int subjectChunk;

    @Override
    protected int getChunk(){

        return this.subjectChunk-1;
    }
}
