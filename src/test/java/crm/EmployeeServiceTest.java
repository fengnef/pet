package crm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com._520it.crm.domain.Employee;
import com._520it.crm.service.IEmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:application.xml")
public class EmployeeServiceTest {
	@Autowired
	private IEmployeeService service;

	@Test
	public void testAdd() throws Exception {
		for (int i = 0; i < 15; i++) {
			Employee e = new Employee() ;
			e.setUsername("neld"+i);
			//e.setRealname("neld"+i);
			//e.setPassword("666");
			//e.setAdmin(true);
			e.setState(true);
			service.insert(e);
		}
	}
}
