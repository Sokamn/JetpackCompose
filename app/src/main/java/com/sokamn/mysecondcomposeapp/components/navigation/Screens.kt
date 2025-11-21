package com.sokamn.mysecondcomposeapp.components.navigation

import com.sokamn.mysecondcomposeapp.components.navigation.examples.model.SettingModel
import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String, val test: Boolean)

@Serializable
data class Settings(val settingModel: SettingModel)