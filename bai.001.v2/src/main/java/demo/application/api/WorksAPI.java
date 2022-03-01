package demo.application.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.application.dto.Work;
import demo.application.entity.WorksEntity;
import demo.application.services.WorksService;

@RestController
public class WorksAPI {

	@Autowired
	private WorksService service;

	@SuppressWarnings("unused")
	@GetMapping("/work")
	public List<WorksEntity> readData(@RequestParam(value = "page", required = false) Integer page) {

		if (page == null || page < 1)
			page = 1;

		return service.<WorksEntity>findPage(page);
	}

	@PostMapping("/work")
	public boolean addData(@RequestBody Work work) {

		WorksEntity max = service.createId();

		String max_id = "WFTECH";

		if (max == null)
			max_id += "00000001";
		else {
			
			int stt = Integer.parseInt(max.getId().substring(6)) + 1;
			
			max_id += String.format("%8d", stt);
		}
			

		WorksEntity entity = work.toEntity();

		entity.setId(max_id);

		return service.addData(entity);
	}

	@PutMapping("/work")
	public boolean updateData(@RequestBody Work work) {

		WorksEntity entity = work.toEntity();
		
		return service.updateData(entity);
	}

	@DeleteMapping("/work/{id}")
	public boolean deleteData(@PathVariable(value = "id") String workId) {
	
		
		return false;
	}

}
