package com.arief.mvc.webcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arief.mvc.services.ProductService;



@Controller
@RequestMapping("/product")
public class ListProductController {
	
	
	@Autowired
	private ProductService pService;
	
	
	@RequestMapping("/list-product")
	public String getAllProductView(Model m) {
		m.addAttribute("data", pService.getAll());
		return "list";
	}
}
