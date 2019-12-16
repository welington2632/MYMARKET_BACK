# MyMarket

Repositório destinado ao PFC da UMC

#### Integrantes

Welington Martins

Gustavo Grégio

Nayara Rodrigues

----------------------------------------------------
### Problemas ao importar o projeto
- Problema com o WEB-INF

 Criar uma pasta WEB-INF no NetBeans na parte de Projetos na pasta "Páginas Web".
 
 ---------------------------------------------------
 ### Tables BD
 
 create table endereco(
id integer,
logradouro varchar(100),
cep varchar(100),
numero numeric(10),
comeplemento varchar(100),
constraint idEndereco primary key (id)
)

create table tipoUsuario(
id integer,
nome varchar(100),
constraint idTipousuarioPk Primary Key(id)
)

create table usuario(
id integer,
cnpj varchar(100),
nome varchar(100),
email varchar(100),
senha text,
enderecofk integer references endereco(id),
tipoUsuariofk integer references tipoUsuario(id)
)

create sequence seq_usuario;

create sequence seq_endereco;
