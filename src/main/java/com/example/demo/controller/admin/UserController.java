package com.example.demo.controller.admin;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.User;
import com.example.demo.service.UploadService;
import com.example.demo.service.UserService;

@Controller
public class UserController {
    private final UserService userService;
    private final UploadService uploadService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, UploadService uploadService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.uploadService = uploadService;
        this.passwordEncoder = passwordEncoder;
    }

    @RequestMapping("/")
    public String getHomePage() {
        return "hello controller";
    }

    @GetMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users", users);
        return "admin/user/detail";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model,
            @ModelAttribute("newUser") User chau03,
            @RequestParam("imageUpload") MultipartFile file) {

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        String hashPassword = this.passwordEncoder.encode(chau03.getPassword());

        chau03.setAvatar(avatar);
        chau03.setPassword(hashPassword);
        chau03.setRole(this.userService.getRoleByName(chau03.getRole().getName()));
        this.userService.handleSaveUser(chau03);
        return "redirect:/admin/user";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        this.userService.handleDeleteUser(id);
        return "redirect:/admin/user";
    }

    @PostMapping("/admin/user/update/{id}")
    public String updateUser(@PathVariable long id, @ModelAttribute("user") User updatedUser, Model model) {

        User existingUser = userService.getUserById(id);

        // Cập nhật thông tin người dùng
        existingUser.setFullName(updatedUser.getFullName());
        existingUser.setAddress(updatedUser.getAddress());
        existingUser.setPhone(updatedUser.getPhone());

        // Lưu lại thông tin đã cập nhật
        this.userService.handleSaveUser(existingUser);
        return "redirect:/admin/user";
    }

}
