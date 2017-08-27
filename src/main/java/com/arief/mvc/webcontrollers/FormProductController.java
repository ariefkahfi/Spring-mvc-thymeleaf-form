package com.arief.mvc.webcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arief.mvc.entity.Product;
import com.arief.mvc.services.ProductService;

import java.util.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class FormProductController {
	
	
	@Autowired
	private ProductService productService;
	

	private UUID uuid;
	
	
	
	
	@RequestMapping(value="/form-simpan",method=RequestMethod.GET)
	public String formInit(Model m) {
		m.addAttribute("product", new Product());
		return "form";
	}
	
	@RequestMapping(value="/form-simpan",method=RequestMethod.POST)
	public String formSubmit(@Valid Product product ,BindingResult bind) {
		
		if(bind.hasErrors()) {
			return "form";
		}
		
		uuid = UUID.randomUUID();
		
		product.setId(uuid.toString());	
		productService.save(product);
		
		return "redirect:list-product";
	}
	
	@RequestMapping(value="/form-update/{id}")
	public String formUpdateProduct(@PathVariable String id ,Model m) {
		Product  p = productService.getOne(id);
		
		m.addAttribute("product",p);
		
		return "form-update";
	}
	
	@RequestMapping(value="/form-update",method = RequestMethod.POST)
	public String formUpdateProductSubmitView(@Valid @ModelAttribute("product") Product p ,BindingResult bind,ModelMap m,@RequestParam("id")String id) {
		
		m.addAttribute("id", id);
		
		if(bind.hasErrors()) {
			m.addAttribute("id", id);
			return "form-update";
		}
	
		//Product update = productService.getOne(id);
		
		String getId =(String) m.get("id");
		
		p.setId(getId);
		
		productService.update(p);
		
		return "redirect:/product/list-product";
	}
	
	@RequestMapping(value="/form-buy/{id}")
	public String formInitForBuyProducts(@PathVariable String id,ModelMap m) {
		Product p = productService.getOne(id);
		m.addAttribute("product", p);
		return "form-buy";
	}
	
	
	@RequestMapping("/form-buy-submit/{id}")
	public String formBuyProductSubmit(@PathVariable String id , @ModelAttribute("product")Product p ,ModelMap m ,@RequestParam(value="qty",required=true)Integer qty) {
		
		Product pp = productService.getOne(id);
		try {

			System.err.println(pp.getStock());
			
			System.err.println(qty);
			
			if(qty > pp.getStock() || qty<0) {
				
				p.setName(pp.getName());
				p.setStock(pp.getStock());
				m.addAttribute("pesan", "Mohon masukkan jumlah yang valid");
				
				return "form-buy"; 	
			}else {
				productService.buyProduct(qty, id);
				return "redirect:/product/list-product";
			}
	
		}catch (NullPointerException e) {		
			m.addAttribute("pesan", "Field tidak boleh kosong");
		
			p.setName(pp.getName());
			p.setStock(pp.getStock());
			
			return "form-buy";
		}

	}
	
	
	
}
