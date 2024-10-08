package com.corhuila.Parcial.IRepository;

import com.corhuila.Parcial.Entity.ControlActividades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IControlActividadesRepository extends JpaRepository<ControlActividades, Long> {
}
