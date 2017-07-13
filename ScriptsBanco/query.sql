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
