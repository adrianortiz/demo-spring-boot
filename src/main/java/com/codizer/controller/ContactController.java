package com.codizer.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.codizer.model.ContactModel;
import com.codizer.service.ContactService;

@Controller
public class ContactController {
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;

	@RequestMapping("/")
	public ModelAndView listUser() {
		ModelAndView mav = new ModelAndView("list-contact");
		mav.addObject("contacts", contactService.listAllContacts());
		return mav;
	}
	
	@GetMapping("/form-contact")
	public String redirectContactForm(@RequestParam(name="id", required=false) int id,
			Model model) {
		
		ContactModel contactModel = new ContactModel();
		if(id != 0) {
			contactModel = contactService.findContactModelById(id);
		}
		model.addAttribute("contactModel", contactModel);
		return "form-contact";
	}
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/";
	}
	
	@PostMapping("/add-contact")
	public String addContact(@ModelAttribute(name="contactModel") ContactModel contactModel,
			Model model) {
		LOG.info("METHOD: addContact() -- PARAMS: " + contactModel.toString());
		
		if(null != contactService.addContact(contactModel)) {
			model.addAttribute("result", 1);
		} else {
			model.addAttribute("result", 0);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("remove-contact")
	public String removeContact(@RequestParam(name="id", required=true) int id) {
		contactService.removeContact(id);
		return "redirect:/";
	}
}