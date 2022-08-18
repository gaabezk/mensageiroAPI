package br.com.mensageiro.services;

import br.com.mensageiro.exceptions.ErrorException;
import br.com.mensageiro.models.UsuarioModel;
import br.com.mensageiro.modelsDTO.AmigoModelDTO;
import br.com.mensageiro.modelsDTO.UsuarioModelDTO;
import br.com.mensageiro.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepo usuarioRepo;

    public List<UsuarioModelDTO> listarTodos() {
        List<UsuarioModelDTO> list = new ArrayList<>();
        Date date = new Date();

        for (UsuarioModel usuarioModel : usuarioRepo.findAll()) {
            UsuarioModelDTO usuarioModelDTO = new UsuarioModelDTO();

            long diff =  date.getTime() - usuarioModel.getDataNascimento().getTime();
            long idade = TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS) / 365;

            usuarioModelDTO.setIdade(idade);
            usuarioModelDTO.setEmail(usuarioModel.getEmail());
            usuarioModelDTO.setFoto(usuarioModel.getFotoUrl());
            usuarioModelDTO.setNick(usuarioModel.getNickname());
            usuarioModelDTO.setStatus(usuarioModel.getStatus());
            usuarioModelDTO.setNome(usuarioModel.getNome());
            list.add(usuarioModelDTO);
        }
        return list;
    }

    public UsuarioModel cadastrar(UsuarioModel usuarioModel) throws ErrorException {
        Optional<UsuarioModel> optional = usuarioRepo.findByEmail(usuarioModel.getEmail());
        if (optional.isPresent()){
            throw new ErrorException("Usuario já existe");
        }
        return usuarioRepo.save(usuarioModel);
    }

    public void adicionarAmigo(String nickUsuario,String nickAmigo) throws ErrorException {
        Optional<UsuarioModel> usuario = usuarioRepo.findByNickname(nickUsuario);
        Optional<UsuarioModel> amigo = usuarioRepo.findByNickname(nickAmigo);
        if (usuario.isEmpty()){
            throw new ErrorException("Usuario logado invalido");
        }
        if (amigo.isEmpty()){
            throw new ErrorException("Usuario não encontrado");
        }
        List<UsuarioModel> usuarioModels = usuario.get().getAmigos();
        usuarioModels.add(amigo.get());
        usuario.get().setAmigos(usuarioModels);
        usuarioRepo.save(usuario.get());
    }

    public List<?> listarAmigos(String nickUsuario) throws ErrorException {
        Optional<UsuarioModel> usuario = usuarioRepo.findByNickname(nickUsuario);
        if (usuario.isEmpty()){
            throw new ErrorException("Usuario invalido");
        }
        List<AmigoModelDTO> amigoModelDTOS = new ArrayList<>();
        for (UsuarioModel usuarioModel : usuario.get().getAmigos()) {
            AmigoModelDTO amigoModelDTO = new AmigoModelDTO();

            amigoModelDTO.setNome(usuarioModel.getNome());
            amigoModelDTO.setFoto(usuarioModel.getFotoUrl());
            amigoModelDTO.setStatus(usuarioModel.getStatus());
            amigoModelDTO.setNickname(usuarioModel.getNickname());
            amigoModelDTOS.add(amigoModelDTO);
        }

        return amigoModelDTOS ;
    }

    public List<?> seguidores(String nickUsuario){
//        dar um getAll em todos os Usuarios e fazer
//        um foreach para achar os usuarios que tem o
//        seu nick na lista de amigos
        return null;
    }

}
