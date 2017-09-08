package com._520it.crm.web.controller;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQuery;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.util.AjaxResult;
import com._520it.crm.util.PermissionName;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class EmployeeController extends BaseController{

	@Autowired
	private IEmployeeService service;

	@RequestMapping("/employee")
	@RequiresPermissions("employee:view")
	@PermissionName("员工主页")
	public String index(){

		return "employee";
	}

	@RequestMapping("/employeeIndex")
	public String employeeIndex(){
		return "employeeIndex";
	}
	//报表主页
	@RequestMapping("/PriceTotalIndex")
	public String PriceTotalIndex(){
		return "PriceTotalIndex";
	}

	//数据报表
	@RequestMapping("/PriceTotal")
	public String PriceTotal(){
		return "PriceTotal";
	}

	//分类销售比例
	@RequestMapping("/ClassSellScale")
	public String ClassSellScale(){
		return "ClassSellScale";
	}

	//商品数据报表
	@RequestMapping("/ProductData")
	public String ProductData(){
		return "ProductData";
	}

	//收银记录
	@RequestMapping("/CashierRecord")
	public String CashierRecord(){
		return "CashierRecord";
	}

	//商品销售记录
	@RequestMapping("/ProductSellRecord")
	public String ProductSellRecord(){
		return "ProductSellRecord";
	}



	@RequestMapping("/employee_list")
	@ResponseBody
	@RequiresPermissions("employee:list")
	@PermissionName("员工列表")
	public PageResult list(EmployeeQuery qo){

		return service.queryPageResult(qo);
	}
	@RequestMapping("/employee_listAll")
	@ResponseBody
	public  List<Employee> listAll(){
		return service.selectAll();
	}



	@RequestMapping("/employee_save")
	@ResponseBody
	@RequiresPermissions("employee:save")
	@PermissionName("新增员工")
	public AjaxResult save(Employee emp){
		System.out.println("================add");
		//默认是在职状态
		emp.setState(true);
		try{
			service.insert(emp);
			return new AjaxResult(true,"保存成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"保存失败!");
	}

	@RequestMapping("/employee_update")
	@ResponseBody
	@PermissionName("更新员工")
	@RequiresPermissions("employee:update")
	public AjaxResult update(Employee emp){
		System.out.println("================add");
		try{
			service.updateByPrimaryKey(emp);
			return new AjaxResult(true,"更新成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"更新失败!");
	}

	@RequestMapping("/employee_changeState")
	@ResponseBody
	@PermissionName("设置离职")
	@RequiresPermissions("employee:changeState")
	public AjaxResult changeState(Long id) {
		try{
			service.changeState(id);
			return new AjaxResult(true,"设置成功!");
		}catch(Exception e){
			e.printStackTrace();
		}
		return new AjaxResult(false,"设置失败!");
	}

	//工资页面
	@RequestMapping("/salary")
	@RequiresPermissions("salary:view")
	@PermissionName("工资主页")
	public String index1(){
		return "salary";
	}
	@RequestMapping("/salary_list")
	@ResponseBody
	public PageResult salaryList(EmployeeQuery qo){
		return service.querySalalryPageResult(qo);
	}





	/*@RequestMapping("/employee_export")
	@ResponseBody
	public void export(HttpServletResponse response) throws Exception {
		//文件下载响应头
		response.setHeader("Content-Disposition", "attachment;filename=a.xls");
		//响应到浏览器
		WritableWorkbook workbook = Workbook.createWorkbook(response.getOutputStream());

		//创建本地xls文件
		//WritableWorkbook workbook = Workbook.createWorkbook(new File("F:/a.xls"));
		//创建工作簿sheet
		WritableSheet sheet = workbook.createSheet("day01", 0);

		//创建文本格式单元格
		Label cell = new Label(0,0,"hello");
		//把单元格添加到工作簿中
		sheet.addCell(cell);
		//创建日期格式单元格
		DateTime dateTime = new DateTime(1, 0, new Date());
		//把单元格添加到工作簿中
		sheet.addCell(dateTime);


		//设置列标题
		sheet.addCell(new Label(0,0,"用户名"));
		sheet.addCell(new Label(1,0,"真实姓名"));
		sheet.addCell(new Label(2,0,"电话"));
		sheet.addCell(new Label(3,0,"邮箱"));


		//把员工的数据填充到工作簿中
		List<Employee> list = service.selectAll();

		for (int i = 0,j = 1; i < list.size(); i++,j++) {
			Employee employee = list.get(i);
			sheet.addCell(new Label(0,j,employee.getUsername()));

		}

		//写入数据
		workbook.write();
		//关闭资源
		workbook.close();
	}


	@RequestMapping("/employee_import")
	@ResponseBody
	public void importFile(MultipartFile file) throws Exception {
		//获取用户上传的文件
		Workbook workbook = Workbook.getWorkbook(file.getInputStream());
		//获取工作簿sheet
		Sheet sheet = workbook.getSheet(0);

		//获取总列数
		int columns = sheet.getColumns();
		//获取单元格内容
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				Cell cell = sheet.getCell(j, i);
				System.out.println(cell.getContents());
			}
		}
		//获取总行数
		int rows = sheet.getRows();
		for (int i = 1; i < rows; i++) {
			Employee employee = new Employee();
			employee.setUsername(sheet.getCell(0, i).getContents());
			employee.setRealname(sheet.getCell(1, i).getContents());
			employee.setTel(sheet.getCell(2, i).getContents());
			employee.setEmail(sheet.getCell(3, i).getContents());
			//添加到数据库中
			service.insert(employee);
		}
		//关闭资源
		workbook.close();
	}
*/




}
