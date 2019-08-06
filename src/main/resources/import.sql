INSERT INTO lang (id, code)
VALUES (0, 'EN');
INSERT INTO lang (id, code)
VALUES (1, 'ES');

INSERT INTO users (user_id, username, password, language_id)
VALUES ('bef7233c16454ff097cd4aa76038b231', 'hta55', '$2a$10$AjHGc4x3Nez/p4ZpvFDWeO6FGxee/cVqj5KHHnHfuLnIOzC5ag4fm', 0);


INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (0, 0, 'MAIL', 'Getting certified is not everything.', '#008000', 'People (Organization)', 'Pay $100', 'Situation',
        'The management is more worried about getting certifies than about improving the development process,' ||
        ' while the team is getting frustrated.', 100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (0, 1, 'MAIL', 'Obtener la certificación no lo es todo.', '#008000', 'Personas (Organización)', 'Paga $100',
        'Situación',
        'La gerencia está más preocupada pvror obtener certificaciones que por mejorar ' ||
        'El proceso de desarrollo, mientras el equipo se frustra.', 100.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ORGANISATION', 0);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (1, 0, 'MAIL', '“Process-itis”', '#008000', 'People (Organization)', 'Pay $250', 'Situation',
        'In this organization everything has to be done following a process that was defined years ago. Currently nobody remembers why the things are don this way.',
        250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (1, 1, 'MAIL', '"Proceso-itis"', '#008000', 'Personas (Organización)', 'Paga $250', 'Situación',
        'En esta organización, todo debe hacerse siguiendo un proceso que Fue definido hace años. Actualmente nadie recuerda por qué las cosas se ponen de esta manera.',
        250.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ORGANISATION', 1);


INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (2, 0, 'MAIL', 'Lagging behind the schedule.', '#008000', 'People (Organization)', 'Pay $200', 'Situation',
        'We got overconfident with deadlines and now we are lagging behind. It is urgent to hire two more developers if we want to finish on time' ||
        '.', 200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (2, 1, 'MAIL', 'Quedando atrás el horario.', '#008000', 'Personas (Organización)', 'Paga $200', 'Situación',
        'Nos confiamos demasiado con los plazos y ahora nos estamos quedando atrás. Es urgente contratar a dos desarrolladores más si queremos terminar a tiempo.' ||
        '.', 200.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ORGANISATION', 2);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (3, 0, 'MAIL', 'This role is not for me.', '#008000', 'People (Organization)', 'Pay $150', 'Situation',
        'You don’t like the role assigned to you in the  team, you find it repetitive and want to go back to your old but exciting role.', 150.00,
        'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (3, 1, 'MAIL', 'Este papel no es para mí.', '#008000', 'Personas (Organización)', 'Paga $150', 'Situación',
        'No te gusta el rol que te asignaron en el equipo, lo encuentras repetitivo y quieres volver a tu antiguo pero emocionante rol.', 150.00,
        'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ORGANISATION', 3);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (4, 0, 'MAIL', 'Lack of delegation', '#008000', 'People (Organization)', 'Pay $300', 'Situation',
        'You are not able to delegate responsibilities and claim all the work for yourself. Of course, it is too much for one person.', 300.00,
        'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (4, 1, 'MAIL', 'Falta de delegacion', '#008000', 'Personas (Organización)', 'Paga $300', 'Situación',
        'No puede delegar responsabilidades y reclamar todo el trabajo por sí mismo. Por supuesto, es demasiado para una persona.', 300.00,
        'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ORGANISATION', 4);


INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction) -- TODO
VALUES (5, 0, 'MAIL', 'Tamales yatole - BBQ, Fish’n’Chips', '#008000', 'People (Organization)', 'Each player gives $100.',
        'Situation',
        'Next Friday is the office party and everyone brings a plate to share. The player who is closest to square 13 gets half of all the contributed money.',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (5, 1, 'MAIL', 'Tamales yatole - BBQ, Fish’n’Chips', '#008000', 'Personas (Organización)', 'Cada jugador da $100.',
        'Situación',
        'El próximo viernes es la fiesta de la oficina y todos traen un plato para compartir. El jugador que está más cerca del cuadrado 13 recibe la mitad de todo el dinero aportado.',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ORGANISATION', 5);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (6, 0, 'MAIL', 'Lack of trust', '#008000', 'People (Collaboration)', 'Pay $100.',
        'Situation',
        'The team is uncertain about the capacities of a new team member; it undermines their condidence and integration into the teamwork.',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (6, 1, 'MAIL', 'Falta de confianza', '#008000', 'Personas (Colaboración)', 'Paga $100.',
        'Situación',
        'El equipo no está seguro de las capacidades de un nuevo miembro del equipo; socava su condidencia e integración en el trabajo en equipo.',
        100.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COLLABORATION', 6);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (7, 0, 'MAIL', 'Fires to put out!', '#008000', 'People (Collaboration)', 'Pay $150.',
        'Situation',
        'A lot of effort gone into addressing last minute changes, so by the end of the week you haven’t finished all the deliverables' ||
        ' you have been assigned to.', 150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (7, 1, 'MAIL', '¡Incendios para apagar!', '#008000', 'Personas (Colaboración)', 'Paga $150.',
        'Situación',
        'Se hizo un gran esfuerzo para abordar los cambios de última hora, por lo que al final de la semana no habrá terminado todos los entregables a los que se le asignó.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COLLABORATION', 7);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (8, 0, 'MAIL', 'Inability to resolve conflicts', '#00FF7F', 'People (Collaboration)', 'Pay $200.',
        'Situation',
        'Any project and any team is likely to have frictions and conflicts, however, there is nobody to get them solved here. Waiting' ||
        ' for conflicts to work out by themselves is useless.', 200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (8, 1, 'MAIL', 'Incapacidad para resolver conflictos.', '#00FF7F', 'Personas (Colaboración)', 'Paga $200.',
        'Situación',
        'Cualquier proyecto y cualquier equipo pueden tener fricciones y conflictos, sin embargo, no hay nadie para resolverlos aquí. Esperar a que los conflictos se resuelvan por sí mismos es inútil.',
        200.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COLLABORATION', 8);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (24, 0, 'MAIL', 'Ineffective leadership', '#00FF7F', 'People (Collaboration)', 'Pay $250.',
        'Situation',
        'The team is lacking a trueleader who would stand forthe team’s interests. The team’s identity and vision are blurring and it ' ||
        'is losing the sense of direction/going off the rails.', 250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (24, 1, 'MAIL', 'Liderazgo inefectivo', '#00FF7F', 'Personas (Colaboración)', 'Paga $250.',
        'Situación',
        'El equipo carece de un verdadero líder que defienda los intereses del equipo. La identidad y la visión del equipo se están difuminando y está perdiendo el sentido de la dirección / saliéndose de los rieles.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COLLABORATION', 24);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (9, 0, 'MAIL', 'Writing documentation is boring.', '#00FF7F', 'People (Collaboration)', 'Pay $300.',
        'Situation',
        'You did not think documenting your code was that necessary. Today you have to refactor your teammate’s code and you realize ' ||
        'it would have been much easier if you both had followed the practice of documenting properly.', 300.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (9, 1, 'MAIL', 'Escribir documentación es aburrido.', '#00FF7F', 'Personas (Colaboración)', 'Paga $300.',
        'Situación',
        'No pensaste que documentar tu código fuera tan necesario. Hoy tiene que refactorizar el código de su compañero de equipo y se dará cuenta de que hubiera sido mucho más fácil si ambos hubieran seguido la práctica de documentar adecuadamente.',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COLLABORATION', 9);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (10, 0, 'MAIL', 'Where is the last version? OR Which is the last version?', '#00FF7F', 'People (Collaboration)',
        'Pay $250.',
        'Situation',
        'As the new law dictates, your client will have to go back to the previous version of the system. You are lucky to have used ' ||
        'an effficient version Monitoring system during all the project.', 250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (10, 1, 'MAIL', '¿Dónde está la última versión? O ¿Cuál es la última versión?', '#00FF7F', 'Personas (Colaboración)',
        'Paga $250.',
        'Situación',
        'Según lo dicte la nueva ley, su cliente tendrá que devolverse a la versión anterior del sistema. Tienes suerte de haber usado un sistema de Monito-ring de versión deficiente durante todo el proyecto.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COLLABORATION', 10);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (11, 0, 'MAIL', 'Painful meetings', '#ADFF2F', 'People (Communication)',
        'Pay $300',
        'Situation', 'After two hours of meeting you realize it has been a waste of time and effortcas no agreement has been reached.', 300.00,
        'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (11, 1, 'MAIL', 'Reuniones dolorosas', '#ADFF2F', 'Personas (Comunicación)',
        'Paga $300',
        'Situación',
        'Después de dos horas de reunión, se da cuenta de que ha sido una pérdida de tiempo y esfuerzo porque no se ha llegado a ningún acuerdo.',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COMMUNICATION', 11);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (12, 0, 'MAIL', 'Agreements Ignored', '#ADFF2F', 'People (Communication)',
        'Pay $150',
        'Situation', 'It looks like agreements are made but actually nobody respects them/pays attention to them.', 150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (12, 1, 'MAIL', 'Acuerdos ignoradosd', '#ADFF2F', 'Personas (Comunicación)',
        'Paga $150',
        'Situación', 'Parece que se hacen acuerdos pero en realidad nadie los respeta / les presta atención.', 150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COMMUNICATION', 12);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (13, 0, 'MAIL', 'Got Superpowers?', '#ADFF2F', 'People (Communication)',
        'Pay $200',
        'Situation', 'You haven’t been to the Daily Scrum meeting for two days and you don’t respond the team’s chat believing that you can do ' ||
                     'it all by yourself.', 200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (13, 1, 'MAIL', 'Tienes superpoderes?', '#ADFF2F', 'Personas (Comunicación)',
        'Paga $200',
        'Situación',
        'No has estado en la reunión de Daily Scrum durante dos días y no respondes al chat del equipo creyendo que puedes hacerlo todo solo.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COMMUNICATION', 13);


INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (14, 0, 'MAIL', 'Slow communication', '#ADFF2F', 'People (Communication)',
        'Pay $250',
        'Situation',
        'The means of communication with the team are not very effective; some prefer email, others use chat and nobody is responding' ||
        '.', 250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (14, 1, 'MAIL', 'Comunicación lenta', '#ADFF2F', 'Personas (Comunicación)',
        'Paga $250',
        'Situación',
        'Los medios de comunicación con el equipo no son muy efectivos; Algunos prefieren el correo electrónico, otros usan el chat y ' ||
        'nadie responde.', 250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COMMUNICATION', 14);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (15, 0, 'MAIL', 'Change of Attitude', '#ADFF2F', 'People (Communication)',
        'Pay $100',
        'Situation', 'You used to be easy to talk to and open to listen to others, but since you got promoted your attitude has changed and the ' ||
                     'good of the team shifted to the background.', 100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (15, 1, 'MAIL', 'Cambio de actitud', '#ADFF2F', 'Personas (Comunicación)',
        'Paga $100',
        'Situación',
        'Solías ser fácil de aceptar y abrir para escuchar a otros, pero desde que no promoviste tu actitud ha cambiado y el bien del equipo se ha cambiado al fondo.',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COMMUNICATION', 15);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description,
                  cost, flow_direction)
VALUES (16, 0, 'MAIL', 'The client called', '#ADFF2F', 'People (Communication)',
        'Pay $150',
        'Situation',
        'The client appreciates the big job done with the new module of the system and calls you to let you know their satisfaction. ' ||
        'The teams’spirit goes up.', 150.00, 'IN');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (16, 1, 'MAIL', 'El cliente llamado', '#ADFF2F', 'People (Communication)',
        'Paga $150',
        'Situación',
        'El cliente aprecia el gran trabajo realizado con el nuevo módulo del sistema y le pide que le haga saber su satisfacción. El espíritu de los equipos sube.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COMMUNICATION', 16);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (17, 0, 'MAIL', 'Its hot in here', '#32CD32', 'People (Environment)',
        'Pay $100',
        'Situation', 'Such a great view of the city from your place, it’s a shame it is summer and the heat is unbearable in the office.', 100.00,
        'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (17, 1, 'MAIL', 'Hace calor aquí', '#32CD32', 'Personas (Medio Ambiente)',
        'Paga $100',
        'Situación', 'Una gran vista de la ciudad desde su lugar, es una pena que sea verano y el calor es insoportable en la oficina.', 100.00,
        'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ENVIRONMENT', 17);


INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (18, 0, 'MAIL', 'Cheaper than a server', '#32CD32', 'People (Environment)',
        'Pay $150',
        'Situation',
        'You decided not to spend money on a server to store the project, because a hard drive seemed to be a good idea. Now that it ' ||
        'is not working, you regret so much your decision.', 150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (18, 1, 'MAIL', 'Más barato que un servidor', '#32CD32', 'Personas (Medio Ambiente)',
        'Paga $150',
        'Situación',
        'Decidió no gastar dinero en un servidor para almacenar el proyecto, porque un disco duro parecía ser una buena idea. Ahora que no está funcionando, lamentas tanto tu decisión.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ENVIRONMENT', 18);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (19, 0, 'MAIL', 'Costly commute', '#32CD32', 'People (Environment)',
        'Pay $200',
        'Situation',
        'The company’s new office is far away from everybody,and commuting two hours to work during rush hours every day is wearing ' ||
        'you down.', 200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (19, 1, 'MAIL', 'Viaje costoso', '#32CD32', 'Personas (Medio Ambiente)',
        'Paga $200',
        'Situación',
        'La nueva oficina de la compañía está lejos de todo el mundo y los desplazamientos de dos horas al trabajo en horas pico todos los días lo están agotando.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ENVIRONMENT', 19);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (20, 0, 'MAIL', 'Personality clashes', '#32CD32', 'People (Environment)',
        'Pay $250',
        'Situation', 'The way you spoke to a developer when proving his code had a bug caused a bad feeling for both.', 250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (20, 1, 'MAIL', 'Choques de personalidad', '#32CD32', 'Personas (Medio Ambiente)',
        'Paga $250',
        'Situación', 'La forma en que habló con un desarrollador al probar que su código tenía un error causó un mal presentimiento para ambos.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ENVIRONMENT', 20);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (21, 0, 'MAIL', 'Quitting the project', '#32CD32', 'People (Environment)',
        'Pay $300',
        'Situation', 'The best developer in the team decides he needs a change of scenery and quits. The deadline to deliver the system is in ' ||
                     'two weeks!', 300.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (21, 1, 'MAIL', 'Salir del proyecto', '#32CD32', 'Personas (Medio Ambiente)',
        'Paga $300',
        'Situación',
        'El mejor desarrollador del equipo decide que necesita un cambio de escenario y se cierra. ¡La fecha límite para entregar el sistema es en dos semanas!',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ENVIRONMENT', 21);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (22, 0, 'MAIL', 'Extra Pay', '#32CD32', 'People (Environment)',
        'Each player gets $150',
        'Situation', 'The boss has noticed all the effort the team is putting into making the deadline of the project. Extra hours pay for each ' ||
                     'member.', 150.00, 'ALL');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (22, 1, 'MAIL', 'Pago extra', '#32CD32', 'Personas (Medio Ambiente)',
        'Cada jugador recibe $ 150',
        'Situación',
        'El jefe ha notado todo el esfuerzo que el equipo está poniendo en hacer la fecha límite del proyecto. Horas extras de pago para cada miembro.',
        150.00, 'ALL');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ENVIRONMENT', 22);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (23, 0, 'OPPORTUNITY', 'Scrum Master', '#FFEF00',
        'Opportunity for Improvement',
        'Cost: $500',
        'Effect',
        'What you learned in the Scrum Master certification has allowed you to improve the interaction of the team and you have been able to remove obstacles efficiently. It cancels all the risks of “Organization” and “Closure”.',
        500.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (23, 1, 'OPPORTUNITY', 'Scrum Master', '#FFEF00', 'Oportunidad de Mejora',
        'Costo: $500',
        'Efecto',
        'Lo que aprendiste en la certificaci ́on de Scrum Master te ha permitido mejorar la interacci ́on del equipo y has sido capaz de ' ||
        'remover obst ́aculos de manera eficiente. Cancela todos los riesgos de “Organizaci ́on” y “Cierre”.', 500.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ORGANISATION', 23);
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CLOSURE', 23);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (25, 0, 'OPPORTUNITY', 'Kanban board', '#FFEF00',
        'Opportunity for Improvement',
        'Cost: $450',
        'Effect',
        'With the board you placed in the common area of the team, the distribution of tasks was simplified and Everyone knows how each person is ' ||
        'moving forward. Cancel all the risks of “Collaboration” and "Planning."',
        450.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (25, 1, 'OPPORTUNITY', 'Tablero Kanban', '#FFEF00',
        'Oportunidad de Mejora',
        'Costo: $450',
        'Efecto',
        'Con el tablero que colocaste en el  ́area com ́un del equipo, la distribuci ́on de tareas se simplific ́o y todos saben en qu ́e est ́a ' ||
        'avanzando cada qui ́en. Cancela todos los riesgos de “Colaboraci ́on” y “Planeaci ́on”.',
        450.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COLLABORATION', 25);
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_PLANNING', 25);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (26, 0, 'OPPORTUNITY', 'Daily Scrum', '#F4BBFF',
        'Opportunity for Improvement',
        'Cost: $650',
        'Effect',
        'Incorporate brief and concise meetings all day has improved the communication of the team. Now we all have a clear vision of progress. day' ||
        ' to day of the project. Cancel all the risks of "Communication" and "Tracing".',
        650.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (26, 1, 'OPPORTUNITY', 'Daily Scrum', '#F4BBFF',
        'Oportunidad de Mejora',
        'Costo: $650',
        'Efecto',
        'Incorporar reuniones breves y concisas todos los d́ıas ha mejorado la comunicaci ́on del equipo. Ahora todos tenemos una visi ́on clara ' ||
        'del progreso d ́ıa a d ́ıa del proyecto. Cancela todos los riesgos de “Comunicaci ́on” y “Seguimiento”.',
        650.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COMMUNICATION', 26);
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_PLANNING', 26);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (27, 0, 'OPPORTUNITY', 'Revitalized human factors', '#F4BBFF',
        'Opportunity for Improvement',
        'Cost: $650',
        'Effect',
        'Keep in mind that the items they take out all work are people makes values and take care of human aspects as motivation, Respect and trust' ||
        '. It cancels all the risks of “Environment” and “Organization”.',
        650.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (27, 1, 'OPPORTUNITY', 'Factores humanos revitalizados', '#F4BBFF',
        'Oportunidad de Mejora',
        'Costo: $650',
        'Efecto',
        'Tener en cuenta que los elementos que sacan todo el trabajo son personas hace que valores y cuides aspectos humanos como motivaci ́on,' ||
        'respeto y confianza. Cancela todos los riesgos de “Entorno” y “Organizaci ́on”.',
        650.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ENVIRONMENT', 27);
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ORGANISATION', 27);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (28, 0, 'OPPORTUNITY', 'Think Aloud', '#F4BBFF',
        'Opportunity for Improvement',
        'Cost: $300',
        'Effect',
        'The user is expressing aloud what Think while testing the system. With this technique ca to validate the functionality and usability of ' ||
        'system you kill two birds with one stone. Cancel all risks of "Functionality" and "Usability."',
        300.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (28, 1, 'OPPORTUNITY', 'Factores humanos revitalizados', '#BF00FF',
        'Oportunidad de Mejora',
        'Costo: $300',
        'Efecto',
        'El usuario est ́a expresando en voz alta lo que piensa mientras prueba el sistema. Con esta t ́ecnica para validar la funcionalidad y la ' ||
        'usabilidad del sistema matas dos p ́ajaros de un tiro. Cancela todos los riesgos de “Funcionalidad” y “Usabilidad”.',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_FUNCTIONALITY', 28);
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_USABILITY', 28);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (29, 0, 'OPPORTUNITY', 'Weekly backs', '#F4BBFF',
        'Opportunity for Improvement',
        'Cost: $350',
        'Effect',
        'Have scheduled tasks to support the information as well as a server in a place The safe way to store them is necessary in any project ' ||
        'Every morning every system Critical issues are supported, there is nothing to to worry. Cancel all risks of "Reliability" and ' ||
        '"Requirements".',
        350.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (29, 1, 'OPPORTUNITY', 'Respaldos semanales', '#BF00FF',
        'Oportunidad de Mejora',
        'Costo: $350',
        'Efecto',
        'Contar con tareas programadas para respaldar la informaci ́on as ́ı como un servidor en un lugar seguro para almacenarlos es necesario en ' ||
        'cualquier proyecto. Cada madrugada todos los sistemas cr ́ıticos se respaldan, no hay nada de qu ́e preocuparse. Cancela todos los riesgos' ||
        ' de “Confiabilidad” y “Requerimientos”.',
        350.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_RELIABILITY', 29);
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_REQUIREMENTS', 29);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (30, 0, 'OPPORTUNITY', 'Responsive Design', '#FDD5B1',
        'Opportunity for Improvement',
        'Cost: $300',
        'Effect',
        'Using a responsive template for the graphical interface of the system allowed you to release the desktop and mobile application at the ' ||
        'same time and with a consistent design. Cancels all risks of "Usability" and "Compatibility".',
        300.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (30, 1, 'OPPORTUNITY', 'Diseño responsivo', '#FDD5B1',
        'Oportunidad de Mejora',
        'Costo: $300',
        'Efecto',
        'Utilizar una plantilla responsiva para la interfaz gráfica del sistema te permitió liberar al mismo tiempo y con un diseño consistente la ' ||
        'aplicación de escritorio y la móvil. Cancela todos los riesgos de ``Usabilidad'''' y ``Compatibilidad''''.',
        300.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_USABILITY', 30);
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_COMPATIBILITY', 30);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (31, 0, 'OPPORTUNITY', 'Stress tests', '#FDD5B1',
        'Opportunity for Improvement',
        'Cost: $400',
        'Effect',
        'With this new tool you can stress the system before releasing it and thus ensure that it supports the amount of' ||
        ' concurrent users expected by the client once the system is in operation. Cancels all risks of "Efficiency" and "Security"',
        300.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (31, 1, 'OPPORTUNITY', 'Pruebas de estrés', '#FDD5B1',
        'Oportunidad de Mejora',
        'Costo: $400',
        'Efecto',
        'Con esta nueva herramienta podrás estresar el sistema antes de liberarlo y así asegurarte que soporta la cantidad de usuarios concurrentes' ||
        ' esperada por el cliente una vez que el sistema esté en operación. Cancela todos los riesgos de "Eficiencia" y "Seguridad".',
        400.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_EFFICIENCY', 31);
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_SECURITY', 31);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (32, 0, 'OPPORTUNITY', 'Web Services', '#CC5500',
        'Opportunity for Improvement',
        'Cost: $350',
        'Effect',
        'Expose as web services the main functionalities of your system has facilitated the interaction with the rest of the systems of the ' ||
        'organization. Cancels all risks of "Maintainability" and "Efficiency".',
        350.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (32, 1, 'OPPORTUNITY', 'Servicios web', '#CC5500',
        'Oportunidad de Mejora',
        'Costo: $350',
        'Efecto',
        'Exponer como servicios web las funcionalidades principales de tu sistema ha facilitado la interacción con el resto de sistemas de la ' ||
        'organización. Cancela todos los riesgos de "Mantenibilidad" y "Eficiencia".',
        350.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_MAINTAINABILITY', 32);
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_EFFICIENCY', 32);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (33, 0, 'OPPORTUNITY', 'Software architect', '#CC5500',
        'Opportunity for Improvement',
        'Cost: $300',
        'Effect',
        'The experience of the new Software Architect helped us to choose an architecture pattern that will allow the system to evolve along with ' ||
        'the changes of the client''s business. Cancels all risks of "Portability" and "Design".',
        300.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (33, 1, 'OPPORTUNITY', 'Arquitecto de software', '#CC5500',
        'Oportunidad de Mejora',
        'Costo: $300',
        'Efecto',
        'La experiencia del nuevo Arquitecto de Software nos ayudó a elegir un patrón de arquitectura que permitirá al sistema evolucionar a la par' ||
        ' de los cambios del negocio del cliente. Cancela todos los riesgos de "Portabilidad" y "Diseño".',
        300.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_PORTABILITY', 33);
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_DESIGN', 33);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (34, 0, 'OPPORTUNITY', 'Development in the cloud', '#CC5500',
        'Opportunity for Improvement',
        'Cost: $350',
        'Effect',
        'Hosting the development platform of the organization in the cloud has made programming more efficient since everything is unified and ' ||
        'ready to use, you can adapt it according to the circumstances and allow remote work. Cancels all the risks of "Compatibility" and "Portability".',
        350.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (34, 1, 'OPPORTUNITY', 'Desarrollo en la nube', '#ADFF2F',
        'Oportunidad de Mejora',
        'Costo: $350',
        'Efecto',
        'Alojar la plataforma de desarrollo de la organización en la nube ha vuelto más eficaz la programación ya que todo está unificado y listo ' ||
        'para usarse, puedes adaptarla de acuerdo a las circunstancias y permite trabajar a distancia. Cancela rodos los riesgos de ' ||
        '"Compatibilidad" y "Portabilidad".',
        350.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_PORTABILITY', 34);
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_COMPATIBILITY', 34);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (35, 0, 'OPPORTUNITY', 'Pen testing at the limit', '#CC5500',
        'Opportunity for Improvement',
        'Cost: $350',
        'Effect',
        'With this penetration test suite, you can ensure that your system is prepared to repel attacks and face hacks without risking the ' ||
        'information it stores. It cancels all the risks of "Security" and "Reliability".',
        350.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (35, 1, 'OPPORTUNITY', 'Pen testing al límite', '#ADFF2F',
        'Oportunidad de Mejora',
        'Costo: $350',
        'Efecto',
        'Con esta suite de pruebas de penetración, podrás asegurarte que tu sistema está preparado para repeler ataques y enfrentar hackeos sin ' ||
        'poner en riesgo la información que almacena. Cancela todos los riesgos de "Seguridad" y "Confiabilidad".',
        350.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_SECURITY', 35);
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_RELIABILITY', 35);