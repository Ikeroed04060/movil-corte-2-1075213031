package com.corhuila.Parcial.Service;

import com.corhuila.Parcial.Entity.ControlActividades;
import com.corhuila.Parcial.IRepository.IControlActividadesRepository;
import com.corhuila.Parcial.IService.IControlActividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ControlActividadesService implements IControlActividadesService {

    @Autowired
    private IControlActividadesRepository controlActividadesRepository;

    @Override
    public List<ControlActividades> findAll() {
        return(List<ControlActividades>) controlActividadesRepository.findAll();
    }

    @Override
    public Optional<ControlActividades> findById(Long id) {
        return controlActividadesRepository.findById(id);
    }

    @Override
    public ControlActividades save(ControlActividades controlActividades) {
        return controlActividadesRepository.save(controlActividades);
    }

    @Override
    public void update(ControlActividades controlActividades, Long id) {
        Optional<ControlActividades>us=controlActividadesRepository.findById(id);
        if(!us.isEmpty()){
            ControlActividades controlActividadesUpdate=us.get();
            controlActividadesUpdate.setCodigo_actividad(controlActividadesUpdate.getCodigo_actividad());
            controlActividadesUpdate.setFecha(controlActividadesUpdate.getFecha());
            controlActividadesUpdate.setNombre(controlActividadesUpdate.getNombre());
            controlActividadesUpdate.setDescripcion(controlActividadesUpdate.getDescripcion());
            controlActividadesRepository.save(controlActividadesUpdate);
        }else {
            System.out.println("No existe la actividad");
        }
    }
    @Override
    public void delete(Long id) {
        controlActividadesRepository.deleteById(id);
    }
}
