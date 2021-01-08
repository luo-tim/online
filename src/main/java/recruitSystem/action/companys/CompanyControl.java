/**
 * 
 */
package recruitSystem.action.companys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import recruitSystem.service.companys.CompanyService;
import recruitSystem.service.job.JobService;
import recruitSystem.view.Company;
import recruitSystem.view.Job;

/**
 * @author 72412
 *公司招聘控制
 */
@Controller
@RequestMapping("/companyPage")
public class CompanyControl {

	@Autowired
	private CompanyService companyService;
	@Autowired
	private JobService jobService;
	
	/*
	 * 进入公司列表页面
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String company(Model model) {
		List<Company> companies = companyService.findCompanies();
		model.addAttribute("companys", companies);
		return "company/companys";
	}
	
	/**
	 * 查看具体公司详情页面
	 */
	@RequestMapping(value = "/companyDetailPage", method = RequestMethod.GET)
	public String companyDetail(@RequestParam(value = "companyId", defaultValue = "0") String  companyId, Model model) {
		
			Company company = companyService.findCompanyById(companyId);
			if (company!=null) {
				model.addAttribute("company", company);
				model.addAttribute("index", 0);
				return "company/companyDetail";
			}
			else {
			return "redirect:/companyPage/notCompanyPage";// 重定向到没有
			}

	}
	
	/**
	 * 查看具体公司的职位列表
	 */
	@RequestMapping(value = "/companyWorksPage", method = RequestMethod.GET)
	public String companyWorks(@RequestParam(value = "companyId", defaultValue = "") String companyId, Model model) {
			Company company = companyService.findCompanyById(companyId);
			if (company != null) {
			List<Job> jobs = jobService.findCompanyJobs(companyId);
			model.addAttribute("company", company);
			model.addAttribute("index", 1);
			model.addAttribute("jobs", jobs);
			return "company/companyDetail";
		} else {
			return "redirect:/companyPage/notCompanyPage";// 重定向到没有
		}
	}
	/**
	 * 公司不存在
	 */
	@RequestMapping(value="/notCompanyPage",method = RequestMethod.GET)
	public String companyWorks(Model model) {
		
		model.addAttribute("error", "该公司不存在");
		return "error/error";
	}
	
	/**
	 * 公司注册页面
	 */
	@RequestMapping(value = "/companyRegisterPage", method = RequestMethod.GET)
	public String companyRegister() {
		return "company/companyRegister";
	}
	
	/**
	 * 公司注册提交
	 */
	@RequestMapping(value = "/companyRegisterPage", method = RequestMethod.POST)
	public String companyRegisterSubmit(@RequestParam(value = "name", defaultValue = "") String name,
			@RequestParam(value = "leader", defaultValue = "") String leader,
			@RequestParam(value = "introduce", defaultValue = "") String introduce,
			@RequestParam(value = "address", defaultValue = "") String address,
			@RequestParam(value = "type", defaultValue = "") String type,
			@RequestParam(value = "treatment", defaultValue = "") String treatment,
			@RequestParam(value = "file", defaultValue = "") CommonsMultipartFile file, HttpServletRequest request,
			Model model) throws IOException {

		String companyId = companyService.findCompany(name);
		if (companyId==null) {
			// 下载图片
			// 获取文件名 : file.getOriginalFilename();
			String uploadFileName = file.getOriginalFilename();
			// 获取上传的文件名 例如：test/img1.png
			// String
			// fileName=uploadFileName.substring(uploadFileName.lastIndexOf("/")+1).toLowerCase();
			// 后缀
			String fileSuffixName = uploadFileName.substring(uploadFileName.lastIndexOf(".") + 1);

//			if (!(fileSuffixName.equals("png") || fileSuffixName.equals("jpg") || fileSuffixName.equals("bmp")
//					|| fileSuffixName.equals("gif"))) {
//				model.addAttribute("companyTip", "图片格式不符合，注册失败");
//				return "redirect:/companyPage/notCompanyPage";// 返回错误页面
//			}
			System.out.println("上传文件名 : " + uploadFileName);
			// 上传路径保存设置
			String uploadPath = request.getServletContext().getRealPath("/resource");
			// System.out.println("上传文件保存地址："+uploadPath);
			// 如果路径不存在，创建一个
			File realPath = new File(uploadPath);
			if (!realPath.exists()) {
				realPath.mkdir();
			}
			// System.out.println("上传文件保存地址："+realPath);
			/*
			 * //使用UUID（唯一识别的通用码），保证文件名唯一 // UUID.randomUUID() 随机生成一个通用码 String uuidPath=
			 * UUID.randomUUID().toString();
			 * 
			 * String filePath=uploadPath+"/"+uuidPath; //给每个文件创建一个文件夹 File realPathFile=new
			 * File(filePath); if(!realPathFile.exists()) realPathFile.mkdir();
			 */
			String fileName = name + "." + fileSuffixName;// 保存的文件名称为公司名称加文件的后缀格式
			InputStream is = file.getInputStream(); // 文件输入流
			OutputStream os = new FileOutputStream(new File(realPath, fileName)); // 文件输出流

			// 读取写出
			int len = 0;
			byte[] buffer = new byte[1024];
			while ((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
				os.flush();
			}
			os.close();
			is.close();

			// String url=realPath+"/"+uploadFileName;

			// System.out.println(url);

			//Company company = new Company(name, introduce, address, treatment, type, fileName, leader);
			Company company=new Company();
			company.setCompanyName(name);
			company.setLeaderIntroduce(leader);
			company.setCompanyDescription(introduce);
			company.setAddress(address);
			company.setTreatment(treatment);
			company.setCompanyLogo(fileName);
			company.setCompanyType(type);
			companyService.insert(company);
			model.addAttribute("companyTip", "公司注册成功");
			// 提交成功后，返回成功信息
			return "company/companyTip"; // 返回成功页面
		} else {
			// 提交失败后，返回成功信息
			return "redirect:/companyPage/companyErrorPage"; // 返回失败页面
		}

	}


	/*
	 * 公司注册失败页面
	 */
	@RequestMapping(value = "/companyErrorPage", method = RequestMethod.GET)
	public String CompanyExist(Model model) {
		model.addAttribute("error", "公司注册失败，请重新注册");
		return "error/error";
	}


}
