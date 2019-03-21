package whitecrow.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Component

@Component
class LocaleHelper @Autowired constructor(val messageSource: MessageSource) {

    fun translate(code: String) :String {
        if (code == "~") return ""
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale())
    }
}