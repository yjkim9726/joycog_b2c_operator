package com.emotiv.common.api.repository

import com.emotiv.api.user.model.UserGoldInfoVo
import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

/**
 * @fileName ActionLogRepository
 * @author yunjeong
 * @since  2023/10/18
 * @version 1.0
 *
 * @Modification Information
 * @
 * @  DATE          AUTHOR         NOTE
 * @ -----------   ------------   -------------------------------
 * @ 2023/10/18        yunjeong        최초 작성
 */
@Mapper
@Repository
interface ActionLogRepository {
    fun insertMemberLog(memberLogEntity: Int) : Int

    fun goldInfo(memberId: Int): MutableList<UserGoldInfoVo>
}