package com.emotiv.api.user.model

/**
 * @fileName UserBasicInfoVo
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
data class UserBasicInfoVo(
    val uid : Int,
    val createAccountDate : String,
    val lastAccessDate : String,
    val os : String,
    val version : String,
    val gold : Int,
    val countC10 : Int,
    val countC20 : Int,
    val countC30 : Int,
    val countC40 : Int,
    val countC50 : Int,
    val maxCountC10 : Int,
    val maxCountC20 : Int,
    val maxCountC30 : Int,
    val maxCountC40 : Int,
    val maxCountC50 : Int,
    val stageG10 : Int,
    val stageG11 : Int,
    val stageG12 : Int
)
