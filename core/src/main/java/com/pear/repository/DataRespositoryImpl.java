package com.pear.repository;

import com.pear.model.ListSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DataRespositoryImpl implements DataRespository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DataRespositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<ListSample> getSampleList() {
        String sql = "select * from LIST_SAMPLE";
        return jdbcTemplate.query(sql,new ListRowMapper(),new Object[]{});
    }

}

/**
 * 行映射
 */
class ListRowMapper implements RowMapper<ListSample> {

    @Override
    public ListSample mapRow(ResultSet resultSet, int i) throws SQLException {
        ListSample data=new ListSample();
        data.setIndex(resultSet.getLong("INDEX"));
        data.setTitle(resultSet.getString("TITLE"));
        data.setAuthor(resultSet.getString("AUTHOR"));
        data.setStatus(resultSet.getString("STATUS"));
        data.setPageviews(resultSet.getInt("PAGEVIEWS"));
        data.setDisplay_time(resultSet.getString("DISPLAY_TIME"));
        return data;
    }

}
