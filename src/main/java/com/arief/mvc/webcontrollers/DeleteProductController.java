package com.arief.mvc.webcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.arief.mvc.services.ProductService;

@Controller
@RequestMapping("/product")
public class DeleteProductController {

	
	@Autowired
	private ProductService pService;
	
	
	@RequestMapping(value = "/delete/{id}")
	public String  deleteProductView(@PathVariable String id) {
		pService.delete(id);
		return "redirect:/product/list-product";
	}
	
}
