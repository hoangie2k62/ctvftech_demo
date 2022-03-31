package platform.ctv.jdbc.repository.impl;

import org.springframework.stereotype.Repository;
import platform.ctv.jdbc.entity.SubjectDocument;
import platform.ctv.jdbc.repository.AbstractFileRepository;

import java.util.List;

@Repository
public class SubjectFileRepository extends AbstractFileRepository<SubjectDocument> {

    @Override
    protected SubjectDocument dataFormat(List<String> args) {

        return new SubjectDocument(args.get(0), args.get(1), args.get(2));
    }
}
