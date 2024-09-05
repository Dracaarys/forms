package forms_project.forms.DTO;


import org.springframework.web.multipart.MultipartFile;

public record UsersRequestDTO(String name, String email, String phone, MultipartFile crpath) {

}
