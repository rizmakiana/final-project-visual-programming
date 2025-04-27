package com.unindra.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.unindra.model.request.TeacherRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TeacherRepositoryImpl implements TeacherRepository {

	private DataSource dataSource;

	public TeacherRepositoryImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	// add data
	public void add(TeacherRequest teacherRequest) {

		String sql = "INSERT INTO teachers (id, name, birth_place, birth_date, gender, address, phone_number, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

			preparedStatement.setString(1, teacherRequest.getId());
			preparedStatement.setString(2, teacherRequest.getName());
			preparedStatement.setString(3, teacherRequest.getBirthPlace());
			preparedStatement.setString(5, teacherRequest.getGender());
			preparedStatement.setString(6, teacherRequest.getAddress());
			preparedStatement.setString(7, teacherRequest.getPhoneNumber());
			preparedStatement.setString(8, teacherRequest.getEmail());

			Date utilDate = teacherRequest.getBirthDate();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			preparedStatement.setDate(4, sqlDate);

			preparedStatement.executeUpdate();

			log.info("succesfully insert data {}", teacherRequest);
		} catch (Exception e) {
			log.info("fail to insert data {}", e);
		}
	}

	// get all data
	@Override
	public TeacherRequest[] getAll() {

		String sql = "SELECT * FROM teachers";

		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {

			List<TeacherRequest> list = new ArrayList<>();

			while (resultSet.next()) {
				TeacherRequest request = new TeacherRequest();
				request.setName(resultSet.getString(1));
				request.setId(resultSet.getString(2));
				request.setBirthPlace(resultSet.getString(3));
				request.setBirthDate(resultSet.getDate(4));
				request.setGender(resultSet.getString(5));
				request.setAddress(resultSet.getString(6));
				request.setPhoneNumber(resultSet.getString(7));
				request.setEmail(resultSet.getString(8));

				list.add(request);
			}

			log.info("succesfully importing database");
			return list.toArray(new TeacherRequest[] {});
		} catch (SQLException exception) {
			log.info("fail to importing database");
			throw new RuntimeException(exception);
		}

	}

	@Override
	public String findById(String id) {
		String sql = "SELECT id FROM teachers WHERE id = ?";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, id);

			try (ResultSet resultSet = statement.executeQuery()) {
				if (resultSet.next()) {
					return resultSet.getString("id");
				}
				return null;
			}

		} catch (SQLException exception) {
			throw new RuntimeException(exception);
		}
	}

	@Override
	public void deleteAll() {
		String sql = "DELETE FROM teachers";

		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement()) {

			int deleted = statement.executeUpdate(sql);
			log.info("Successfully deleted {} row(s) from teachers table", deleted);

		} catch (SQLException e) {
			log.error("Failed to delete all data from teachers table", e);
		}
	}

	@Override
	public void update(String id, TeacherRequest request) {

		String sql = "UPDATE teachers SET name = ?, birth_place = ?, birth_date = ?, gender = ?, address = ?, phone_number = ?, email = ? WHERE id = ?";

		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {

			statement.setString(1, request.getName());
			statement.setString(2, request.getBirthPlace());
			statement.setDate(3, new java.sql.Date(request.getBirthDate().getTime()));
			statement.setString(4, request.getGender());
			statement.setString(5, request.getAddress());
			statement.setString(6, request.getPhoneNumber());
			statement.setString(7, request.getEmail());
			statement.setString(8, id);

			statement.executeUpdate();
			log.info("data : {}", request);
		} catch (SQLException e) {
			throw new RuntimeException("Gagal update guru", e);
		}

	}
}
