/*
 * Xửa lý thêm, xóa, sửa bảng works, work_assgin
 */

package demo.application.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demo.application.dto.Work;
import demo.application.dto.WorkAssgin;
import demo.application.entity.EmployeesEntity;
import demo.application.entity.WorksEntity;
import demo.application.entity.relationship.WorkAssginEntity;
import demo.application.entity.relationship.WorkAssginKey;
import demo.application.services.WorkAssginService;
import demo.application.services.WorksService;

@RestController
@RequestMapping(value = "/work")
public class WorkAPI implements CrudAPI<Work, String> {

	@Autowired
	private WorksService workService;

	@Autowired
	private WorkAssginService workassginService;

	private final String symbol = "WFTECH";

	@GetMapping(value = "/")
	public List<Work> readData(@RequestParam(value = "page", required = false) Integer page) {

		if (page == null)
			page = 1;

		List<Work> list = new ArrayList<>();

		for (WorksEntity entity : workService.readData("WorksEntity", page)) {

			list.add(new Work(entity));
		}

		return list;
	}

	@PostMapping(value = "/")
	public String createData(@RequestBody Work work) throws Exception {

		if (!workService.checkId("EmployeesEntity", work.getCreatedId()))
			return "failed";

		WorksEntity entity = work.toEntity();

		entity.setCreatedEmployee(new EmployeesEntity(work.getCreatedId()));

		if (!workService.createData(entity, symbol))
			return "failed";

		return "successful";
	}

	@PutMapping(value = "/")
	public String updateData(@RequestBody Work work) throws Exception {

		if (!workService.checkId("EmployeesEntity", work.getCreatedId()))
			return "failed";

		WorksEntity entity = work.toEntity();

		entity.setCreatedEmployee(new EmployeesEntity(work.getCreatedId()));

		if (!workService.updateData(entity, entity.getId()))
			return "failed";

		return "successful";
	}

	@DeleteMapping(value = "/{id}")
	public String deleteData(@PathVariable(value = "id") String id) {

		if (!workService.deleteData(WorksEntity.class, id))
			return "failed";

		return "successful";
	}

	@GetMapping("/work/workassgin/")
	public List<WorkAssgin> readWorkAssgin(@RequestParam(value = "page", required = false) Integer page) {

		if (page == null)
			page = 1;

		List<WorkAssgin> list = new ArrayList<>();

		for (WorkAssginEntity entity : workassginService.readData("WorkAssginEntity", page)) {

			list.add(new WorkAssgin(entity));
		}

		return list;
	}

	@PostMapping("/workassgin/")
	public String createWorkAssgin(@RequestBody WorkAssgin workassgin) throws Exception {

		if (!workassginService.checkId("WorkAssginEntity", workassgin))
			return "failed";

		WorkAssginEntity entity = workassgin.toEntity();

		if (!workassginService.createData(entity, null))
			return "failed";

		return "success";
	}

	@PutMapping("/workassgin/")
	public String updateWorkAssgin(@RequestBody WorkAssgin workassgin) throws Exception {

		if (!workassginService.checkId("WorkAssginEntity", workassgin))
			return "failed";

		WorkAssginEntity entity = workassgin.toEntity();

		if (!workassginService.updateData(entity, entity.getId()))
			return "failed";

		return "success";
	}

	@DeleteMapping("/workassgin/")
	public String deleteWorkAssgin(@RequestParam(value = "employeeId") String employeeId,
			@RequestParam(value = "officeId") String officeId, @RequestParam(value = "workId") String workId) {
		
		if(employeeId == null || employeeId.isEmpty()) return "failed";
		
		if(officeId == null || officeId.isEmpty()) return "failed";
		
		if(workId == null || workId.isEmpty()) return "failed";	

		if( !workassginService.deleteData(WorkAssginEntity.class, new WorkAssginKey(employeeId, officeId, workId)) ) return "failed";
		
		return "success";
	}
}
