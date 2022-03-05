package demo.application.api;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public interface CrudAPI<T, ID> {

	List<T> readData(@RequestParam(value = "page", required = false) Integer page);
	String createData(@RequestBody T dto) throws Exception;
	String updateData(@RequestBody T dto) throws Exception;
	String deleteData(@PathVariable(value = "id") ID id);
}
