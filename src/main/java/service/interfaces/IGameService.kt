package whitecrow.service.interfaces

import whitecrow.dto.GameDto
import whitecrow.model.Game

interface IGameService : IDataService<Game, GameDto, Int>