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
VALUES (1, 0, 'MAIL', '"Process-itis"', '#008000', 'People (Organization)', 'Pay $250', 'Situation',
        'In this organization everything has to be done following a process that was defined years ago. Currently nobody remembers why the things ' ||
        'are done this way.',
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


INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (5, 0, 'MAIL', 'Tamales yatole - BBQ, Fish’n’Chips', '#008000', 'People (Organization)', 'Each player gives $100.',
        'Situation',
        'Next Friday is the office party and everyone brings a plate to share.',
        100.00, 'OUT'); --TODO
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
                     'member.', 150.00, 'ALL_OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (22, 1, 'MAIL', 'Pago extra', '#32CD32', 'Personas (Medio Ambiente)',
        'Cada jugador recibe $ 150',
        'Situación',
        'El jefe ha notado todo el esfuerzo que el equipo está poniendo en hacer la fecha límite del proyecto. Horas extras de pago para cada miembro.',
        150.00, 'ALL_OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ENVIRONMENT', 22);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (23, 0, 'OPPORTUNITY', 'Scrum Master', '#FFEF00',
        'Opportunity for Improvement',
        'Cost: $500',
        'Effect',
        'What you learned in the Scrum Master certification has allowed you to improve the interaction of the team and you have been able to remove obstacles efficiently. It cancels all the risks of "Organization" and "Closure".',
        500.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (23, 1, 'OPPORTUNITY', 'Scrum Master', '#FFEF00', 'Oportunidad de Mejora',
        'Costo: $500',
        'Efecto',
        'Lo que aprendiste en la certificaci ́on de Scrum Master te ha permitido mejorar la interacci ́on del equipo y has sido capaz de ' ||
        'remover obst ́aculos de manera eficiente. Cancela todos los riesgos de "Organizaci ́on" y "Cierre".', 500.00, 'OUT');

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
        'moving forward. Cancel all the risks of "Collaboration" and "Planning."',
        450.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (25, 1, 'OPPORTUNITY', 'Tablero Kanban', '#FFEF00',
        'Oportunidad de Mejora',
        'Costo: $450',
        'Efecto',
        'Con el tablero que colocaste en el  ́area com ́un del equipo, la distribuci ́on de tareas se simplific ́o y todos saben en qu ́e est ́a ' ||
        'avanzando cada qui ́en. Cancela todos los riesgos de "Colaboraci ́on" y "Planeaci ́on".',
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
        'del progreso d ́ıa a d ́ıa del proyecto. Cancela todos los riesgos de "Comunicaci ́on" y "Seguimiento".',
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
        '. It cancels all the risks of "Environment" and "Organization".',
        650.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (27, 1, 'OPPORTUNITY', 'Factores humanos revitalizados', '#F4BBFF',
        'Oportunidad de Mejora',
        'Costo: $650',
        'Efecto',
        'Tener en cuenta que los elementos que sacan todo el trabajo son personas hace que valores y cuides aspectos humanos como motivaci ́on,' ||
        'respeto y confianza. Cancela todos los riesgos de "Entorno" y "Organizaci ́on".',
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
        'usabilidad del sistema matas dos p ́ajaros de un tiro. Cancela todos los riesgos de "Funcionalidad" y "Usabilidad".',
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
        ' de "Confiabilidad" y "Requerimientos".',
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


--------------------------------------

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (36, 0, 'MAIL', 'I didnt want that', '#8B008B', 'Product (Functionality)',
        'Pay $100',
        'Situation',
        'Because of not getting your doubts clear with the clients, you implemented an unnecessary functionality, which means wasted ' ||
        'time and effort.', 100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (36, 1, 'MAIL', 'Pero no quise decir eso', '#8B008B', 'Producto (Funcionalidad)',
        'Paga $100',
        'Situación',
        'Por no resolver tus dudas con el cliente, implementaste una funcionalidad innecesaria, eso implica esfuerzo y tiempo perdido.',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_FUNCTIONALITY', 36);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (37, 0, 'MAIL', 'Extra Features', '#8B008B', 'Product (Functionality)',
        'Pay $150',
        'Situation',
        'You thought it was a good idea to add some nice extra features to the module. As the client didn’t ask for it, they are not going to pay for it either.',
        150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (37, 1, 'MAIL', 'Adornando el módulo', '#8B008B', 'Producto (Funcionalidad)',
        'Paga $150',
        'Situación',
        'Te pareció buena idea adornar el módulo con una funcionalidad nueva. Como el cliente no la pidió, tampoco la pagó.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_FUNCTIONALITY', 37);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (38, 0, 'MAIL', 'Please only use this web browser', '#8B008B', 'Product (Functionality)',
        'Pay $200',
        'Situation',
        'Your form validations are elegant and easy to implement, but they are not supported by the new web browser yet and are not shown to the user.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (38, 1, 'MAIL', 'Por favor, use sólo este navegador', '#8B008B', 'Producto (Funcionalidad)',
        'Paga $200',
        'Situación',
        'Las validaciones de tu formulario además de elegantes son sencillas de implementar, sin embargo el nuevo navegador web aún no la soporta y no se muestran al usuario.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_FUNCTIONALITY', 38);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (39, 0, 'MAIL', 'Lack of Fault Tolerance', '#F9429E', 'Product (Reliability)',
        'Pay $100',
        'Situation',
        'After having filled in more than 30 fields on several screens, the internet connection is lost and the system asks the user to start from the very beginning. So frustrating!',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (39, 1, 'MAIL', 'Sistema intolerante a fallos', '#F9429E', 'Producto (Confiabilidad)',
        'Paga $100',
        'Situación',
        'Después de haber rellenado un formulario de más de 30 campos a través de varias pantallas, se perdió la conexión a internet y el sistema obliga al usuario a comenzar de nuevo. Qué frustrante!',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_RELIABILITY', 39);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (40, 0, 'MAIL', 'There is only one way to do it', '#F9429E', 'Product (Reliability)',
        'Pay $300',
        'Situation',
        'The code scanner to enter products’ codes is not working. Because your system does not have another option to enter product codes manually, you will have to suspend the service for today.',
        300.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (40, 1, 'MAIL', 'Sólo hay una forma de hacerlo', '#F9429E', 'Producto (Confiabilidad)',
        'Paga $300',
        'Situación',
        'El escaner para leer los códigos de los productos se descompuso. Como tu sistema no tiene una opción para capturar el código manualmente tendrás que suspender los servicios de hoy.',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_RELIABILITY', 40);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (41, 0, 'MAIL', 'A Backup Server', '#F9429E', 'Product (Reliability)',
        'Receive $150',
        'Situation',
        'The servers’ room got flooded. Luckily, you invested in a server mirroring and are able to keep on operating in a normal way.',
        150.00, 'IN');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (41, 1, 'MAIL', 'Servidor de respaldo', '#F9429E', 'Producto (Confiabilidad)',
        'Recibe $150',
        'Situación',
        'Una inundación arruinó el cuarto de servidores. Por suerte invertiste en un servidor espejo que permitió seguir la operación con normalidad.',
        150.00, 'IN');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_RELIABILITY', 41);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (42, 0, 'MAIL', 'Poor usability of the system', '#FBA0E3', 'Product (Usability)',
        'Pay $100',
        'Situation',
        'Making the interface user friendly and matching colours is not your thing. You should hire a web designer to improve the user experience of your system.',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (42, 1, 'MAIL', 'La usabilidad de tu sistema es muy pobre', '#FBA0E3', 'Producto (Usabilidad)',
        'Paga $100',
        'Situación',
        'Organizar la interfaz y combinar colores no es lo tuyo. Deberás contratar a un diseñador para mejorar la UX de tu sistema.',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_USABILITY', 42);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (43, 0, 'MAIL', 'User interface is not responding', '#FBA0E3', 'Product (Usability)',
        'Pay $150',
        'Situation',
        'You didn’t realise that most of your users prefer to connect to the system through a smart phone. Your interface is perfect . . . . but only on a desktop.',
        150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (43, 1, 'MAIL', 'La IU no es responsiva', '#FBA0E3', 'Producto (Usabilidad)',
        'Paga $150',
        'Situación',
        'Nunca te diste cuenta de que la mayoría de tus usuarios prefieren conectarse desde dispositivos móviles al sistema. Tu interfaz es perfecta... pero sólo la versión de escritorio.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_USABILITY', 43);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (44, 0, 'MAIL', 'Is it a button or a link or a label or a tag?', '#FBA0E3', 'Product (Usability)',
        'Pay $200',
        'Situation',
        'The UI was developed without any agreed standard, so now with the integration done you realize that buttons lack consistency. The buttons are different from one another, the hyperlinks are the same as the simple text and the text boxes have become lost in the background.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (44, 1, 'MAIL', 'Es un botón, un link o una etiqueta?', '#FBA0E3', 'Producto (Usabilidad)',
        'Paga $200',
        'Situación',
        'La IU la desarrollaron sin acordar un estándar, ahora que la integraron los botónes no son consistentes entre sí, los links no se diferencían del texto simple y las cajas de texto se pierden con el fondo de la pantalla.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_USABILITY', 44);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (45, 0, 'MAIL', 'Frozen Screen', '#FF8C69', 'Product (Efficiency)',
        'Pay $250',
        'Situation',
        'The system has suddenly frozen! You didn''t take into account that the log has been increasing quickly and it ran out of memory.',
        250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (45, 1, 'MAIL', 'Se quedó pasmado', '#FF8C69', 'Producto (Eficiencia)',
        'Paga $250',
        'Situación',
        'Sin más, el sistema se congeló, nada reacciona. No tomaste en cuenta que el log crecía demasiado rápido y se acabó la memoria.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_EFFICIENCY', 45);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (46, 0, 'MAIL', 'Database running slowly', '#FF8C69', 'Product (Efficiency)',
        'Pay $300',
        'Situation',
        'You decided to run database queries in plain SQL as stored procedures are not your thing. Now you have been waiting for 45 minutes for a query to be executed.',
        300.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (46, 1, 'MAIL', 'La base de datos no responde', '#FF8C69', 'Producto (Eficiencia)',
        'Paga $300',
        'Situación',
        'Las consultas a la base de datos las decidiste hacer en SQL plano, los procedimientos almacenados no son para ti. Llevas 45 minutos esperando a que termine la ejecución de la consulta.',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_EFFICIENCY', 46);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (47, 0, 'MAIL','Users mobile data is all gone', '#FF8C69', 'Product (Efficiency)',
        'Pay $100',
        'Situation',
        'Your new app for facial recognition processes everything in the server. You did not take into consideration that sending images through mobile data eats up the clients balance',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (47, 1, 'MAIL', 'Se acaban los datos del cliente', '#FF8C69', 'Producto (Eficiencia)',
        'Paga $100',
        'Situación',
        'Tu nueva app de reconocimiento facial procesa todo en el servidor, nunca consideraste que enviar imágenes por la red de datos se acabaría el crédito de tus usuarios.',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_EFFICIENCY', 47);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (48, 0, 'MAIL','Programming language not supported', '#C04000', 'Product (Maintainability)',
        'Pay $100',
        'Situation',
        'The programming language you have chosen to use sped up the development, however it has gone out of trend and is not supported any more.',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (48, 1, 'MAIL', 'El metalenguaje ya no es soportado', '#C04000', 'Producto (Mantenibilidad)',
        'Paga $100',
        'Situación',
        'Decidiste utilizar un metalenguaje que aceleró el desarrollo, sin embargo pasó de moda y ya no tiene soporte.',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_MAINTAINABILITY', 48);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (49, 0, 'MAIL','A better thought on the architecture', '#C04000', 'Product (Maintainability)',
        'Pay $300',
        'Situation',
        'Your architecture design is the same as usual, but now the system cannot scale up to address new functionalities and needs.',
        300.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (49, 1, 'MAIL', 'Debiste pensar mejor la arquitectura', '#C04000', 'Producto (Mantenibilidad)',
        'Paga $300',
        'Situación',
        'Diseñaste siguiendo la arquitectura de siempre, ahora el sistema no puede ser escalado para atender las nuevas necesidades.',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_MAINTAINABILITY', 49);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (50, 0, 'MAIL','Development, testing and production', '#C04000', 'Product (Maintainability)',
        'Receive $200',
        'Situation',
        'Your team is working hard on performing corrective maintenance on a critical function of the system.Luckily, you have three environments and will be able to run some tests before deploying it.',
        200.00, 'IN');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (50, 1, 'MAIL', 'Desarrollo, pruebas y producción', '#C04000', 'Producto (Mantenibilidad)',
        'Recibe $200',
        'Situación',
        'Tu equipo está concentrado en realizar un mantenimiento correctivo a una función crítica del sistema, afortunadamente como cuentas con tres ambientes podrás probarlo antes de subirlo a producción.',
        200.00, 'IN');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_MAINTAINABILITY', 50);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (51, 0, 'MAIL','One of the other, but not both', '#E2062C', 'Product (Portability)',
        'Pay $250',
        'Situation',
        'The library you are using for this painstaking function cannot coexist with the other critically important library on the server. You will not be able to deliver the module in this state.',
        250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (51, 1, 'MAIL', 'Uno u otro pero no los dos', '#E2062C', 'Producto (Portabilidad)',
        'Paga $250',
        'Situación',
        'La biblioteca que utilizas para llevar a cabo esa función que tanto trabajo te costó no puede coexistir en el servidor de aplicaciones con otra biblioteca crítica. Así no podrás liberar tu módulo.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_PORTABILITY', 51);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (52, 0, 'MAIL','All in the README', '#E2062C', 'Product (Portability)',
        'Pay $300',
        'Situation',
        'Installing the system on the new computers is a nightmare for the technical support staff. You left a README with instructions that only you understand. Why haven’t you got a wizard?',
        300.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (52, 1, 'MAIL', 'Todo está en el README', '#E2062C', 'Producto (Portabilidad)',
        'Paga $300',
        'Situación',
        'Instalar tu sistema en las máquinas nuevas es una pesadilla para los de soporte técnico. Dejaste un README con instrucciones que ya sólo tú entiendes, por qué no creaste un wizard?',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_PORTABILITY', 52);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (53, 0, 'MAIL','Virtual Machines', '#E2062C', 'Product (Portability)',
        'Receive $150',
        'Situation',
        'Your team decided to use virtual machines to emulate the precise operation environment of the future system. Delivery and operation ran as smoothly as ever.',
        150.00, 'IN');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (53, 1, 'MAIL', 'Máquinas virtuales', '#E2062C', 'Producto (Portabilidad)',
        'Recibe $150',
        'Situación',
        'Tu equipo decidió utilizar máquinas virtuales emulando de manera precisa el ambiente donde operará el sistema. La liberación y operación fluyeron como nunca.',
        150.00, 'IN');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_PORTABILITY', 53);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (54, 0, 'MAIL','No problems with the old module?', '#FF4500', 'Product (Compatibility)',
        'Pay $100',
        'Situation',
        'The system that you have just delivered cannot communicate with the legacy system of the client. Did any one test compatibility?',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (54, 1, 'MAIL', 'El módulo viejo no causará problemas', '#FF4500', 'Producto (Compatibilidad)',
        'Paga $100',
        'Situación',
        'El sistema que acabas de liberar no se puede comunicar con el módulo legado de tu cliente. Nadie hizo pruebas para verificar la compatibilidad?',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_COMPATIBILITY', 54);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (55, 0, 'MAIL','Retro Compatibility? Not this time!', '#FF4500', 'Product (Compatibility)',
        'Pay $150',
        'Situation',
        'It seemed like no big deal when you worked with the 2019 version during the project, but the rest of the clients system is still under the 2016 version. Now the "old" stuff has stopped working.',
        150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (55, 1, 'MAIL', 'Retro-compatibilidad? No esta vez', '#FF4500', 'Producto (Compatibilidad)',
        'Paga $150',
        'Situación',
        'Parecía no ser grave, trabajaste con la versión 2018 durante todo el proyecto pero el resto de sistemas del cliente siguen corriendo en la 2016. Ahora lo "viejo" no funciona.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_COMPATIBILITY', 55);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (56, 0, 'MAIL','Not only expensive! Its also incompatible!', '#FF4500', 'Product (Compatibility)',
        'Pay $200',
        'Situation',
        'Compatibility of Apple products is always a problem. The library you are using works well with all operating systems, except for this one.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (56, 1, 'MAIL', 'Además de caros, incompatibles', '#FF4500', 'Producto (Compatibilidad)',
        'Paga $200',
        'Situación',
        'La compatibilidad de los productos de Apple siempre es un problema, la biblioteca que utilizaste funciona bien en todos los demás sistemas operativos menos en éste.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_COMPATIBILITY', 56);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (57, 0, 'MAIL','Pirates Aboard', '#FF7518', 'Product (Security)',
        'Pay $250',
        'Situation',
        'Since you have not implemented an SSL, all the client’s information was intercepted and stolen. We are in big trouble now.',
        250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (57, 1, 'MAIL', 'Piratas al abordaje', '#FF7518', 'Producto (Seguridad)',
        'Paga $250',
        'Situación',
        'Como no implementaste un SSL, toda la información de la organización fue interceptada y robada. Estamos en problemas.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_SECURITY', 57);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (58, 0, 'MAIL','Default username and password', '#FF7518', 'Product (Security)',
        'Pay $300',
        'Situation',
        'It didn’t seem important to change default usernames, passwords and ports for the application server and SMBD. Somebody took advantage of your vulnerability and hacked you.',
        300.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (58, 1, 'MAIL', 'Usaste la contraseña y usuario por defecto', '#FF7518', 'Producto (Seguridad)',
        'Paga $300',
        'Situación',
        'No te pareció importante cambiar los usuarios, contraseñas y puertos por defecto del servidor de aplicaciones y del SMBD. Alguien aprovechó tu vulnerabilidad y te ha hackeado.',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_SECURITY', 58);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (59, 0, 'MAIL','A Simple Selfie', '#FF7518', 'Product (Security)',
        'Pay $100',
        'Situation',
        'You took a selfie with your laptop while working and you have not realized that there was your client’s confidential information on the screen background.',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (59, 1, 'MAIL', 'Una selfie', '#FF7518', 'Producto (Seguridad)',
        'Paga $100',
        'Situación',
        'Te tomaste una selfie "aquí trabajando" y no te diste cuenta que en el fondo tu laptop tenía información confidencial del cliente.',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_SECURITY', 59);


-- todo
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (60, 0, 'MAIL','Technologically Agnostic AP', '#2A52BE', 'Process (Planning)',
        'Pay $300',
        'Situation',
        'The face of the team is the AP but ours does not have much technical knowledge and has said yes to some technologically complex requests.',
        300.00, 'OUT');
-- todo
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (60, 1, 'MAIL', 'AP tecnologicamente "agnóstico"', '#2A52BE', 'Proceso (Planeación)',
        'Paga $300',
        'Situación',
        'La cara del equipo es el AP, el nuestro no tiene mucha idea de la parte técnica y ha dicho que sí a peticiones tecnológicamente complejas. Ahora tenemos la soga al cuello.',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_PLANNING', 60);


INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (61, 0, 'MAIL','Resource Management', '#2A52BE', 'Process (Planning)',
        'Pay $150',
        'Situation',
        'The delivery date is planned for tomorrow. Unfortunately your team is not going to make the deadline because you did not allocate your resources properly. ',
        150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (61, 1, 'MAIL', 'Manejo de recursos', '#2A52BE', 'Proceso (Planeación)',
        'Paga $150',
        'Situación',
        'La entrega está planeada para mañana, pero no vamos a llegar, todo por no saber administrar correctamente los recursos del proyecto.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_PLANNING', 61);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (62, 0, 'MAIL','What a good estimate!', '#2A52BE', 'Process (Planning)',
        'Receive $150',
        'Situation',
        'You decide to use Planning Poker" and your teams estimates are much more accurate.',
        150.00, 'IN');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (62, 1, 'MAIL', 'Qué buena estimación', '#2A52BE', 'Proceso (Planeación)',
        'Recibe $150',
        'Situación',
        'Decidiste usar "Planning Poker" y las estimaciones del equipo son mucho más acertadas.',
        150.00, 'IN');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_PLANNING', 62);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (63, 0, 'MAIL','When in Doubt', '#4997D0', 'Process (Requirements)',
        'Pay $250',
        'Situation',
        'You had a question but decided to document the clients requirements without finding the answer. You never imagined that such a "small detail" was so important to the clients business process.',
        250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (63, 1, 'MAIL', 'Te quedaste con la duda', '#4997D0', 'Proceso (Requerimientos)',
        'Paga $250',
        'Situación',
        'Te dio pena preguntar y decidiste documentar los requerimientos sin resolver tus dudas. Nunca imaginaste que un detalle tan "pequeño" fuera tan importante para el proceso de negocio del cliente.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_REQUIREMENTS', 63);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (64, 0, 'MAIL','Stakeholders Identified', '#4997D0', 'Process (Requirements)',
        'Pay $200',
        'Situation',
        'The key stakeholders for identifying customer needs have just been integrated into the project, now it appears that most of what they have worked on is not all that "valuable".',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (64, 1, 'MAIL', 'Stakeholders identificados', '#4997D0', 'Proceso (Requerimientos)',
        'Paga $200',
        'Situación',
        'Los stakeholders clave para identificar las necesidades del cliente se acaban de integrar al proyecto, ahora resulta que la mayor parte de lo que han trabajado no es tan "valiosa".',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_REQUIREMENTS', 64);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (65, 0, 'MAIL','"Get it out fast"', '#4997D0', 'Process (Requirements)',
        'Pay $150',
        'Situation',
        'In an interview with the client about a new requirement, your product analyst did not think before saying that the team will "get it out fast". After analyzing it is much more complicated than expected and will require a lot of work.',
        150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (65, 1, 'MAIL', '"Sale rápido"', '#4997D0', 'Proceso (Requerimientos)',
        'Paga $150',
        'Situación',
        'El nuevo analista se entrevistó con el cliente y sin pensarlo mucho dijo que el requerimiento "salía rápido", después de analizarlo es mucho más complicado y requerirá mucho trabajo.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_REQUIREMENTS', 65);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (66, 0, 'MAIL','The most elegant solution...', '#6495ED', 'Process (Design)',
        'Pay $100',
        'Situation',
        '...is not always the most efficient. The design proposed by the external consultants is too complex for the required solution. You are building a thousand-headed monster.',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (66, 1, 'MAIL', 'La solución más elegante…', '#6495ED', 'Proceso (Diseño)',
        'Paga $100',
        'Situación',
        '…no siempre es la más eficiente. El diseño propuesto por los consultores externos es demasiado complejo para la solución requerida. Estás construyendo un monstruo de mil cabezas.',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_DESIGN', 66);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (67, 0, 'MAIL','Relational would have been enough', '#6495ED', 'Process (Design)',
        'Pay $150',
        'Situation',
        'You fell into the fashion of non-relational databases and proposed to use one even though it was clear that the system would be functional and efficient with a relational database.',
        150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (67, 1, 'MAIL', 'Relacional hubiera sido suficiente', '#6495ED', 'Proceso (Diseño)',
        'Paga $150',
        'Situación',
        'Caíste en la moda de las bases de datos no relacionales y propusiste usar una cuando era claro que el sistema sería funcional y eficiente con una base de datos relacional.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_DESIGN', 67);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (68, 0, 'MAIL','Design emerges over time', '#6495ED', 'Process (Design)',
        'Pay $200',
        'Situation',
        'You believed the Agile principle of "your overall system design will emerge over time, evolving to fulfill new requirements and take advantage of new technologies as appropriate". Too bad this is almost never fulfilled.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (68, 1, 'MAIL', 'El diseño emerge con el tiempo', '#6495ED', 'Proceso (Diseño)',
        'Paga $200',
        'Situación',
        'Te creiste el principio ágil de "Your overall system design will emerge over time, evolving to fulfill new requirements and take advantage of new technologies as appropriate", lástima que no se cumple casi nunca.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_DESIGN', 68);
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (69, 0, 'MAIL','No one knows the language', '#DF73FF', 'Process (Construction)',
        'Pay $250',
        'Situation',
        'No one on your team is a master of the programming language requested by the client. The learning curve will be long.',
        250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (69, 1, 'MAIL', 'No conoces el lenguaje de programación', '#DF73FF', 'Proceso (Construcción)',
        'Paga $250',
        'Situación',
        'El lenguaje de programación solicitado por el cliente no lo dominas, la curva de aprendizaje será larga.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CONSTRUCTION', 69);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (70, 0, 'MAIL','Different Environments', '#DF73FF', 'Process (Construction)',
        'Pay $200',
        'Situation',
        'Its the same technology but not the same version so the development environments do not match. Thats why what is working on your machine is not working on anyone elses.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (70, 1, 'MAIL', 'Ambientes diferentes', '#DF73FF', 'Proceso (Construcción)',
        'Paga $200',
        'Situación',
        'Era la misma tecnología pero no la misma versión, los ambientes de desarrollo no coinciden. Lo que funciona en tu máquina no funciona en la de nadie más.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CONSTRUCTION', 70);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (71, 0, 'MAIL','Peer Programming', '#DF73FF', 'Process (Construction)',
        'Receive $150',
        'Situation',
        'You applied the peer programming technique. In addition to learning a lot from your colleagues, you are also now more familiar with other modules.',
        150.00, 'IN');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (71, 1, 'MAIL', 'Programación entre pares', '#DF73FF', 'Proceso (Construcción)',
        'Recibe $150',
        'Situación',
        'Aplicaste la técnica de programación entre pares, además de que aprendiste mucho de tu colega, ahora estás más familiarizado con otros módulos.',
        150.00, 'IN');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CONSTRUCTION', 71);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (72, 0, 'MAIL','Different Versions', '#20B2AA', 'Process (Integration)',
        'Pay $200',
        'Situation',
        'Your colleague developed an entire module using a different version than yours. It is not possible to integrate for the work for this week.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (72, 1, 'MAIL', 'Diferentes versiones', '#20B2AA', 'Proceso (Integración)',
        'Paga $200',
        'Situación',
        'Tu colega desarrolló todo el módulo utilizando una versión diferente a la tuya, no es posible integrar el trabajo de la semana.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_INTEGRATION', 72);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (73, 0, 'MAIL','Merge Conflicts', '#20B2AA', 'Process (Integration)',
        'Pay $200',
        'Situation',
        'Your team waited too long to merge and now there are so many conflicts that it is impossible to merge all of the branches.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (73, 1, 'MAIL', 'Conflictos en el merge', '#20B2AA', 'Proceso (Integración)',
        'Paga $200',
        'Situación',
        'El equipo y tú esperaron demasiado y ahora hay tantos conflictos que nos es posible completar el merge de sus branches.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_INTEGRATION', 73);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (74, 0, 'MAIL','Continuous Integration', '#20B2AA', 'Process (Integration)',
        'Receive $200',
        'Situation',
        'Although it was painful at first, having lifted the continuous integration server has accelerated the builds and made the releases more frequent.',
        200.00, 'IN');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (74, 1, 'MAIL', 'Integración continua', '#20B2AA', 'Proceso (Integración)',
        'Recibe $200',
        'Situación',
        'Si bien fue doloroso al principio, el haber levantado el servidor de integración continua ha acelerado los builds y hecho más frecuentes las liberaciones.',
        200.00, 'IN');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_INTEGRATION', 74);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (75, 0, 'MAIL','Testing is the "last" phase', '#96DED1', 'Process (Testing)',
        'Pay $250',
        'Situation',
        'You thought you could leave the testing until the end of the process. Now you do not have any time left to test properly and the defects have slipped passed.',
        250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (75, 1, 'MAIL', 'Pruebas es la "última" fase', '#96DED1', 'Proceso (Pruebas)',
        'Paga $250',
        'Situación',
        'Creiste que probar lo podías hacer hasta el final del proceso, ahora no tienes tiempo para probar adecuadamente y los defectos se fugaron.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_TESTING', 75);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (76, 0, 'MAIL','Oh no, a bug!', '#96DED1', 'Process (Testing)',
        'Pay $300',
        'Situation',
        'A bug discovered at the last moment prevents the system from being released.',
        300.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (76, 1, 'MAIL', 'Oh no, un "bug"!', '#96DED1', 'Proceso (Pruebas)',
        'Paga $300',
        'Situación',
        'Un bug descubierto en el último momento impide que se pueda liberar el sistema.',
        300.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_TESTING', 76);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (77, 0, 'MAIL','Automated Testing', '#96DED1', 'Process (Testing)',
        'Receive $150',
        'Situation',
        'You invested a lot of effort into automating unit tests. Now you are rewarded by being able to execute all the test cases of your module with just a click.',
        150.00, 'IN');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (77, 1, 'MAIL', 'Pruebas automatizadas', '#96DED1', 'Proceso (Pruebas)',
        'Paga $150',
        'Situación',
        'Invertiste más esfuerzo en automatizar las pruebas unitarias, ahora llegó la recompensa cuando con un click puedes ejecutar todos los casos de prueba de tu módulo.',
        150.00, 'IN');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_TESTING', 77);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (78, 0, 'MAIL','Where is that email?', '#73C2FB', 'Process (Monitoring)',
        'Pay $200',
        'Situation',
        'You are sure that your colleague sent you a description of a bug that needs to be fixed, however you can not find anything in your notes or emails.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (78, 1, 'MAIL', 'En dónde está ese correo?', '#73C2FB', 'Proceso (Seguimiento)',
        'Paga $200',
        'Situación',
        'Estás seguro que tu colega te envió la descripción de ese bug que debes corregir, sin embargo no puedes encontrarlo ni en tu correo ni en tus notas.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_MONITORING', 78);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (79, 0, 'MAIL','Reporting our activities', '#73C2FB', 'Process (Monitoring)',
        'Pay $100',
        'Situation',
        'The board where each team member reports their activities has not been updated in weeks and nobody knows how we are doing.',
        100.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (79, 1, 'MAIL', 'Reportando nuestras actividades', '#73C2FB', 'Proceso (Seguimiento)',
        'Paga $100',
        'Situación',
        'El trablero de control donde cada integrante del equipo reporta sus actividades no se ha actualizado en semanas, ya nadie sabe cómo vamos.',
        100.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_MONITORING', 79);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (80, 0, 'MAIL','Meeting after meeting and still nothing', '#73C2FB', 'Process (Monitoring)',
        'Pay $250',
        'Situation',
        'As a result of this weeks meeting, everyone agrees to convene for another urgent meeting to decide if we are having productive meetings.',
        250.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (80, 1, 'MAIL', 'Junta tras junta y nada', '#73C2FB', 'Proceso (Seguimiento)',
        'Paga $250',
        'Situación',
        'Como resultado de la junta de esta semana, acuerdan convocar otra junta urgente para decidir si las juntas están siendo productivas.',
        250.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_MONITORING', 80);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (81, 0, 'MAIL','Releasing does not mean operating', '#E0B0FF', 'Process (Closure)',
        'Pay $200',
        'Situation',
        'The day has come and it is finally time to release the system! Unfortunately the client believed releasing meant that his employees could already use the system.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (81, 1, 'MAIL', 'Liberar no implica operar', '#E0B0FF', 'Proceso (Cierre)',
        'Paga $200',
        'Situación',
        'Llegó el día, liberaste el sistema! El problema es que el cliente entendió que liberar significaba que ya todos sus empleados podrían usar el sistema.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CLOSURE', 81);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (82, 0, 'MAIL','Change is complicated', '#E0B0FF', 'Process (Closure)',
        'Pay $200',
        'Situation',
        'Resistance to change is always a complicated obstacle. If you had integrated the end users of the system earlier, maybe they would not be complaining so much about the new system.',
        200.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (82, 1, 'MAIL', 'Cambiar es complicado', '#E0B0FF', 'Proceso (Cierre)',
        'Paga $200',
        'Situación',
        'La resistencia al cambio es siempre un obstáculo complicado. Si hubieras integrado a los usuarios finales del sistema antes, tal vez hoy no se quejarían tanto del nuevo sistema.',
        200.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CLOSURE', 82);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (83, 0, 'MAIL','We are at 95%', '#E0B0FF', 'Process (Closure)',
        'Pay $150',
        'Situation',
        'When asked "what is the progress of the project?" we respond that we are at 95%. What does that mean? No body knows for sure, but we have responded the same way for the past two months.',
        150.00, 'OUT');
INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (83, 1, 'MAIL', 'Estamos al 95%', '#E0B0FF', 'Proceso (Cierre)',
        'Paga $150',
        'Situación',
        'Al preguntarnos cuál es el avance del proyecto respondemos que estamos al 95%. Qué significa eso? Nadie lo sabe con certeza, pero hemos respondido lo mismo los últimos dos meses.',
        150.00, 'OUT');
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CLOSURE', 83);


INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (84, 0, 'OPPORTUNITY', 'PMP Certification', '#D3D3D3',
        'Opportunity for Improvement',
        'Cost: $500',
        'Effect',
        'Upon certification you have discovered that not only is the scope, time and cost of the project important. Now you are able to integrate elements of human resources, communication, acquisitions, risks, quality and stakeholders, achieving a complete vision of your project.' ||
        'Cancel all the risks of "Planning" and "Environment".',
        500.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (84, 1, 'OPPORTUNITY', 'Certificación PMP', '#D3D3D3',
        'Oportunidad de Mejora',
        'Costo: 500',
        'Efecto',
        'Al certificarte has descubierto que no sólo es importante el alcance, tiempo y costo del proyecto. Ahora eres capaz de integrar elementos de recursos humanos, comunicación, adquisiciones, riesgos, calidad y stakeholders, logrando una visión completa de tu proyecto.' ||
        'Cancela todos los riesgos de "Planeación" y "Entorno".',
        500.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_PLANNING', 84);
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_ENVIRONMENT', 84);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (85, 0, 'OPPORTUNITY', 'User Stories', '#D3D3D3',
        'Opportunity for Improvement',
        'Cost: $350',
        'Effect',
        'Documenting the requirements through user stories allows the team to understand customer needs and focus on what is valuable for the business.' ||
        'It cancels all the risks of "Requirements" and "Functionality".',
        350.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (85, 1, 'OPPORTUNITY', 'Historias de Usuario', '#D3D3D3',
        'Oportunidad de Mejora',
        'Costo: 350',
        'Efecto',
        'Documentar los requerimientos a través de historias de usuario permite al equipo entender las necesidades del cliente y enfocarse en lo que es valioso para el negocio.' ||
        'Cancela todos los riesgos de "Requerimientos" y "Funcionalidad".',
        350.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_REQUIREMENTS', 85);
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_FUNCTIONALITY', 85);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (86, 0, 'OPPORTUNITY', 'Development framework', '#964B00',
        'Opportunity for Improvement',
        'Cost: $300',
        'Effect',
        'The use of a development framework has increased the speed of the equipment, facilitates following the chosen architectural pattern and reduces the configuration effort.' ||
        'It cancels all the risks of "Design" and "Maintainability".',
        300.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (86, 1, 'OPPORTUNITY', 'Framework de desarrollo', '#964B00',
        'Oportunidad de Mejora',
        'Costo: 300',
        'Efecto',
        'El uso de un framework de desarrollo ha incrementado la velocidad del equipo, facilita seguir el patrón arquitectónico elegido y reduce el esfuerzo de configuración.' ||
        'Cancela todos los riesgos de "Diseño" y "Mantenibilidad".',
        300.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_DESIGN', 86);
INSERT INTO card_category(category, card_id)
VALUES ('PRODUCT_MAINTAINABILITY', 86);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (87, 0, 'OPPORTUNITY', 'Repository with version control system', '#964B00',
        'Opportunity for Improvement',
        'Cost: $300',
        'Effect',
        'The version control system has turned out to be wonderful, you don''t waste time looking for files, downloading libraries or worrying about the latest version of the code.' ||
        'It cancels all the risks of "Construction" and "Integration".',
        300.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (87, 1, 'OPPORTUNITY', 'Repositorio con sistema de control de versiones', '#964B00',
        'Oportunidad de Mejora',
        'Costo: 300',
        'Efecto',
        'El sistema de control de versiones ha resultado ser una maravilla, no pierdes el tiempo buscando archivos, descargando bibliotecas ni preocupado por cuál será la última versión del código.' ||
        'Cancela todos los riesgos de "Construcción" e "Integración".',
        300.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CONSTRUCTION', 87);
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_INTEGRATION', 87);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (88, 0, 'OPPORTUNITY', 'Integration and continuous deployment system', '#FFC0CB',
        'Opportunity for Improvement',
        'Cost: $300',
        'Effect',
        'With the continuous integration system they installed, now integrating the code and deploying the system is much faster and requires less effort.' ||
        'It cancels all the risks of "Integration" and "Testing".',
        300.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (88, 1, 'OPPORTUNITY', 'Sistema de intregración y despliegue continuo', '#FFC0CB',
        'Oportunidad de Mejora',
        'Costo: 300',
        'Efecto',
        'Con el sistema de integración continua que instalaron, ahora integrar el código y desplegar el sistema es mucho más rápido y requiere menos esfuerzo.' ||
        'Cancela todos los riesgos de "Integración" y "Pruebas".',
        300.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CONSTRUCTION', 88);
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_TESTING', 88);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (89, 0, 'OPPORTUNITY', 'Bug tracker', '#FFC0CB',
        'Opportunity for Improvement',
        'Cost: $350',
        'Effect',
        'The bug tracker that they installed has allowed them to keep an adequate control of all the defects found during the tests and assign them to the programmers for their attention. Nothing overlaps.' ||
        'It cancels all the risks of "Testing" and "Construction."',
        350.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (89, 1, 'OPPORTUNITY', 'Sistema de intregración y despliegue continuo', '#FFC0CB',
        'Oportunidad de Mejora',
        'Costo: 350',
        'Efecto',
        'El bug tracker que instalaron les ha permitido llevar un control adecuado de todos los defectos encontrados durante las pruebas y asignarlos a los programadores para su atención. Nada se traspapela.' ||
        'Cancela todos los riesgos de "Pruebas" y "Construcción".',
        350.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CONSTRUCTION', 89);
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_TESTING', 89);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (90, 0, 'OPPORTUNITY', 'Activities outside of work', '#BFFF00',
        'Opportunity for Improvement',
        'Cost: $550',
        'Effect',
        'Going to the gym at the end of the day or playing basketball on Thursdays with your work colleagues has improved coexistence, creating a healthier and closer work environment.' ||
        'It cancels all the risks of "Monitoring" and "Collaboration."',
        550.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (90, 1, 'OPPORTUNITY', 'Actividades fuera del trabajo', '#BFFF00',
        'Oportunidad de Mejora',
        'Costo: 550',
        'Efecto',
        'Ir al gimnasio al final del día o jugar basquetbol los jueves con tus colegas del trabajo ha mejorado la convivencia, generando un ambiente de trabajo más sano y cercano.' ||
        'Cancela todos los riesgos de "Seguimiento" y "Colaboración".',
        550.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COLLABORATION', 90);
INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_MONITORING', 90);

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (91, 0, 'OPPORTUNITY', 'Frequent releases', '#BFFF00',
        'Opportunity for Improvement',
        'Cost: $550',
        'Effect',
        'By segmenting the system into modules with low coupling and high cohesion, the device is able to release functional software more frequently. With this, the client can test it and provide feedback to the team, avoiding rework.' ||
        'It cancels all the risks of "Closure" and "Communication".',
        550.00, 'OUT');

INSERT INTO card (cardId, langId, card_type, title, color, category_description, action, sub_title, description, cost, flow_direction)
VALUES (91, 1, 'OPPORTUNITY', 'Liberaciones frecuentes', '#BFFF00',
        'Oportunidad de Mejora',
        'Costo: 550',
        'Efecto',
        'Al segmentar el sistema en módulos con bajo acomplamiento y alta cohesión, el equipo es capaz de liberar software funcional de manera más frecuente. Con ello el cliente puede probarlo y retroalimentar al equipo, evitando retrabajo.' ||
        'Cancela todos los riesgos de "Cierre" y "Comunicación".',
        550.00, 'OUT');

INSERT INTO card_category(category, card_id)
VALUES ('PROCESS_CLOSURE', 91);
INSERT INTO card_category(category, card_id)
VALUES ('PEOPLE_COMMUNICATION', 91);