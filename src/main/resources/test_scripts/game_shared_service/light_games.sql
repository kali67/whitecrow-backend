INSERT INTO users (user_id, username, password, language_id)
VALUES ('bef7233c164597cd4ff04aa76038b231', 'hta55_test', '$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm', 0);


insert into game (id, max_players, number_rounds, type, next, winner)
values (1, 2, 1, 'SINGLEPLAYER', null, null);


insert into game (id, max_players, number_rounds, type, next, winner)
values (2, 2, 1, 'SINGLEPLAYER', null, null);

insert into player (player_id,
                    cost_reduced_since,
                    current_day,
                    final_score,
                    money,
                    play_order,
                    set_back_steps,
                    turn_type,
                    game_id,
                    user_id)
values (1, -1, 0, 0, 1000.00, 0, 0, 'NORMAL', 1, 'bef7233c16454ff097cd4aa76038b231');

insert into player (player_id,
                    cost_reduced_since,
                    current_day,
                    final_score,
                    money,
                    play_order,
                    set_back_steps,
                    turn_type,
                    game_id,
                    user_id)
values (2, -1, 0, 0, 1000.00, 1, 0, 'NORMAL', 1, 'bef7233c164597cd4ff04aa76038b231');

update game -- set next player on game objects
set next = 1;
