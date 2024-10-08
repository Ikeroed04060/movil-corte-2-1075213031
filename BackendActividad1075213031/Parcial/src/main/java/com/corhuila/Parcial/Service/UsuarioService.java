package com.corhuila.Parcial.Service;

import com.corhuila.Parcial.Entity.Usuario;
import com.corhuila.Parcial.IRepository.IUsuarioRepository;
import com.corhuila.Parcial.IService.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return(List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void update(Usuario usuario, Long id) {
        Optional<Usuario>us=usuarioRepository.findById(id);
        if(!us.isEmpty()){
            Usuario usuarioUpdate=us.get();
            usuarioUpdate.setId_usuario(usuarioUpdate.getId_usuario());
            usuarioUpdate.setNombre(usuarioUpdate.getNombre());
            usuarioUpdate.setApellido(usuarioUpdate.getApellido());
            usuarioUpdate.setCorreo(usuarioUpdate.getCorreo());
            usuarioUpdate.setDireccion(usuarioUpdate.getDireccion());
            usuarioUpdate.setTelefono(usuarioUpdate.getTelefono());
            usuarioUpdate.setContraseña(usuarioUpdate.getContraseña());
            usuarioRepository.save(usuarioUpdate);
        }else {
            System.out.println("No existe el usuario");
        }
    }
    @Override
    public void delete(Long id) {
        usuarioRepository.deleteById(id);
    }
}
