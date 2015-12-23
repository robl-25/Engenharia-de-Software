
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema sussa_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sussa_db` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `sussa_db` ;

-- -----------------------------------------------------
-- Table `sussa_db`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Usuario` (
  `idUsuario` INT NOT NULL COMMENT '',
  `nomeUsuario` VARCHAR(45) NULL COMMENT '',
  `idSenha` VARCHAR(45) NOT NULL COMMENT '',
  `tipoUsuario` INT NULL DEFAULT 2 COMMENT 'tipo 1 administrador, tipo 2 aluno',
  PRIMARY KEY (`idUsuario`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`NotasProfessor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`NotasProfessor` (
  `idNotasProfessor` INT NOT NULL COMMENT '',
  `notaDidatica` INT NULL DEFAULT 0 COMMENT '',
  `notaCoerênciaAulaProva` INT NULL DEFAULT 0 COMMENT '',
  `notaDominioAssunto` INT NULL DEFAULT 0 COMMENT '',
  `notaAuxilioPosAula` INT NULL DEFAULT 0 COMMENT '',
  PRIMARY KEY (`idNotasProfessor`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Professor` (
  `idProfessor` INT NOT NULL COMMENT '',
  `nomeProfessor` VARCHAR(45) NULL COMMENT '',
  `notaMediaProfessor` INT NULL COMMENT '',
  `NotasProfessor_idNotasProfessor` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idProfessor`, `NotasProfessor_idNotasProfessor`)  COMMENT '',
  INDEX `fk_Professor_NotasProfessor1_idx` (`NotasProfessor_idNotasProfessor` ASC)  COMMENT '',
  CONSTRAINT `fk_Professor_NotasProfessor1`
    FOREIGN KEY (`NotasProfessor_idNotasProfessor`)
    REFERENCES `sussa_db`.`NotasProfessor` (`idNotasProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Ementa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Ementa` (
  `idEmenta` INT NOT NULL COMMENT '',
  `descricaoEmenta` VARCHAR(450) NULL DEFAULT '' COMMENT '',
  PRIMARY KEY (`idEmenta`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Disciplina` (

  `idDisciplina` INT NOT NULL COMMENT '',
  `nomeDisciplina` VARCHAR (100) NOT NULL COMMENT '',
  `idEmenta` INT NULL COMMENT '',
  `cargaHorariaDisciplina` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idDisciplina`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Matriz`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Matriz` (
  `idMatriz` INT NOT NULL COMMENT '',
  `nomeMatriz` varchar (45) NOT NULL COMMENT '',
  PRIMARY KEY (`idMatriz`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Curso` (
  `idCurso` INT NOT NULL COMMENT '',
  `nomeCurso` VARCHAR(45) NULL COMMENT '',
  `Matriz_idMatriz` INT NOT NULL COMMENT '',
  `cargaHorariaTotal` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idCurso`)  COMMENT '',
  INDEX `fk_Curso_Matriz1_idx` (`Matriz_idMatriz` ASC)  COMMENT '',
  CONSTRAINT `fk_Curso_Matriz1`
    FOREIGN KEY (`Matriz_idMatriz`)
    REFERENCES `sussa_db`.`Matriz` (`idMatriz`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Aluno` (
  `idAluno` INT NOT NULL COMMENT '',
  `nomeAluno` VARCHAR(45) NULL COMMENT '',
  `raAluno` INT NOT NULL COMMENT '',
  `emailAluno` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`idAluno`)  COMMENT '',
  CONSTRAINT `idAluno`
    FOREIGN KEY (`idAluno`)
    REFERENCES `sussa_db`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Arquivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Arquivo` (
  `idArquivo` INT NOT NULL COMMENT '',
  `nomeArquivo` VARCHAR(45) NOT NULL COMMENT '',
  `linkArquivo` VARCHAR(450) NULL COMMENT '',
  `Aluno_idAluno` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idArquivo`)  COMMENT '',
  INDEX `fk_Arquivo_Aluno1_idx` (`Aluno_idAluno` ASC)  COMMENT '',
  CONSTRAINT `fk_Arquivo_Aluno1`
    FOREIGN KEY (`Aluno_idAluno`)
    REFERENCES `sussa_db`.`Aluno` (`idAluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Administrador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Administrador` (
  `idAdministrador` INT NOT NULL COMMENT '',
  PRIMARY KEY (`idAdministrador`)  COMMENT '',
  CONSTRAINT `idAdministrador`
    FOREIGN KEY (`idAdministrador`)
    REFERENCES `sussa_db`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Aluno_has_Curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Aluno_has_Curso` (
  `Aluno_idAluno` INT NOT NULL COMMENT '',
  `Curso_idCurso` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Aluno_idAluno`, `Curso_idCurso`)  COMMENT '',
  INDEX `fk_Aluno_has_Curso_Curso1_idx` (`Curso_idCurso` ASC)  COMMENT '',
  INDEX `fk_Aluno_has_Curso_Aluno1_idx` (`Aluno_idAluno` ASC)  COMMENT '',
  CONSTRAINT `fk_Aluno_has_Curso_Aluno1`
    FOREIGN KEY (`Aluno_idAluno`)
    REFERENCES `sussa_db`.`Aluno` (`idAluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_Curso_Curso1`
    FOREIGN KEY (`Curso_idCurso`)
    REFERENCES `sussa_db`.`Curso` (`idCurso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Matriz_has_Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Matriz_has_Disciplina` (
  `Matriz_idMatriz` INT NOT NULL COMMENT '',
  `Disciplina_idDisciplina` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Matriz_idMatriz`, `Disciplina_idDisciplina`)  COMMENT '',
  INDEX `fk_Matriz_has_Disciplina_Disciplina1_idx` (`Disciplina_idDisciplina` ASC)  COMMENT '',
  INDEX `fk_Matriz_has_Disciplina_Matriz1_idx` (`Matriz_idMatriz` ASC)  COMMENT '',
  CONSTRAINT `fk_Matriz_has_Disciplina_Matriz1`
    FOREIGN KEY (`Matriz_idMatriz`)
    REFERENCES `sussa_db`.`Matriz` (`idMatriz`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Matriz_has_Disciplina_Disciplina1`
    FOREIGN KEY (`Disciplina_idDisciplina`)
    REFERENCES `sussa_db`.`Disciplina` (`idDisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Professor_has_Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Professor_has_Disciplina` (
  `Professor_idProfessor` INT NOT NULL COMMENT '',
  `Disciplina_idDisciplina` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Professor_idProfessor`, `Disciplina_idDisciplina`)  COMMENT '',
  INDEX `fk_Professor_has_Disciplina_Disciplina1_idx` (`Disciplina_idDisciplina` ASC)  COMMENT '',
  INDEX `fk_Professor_has_Disciplina_Professor1_idx` (`Professor_idProfessor` ASC)  COMMENT '',
  CONSTRAINT `fk_Professor_has_Disciplina_Professor1`
    FOREIGN KEY (`Professor_idProfessor`)
    REFERENCES `sussa_db`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Professor_has_Disciplina_Disciplina1`
    FOREIGN KEY (`Disciplina_idDisciplina`)
    REFERENCES `sussa_db`.`Disciplina` (`idDisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sussa_db`.`Aluno_has_Professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sussa_db`.`Aluno_has_Professor` (
  `Aluno_idAluno` INT NOT NULL COMMENT '',
  `Professor_idProfessor` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Aluno_idAluno`, `Professor_idProfessor`)  COMMENT '',
  INDEX `fk_Aluno_has_Professor_Professor1_idx` (`Professor_idProfessor` ASC)  COMMENT '',
  INDEX `fk_Aluno_has_Professor_Aluno1_idx` (`Aluno_idAluno` ASC)  COMMENT '',
  CONSTRAINT `fk_Aluno_has_Professor_Aluno1`
    FOREIGN KEY (`Aluno_idAluno`)
    REFERENCES `sussa_db`.`Aluno` (`idAluno`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aluno_has_Professor_Professor1`
    FOREIGN KEY (`Professor_idProfessor`)
    REFERENCES `sussa_db`.`Professor` (`idProfessor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;



INSERT usuario (idUsuario, nomeUsuario, idSenha, tipoUsuario)
values (1,"Jonathan J. Suenaga ", "senhaadmin01", 1),
(2,"Ellen Borges", "senhaadmin02", 1),
(3,"Juliana de Paula Nader  ", "senhaadmin03", 1),
(4,"Mariane Coelho Robl", "senhaadmin04", 1);


INSERT INTO Administrador (idAdministrador)
values (1),
		(2),
		(3),
        (4);
        
INSERT INTO notasprofessor (idNotasProfessor)
values (1),
		(2),
		(3),
        (4),
        (5),
        (6),
        (7),
        (8),
        (9),
        (10),
		(11),
		(12),
		(13),
        (14),
        (15),
        (16),
        (17),
		(18),
        (19),
		(20),
		(21),
        (22),
		(23),
		(24),
        (25),
        (26),
		(27),
		(28),
        (29),
		(30),
		(31),
		(32),
        (33),
		(34),		
        (35),
		(36),
        (37),
		(38),
		(39),
		(40),
        (41),
		(42),
		(43),
		(44),
        (45),
		(46),
		(47),
		(48),
        (49),
		(50),
		(51),
		(52),
        (53),
		(54),
        (55),
		(56),
        (57),
		(58),
		(59),
		(60),
        (61),
		(62),
		(63),
		(64),
        (65),
		(66),
        (67),
		(68),
        (69),
		(70),
		(71),
		(72),
        (73),
		(74),
        (75),
		(76),
        (77),
		(78),
		(79),
		(80),
        (81),
		(82),        
		(83),
		(84),
        (85),
     /* professores visitantes nacional sênio */	   
		(86),
        (87),
		(88),
        (89);

INSERT INTO professor (idProfessor, nomeProfessor, notaMediaProfessor, NotasProfessor_idNotasProfessor)
  /* professores titular */	
values (1, "Horacio Hideki Yanasse", 0 ,1),
  /* professores adunto */	
		(2,"Adenauer Girardi Casali", 0 ,2),
		(3,"Álvaro Luiz Fazenda", 0 ,3),
        (4, "Aline Capella de Oliveira", 0 ,4),
        (5,"Ana Carolina Lorena", 0 ,5),
        (6," Ana Luísa Dine Martins Lemos", 0 ,6),
        (7, "Ana Paula Lemes", 0 ,7),
        (8,"Anderson Garbuglio de Oliveira", 0 ,8),
        (9,"André Zelanis", 0 ,9),
        (10, "Angelo Calil Bianchi", 0,10),
		(11, "Antonio Augusto Chaves", 0,11),
		(12, "Arlindo Flavio da Conceição", 0,12),
		(13, "Camila Bertini Martins", 0,13),
        (14, "Claudio Saburo Shida", 0,14),
        (15, "Daniela Leal Musa", 0,15),
        (16, "Danieli A. P. Reis", 0,16),
        (17, "Dayane Batista Tada", 0,17),
		(18, "Denise Stringhini", 0,18),
        (19, "Dilermando Nagle Travessa", 0,19),
		(20, "Eduardo Antonelli", 0,20),
		(21, "Eduardo Quinteiro", 0,21),
        (22, "Eliandra de Sousa Trichês", 0,22),
		(23, "Elisa Esposito", 0,23),
		(24, "Elizangela Camilo", 0,24),
        (25, "Erwin Doescher", 0,25),
        (26, "Eudes Eterno Fileti", 0,26),
		(27, "Ezequiel Roberto Zorzal", 0,27),
		(28, "Fábio Augusto Menocci Cappabianco", 0,28),
        (29, "Fábio Fagundes Silveira", 0,29),
		(30, "Fábio Roberto Passador", 0,30),
		(31, "Fabiano C. Paixão", 0,31),
		(32, "Fernando Henrique Cristovan", 0,32),
        (33, "Flávia Cristina Martins Queiroz Mariano", 0,33),
		(34, "Flávio Aimbire Soares de Carvalho", 0,34),		
        (35, "Gisele Ferreira de Lima", 0,35),
		(36, "Grasiele Cristiane Jorge", 0,36),
        (37, "Henrique Alves de Amorim", 0,37),
		(38, "Jaime Shinsuke Ide", 0,38),
		(39, "Jean Faber Ferreira de Abreu", 0,39),
		(40, "Juliana Garcia Cespedes", 0,40),
        (41, "Jurandy Gomes de Almeida Junior", 0,41),
		(42, "Karina Rabello Casali", 0,42),
		(43, "Katia da Conceição", 0,43),
		(44, "Katia Regina Cardoso", 0,44),
        (45, "Lilia Müller Guerrini", 0,45),
		(46, "Luciana Ferreira da Silva", 0,46),
		(47, "Luciane Portas Capelo", 0,47),
		(48, "Luis Felipe Cesar da Rocha Bueno", 0,48),
        (49, "Luiz Eduardo Galvão Martins", 0,49),
		(50, "Luiz Leduíno de Salles Neto", 0,50),
		(51, "Manuel Henrique Lente", 0,51),
		(52, "Marcelo Cristino Gama", 0,52),
        (53, "Márcio Basgalupp", 0,53),
		(54, "Marli Leite de Moraes", 0,54),
        (55, "Marcos Gonçalves Quiles", 0,55),
		(56, "Mariá Cristina Vasconcelos Nascimento", 0,56),
        (57, "Maria Elizete Kunkel", 0,57),
		(58, "Mariana Motisuke", 0,58),
		(59, "Marina Oliveira de Souza Dias", 0,59),
		(60, "Matheus Cardoso Moraes", 0,60),
        (61, "Martin Rodrigo Alejandro Wurtele Alfonso", 0,61),
		(62, "Maurício Pinheiro de Oliveira", 0,62),
		(63, "Otavio Augusto Lazzarini Lemos", 0,63),
		(64, "Pedro Levit Kaufmann", 0,64),
        (65, "Regiane Albertini de Carvalho", 0,65),
		(66, "Regina Célia Coelho", 0,66),
        (67, "Reginaldo Massanobu Kuroshu", 0,67),
		(68, "Renato Alessandro Martins", 0,68),
        (69, "Renato Cesar Sato", 0,69),
		(70, "Robson Silva", 0,70),
		(71, "Rossano Lang", 0,71),
		(72, "Silvia Lucia Cuffini", 0,72),
        (73, "Silvio Eduardo Duailibi", 0,73),
		(74, "Tatiana Sousa Cunha", 0,74),
        (75, "Thaciana Valentina Malaspina Fileti", 0,75),
		(76, "Tiago de Oliveira", 0,76),
        (77, "Tiago Rodrigues Macedo", 0,77),
		(78, "Tiago Silva da Silva", 0,78),
		(79, "Thiago Castilho de Mello", 0,79),
		(80, "Thiago Martini Pereira", 0,80),
        (81, "Valerio Rosset", 0,81),
		(82, "Vanessa Gonçalves Paschoa Ferraz", 0,82),        
		(83, "Vanessa Andrade Pereira", 0,83),
		(84, "Vinícius Veloso de Melo", 0,84),
        (85, "Valerio Rosset", 0,85),
     /* professores visitantes nacional sênio */	   
		(86, "Marcos Massi", 0,86),
        (87, "Mirabel Cerqueira Rezende", 0,87),
		(88, "Francisco Gorgonio da Nóbrega", 0,88),
        (89, "Rodolpho Vilhena de Moraes", 0,89);
        
INSERT INTO ementa (idEmenta)
values (1),
		(2),
		(3),
        (4),
        (5),
        (6),
        (7),
        (8),
        (9),
        (10),
		(11),
		(12),
		(13),
        (14),
        (15),
        (16),
        (17),
		(18),
        (19),
		(20),
		(21),
        (22),
		(23),
		(24),
        (25),
        (26),
		(27),
		(28),
        (29),
		(30),
		(31),
		(32),
        (33),
		(34),		
        (35);
        
INSERT INTO disciplina (idDisciplina,nomeDisciplina, idEmenta, cargaHorariaDisciplina)

/* BCT obrigatórias*/	
values (1, "Logica de programação", 1,72),
		(2,"Lógica de programação", 2,108),
		(3, "Química Geral", 3,72),
        (4, "Cálculo em uma variável" , 4, 108),
        (5, "Cálculo em uma variável",5,72),
        (6, "Ciência, Tecnologia e Sociedade", 6,36),
        (7,"Fundamentos da Biologia", 7, 72),
        (8,"Fênomenos Mecânicos",8,72),
        (9,"Ciência,Tecnologia, Sociedade e Meio Ambiente",9,36),	
/* BCC obrigatorias*/
        (10,"Algoritmos e Estrutura de Dados I", 10,72),
        (11,"Geometria Analítica", 11,72),
        (12,"Matemática Discreta",12,72),
        (13,"Séries e Equações Diferenciais Ordinárias",13,72),
        
        (14, "Algoritmo e Estrutura de Dados II", 14,72),
        (15, "Circuitos Digitais", 15,72),
        (16,"Probabilidade e Estatística",16,72),
        (17,"Cálculo em Várias Variáveis",17,72),
        (18,"Álgebra Linear",18,72),
        (19,"Arquitetura e Organização de Computadores", 19,72),
        (20,"Banco de Dados",20,72),
        (21,"Projeto e Análise de Algoritmos", 21,72),
        (22,"Programação Orientada a Objetos",22,72),
        (23,"Cálculo Numérico", 23,72),
        (24,"Sistemas Operacionais",24,72),
        (25,"Linguagens Formais e Autômatos", 25,72),
        (26,"Inteligência Artificial",26,72),
        (27,"Computação Gráfica",27,72),
        (28,"Projeto Orientado a Objetos",28,72),
        (29,"Engenharia de Software",29,72),
        (30,"Compiladores",30,72),
        (31,"Teoria dos Grafos",31,72),
        (32,"Programação Concorrente e Distribuída",32,72),
        (33,"Redes de Computadores",33,72),
        
/*TCC */
		(34,"Trabalho de Conclusão de Curso I",34,72),
        (35,"Trabalho de Conclusão de Curso II",35,72);
        
/* Eletivas BCC */
		/*Grupo 1 */
        /*Grupo 2 */
        /*Grupo 3 *
        
        Obs:terminar de inserir todas as disciplinas e nao esquecer atividades complementares de cadacurso!
        
        */

INSERT INTO matriz (idMatriz, nomeMatriz)
values (1,"matrizBCT"), /*incluindo atividades complementares */
		(2,"matrizBCC"), /* verificar carga horaria com cada coordenador! */
        (3,"matrizBMC"),
        (4,"matrizENGCOMP"),
        (5,"matrizENGBIO"),
        (6,"matrizENGMAT"),
        (7,"matrizBIOTEC");

INSERT INTO curso (idCurso, nomeCurso, Matriz_idMatriz, cargaHorariaTotal)
values (1,"Bacharelado em Ciência e Tecnologia",1,2400), /*incluindo atividades complementares */
		(2,"Bacharelado em Ciência da Computação",2,3480), /* verificar carga horaria com cada coordenador! */
        (3,"Bacharelaod em Matemática Computacional",3,2916),
        (4,"Engenharia de Computação",4,4200),
        (5,"Engenharia Biomédica",5,3780),
        (6,"Engenharia de Materiais",6,3816),
        (7,"Bacharelado em Biotecnologia",7,3054);
        

  