package com.example.demo.main

import com.example.demo.oauth.service.COauth2Service
import org.springframework.http.ResponseEntity
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 토큰, 로그인사용자이름을 얻을수있습니다.
 */
@RestController
class MainController {

    /**
     * main()에서 db에 유저정보 저장예정
     */
    @GetMapping("/tempEndpoint")
    fun main(@RegisteredOAuth2AuthorizedClient client: OAuth2AuthorizedClient): ResponseEntity<String> {
        val responseBody = " ${client.accessToken.tokenValue} / ${client.refreshToken?.tokenValue} / ${client.principalName}"
        return ResponseEntity.ok(responseBody)
    }
}