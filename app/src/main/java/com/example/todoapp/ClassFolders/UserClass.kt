package com.example.todoapp.ClassFolders

class UserClass {

    var position: Int? = null
    var name: String? = null
    var degree: Int? = null
    var description: String? = null
    var createDate: String? = null
    var toDo: String? = null


    constructor(
        position: Int?,
        name: String?,
        degree: Int?,
        description: String?,
        createDate: String?,
        toDo: String?
    ) {
        this.position = position
        this.name = name
        this.degree = degree
        this.description = description
        this.createDate = createDate
        this.toDo = toDo
    }

    constructor(
        name: String?,
        degree: Int?,
        description: String?,
        createDate: String?,
        toDo: String?
    ) {
        this.name = name
        this.degree = degree
        this.description = description
        this.createDate = createDate
        this.toDo = toDo
    }
}