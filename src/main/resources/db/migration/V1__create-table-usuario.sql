CREATE TABLE
    usuario (
    id_usuario SERIAL UNIQUE PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    senha VARCHAR(100) NOT NULL
);