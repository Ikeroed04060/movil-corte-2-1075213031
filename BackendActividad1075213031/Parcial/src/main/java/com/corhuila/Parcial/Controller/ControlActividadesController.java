package com.corhuila.Parcial.Controller;

import com.corhuila.Parcial.Entity.ControlActividades;
import com.corhuila.Parcial.IService.IControlActividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actividades")
public class ControlActividadesController {
    @Autowired
    private IControlActividadesService controlActividadesService;

    @GetMapping()
    public List<ControlActividades> findALL(){
        return controlActividadesService.findAll();
    }


    @GetMapping("/{id}")
    public Optional<ControlActividades> findById(@PathVariable Long id){
        return controlActividadesService.findById(id);
    }


    @PostMapping()
    public ControlActividades save(@RequestBody ControlActividades controlActividades){
        return controlActividadesService.save(controlActividades);}


    @PutMapping("/{id}")
    public void update(@RequestBody ControlActividades controlActividades, @PathVariable Long id){
        controlActividadesService.update(controlActividades, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        controlActividadesService.delete(id);
    }
}
