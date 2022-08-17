package br.com.mensageiro.services;

import br.com.mensageiro.exceptions.ErrorException;
import br.com.mensageiro.models.UsuarioModel;
import br.com.mensageiro.modelsDTO.UsuarioModelDTO;
import br.com.mensageiro.repositories.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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


        for (UsuarioModel usuarioModel : usuarioRepo.findAll()) {
            UsuarioModelDTO usuarioModelDTO = new UsuarioModelDTO();
            Date date = new Date();

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
        Optional<UsuarioModel> optional = usuarioRepo.findById(usuarioModel.getId());
        if (optional.isPresent()){
            throw new ErrorException("Usuario já existe");
        }
        return usuarioRepo.save(usuarioModel);
    }

}
