package com.eungsoo.blog.controller;

        import com.eungsoo.blog.models.UserRoleEnum;
        import com.eungsoo.blog.security.UserDetailsImpl;
        import org.springframework.security.core.annotation.AuthenticationPrincipal;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")


    public String home(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        if (userDetails==null) {
//            System.out.println(model);
//            System.out.println(userDetails);
            return "index";
        }

        model.addAttribute("username", userDetails.getUsername());

        if (userDetails.getUser().getRole() == UserRoleEnum.ADMIN) {
            model.addAttribute("admin_role", true);
        }

        return "index";
    }
}
