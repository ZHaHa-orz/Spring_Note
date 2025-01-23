package com.atguigu.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;

/**
 * 方式1: 保留mybatis-config.xml配置文件
 * TODO: 如果将dataSource和mybatis的组件配置到一起, 触发@value注解不生效的问题
 *      原因: mybatis的组件优先加载, @value还没有读取
 *      解决: 分开配置, 写到不同的类->DataSourceJavaConfig
 *
 * 方式2: 不需要xml文件 -> MapperJavaConfigNew
 */
@Configuration
public class MapperJavaConfig {

    // @Value("${jdbc.user}")
    // private String user;
    // @Value("${jdbc.password}")
    // private String password;
    // @Value("${jdbc.url}")
    // private String url;
    // @Value("${jdbc.driver}")
    // private String driver;
    //
    // // 数据库连接池配置
    // @Bean
    // public DataSource dataSource(){
    //     DruidDataSource dataSource = new DruidDataSource();
    //     dataSource.setUsername(user);
    //     dataSource.setPassword(password);
    //     dataSource.setUrl(url);
    //     dataSource.setDriverClassName(driver);
    //     return dataSource;
    // }

    /**
     * 配置SqlSessionFactoryBean,指定连接池对象和外部配置文件即可
     * @param dataSource 需要注入连接池对象
     * @return 工厂Bean
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource){
        // 实例化SqlSessionFactory工厂
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

        // 设置连接池
        sqlSessionFactoryBean.setDataSource(dataSource);

        // 设置配置文件
        // 包裹外部配置文件地址对象
        // spring.core包
        Resource resource = new ClassPathResource("mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        return sqlSessionFactoryBean;
    }

    /**
     * 配置Mapper实例扫描工厂,配置 <mapper <package 对应接口和mapper.xml文件所在的包
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 设置mapper接口和xml文件所在的共同包
        mapperScannerConfigurer.setBasePackage("com.atguigu.mapper");
        return mapperScannerConfigurer;
    }
}