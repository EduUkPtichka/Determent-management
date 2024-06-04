package com.determent.edeterment_management_system

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform