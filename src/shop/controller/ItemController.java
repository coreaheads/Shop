package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import shop.svc.ItemService;

@Controller
public class ItemController {

@Autowired
ItemService svc;
	
}
