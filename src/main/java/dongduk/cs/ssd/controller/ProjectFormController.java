package dongduk.cs.ssd.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import dongduk.cs.ssd.model.Category;
import dongduk.cs.ssd.model.Product;
import dongduk.cs.ssd.model.Project;
import dongduk.cs.ssd.service.CategoryServiceImpl;
import dongduk.cs.ssd.service.ProjectServiceImpl;

@Controller
@RequestMapping({"/newProject", "/editProject"})
@SessionAttributes("projectForm")
public class ProjectFormController implements ApplicationContextAware {
	private static final String STEP1_FORM_VIEW = "projectForm1";
	private static final String STEP2_FORM_VIEW = "projectForm2";
	private static final String CONFIRM_VIEW = "projectConfirm";
	private static final String RESULT_VIEW = "projectDone";
	private static final String PRODUCT_FORM_VIEW = "productForm";
	
	@Autowired
	private ProjectServiceImpl projectService;
	@Autowired
	private CategoryServiceImpl categoryService;
	
	private List<Product> products;
	private int productId = 1;
	private String image="default";
	
	private WebApplicationContext context;	
	private String uploadDir;
	
	@Override					// life-cycle callback method
	public void setApplicationContext(ApplicationContext appContext)
		throws BeansException {
		this.context = (WebApplicationContext) appContext;
		this.uploadDir = context.getServletContext().getRealPath("/images/");
	}
	
	@ModelAttribute("projectForm")
	public ProjectForm formBanking(HttpServletRequest request) throws ParseException {
		ProjectForm projectForm;
		if(request.getParameter("projectId") != null) {		// 파라미터 값이 있으면 프로젝트 수정
			Project pj = projectService.getProject(Integer.parseInt(request.getParameter("projectId")));
			
			projectForm = new ProjectForm(pj.getProjectId(), pj.getName(), pj.getDescription(), 
					pj.getGoalAmount(), new SimpleDateFormat("yyyy-MM-dd").parse(pj.getDeadline()), pj.getUsername(),
					pj.getCategory(), pj.getProducts());
			products = pj.getProducts();
		}
		else {	// 파라미터 값이 없으면 새로운 프로젝트
			projectForm = new ProjectForm();
			products = new ArrayList<Product>();
			projectForm.setProducts(products);
		}
		return projectForm;
	}
	
	@ModelAttribute("categoryList")
	public List<String> getCategoryList() {
		List<Category> categories = categoryService.getCategoryList();
		List<String> categoryList = new ArrayList<String>();
		for(Category category : categories) {
			categoryList.add(category.getName());
		}
		return categoryList;
	}
	
	@RequestMapping("/productForm")		
	public String productForm(@ModelAttribute("productForm") ProductForm productForm) {
		return PRODUCT_FORM_VIEW;	
	}
	
	@RequestMapping("/addProduct")
	public String addProduct(@Valid @ModelAttribute("productForm") ProductForm productForm,
			BindingResult result) {
		if (result.hasFieldErrors("name") ||
			result.hasFieldErrors("goalAmount")) {		
			return PRODUCT_FORM_VIEW;	// 검증 오류 발생 시 product form view로 이동
		}
		
		Product product = new Product();
		product.setProductId(productId++);
		product.setName(productForm.getName());
		product.setDescription(productForm.getDescription());
		product.setPrice(productForm.getPrice());
		if (productForm.getQuantity() == 0) {	// 상품 수량을 입력하지 않으면 -1 설정
			product.setQuantity(-1);
		} else {
			product.setQuantity(productForm.getQuantity());
		}
		product.setMember(0);
		
		if(products == null) {
			products = new ArrayList<Product>();
		}
		products.add(product);
		return STEP2_FORM_VIEW;	// step2 form view로 이동
	}
	
	@RequestMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable String productId) {
		for(Product product : products) {
			if(product.getProductId() == Integer.parseInt(productId)) {
				products.remove(product);
				break;
			}
		}
		return STEP2_FORM_VIEW;	// step2 form view로 이동
	}
	
	@RequestMapping("/step1")		// step1 요청
	public String step1() {
		return STEP1_FORM_VIEW;	// step1 form view로 이동
	}
	
	@GetMapping("/step2")		// confirm -> step2 이동	
	public String step2FromConfirm() {
		return STEP2_FORM_VIEW;	// step2 form view로 이동
	}
	
	@PostMapping("/step2")		// step1 -> step2 이동	
	public String step2(
			@Valid @ModelAttribute("projectForm") ProjectForm projectForm,
			BindingResult result) {
		if (result.hasFieldErrors("name") ||
			result.hasFieldErrors("goalAmount") ||
			result.hasFieldErrors("deadline") ||
			result.hasFieldErrors("description")) {		
			return STEP1_FORM_VIEW;	// 검증 오류 발생 시 step1 form view로 이동
		}
		
		if(!projectForm.getImage().isEmpty()) {		// 이미지 임시저장
			MultipartFile imageFile = projectForm.getImage();
			uploadFile(projectForm.getName(), imageFile);
			image = imageFile.getOriginalFilename();
		}
		return STEP2_FORM_VIEW;		// 오류 없으면 step2 form view로 이동
	}
	
	@PostMapping("/confirm")		// step2 -> confirm 이동
	public String confirm(
			@ModelAttribute("projectForm") ProjectForm projectForm,
			BindingResult result, Model model) {	
		return CONFIRM_VIEW;
	}
	
	@PostMapping("/done")		// confirm -> done 이동
	public String onSubmit(
			@ModelAttribute("projectForm") ProjectForm projectForm,
			BindingResult bindingResult, Model model,
			HttpServletRequest request, SessionStatus sessionStatus) {
		
		UserSession userSession = 
				(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		
		Project pj = new Project();
		pj.setProjectId(projectForm.getProjectId());
		pj.setName(projectForm.getName());	
		pj.setImage(image);
		pj.setDescription(projectForm.getDescription());
		pj.setGoalAmount(projectForm.getGoalAmount());
		pj.setDeadline(new SimpleDateFormat("yyyy-MM-dd").format(projectForm.getDeadline()));
		pj.setUsername(userSession.getAccount().getUsername());
		pj.setCategory(projectForm.getCategory());
		pj.setProducts(products);
		
		if (projectForm.isNewProject()) {
			projectService.insertProject(pj);
			projectService.ProjectScheduler(projectForm.getDeadline());		// 프로젝트 스케줄러
			model.addAttribute("result", "등록");
		}
		else {
			projectService.updateProject(pj);
			model.addAttribute("result", "수정");
		}
		
		sessionStatus.setComplete();	// session 종료
		return RESULT_VIEW;
	}
	
	private void uploadFile(String projectName, MultipartFile imageFile) {
		System.out.println(projectName + " 프로젝트 이미지 파일: "
				+ imageFile.getOriginalFilename());
		File file = new File(this.uploadDir + imageFile.getOriginalFilename());
		try {
			imageFile.transferTo(file);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
	}

}
