package whitecrow.repository.interfaces

import whitecrow.model.*

interface ILanguageRepository {

    fun findByCode(code: LanguageCode) : Language
}