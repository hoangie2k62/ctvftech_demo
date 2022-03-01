package demo.api;

import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import demo.annomations.Inject;
import demo.annomations.Service;
import demo.beans.Work;
import demo.database.CreateId;
import demo.entity.WorksEntity;
import demo.utils.AttributesUtils;

@Service
@RestController
public class WorksAPI{

	@Inject
	private CreateId createId;
	
	private WorksEntity entity;
	
	@GetMapping("/work")
	public List<Work> readData(@RequestParam(name = "page", required = false) int page) {
			
		return null;
	}

	@PostMapping("/work")
	public String addData(@RequestBody Work work){
		
//		entity = work.toEntity();
//		
//		entity.setId("FTECH0002");
//		
//		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
//		
//		EntityManager em = AttributesUtils.getEntityManager(request);
//		
//		em.persist(entity);
		
		System.out.println("??????????????????????????");
		
		return "success";
	}

	@PutMapping("/work")
	public String updateData(@RequestBody Work work) {
		// TODO Auto-generated method stub
		return null;
	}

	@DeleteMapping("/work")
	public String deleteData(@RequestParam(name = "id") String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
