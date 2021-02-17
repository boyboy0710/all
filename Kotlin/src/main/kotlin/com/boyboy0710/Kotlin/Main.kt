package com.boyboy0710.Kotlin

import org.bukkit.plugin.java.JavaPlugin

class Main: JavaPlugin() {
    override fun onEnable() {
        logger.info("Kotlin 플러그인이 성공적으로 로드되었습니다")
    }

    override fun onDisable(){
        logger.info("Kotlin Plugin disabled")
    }
}