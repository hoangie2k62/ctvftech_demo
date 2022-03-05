/*
 * Xửa lý thêm, xóa, sửa phần thông tin nhân viên trong bảng employees
 * Không xử lý phần tài khoản đăng nhập của nhân viên.
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

import demo.application.dto.Employee;
import demo.application.entity.EmployeesEntity;
import demo.application.services.EmployeesService;

@RestController
@RequestMapping("/employee")
public class EmployeeAPI implements CrudAPI<Employee, String> {

	@Autowired
	private EmployeesService service;

	private final String symbol = "FTECH";

	@GetMapping(value = "/")
	public List<Employee> readData(@RequestParam(value = "page", required = false) Integer page) {

		if (page == null)
			page = 1;

		List<Employee> list = new ArrayList<>();

		for (EmployeesEntity entity : service.readData("EmployeesEntity", page)) {

			list.add(new Employee(entity));
		}

		return list;
	}

	@PostMapping(value = "/")
	public String createData(@RequestBody Employee employee) throws Exception {

		if (employee.getReportTo() != null) {

			if (!service.checkId("EmployeesEntity", employee.getReportTo()))
				return "failed";
		}

		EmployeesEntity entity = employee.toEntity();

		if(employee.getReportTo() != null) 
			entity.setManager( new EmployeesEntity(employee.getReportTo()) );

		if (!service.createData(entity, symbol))
			return "failed";

		return "successful";
	}

	@PutMapping(value = "/")
	public String updateData(@RequestBody Employee employee) throws Exception {

		if (employee.getReportTo() != null) {

			if (!service.checkId("EmployeesEntity", employee.getReportTo()))
				return "failed";
		}

		EmployeesEntity entity = employee.toEntity();

		if(employee.getReportTo() != null) 
			entity.setManager( new EmployeesEntity(employee.getReportTo()) );

		if (!service.updateData(entity, entity.getId()))
			return "failed";

		return "successful";
	}

	@DeleteMapping(value = "/{id}")
	public String deleteData(@PathVariable(value = "id") String id) {

		if (!service.deleteData(EmployeesEntity.class, id))
			return "failed";

		return "successful";
	}
}
