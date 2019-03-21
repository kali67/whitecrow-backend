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

    abstract fun dataSource (): DataSource

    @Bean
    fun sessionFactory() : LocalSessionFactoryBean {
        val sessionFactory = LocalSessionFactoryBean()
        sessionFactory.setDataSource(dataSource())
        sessionFactory.setPackagesToScan("whitecrow.model")
        sessionFactory.hibernateProperties = hibernateProperties()
        return sessionFactory
    }

    @Bean
    fun hibernateTransactionManager(): PlatformTransactionManager {
        val transactionManager = HibernateTransactionManager()
        transactionManager.sessionFactory = sessionFactory().getObject()
        return transactionManager
    }

    private fun hibernateProperties(): Properties {
        val hibernateProperties = Properties()
        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none") // influences schema on start up
        hibernateProperties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false")
        return hibernateProperties
    }
}