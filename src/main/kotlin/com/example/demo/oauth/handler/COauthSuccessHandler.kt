package com.example.demo.oauth.handler

import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 * OAuth2 로그인 성공시 진입
 * 테스트를 위해 임의로 생성한 컨트롤러로 이동합니다.
 */
class COauthSuccessHandler: AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
        authentication: Authentication?
    ) {
        println("success Authentication!")
        response?.sendRedirect("/tempEndpoint")
    }
}