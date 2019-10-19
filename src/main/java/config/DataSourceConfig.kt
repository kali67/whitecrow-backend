package whitecrow.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*
import javax.sql.DataSource

@Configuration
@EnableTransactionManagement
abstract class DataSourceConfig {

    /**
     * To be implemented by all extending this class.
     * Requires a datasource configuration for db
     * implementations.
     *
     * See [whitecrow.config.PostgresHibernateConfigLocal] for an example.
     * @return datasource object
     */
    abstract fun dataSource(): DataSource

    @Bean
    fun sessionFactory(): LocalSessionFactoryBean {
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

    /**
     *  To be implemented by all extending this class.
     *  Must detail properties for the database implementation, i.e. dialect etc.
     *
     *  See [whitecrow.config.PostgresHibernateConfigLocal] for an example.
     *  @return properties for hibernate configuration
     */
    abstract fun hibernateProperties(): Properties

}