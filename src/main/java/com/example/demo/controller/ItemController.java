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
	
	/*
	 * 1.->mainアクセス（一覧表示　＋　ユーザ検索フォーム）
	 * 2.->detailアクセス（一覧内の商品画像（path格納）　detailリンクから）
	 * 3.->
	 * */
	
	//main 商品全件渡す
	@GetMapping("/item/search-list")
	public String main(Model model) {
		model.addAttribute("item", new Item());
		List<Item> items = item.Repository.
		
		return "item/search-list";
	}
	
	
	//search 商品検索結果渡す
	@PostMapping("/item/search-list")
	public String search(@ModelAttribute Item item) {
		
		
		return "item/search-list"
		;}
	
	
	//detail 詳細遷移
	@RequestMapping(value="/item/{itemId}", method = RequestMethod.GET)
	public ModelAndView detail(@PathVariable("itemId") String itemId, ModelAndView mav) {
		
		//serch-resultの商品idで検索
		Item itemData = itemRepository.findOne(itemId);
		//clickされたitemIdで個別itemに飛ぶ
		mav.addObject("itemData", itemData);
		mav.setViewName("item");
		return mav;
	}
	
	
	
	
}
