package com.emotiv.api.user.service

import com.emotiv.common.api.repository.ActionLogRepository
import com.emotiv.api.user.repository.UserRepository
import org.springframework.stereotype.Service

/**
 * @fileName UserService
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
class UserService (
    private val userRepository: UserRepository,
    private val actionLogRepository: ActionLogRepository
){
    fun userInfo(uid: Int): Any {
        val memberId = userRepository.getMemberId(uid) ?: return "noUser"
        val basicInfo = userRepository.basicInfo(memberId)
        return basicInfo
    }

    fun goldInfo(uid: Int): Any {
        val memberId = userRepository.getMemberId(uid) ?: return "noUser"
        val goldInfo = actionLogRepository.goldInfo(memberId)
        return goldInfo
    }
}