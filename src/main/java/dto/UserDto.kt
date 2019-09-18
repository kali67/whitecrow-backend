package whitecrow.dto

import whitecrow.model.*
import java.util.*

data class UserDto(val username: String?, val languageCode: LanguageCode?, val id: UUID?, val hasCompletedPreTest: Boolean?)