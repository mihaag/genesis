----- criacao banco ---------------

  Create tablespace GENESIS 
  datafile 'C:\oracle\oraclexe\app\oracle\oradata\XE\GENESIS.dbf' 
  size 100m 
  autoextend on 
  next 100m 
  maxsize 2048m;

Create user GENESIS identified by GENESIS default tablespace GENESIS;
grant connect, resource, create view to GENESIS;

--inserts das permissoes
insert into permissao (id, descricao)
values (1, 'Administrador');

insert into permissao (id, descricao)
values (2, 'Colaborador');

insert into permissao (id, descricao)
values (3, 'Master');

insert into permissao (id, descricao)
values (4, 'Publico');

--insert dos feitos básicos (1,2,3) e mais 3 para feitos para a base (4,5,6)
insert into feito (id, descricao, descricaoresumida, imagem, nome, relevancia, id_permissao)
values (1, 'Admissão','Admissão','https://maxcdn.icons8.com/Share/icon/ios7/Business//badge1600.png','Admissão',1,2);

insert into feito (id, descricao, descricaoresumida, imagem, nome, relevancia, id_permissao)
values (2, 'Demissão','Demissão','https://maxcdn.icons8.com/Share/icon/ios7/Business//badge1600.png','Demissão',1,1);

insert into feito (id, descricao, descricaoresumida, imagem, nome, relevancia, id_permissao)
values (3, 'Troca de Time','Troca de Time','https://maxcdn.icons8.com/Share/icon/ios7/Business//badge1600.png','Troca de Time',1,1);

insert into feito (id, descricao, descricaoresumida, imagem, nome, relevancia, id_permissao)
values (4, 'Palestra .Net','Palestra .Net','https://maxcdn.icons8.com/Share/icon/ios7/Business//badge1600.png','Palestra .Net',5,4);

insert into feito (id, descricao, descricaoresumida, imagem, nome, relevancia, id_permissao)
values (5, 'Certificação Interna','Certificação Interna','https://maxcdn.icons8.com/Share/icon/ios7/Business//badge1600.png','Certificação Interna',3,2);

insert into feito (id, descricao, descricaoresumida, imagem, nome, relevancia, id_permissao)
values (6, 'Avaliação de Desempenho','Avaliação de Desempenho','https://maxcdn.icons8.com/Share/icon/ios7/Business//badge1600.png','Avaliação de Desempenho',1,3);

--insert usuario admin (usuario: adminteste@cwi.com.br  senha: 1111)
insert into colaborador(id, admissao, email, foto, nascimento, nomecompleto, possuitime, sede, senha, situacao, id_permissao)
values (1, to_date('2012-10-10','yyyy-MM-dd'), 'adminteste@cwi.com.br', 'https://png.icons8.com/employee-card/dotty/1600',
            to_date('2012-10-10','yyyy-MM-dd'), 'Mirela Haag Adam', 'N', 1, '$2a$10$McdKWxYuZ/GWyDpyY3I54OXRjZicZIYCjOgF8NeAOlr1HvPUGTkQ2',
            'A', 1);

-- vincula feito de admissão ao admin
insert into colaborador_feito (id, datafeito, id_colaborador, id_feito)
values (1, to_date('2012-10-10','yyyy-MM-dd'), 1, 1);

-- vincula feito de troca de time ao admin
insert into colaborador_feito (id, datafeito, id_colaborador, id_feito)
values (2, to_date('2016-08-07','yyyy-MM-dd'), 1, 3);

-- cadastro de um time
insert into timecwi (id, descricao, descricaoresumida, nome, situacao)
values (1, 'Desenvolvimento Fiscal','Fiscal','Time Fiscal','A');

-- vincula time ao admin deixando-o como owner
insert into timecwi_colaborador (id, tipo, id_colaborador, id_timecwi)
values (1, 'O', 1, 1);

-- atualiza campo possuitime do admin que agora é owner de um time
update colaborador
set possuitime = 'S'
where id = 1;

-- cadastra um colaborador com permissão colaborador (usuario: colaboradorteste@cwi.com.br   senha: 1111)
insert into colaborador(id, admissao, email, foto, nascimento, nomecompleto, possuitime, sede, senha, situacao, id_permissao)
values (2, to_date('2015-11-01','yyyy-MM-dd'), 'colaboradorteste@cwi.com.br', 'https://png.icons8.com/employee-card/dotty/1600',
            to_date('1990-05-06','yyyy-MM-dd'), 'Colaborador teste', 'N', 1, '$2a$10$McdKWxYuZ/GWyDpyY3I54OXRjZicZIYCjOgF8NeAOlr1HvPUGTkQ2',
            'A', 2);

--vincula admissão
insert into colaborador_feito (id, datafeito, id_colaborador, id_feito)
values (3, to_date('2015-11-01','yyyy-MM-dd'), 2, 1);

-- create da view obrigatoria para pesquisa de colaboradores na criação/edição de times
CREATE VIEW emp_view Usuarios_Disponiveis as

SELECT c.email
FROM colaborador c
WHERE NOT EXISTS (
        SELECT tc.tipo,
               COUNT(1)
        
        FROM   timecwi_colaborador tc
        WHERE  tc.tipo = 'O'
        AND    tc.id_timecwi IN (
                      SELECT DISTINCT id_timecwi
                      FROM timecwi_colaborador
                      WHERE id_colaborador = c.id
                      AND tipo = 'O'
                )
        GROUP BY tc.tipo
        HAVING COUNT(1) < 2
    );


CREATE VIEW VW_Usuarios_Disponiveis AS

SELECT
    rownum AS ID_view,
    c.id,
    c.admissao,
    c.andar,
    c.demissao,
    c.descricao,
    c.descricaoresumida,
    c.email,
    c.nascimento,
    c.nomecompleto,
    c.posicao,
    c.ramal,
    c.sede,
    c.senha,
    c.situacao,
    c.id_permissao,
    c.foto,
    c.possuiTime
FROM  colaborador c
WHERE NOT EXISTS (
        SELECT tc.tipo,
               COUNT(1)
        FROM   timecwi_colaborador tc
        WHERE  tc.tipo = 'O'
        AND    tc.id_timecwi IN (
                SELECT DISTINCT id_timecwi
                FROM timecwi_colaborador
                WHERE id_colaborador = c.id
                AND tipo = 'O'
            )
        GROUP BY  tc.tipo
        HAVING    COUNT(1) < 2
    ); 


-- criação das tabelas/sequences pode ser feita diretamente com a execução do projeto (spring)

-- unique key tabela colaborador
ALTER TABLE COLABORADOR 
ADD CONSTRAINT EMAIL_UNIQUE UNIQUE (EMAIL);