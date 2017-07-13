/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.genesis.services;

import br.com.crescer.genesis.entidades.Colaborador;
import br.com.crescer.genesis.entidades.ColaboradorFeito;
import br.com.crescer.genesis.entidades.Feito;
import br.com.crescer.genesis.entidades.Permissao;
import br.com.crescer.genesis.repositorios.ColaboradorFeitoRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafa
 */
@Service
public class ColaboradorFeitoService {

    @Autowired
    ColaboradorFeitoRepositorio repositorio;
    @Autowired
    FeitoService feitoService;
    @Autowired
    ColaboradorService colabService;

    public Iterable<ColaboradorFeito> buscarTodos(User user) {

        if (user == null) {
            Permissao permissaoPublica = new Permissao();
            permissaoPublica.setId(4L);
            List<Feito> feitocolab = feitoService.buscarPorPermissao(permissaoPublica);
            return repositorio.findAllByIdFeito_In(feitocolab);
        } else {
            Colaborador colaboradorLogado = colabService.buscarPorEmail(user.getUsername());
            String permissaoColaborador = colaboradorLogado.getIdPermissao().getDescricao().toUpperCase();

            if (permissaoColaborador.equals("ADMINISTRADOR")) {
                return repositorio.findAll();

            } else if (permissaoColaborador.equals("COLABORADOR")) {
                List<Feito> feitos = feitoService.buscarPorPermissao(colaboradorLogado.getIdPermissao());
                Permissao permissaoPublica = new Permissao();
                permissaoPublica.setId(4L);
                feitos.addAll(feitoService.buscarPorPermissao(permissaoPublica));
                return repositorio.findAllByIdFeito_In(feitos);

            } else if (permissaoColaborador.equals("MASTER")) {
                Permissao permissaoColab = new Permissao();
                permissaoColab.setId(2L);
                List<Feito> feitocolab = feitoService.buscarPorPermissao(permissaoColab);

                Permissao permissaoPublic = new Permissao();
                permissaoPublic.setId(4L);
                feitocolab.addAll(feitoService.buscarPorPermissao(permissaoPublic));

                feitocolab.addAll(feitoService.buscarPorPermissao(colaboradorLogado.getIdPermissao()));
                return repositorio.findAllByIdFeito_In(feitocolab);
            }

            return null;
        }
    }

    public void novoColaboradorFeito(ColaboradorFeito colFeito) {
        repositorio.save(colFeito);
    }

    public Iterable<ColaboradorFeito> buscarFeitosPerfil(User user, Long id) {
        Colaborador colabPerfilVisualizado = colabService.buscarPorID(id);
        if (user == null) {
            Permissao permissaoPublica = new Permissao();
            permissaoPublica.setId(4L);
            List<Feito> feitocolab = feitoService.buscarPorPermissao(permissaoPublica);
            return repositorio.findAllByIdFeitoInAndIdColaborador(feitocolab, colabPerfilVisualizado);
        } else {
            Colaborador colaboradorLogado = colabService.buscarPorEmail(user.getUsername());
            String permissaoColabLogado = colaboradorLogado.getIdPermissao().getDescricao().toUpperCase();

            if (permissaoColabLogado.equals("ADMINISTRADOR") || colaboradorLogado.getId() == id) {
                return repositorio.findAllByIdColaborador(colabPerfilVisualizado);

            } else if (permissaoColabLogado.equals("COLABORADOR")) {
                List<Feito> feitos = feitoService.buscarPorPermissao(colaboradorLogado.getIdPermissao());

                Permissao permissaoPublica = new Permissao();
                permissaoPublica.setId(4L);
                feitos.addAll(feitoService.buscarPorPermissao(permissaoPublica));

                return repositorio.findAllByIdFeitoInAndIdColaborador(feitos, colabPerfilVisualizado);

            } else if (permissaoColabLogado.equals("MASTER")) {
                Permissao permissaoColab = new Permissao();
                permissaoColab.setId(2L);
                List<Feito> feitos = feitoService.buscarPorPermissao(permissaoColab);

                Permissao permissaoPublica = new Permissao();
                permissaoPublica.setId(4L);
                feitos.addAll(feitoService.buscarPorPermissao(permissaoPublica));

                feitos.addAll(feitoService.buscarPorPermissao(colaboradorLogado.getIdPermissao()));

                return repositorio.findAllByIdFeitoInAndIdColaborador(feitos, colabPerfilVisualizado);
            }
        }
        return null;
    }
}
