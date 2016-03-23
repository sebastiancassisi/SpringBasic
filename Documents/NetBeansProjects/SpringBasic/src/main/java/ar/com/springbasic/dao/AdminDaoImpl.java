/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.springbasic.dao;

import ar.com.springbasic.beans.Admin;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author cassisi
 */
@Component("adminDao")
public class AdminDaoImpl implements AdminDao {

    //Plantilla que acepta comodines
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Admin admin) {
        MapSqlParameterSource paramMap = new MapSqlParameterSource();
        paramMap.addValue("nombre", admin.getNombre());
        paramMap.addValue("cargo", admin.getCargo());
        paramMap.addValue("fechaCreacion", admin.getFechaCreacion());

        return jdbcTemplate.update("insert into Admin (nombre, cargo, fechaCreacion) values (:nombre, :cargo, :fechaCreacion) ", paramMap) == 1;
    }

}
