package com.udemy.backendninja.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.constant.ViewConstant;
import com.udemy.backendninja.entity.Contact;
import com.udemy.backendninja.model.ContactModel;
import com.udemy.backendninja.service.ContactService;

@Controller
//	@PreAuthorize("permitAll()") tambien a nivel de clase puedes añadir esta funcion, tambin funcionan on los services(metodo o class)
@RequestMapping("/contact")
public class ContactController {

//	@GetMapping("/")
//	public String redirectContac() {
//		return "redirect:/contact/contactform";
//	}
	@Autowired
	@Qualifier("contactServiceImpl")
	private ContactService contactService;
	
	private static final Log LOG = LogFactory.getLog(ContactController.class);
	
	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/contact/listcontacts";
	}

	// puedes usar el
//	@PreAuthorize("permitAll()") tiene acceso todos los usuarios
	@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")  // ROLE_USER es por defecto de spring security - si cambias no mostrara la vista
	@GetMapping("/contactform")
	public String redirectContac(@RequestParam(name="id", required=false) int id, 
			Model model) { // false porqe si viene vacio por el crear contact
		// creamos el contac con la ruta id obtenida service
		ContactModel contact = new ContactModel();
		if( id != 0) { // a tener listo esta logica ir a addContactsController - se crea un input=id
		contact = contactService.findContactByIdModel(id);
		}
		model.addAttribute("contactModel", contact);
		return ViewConstant.CONTACT_FORM;
	}
	
	@PostMapping("/addcontacts")
	public String addContacts(@ModelAttribute(name= "contactModel") ContactModel contactModel,
			Model model) {
		LOG.info("Call: addContacts() -- Con PARAMS : " + contactModel.toString());
		if(null != contactService.addContact(contactModel)) {
		model.addAttribute("result", 1); // utiliza para el alert
		}else {
		model.addAttribute("result", 0); // utiliza para el alert
		}
		return "redirect:/contact/listcontacts";
	}
	
	@GetMapping("/listcontacts")
	public ModelAndView listContacts() {
		ModelAndView modelAndView = new ModelAndView(ViewConstant.CONTACTS);
		modelAndView.addObject("contacts", contactService.listAllContacts());
		return modelAndView;
	}

	@GetMapping("/removecontact")
	public ModelAndView removeContact(@RequestParam(name="id", required=true) int id){
		contactService.removeContact(id);
		return listContacts();
	}
}