package com.example.demo.oauth.service

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService
import org.springframework.security.oauth2.core.user.DefaultOAuth2User
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.LinkedHashMap

/**
 * 유저정보, 액세스토큰을 받을수있는 클래스
 * 1. 카카오api 정보가져오기에서 스코프에 따라 getKakaoNameMap()의 내용은 달라짐
 * 2. 코틀린문법이 어색하여 구조, 코드수정중에 있음
 */
@Service
class COauth2Service(): OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    companion object {
        const val KAKAO_NICK_NAME_KEY = "id"
        const val OAUTH_ATTRIBUTE_OUTER_KEY = "kakao_account"
        const val OAUTH_ATTRIBUTE_INNER_KEY = "profile"
        const val OAUTH_ATTRIBUTE_NICK_NAME_KEY = "nickname"
        const val KAKAO_USER_AUTHORITY = "ROLE_USER"
    }

    val delegate: OAuth2UserService<OAuth2UserRequest, OAuth2User> = DefaultOAuth2UserService()

    override fun loadUser(userRequest: OAuth2UserRequest?): OAuth2User {

        val oAuth2User: OAuth2User = delegate.loadUser(userRequest)
        val nameAttributeKey: String? = userRequest
            ?.clientRegistration
            ?.providerDetails
            ?.userInfoEndpoint
            ?.userNameAttributeName

        val kakaoName:Map<String, String> = getKakaoNameMap(oAuth2User)

        return DefaultOAuth2User(
            Collections.singleton(SimpleGrantedAuthority(KAKAO_USER_AUTHORITY)),
            kakaoName,
            nameAttributeKey) // 해당 파라미터의 역할은 파악되지 않음
    }

    /**
     * accessToken을 제출하여 받은 카카오유저정보에서 카카오네임을 추출합니다.
     * parameter : 카카오유저정보
     * return : 카카오유저이름
     */
    private fun getKakaoNameMap(oAuth2User: OAuth2User): Map<String, String> {
        val accountAttributes: LinkedHashMap<String, Any?> = (oAuth2User.getAttribute<String>(OAUTH_ATTRIBUTE_OUTER_KEY) as LinkedHashMap<String, Any?>).get(OAUTH_ATTRIBUTE_INNER_KEY) as LinkedHashMap<String, Any?>
        val nickname: String? = accountAttributes.get(OAUTH_ATTRIBUTE_NICK_NAME_KEY) as String
        val kakaoName:Map<String, String> = mapOf(KAKAO_NICK_NAME_KEY to "${nickname}")
        return kakaoName
    }
}