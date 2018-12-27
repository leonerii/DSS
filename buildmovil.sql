DROP SCHEMA IF EXISTS BuildMovil;
CREATE SCHEMA BuildMovil;

USE BuildMovil;

CREATE TABLE Cliente (
    nif CHAR(9) PRIMARY KEY,
    nome VARCHAR(50),
    morada VARCHAR(50)
);

CREATE TABLE Utilizador (
    user VARCHAR(50) PRIMARY KEY,
    pass VARCHAR(50),
    tipo VARCHAR(50),
    nome VARCHAR(50)
);

CREATE TABLE Pedido (
    estado VARCHAR(50),
    valor INT,
    id INT PRIMARY KEY,
    data_inicial DATE,
    data_final DATE,
    fk_Cliente_nif CHAR(9)
);

CREATE TABLE Pacote (
    id INT PRIMARY KEY,
    valor FLOAT,
    nome VARCHAR(50)
);

CREATE TABLE Componente (
    nome VARCHAR(50),
    id INT PRIMARY KEY,
    peso INT,
    valor FLOAT
);

CREATE TABLE Incompativel (
    fk_Componente_id INT,
    fk_Componente_id_ INT
);

CREATE TABLE Dependente (
    fk_Componente_id INT,
    fk_Componente_id_ INT
);

CREATE TABLE Pacote_Componente (
    fk_Componente_id INT,
    fk_Pacote_id INT
);

CREATE TABLE Pedido_Componente (
    fk_Componente_id INT,
    fk_Pedido_id INT
);
 
ALTER TABLE Pedido ADD CONSTRAINT FK_Pedido_2
    FOREIGN KEY (fk_Cliente_nif)
    REFERENCES Cliente (nif)
    ON DELETE RESTRICT;
 
ALTER TABLE Incompativel ADD CONSTRAINT FK_Incompativel_1
    FOREIGN KEY (fk_Componente_id)
    REFERENCES Componente (id)
    ON DELETE CASCADE;
 
ALTER TABLE Incompativel ADD CONSTRAINT FK_Incompativel_2
    FOREIGN KEY (fk_Componente_id_)
    REFERENCES Componente (id)
    ON DELETE CASCADE;
 
ALTER TABLE Dependente ADD CONSTRAINT FK_Dependente_1
    FOREIGN KEY (fk_Componente_id)
    REFERENCES Componente (id)
    ON DELETE CASCADE;
 
ALTER TABLE Dependente ADD CONSTRAINT FK_Dependente_2
    FOREIGN KEY (fk_Componente_id_)
    REFERENCES Componente (id)
    ON DELETE CASCADE;
 
ALTER TABLE Pacote_Componente ADD CONSTRAINT FK_Pacote_Componente_1
    FOREIGN KEY (fk_Componente_id)
    REFERENCES Componente (id)
    ON DELETE RESTRICT;
 
ALTER TABLE Pacote_Componente ADD CONSTRAINT FK_Pacote_Componente_2
    FOREIGN KEY (fk_Pacote_id)
    REFERENCES Pacote (id)
    ON DELETE SET NULL;
 
ALTER TABLE Pedido_Componente ADD CONSTRAINT FK_Pedido_Componente_1
    FOREIGN KEY (fk_Componente_id)
    REFERENCES Componente (id)
    ON DELETE RESTRICT;
 
ALTER TABLE Pedido_Componente ADD CONSTRAINT FK_Pedido_Componente_2
    FOREIGN KEY (fk_Pedido_id)
    REFERENCES Pedido (id)
    ON DELETE SET NULL;
