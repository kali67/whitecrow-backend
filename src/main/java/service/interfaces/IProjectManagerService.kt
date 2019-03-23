package whitecrow.service.interfaces

import whitecrow.model.BankingStrategy

interface IProjectManagerService {

    fun createPlayer(username: String)

    fun updateUsername(id: Int, username: String)

    fun updateBankingStrategy(id: Int, bankingStrategy: BankingStrategy)

}