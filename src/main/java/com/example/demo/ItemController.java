package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ItemController {
	
	//è§ïiëSåèìnÇ∑
	@GetMapping("item/search-list")
	public String main(Model model) {
		model.addAttribute("item", new Item());
		return "item/search-list";
	}
	
	
	//form serch-list
	@PostMapping("item/search-list")
	public String item(@ModelAttribute Item item) {
		return "item/search-list"
		;}
	
	
	//detail
	@RequestMapping(value="/item/{itemId}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("itemId") String itemId, ModelAndView mav) {
		
		//serch-resultÇÃè§ïiidÇ≈åüçı
		
		//clickÇ≥ÇÍÇΩitemIdÇ≈å¬ï itemÇ…îÚÇ‘
		mav.addObject("target", "America");
		mav.setViewName("item");
		return mav;
	}
	
	
	
	
}
