package whitecrow.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import whitecrow.model.BankingStrategy

import whitecrow.interfaces.IProjectManagerService


@RestController
class ProjectManagerApiController @Autowired constructor(var projectManagerService: IProjectManagerService) {

    @PostMapping("/create/project_manager")
    fun createPlayer(@RequestParam(value = "username") username: String): String {
        projectManagerService.createPlayer(username)
        return "done"
    }

    @PostMapping("/project_manager/{id}/banking_strategy")
    fun updateBankingStrategy(@PathVariable id: Int, @RequestParam bankingStrategy: BankingStrategy) {
        projectManagerService.updateBankingStrategy(id, bankingStrategy)
    }


    @PutMapping("/project_manager/{id}")
    fun updateUsername(@PathVariable id: Int) {
        projectManagerService.updateUsername(id, "test")
    }
}