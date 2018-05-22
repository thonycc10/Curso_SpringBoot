package com.udemy.backendninja.controller;

import com.udemy.backendninja.model.ContactModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

//    @GetMapping("/checkrest")
//    public ResponseEntity<String> checkRest(){   devuelce string
//        return new ResponseEntity<String>("OK!", HttpStatus.OK);
//        // OJO ! El body es que el retorna al front - devuelve los datos con un status
//    }
    @GetMapping("/checkrest")
    public ResponseEntity<ContactModel> checkRest(){    // devuelve un model
        ContactModel contactModel = new ContactModel(8, "brenda", "quiñonez", "2312312", "Madrid");
        return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK);
        // OJO ! El body es que el retorna al front - devuelve los datos con un status
    }
}
