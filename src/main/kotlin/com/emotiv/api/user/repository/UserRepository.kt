package com.emotiv.api.user.repository

import com.emotiv.api.user.model.UserBasicInfoVo
import com.emotiv.api.user.model.UserGoldInfoVo
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

/**
 * @fileName UserRepository
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
@Mapper
@Repository
interface UserRepository {

    fun getMemberId(memberId: Int) : Int?

    fun basicInfo(memberId: Int): UserBasicInfoVo

}