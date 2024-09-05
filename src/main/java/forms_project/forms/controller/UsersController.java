package forms_project.forms.controller;


import forms_project.forms.DTO.UsersResponseDTO;
import forms_project.forms.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/upload")
    public ResponseEntity<UsersResponseDTO>CreateUser(
            @RequestParam("name")String name,
            @RequestParam("email")String email,
            @RequestParam("phone")String phone,
            @RequestParam("crpath") MultipartFile crpath) {



            UsersResponseDTO userResponseDTO = usersService.createUser(name,email,phone,crpath);
            return ResponseEntity.ok(userResponseDTO);


            }

}
