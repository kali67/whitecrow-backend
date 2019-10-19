package whitecrow.repository.interfaces

import whitecrow.model.*

interface ILanguageRepository {

    /**
     * Finds the language object queried by the code
     * @param code code to query language by
     * @return language object that conforms to the lang code
     */
    fun findByCode(code: LanguageCode) : Language
}