package com.unindra.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.unindra.repository.TeacherRepository;
import com.unindra.repository.TeacherRepositoryImpl;
import com.unindra.service.TeacherService;
import com.unindra.service.TeacherServiceImpl;
import com.unindra.view.TeacherDataView;

public class AppContext {

    private static final TeacherRepository teacherRepository;
    private static final TeacherService teacherService;
    private static HikariDataSource hikariDataSource;

    static {
        HikariConfig hikariConfig = new HikariConfig();

        // configuration database connection
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setUsername("root");
        hikariConfig.setPassword("");
        hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/final_project_visual_programming?serverTimezone=Asia/Jakarta");

        // configuration connection pool
        hikariConfig.setMaximumPoolSize(100);
        hikariConfig.setMinimumIdle(10);
        hikariConfig.setIdleTimeout(60_000);
        hikariConfig.setMaxLifetime(60 * 60 * 60_000);

        hikariDataSource = new HikariDataSource(hikariConfig);

        teacherRepository = new TeacherRepositoryImpl(hikariDataSource);
        teacherService = new TeacherServiceImpl(teacherRepository);
    }

    public static HikariDataSource getDataSource() {
        return hikariDataSource;
    }

    public static TeacherDataView getTeacherDataView() {
        return new TeacherDataView(teacherService);
    }

    public static TeacherService getTeacherService() {
        return teacherService;
    }
}
