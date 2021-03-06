CREATE TABLE PERMISSAO ( 
    ID NUMBER(12) NOT NULL,
	DESCRICAO VARCHAR2(20) NOT NULL, -- master, admin, colaborador
    CONSTRAINT PERMISSAO_PK PRIMARY KEY (ID)
);

CREATE TABLE COLABORADOR ( 
    ID NUMBER(12) NOT NULL,
    EMAIL VARCHAR2(100) NOT NULL,
	NOMECOMPLETO VARCHAR2(100) NOT NULL,	
    NASCIMENTO DATE NOT NULL,
    ADMISSAO DATE NOT NULL,
    DEMISSAO DATE,
    SEDE NUMBER(1) NOT NULL, -- 0 SL, 1 SP, 2 POA
	RAMAL VARCHAR2(10), 
    ANDAR VARCHAR2(10),
    POSICAO VARCHAR2(10),
    DESCRICAO VARCHAR2(200),
    DESCRICAORESUMIDA VARCHAR2(20),
    ID_PERMISSAO NUMBER(12) NOT NULL, -- PERMISSAO: ADMIN, COLABORADOR, MASTER
    SITUACAO CHAR(1) NOT NULL, -- 'A' ou 'I' (Ativo / Inativo)
    SENHA VARCHAR(200) NULL, 	
    FOREIGN KEY(ID_PERMISSAO) REFERENCES PERMISSAO (ID),
    CONSTRAINT USUARIO_PK PRIMARY KEY (ID)
);

ALTER TABLE COLABORADOR
ADD CONSTRAINT EMAIL_UNIQUE UNIQUE (EMAIL);

CREATE TABLE FEITO(
    ID NUMBER(12) NOT NULL,
    NOME VARCHAR2(200) NOT NULL,
    DESCRICAO VARCHAR2(200) NOT NULL,
    DESCRICAORESUMIDA VARCHAR2(100) ,
    ID_PERMISSAO NUMBER(12) NOT NULL,
    IMAGEM VARCHAR2(500) NOT NULL,
    RELEVANCIA NUMBER(1) NOT NULL,
    FOREIGN KEY(ID_PERMISSAO) REFERENCES PERMISSAO (ID),
    CONSTRAINT FEITO_PK PRIMARY KEY (ID)
);

CREATE TABLE COLABORADOR_FEITO(
    ID NUMBER(12) NOT NULL,
    ID_COLABORADOR NUMBER(12) NOT NULL,
    ID_FEITO NUMBER(12) NOT NULL,
    DATAFEITO DATE NOT NULL,
    OBSERVACAO VARCHAR2(200),
    FOREIGN KEY(ID_COLABORADOR) REFERENCES COLABORADOR (ID),
    FOREIGN KEY(ID_FEITO) REFERENCES FEITO (ID),
    CONSTRAINT COLABORADORFEITO_PK PRIMARY KEY (ID)
);

CREATE TABLE SOLICITACAO_ACESSO(
	ID NUMBER(12) NOT NULL,
    EMAIL VARCHAR2(100) NOT NULL,
    CONSTRAINT SOLICITACAOACESSO_PK PRIMARY KEY (ID)
);

CREATE TABLE TIMECWI(
    ID NUMBER(12) NOT NULL,
    NOME VARCHAR2(200) NOT NULL,
    DESCRICAO VARCHAR2(500) NOT NULL,
    DESCRICAORESUMIDA VARCHAR2(100),
    SITUACAO CHAR(1), -- 'A' ou 'I' / Ativou ou Inativo 
    CONSTRAINT TIMECWI_PK PRIMARY KEY (ID)
);

CREATE TABLE TIMECWI_COLABORADOR(
    ID NUMBER(12) NOT NULL,
    ID_TIMECWI NUMBER(12) NOT NULL,
    ID_COLABORADOR NUMBER(12) NOT NULL,
    TIPO CHAR(1) NOT NULL, --'O' ou 'M' / Owner ou Membro
    FOREIGN KEY(ID_TIMECWI) REFERENCES TIMECWI (ID),
    FOREIGN KEY(ID_COLABORADOR) REFERENCES COLABORADOR (ID),
    CONSTRAINT TIMECWICOLABORADOR_PK PRIMARY KEY (ID)
);

CREATE TABLE COLABORADOR_TAG(
    ID NUMBER(12) NOT NULL,
    ID_COLABORADOR NUMBER(12) NOT NULL,
    DESCRICAO VARCHAR2(20) NOT NULL,
    FOREIGN KEY(ID_COLABORADOR) REFERENCES TIMECWI (ID),
    CONSTRAINT COLABORADORTAG_PK PRIMARY KEY (ID)
);

CREATE TABLE COLABORADOR_REACAO_TAG(
    ID NUMBER(12) NOT NULL,
    ID_COLABORADORTAG NUMBER(12) NOT NULL,
    ID_COLABORADOR NUMBER(12) NOT NULL,
    REACAO CHAR(1) NOT NULL, -- 'C' ou 'D' / Concordou ou Discordou
    FOREIGN KEY(ID_COLABORADORTAG) REFERENCES COLABORADOR_TAG (ID),
    FOREIGN KEY(ID_COLABORADOR) REFERENCES COLABORADOR (ID),
    CONSTRAINT PK_COLABORADOR_REACAO_TAG PRIMARY KEY (ID)
);

CREATE TABLE COLABORADOR_SEGUINDO(
    ID NUMBER(12) NOT NULL,
    ID_SEGUIDOR NUMBER(12) NOT NULL,
    ID_SEGUIDO NUMBER(12) NOT NULL,
    FOREIGN KEY(ID_SEGUIDOR) REFERENCES CLABORADOR (ID),
    FOREIGN KEY(ID_SEGUIDO) REFERENCES COLABORADOR (ID),
    CONSTRAINT COLABORADORSEGUINDO_PK PRIMARY KEY (ID)
);

CREATE TABLE SOLICITACAO_TROCATIME(
    ID NUMBER(12) NOT NULL,
    ID_COLABORADOR NUMBER(12) NOT NULL,
    ID_NOVOTIME NUMBER(12) NOT NULL,
    FOREIGN KEY(ID_COLABORADOR) REFERENCES COLABORADOR (ID),
    FOREIGN KEY(ID_NOVOTIME) REFERENCES TIMECWI (ID),
    CONSTRAINT SOLICITACAOTROCATIME_PK PRIMARY KEY (ID)
);
email: tccGenesisCwi@gmail.com
genesis1234

genesistcccwi@gmail.com
12345gtcc send