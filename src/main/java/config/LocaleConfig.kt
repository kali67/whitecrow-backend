package whitecrow.config

import org.springframework.context.annotation.Configuration
import java.util.Locale
import org.springframework.web.servlet.i18n.SessionLocaleResolver
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.LocaleResolver
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer




@Configuration
class LocaleConfig : WebMvcConfigurer {

    @Bean
    fun localeResolver(): LocaleResolver {
        val slr = SessionLocaleResolver()
        slr.setDefaultLocale(Locale.ENGLISH)
        return slr
    }

    @Bean
    fun localeChangeInterceptor(): LocaleChangeInterceptor {
        val lci = LocaleChangeInterceptor()
        lci.paramName = "lang"
        return lci
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(localeChangeInterceptor())
    }
}