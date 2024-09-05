package forms_project.forms.service;

import forms_project.forms.DTO.UsersResponseDTO;
import forms_project.forms.domain.Users;
import forms_project.forms.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;

    public UsersResponseDTO createUser(String name, String email, String phone, MultipartFile crpath) {

        String crpathfile = savefile(crpath);

        Users user = new Users();
        user.setName(name);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCrpath(crpathfile);

        usersRepository.save(user);

        return new UsersResponseDTO(user.getName(), user.getEmail(), user.getPhone(), crpathfile);

    }


    private String savefile(MultipartFile file) {
        try{
            String folder = "upload/";
            byte[] bytes = file.getBytes();
            Path path = Paths.get(folder + file.getOriginalFilename());
            Files.write(path,bytes);

            return path.toString();
        }
        catch (IOException e){
            throw new RuntimeException("error saving file",e);
        }

    }


}

