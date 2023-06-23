package com.example.Criteria_Builder;

import com.example.Criteria_Builder.entity.Admin;
import com.example.Criteria_Builder.repo.AdminRepo;
import com.example.Criteria_Builder.services.AdminService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

//@RunWith(SpringRunner.class)
@SpringBootTest
class CriteriaBuilderApplicationTests {
//	@Autowired
//	private AdminService adminService;
//	@MockBean
//	private AdminRepo adminRepo;
//	@Test
//	public void addAdmin(){
//		Admin admin = new Admin();
//		when(adminRepo.save(admin)).thenReturn(admin);
//		assert(admin,adminService.addAdmin(admin));
//	}

	@Test
	void contextLoads(){
	}

}
