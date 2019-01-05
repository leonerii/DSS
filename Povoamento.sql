use BuildMovil;

insert into Componente values
("Motor: 110CV 3.0",1,50,1555.0,14),
("Motor: 100CV 2.0",2,80,1655,14),
("Motor: 130CV 3.5",3,85,1855,14),
("Motor: 160CV 3.0",4,80,2055,14),
("Motor: 190CV 2.0",5,90,2255,14),
("Motor: 300CV 3.0",6,65,2455,14),
("Jante: 17",7,50,800,14),
("Jante: 19",8,80,900,14),
("Jante: 15",9,85,1100,14),
("Jante: 17 ultra",10,80,1300,14),
("Jante: 19 spin",11,90,1500,14),
("Assento: Pele tigre",12,50,800,14),
("Assento: Napa",13,80,900,14),
("Assento: Soft",14,85,1100,14),
("Assento: Desdobrável",15,80,1300,14),
("Assento: Aquecido",16,90,1500,14),
("Espelhos: Desembaciador",17,50,600,14),
("Espelhos: Luzes",18,80,700,14),
("Espelhos: Limpa espelhos",19,85,900,14),
("Espelhos: Revertiveis",20,80,1100,14),
("Peneu: 17",21,50,800,14),
("Peneu: 19",22,80,900,14),
("Peneu: 15",23,85,1100,14),
("Peneu: 17 ultra",24,80,1300,14),
("Peneu: 19 spin",25,90,1500,14),
("Peneu: slik",26,65,1700,14),
("Cor: Preto",33,50,800,14),
("Cor: Azul",34,80,900,14),
("Cor: Vermelho",35,85,1100,14),
("Cor: Verde",36,80,1300,14),
("Cor: Cinzento metalizado",37,90,1500,14),
("Cor: Branco",38,65,1700,14),
("Mudanças:  Atumáticas",27,50,800,14),
("Mudanças:  Sequenciais",28,80,900,14),
("Mudanças: Manuais",29,85,1100,14),
("Mudanças: Autmáticas e Sequenciais",30,80,1300,14);


insert into Cliente (nome,nif,morada) values
("Antonio","11111111","Andar de cima"),
("Manuel","222222222","Andar de cima"),
("Antonio","333333333","Andar de cima");


insert into Utilizador values
("stock","aa","aa","José"),
("comercial","bb","bb","Amadeu"),
("admin","cc","cc","Meireles");


insert into Pacote values
("Sport",19465,1),
("Confort",18888,2);


insert into Incompativel values
(1,2),
(1,3),
(1,4),
(1,5),
(1,6),
(1,12),
(1,19),
(1,24),
(2,1),
(2,3),
(2,4),
(2,5),
(2,6),
(2,10),
(2,16),
(2,26),
(4,1),
(4,3),
(4,2),
(4,5),
(4,6),
(4,23),
(4,26),
(4,17),
(3,1),
(3,2),
(3,4),
(3,5),
(3,6),
(3,20),
(3,14),
(3,15),
(5,1),
(5,3),
(5,2),
(5,5),
(5,6),
(5,4);

insert into Dependente values

(1,7),
(1,18),
(1,27),
(2,8),
(2,19),
(2,25),
(3,29),
(3,16),
(3,12);

insert into Pacote_Componente values

(1,1),
(18,1),
(27,1),
(12,1),
(8,1),
(2,2),
(7,2),
(12,2),
(19,2),
(25,2);


insert into Pedido values
("novo",null,null,1,18888,"222222222",1);


insert into Pedido_Componente values
(2,1),
(7,1),
(12,1),
(19,1),
(25,1);
