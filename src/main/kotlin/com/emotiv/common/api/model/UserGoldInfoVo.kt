package com.emotiv.common.api.model

import com.fasterxml.jackson.databind.BeanDescription

/**
 * @fileName UserGoldInfoVo
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
data class UserGoldInfoVo(
    val date : String,
    val logDescription: String,
    val value : String,
    val gold : Int
)
