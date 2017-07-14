angular.module('app')
  .controller('perfilController', function ($scope, authService, $location, toastr, $localStorage,
    colaboradorService, loginService, homeService, perfilService, $routeParams, $http, tagsService) {
    $scope.usuarioAutenticado = authService.isAutenticado();
    $scope.usuarioLogado = authService.getUsuario();
    $scope.irParaHome = irParaHome;
    $scope.loadTags = loadTags;
    $scope.validarRemocao = validarRemocao;

    validaPermissaoUsuarioLogado($scope.usuarioLogado);
    usuarioNoProprioPerfil($scope.usuarioLogado);
    buscarColaborador($routeParams.id);
    buscarTags($routeParams.id);

    function buscarColaborador(id) {
      colaboradorService.buscarDadosColaborador(id).then(response => {
        $scope.colaborador = response.data;
        //dados formatados para exibição
        $scope.sedeTela = verificaSede($scope.colaborador.sede);
        $scope.ramalTela = $scope.colaborador.ramal === null ? 'não informado' : $scope.colaborador.ramal;
        $scope.andarTela = $scope.colaborador.andar === null ? 'não informado' : $scope.colaborador.andar;
        $scope.posicaoTela = $scope.colaborador.posicao === null ? 'não informado' : $scope.colaborador.posicao;
        $scope.descricaoTela = $scope.colaborador.descricao === null ? 'não informado' : $scope.colaborador.descricao;
        $scope.descricaoResumidaTela = $scope.colaborador.descricaoresumida === null ? 'não informado' : $scope.colaborador.descricaoresumida;
        $scope.situacaoTela = $scope.colaborador.situacao === 'A' ? 'Ativo' : 'Inativo';

        if ($scope.usuarioAutenticado) {
          perfilService.buscarFeitosDoUsuarioPorPermissao(id).then(response => {
            $scope.feitos = response.data;
          });
        } else {
          perfilService.buscarFeitosPublicosDoUsuario(id).then(response => {
            $scope.feitos = response.data;
          });
        }
      })
    };

    function usuarioNoProprioPerfil(usuario) {
      if (typeof usuario === 'undefined' || usuario === null) {
        $scope.vendoProprioPerfil = false;
      } else {
        $scope.vendoProprioPerfil = usuario.id.toString() === $routeParams.id ? true : false;
      }
      return;
    };

    function validaPermissaoUsuarioLogado(usuario) {
      if (typeof usuario === 'undefined' || usuario === null) {
        $scope.permissaoAdministrador = false;
        $scope.permissaoColaborador = false;
        $scope.permissaoMaster = false;
        return;
      }

      switch (usuario.idPermissao.id) {
        case 1:
          $scope.permissaoAdministrador = true;
          $scope.permissaoColaborador = false;
          $scope.permissaoMaster = false;
          break;
        case 2:
          $scope.permissaoColaborador = true;
          $scope.permissaoAdministrador = false;
          $scope.permissaoMaster = false;
          break;
        case 3:
          $scope.permissaoMaster = true;
          $scope.permissaoAdministrador = false;
          $scope.permissaoColaborador = false;
          break;
        default:
          $scope.permissaoAdministrador = false;
          $scope.permissaoColaborador = false;
          $scope.permissaoMaster = false;
      }
      return;
    };

    function verificaSede(idSede) {
      if (idSede === 1) {
        return 'São Leopoldo';
      } else if (idSede === 2) {
        return 'Porto Alegre';
      } else {
        return 'São Paulo';
      }
    };

    function irParaHome() {
      $location.path('/home');
    };

    function loadTags(query) {
      return perfilService.buscarTags();
    }

    $scope.console = function (tag) {
      var colabTag = {
        "id": 0,
        "descricao": tag.text,
        "idColaborador": {
          "id": $scope.usuarioLogado.id
        }
      }
      console.log(colabTag);
      tagsService.criarTag(colabTag).then(function () {
        debugger;
        console.log("ver se criou");
      }, function () {
        debugger;
        console.log("com certeza nao criou");
      })
    }

    function validarRemocao(tag) {
     if($scope.usuarioLogado.id == $routeParams.id) 
     return true;
     else return false;
    }

    $scope.tags = {};
    function buscarTags(id) {
      tagsService.buscarTagsColaborador(id).then(function (response) {
        var colaboradoresTag = {};
        colaboradoresTag = response.data;

        colaboradoresTag.forEach(function(colabTag) {
          tags.push(colabTag.descricao);
        }, this);
      })
    }
  });