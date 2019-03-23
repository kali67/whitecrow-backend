package whitecrow.interfaces

import org.springframework.data.repository.NoRepositoryBean
import org.springframework.data.repository.Repository
import whitecrow.static_objects.MailCard

@NoRepositoryBean
interface IMailCardRepository : Repository<MailCard, Int> {

    fun findAll(): List<MailCard>
}