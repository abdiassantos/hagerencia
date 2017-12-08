CREATE TABLE controlecliente(
	idcliente SERIAL NOT NULL,
	nomecliente VARCHAR(70),
	cpfcliente VARCHAR(20) UNIQUE,
	telefonecliente VARCHAR(20),
	emailcliente VARCHAR(30),
	ruacliente VARCHAR(70),
	numerocasa VARCHAR(10),
	bairrocliente VARCHAR(30),
	cidadecliente VARCHAR(40),
	estadocliente VARCHAR(25),
	cepcliente VARCHAR(15),
	complementoendereco VARCHAR(50),
	valoratual DOUBLE PRECISION DEFAULT 0,

	PRIMARY KEY (idcliente)
);

CREATE TABLE controleusuarioslogin(
	idusuario SERIAL NOT NULL ,
	nomeusuario VARCHAR(30) UNIQUE NOT NULL,
	senhausuario varchar(30) NOT NULL,
	emailusuario VARCHAR(40) UNIQUE NOT NULL,

	PRIMARY KEY (idusuario)
);

CREATE TABLE estoqueproduto(
	idproduto SERIAL NOT NULL,
	nomeproduto VARCHAR(100),
	tamanhoproduto VARCHAR(50),
	valorproduto DOUBLE PRECISION DEFAULT 0,
	quantidadeproduto INTEGER,
	descricaoproduto VARCHAR(500),

	PRIMARY KEY (idproduto)
);


create table vendas(
  idvenda SERIAL NOT NULL ,
  idcliente INTEGER NOT NULL ,
  idproduto INTEGER NOT NULL,
  datavenda DATE NOT NULL,

PRIMARY KEY (idvenda)
);

ALTER TABLE vendas ADD CONSTRAINT produto_fk FOREIGN KEY (idproduto) REFERENCES estoqueproduto(idproduto);
ALTER TABLE vendas ADD CONSTRAINT cliente_fk FOREIGN KEY (idcliente) REFERENCES controlecliente(idcliente);
