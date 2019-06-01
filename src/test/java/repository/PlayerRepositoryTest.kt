package repository

import org.junit.*
import org.junit.runner.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.test.autoconfigure.orm.jpa.*
import org.springframework.test.context.junit4.*
import whitecrow.model.*
import whitecrow.repository.interfaces.*

@RunWith(SpringRunner::class) @DataJpaTest
@Ignore
class PlayerRepositoryTest {

    @Autowired
    private lateinit var playerRepositoryImpl: IPlayerRepository

    @Test
    fun test() {
        playerRepositoryImpl.save(Player())
    }
}