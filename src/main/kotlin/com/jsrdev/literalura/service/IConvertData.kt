package com.jsrdev.literalura.service

interface IConvertData {
    fun <T> getData(json: String, genericClass: Class<T>): T
}
