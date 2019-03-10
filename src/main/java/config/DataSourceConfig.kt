package whitecrow.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import java.util.*
import javax.sql.DataSource

@Configuration
abstract class DataSourceConfig {
    @Bean
    fun sessionFactory() : LocalSessionFactoryBean {
        val sessionFactory = LocalSessionFactoryBean()
        sessionFactory.setDataSource(dataSource())
        sessionFactory.setPackagesToScan("whitecrow.model")
        sessionFactory.hibernateProperties = hibernateProperties()
        return sessionFactory
    }

    abstract fun dataSource (): DataSource

    @Bean
    fun hibernateTransactionManager(): PlatformTransactionManager {
        val transactionManager = HibernateTransactionManager()
        transactionManager.sessionFactory = sessionFactory().getObject()
        return transactionManager
    }

     fun hibernateProperties(): Properties {
        val hibernateProperties = Properties()
        hibernateProperties.setProperty(
            "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"
        )
        return hibernateProperties
    }
}