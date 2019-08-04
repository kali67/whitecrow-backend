-- removes games, players, all other users expect for the admin
delete from game;
delete from player;
delete from users u where u.user_id != 'bef7233c16454ff097cd4aa76038b231';

