package com.emotiv.api.login.repository

import com.emotiv.api.login.mobel.OperatorEntity
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

/**
 * @fileName LoginRepository
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
interface LoginRepository {
    fun isValidUser(operatorEntity : OperatorEntity) : OperatorEntity?
}