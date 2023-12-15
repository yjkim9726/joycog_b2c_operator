package com.emotiv.api.user.controller

import com.emotiv.api.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

/**
 * @fileName UserController
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
@RequestMapping("/user")
class UserController (
    private val userService: UserService
){

    @GetMapping("/info")
    fun basicInfo(@RequestParam uid : Int): ResponseEntity<Any> {
        val user = userService.userInfo(uid)
        return ResponseEntity.ok(user) // JSON 형식으로 반환
    }

    @GetMapping("/gold-info")
    fun goldInfo(@RequestParam uid : Int): ResponseEntity<Any> {
        val gold = userService.goldInfo(uid)
        return ResponseEntity.ok(gold) // JSON 형식으로 반환
    }
}