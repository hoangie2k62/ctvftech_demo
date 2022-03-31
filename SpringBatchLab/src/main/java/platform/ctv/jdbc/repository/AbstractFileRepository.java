package platform.ctv.jdbc.repository;

import com.sun.org.apache.bcel.internal.util.ClassPath;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractFileRepository<T> {
    private Resource resource;

    //Lưu trữ danh sách các file cần scan
    private List<File> files;

    //Đánh dấu các file đã duyệt.
    private Iterator<File> iterator;

    public AbstractFileRepository(){
        resource = new ClassPathResource("inputData");
        files = new ArrayList<>();
        init();
    }

    protected void init() {
        try {
            this.filesLoaderScan(this.resource.getFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Đọc dữ liệu từ lần lượt các file.
    public List<T> read() throws IOException{
        if(iterator == null) iterator = files.iterator();

        while(iterator.hasNext())
            return this.read(iterator.next());
        return null;
    }

    //đọc dữ liệu từ 1 file.
    private List<T> read(File file) throws IOException {

        Reader reader = new FileReader(file);
        CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        List<T> datas = new ArrayList<>();
        for(CSVRecord record : csvParser.getRecords()){

            T object = this.dataFormat(record.toList());
            datas.add(object);
        }
        return datas;
    }

    //Quét danh sách file.
    private void filesLoaderScan(File directory){

        if(directory.isFile())
            files.add(directory);
        else{

            for(File file : directory.listFiles())
                this.filesLoaderScan(file);
        }
    }

    //Định dạng dữ liệu của đối tượng cần.
    protected abstract T dataFormat(List<String> args);
}
