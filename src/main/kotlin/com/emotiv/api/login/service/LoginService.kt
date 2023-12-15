package com.emotiv.api.login.service

import com.emotiv.api.login.mobel.OperatorEntity
import com.emotiv.api.login.repository.LoginRepository
import org.springframework.stereotype.Service

/**
 * @fileName LoginService
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
@Service
class LoginService (
    private val loginRepository: LoginRepository
){

    fun isValidUser(loginId: String, password: String) : OperatorEntity? {
        val operator = OperatorEntity(
            loginId = loginId,
            password = password
        )
        return loginRepository.isValidUser(operator)
    }


}