package platform.ctv.api.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;

import java.io.*;
import java.util.List;

public abstract class AbstractDTORepository<T> {

    @Value("classpath:/outputData/output.txt")
    private Resource resource;

    public void write(List<? extends List<T>> documents) throws IOException {
        Writer writer = new FileWriter(resource.getFile());
        BufferedWriter buffered = new BufferedWriter(writer);

        for(T object : documents.get(this.getChunk())){

            buffered.write(object.toString());
            buffered.newLine();
        }

        buffered.close();
        writer.close();
    }

    protected abstract  int getChunk();
}
