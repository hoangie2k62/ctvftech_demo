/*
 * Xử lý phần thêm, xóa, sửa bảng offices
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

import demo.application.dto.Office;
import demo.application.entity.EmployeesEntity;
import demo.application.entity.OfficesEntity;
import demo.application.services.OfficesService;

@RestController
@RequestMapping("/office")
public class OfficeAPI implements CrudAPI<Office, String>{

	@Autowired
	private OfficesService service;
	
	private final String symbol = "OFTECH";

	@GetMapping(value = "/")
	public List<Office> readData(@RequestParam(value = "page", required = false) Integer page) {

		if (page == null)
			page = 1;

		List<Office> list = new ArrayList<>();

		for (OfficesEntity entity : service.readData("OfficesEntity", page)) {

			list.add(new Office(entity));
		}

		return list;
	}

	@PostMapping(value = "/")
	public String createData(@RequestBody Office office) throws Exception {
		
		if (!service.checkId("OfficesEntity", office.getManagerId()))
			return "failed";

		OfficesEntity entity = office.toEntity();

		entity.setManagerId(new EmployeesEntity(office.getManagerId()));
		
		if (!service.createData(entity, symbol))
			return "failed";
		
		return "successful";
	}

	@PutMapping(value = "/")
	public String updateData(@RequestBody Office office) throws Exception{
		
		if (!service.checkId("OfficesEntity", office.getManagerId()))
			return "failed";

		OfficesEntity entity = office.toEntity();
		
		entity.setManagerId(new EmployeesEntity(office.getManagerId()));
		
		if (!service.updateData(entity, entity.getId()))
			return "failed";
		
		return "successful";
	}

	@DeleteMapping(value = "/{id}")
	public String deleteData(@PathVariable(value = "id") String id) {

		if (!service.deleteData(OfficesEntity.class, id))
			return "failed";

		return "successful";
	}
}
