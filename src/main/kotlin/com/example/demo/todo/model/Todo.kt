package com.example.demo.todo.model

import javax.persistence.*

/**
 * 테스트용
 */
@Entity
@Table(name = "todo")
class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본키 생성전략을 db에 위임
    var id:Long?=null

    var title:String?=null
    var description:String?=null
    var finished:Boolean?=false
}