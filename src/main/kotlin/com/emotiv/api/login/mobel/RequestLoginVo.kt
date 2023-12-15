package com.emotiv.api.login.mobel

/**
 * @fileName LoginVo
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
data class RequestLoginVo(
    val loginId : String,
    val password : String
)
