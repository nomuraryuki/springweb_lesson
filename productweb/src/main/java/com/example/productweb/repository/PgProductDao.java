package com.example.productweb.repository;

import com.example.productweb.entity.ProductRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PgProductDao implements ProductDao{
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public List<ProductRecord> findAll() {
        return jdbcTemplate.query("SELECT * FROM products ORDER BY id",
                new DataClassRowMapper<>(ProductRecord.class));
    }

    @Override
    public ProductRecord findById(int id) {
        var param = new MapSqlParameterSource();
        param.addValue("id", id);
        var list = jdbcTemplate.query("SELECT * FROM products WHERE id = :id", param, new DataClassRowMapper<>(ProductRecord.class));
        return list.isEmpty() ? null : list.get(0);
    }
}
