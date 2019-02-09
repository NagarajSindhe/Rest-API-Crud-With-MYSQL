package com.sindhe.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sindhe.model.DBConstants;
import com.sindhe.model.Website;

public class ServiceImpl implements Service {

	static List<Website> list = null;

	public List<Website> getRecordsById(int id) {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Website website = new Website();
		list = new ArrayList<>();
		try {

			statement = DBConstants.dbConnection.getConnection()
					.prepareStatement(DBConstants.SELECT_STATEMENT + "where id='" + id + "'");
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				website.setId(Integer.parseInt(resultSet.getString(1)));
				website.setTitle(resultSet.getString(2));
				website.setDescription(resultSet.getString(3));
				website.setUrl(resultSet.getString(4));
				list.add(website);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<Website> getAllRecords() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		list = new ArrayList<>();
		try {
			statement = DBConstants.dbConnection.getConnection().prepareStatement(DBConstants.SELECT_STATEMENT);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Website website = new Website();
				website.setId(resultSet.getInt(1));
				website.setTitle(resultSet.getString(2));
				website.setDescription(resultSet.getString(3));
				website.setUrl(resultSet.getString(4));
				list.add(website);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Website> deleteById(Long id) {
		PreparedStatement statement = null;
		list = new ArrayList<>();
		Boolean b = false;
		try {
			statement = DBConstants.dbConnection.getConnection()
					.prepareStatement("DELETE FROM WEBSITE WHERE ID='" + id + "'");
			b = statement.execute();
			if (b == true) {
				list = new ServiceImpl().getAllRecords();
			}
			list.remove(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

}
