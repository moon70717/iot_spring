package com.iot.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService eserivce;
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String getEmpList(Model m) {
		List<Emp> empList=eserivce.getEmpList();
		m.addAttribute("empList", empList);
		return "emp/jstl_list";
	}
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String getEmpWrite(Model m) {
		return "emp/write";
	}
	
	@RequestMapping(value="insert", method=RequestMethod.GET)
	public String InsertEmp(@Valid Emp empDTO,Errors es,Model m) {
		System.out.println("fasafafs");
		if(es.hasErrors()) {
			/*Log.info("error =>{}",es);*/
			m.addAttribute("errorMsg",es.getAllErrors());
			return "error/error";
		}
		logger.info("insert result =>{}",empDTO);
		eserivce.insertEmp(empDTO);
		return "emp/write";
	}
	
	@RequestMapping(value="info", method=RequestMethod.GET)
	public String GetEmpInfo(@Valid Emp empDTO,Errors es,Model m) {
		
		return "emp/list_info";
	}
}
