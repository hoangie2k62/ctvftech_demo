package platform.ctv.scheduler.jobs.steps.items.processors;

import org.springframework.batch.item.ItemProcessor;
import platform.ctv.api.dto.SubjectDTO;
import platform.ctv.jdbc.entity.SubjectDocument;
import platform.ctv.scheduler.jobs.steps.items.AbstractItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Đây sẽ là bộ trung chuyển: chuyển đổi sao cho dữ liệu đầu vào chuyển thành kiểu mong muốn đầu ra.
public class SubjectItemProcessor extends AbstractItem implements ItemProcessor<List<SubjectDocument>, List<SubjectDTO>> {

    @Override
    public List<SubjectDTO> process(List<SubjectDocument> documents){

        Map<String, Integer> map = new HashMap<>();
        for(SubjectDocument subject : documents){

            check(subject.getName(), map);
            check(subject.getPin(), map);
            check(subject.getDescribe(), map);
        }

        List<SubjectDTO> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()){

            list.add( new SubjectDTO(entry.getKey(), entry.getValue()) );
        }

        return list;
    }

    //tìm tần suất xuất hiện của 1 từ
    private void check(String letter, Map<String, Integer> map){

        if(map.containsKey(letter)){
            int frequency = map.get(letter);
            map.put(letter, ++frequency);
        }else
            map.put(letter, 1);
    }
}
