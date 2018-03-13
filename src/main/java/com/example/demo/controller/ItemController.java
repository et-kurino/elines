package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.domain.Item;
import com.example.demo.domain.ItemRepository;

@Controller
public class ItemController {
	
	@Autowired
	ItemRepository itemRepository;
	
	//���i�S���n��
	@GetMapping("/item/search-list")
	public String main(Model model) {
		model.addAttribute("item", new Item());
		return "item/search-list";
	}
	
	
	//���i�������ʓn��
	@PostMapping("/item/search-list")
	public String search(@ModelAttribute Item item) {
		return "item/search-list"
		;}
	
	
	//detail
	@RequestMapping(value="/item/{itemId}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("itemId") String itemId, ModelAndView mav) {
		
		//serch-result�̏��iid�Ō���
		Item item = itemRepository.findOne(itemId);
		//click���ꂽitemId�Ō�item�ɔ��
		mav.addObject("target", "America");
		mav.setViewName("item");
		return mav;
	}
	
	
	
	
}
