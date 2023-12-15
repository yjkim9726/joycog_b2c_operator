package com.emotiv.api.login.controller

import com.emotiv.api.login.service.LoginService
import jakarta.servlet.http.HttpSession
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.mvc.support.RedirectAttributes


/**
 * @fileName LoginController
 * @author yunjeong
 * @since  2023/12/14
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/12/14        yunjeong        최초 작성
 */
@Controller
class LoginController (
    private val loginService: LoginService
){
    //로그인 페이지 이동
    @GetMapping("/login")
    fun doLogin(): String? {
        return "login"
    }

    @GetMapping("/main")
    fun doMain(): String? {
        return "main"
    }

    @PostMapping("/doLogin")
    fun login(loginId : String, password : String, session : HttpSession, redirectAttributes: RedirectAttributes): String {
        val operator = loginService.isValidUser(loginId,password)
        return if (operator != null) {
            session.setAttribute("loginId",operator.loginId)
            session.setAttribute("name",operator.name)
            "redirect:main" // Thymeleaf 뷰로 리디렉션
        } else {
            redirectAttributes.addFlashAttribute("loginError", "Please check your ID and password again.")
            "redirect:login" // 로그인 페이지로 리디렉션
        }
    }

    // 로그아웃
    @GetMapping("/logout")
    fun logout(session : HttpSession) : String {
        session.invalidate()
        return "redirect:login"
    }

}