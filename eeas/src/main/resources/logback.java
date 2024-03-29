<?xml version="1.0" encoding="UTF-8"?>
<configuration>
    <springProperty scope="context" name="logbackLevel" source="logback.level"/>
    <springProperty scope="context" name="logbackAppender" source="logback.appender"/>
    <!-- 开发环境（输出到控制台）  -->
    <appender name="development" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!-- 设置日志输出格式 -->
            <pattern>%d %p (%file:%line\)- %m%n</pattern>
            <!-- 输出编码 -->
            <charset>UTF-8</charset>
        </encoder>
    </appender>

    <!-- 测试/线上环境（日期分割日志文件） -->
    <appender name="production"
              class="ch.qos.logback.core.rolling.RollingFileAppender">
        <File>log/eeas.log</File>
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <!-- 文件名配置 -->
            <fileNamePattern>log/eeas-%d.%i.log</fileNamePattern>
            <!-- 日志文件保存期限（单位天） -->
            <maxHistory>30</maxHistory>
            <timeBasedFileNamingAndTriggeringPolicy  class="ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP">
                <!-- 设置日志文件大小，默认值是10MB-->
                <maxFileSize>10MB</maxFileSize>
            </timeBasedFileNamingAndTriggeringPolicy>
        </rollingPolicy>
        <encoder>
            <!-- 设置日志输出格式 -->
            <pattern>%d %p (%file:%line\)- %m%n</pattern>
            <!-- 输出编码 -->
            <charset>UTF-8</charset>
        </encoder>
    </appender>
    <!-- 设置日志级别和输出模式 -->
    <root level="${logbackLevel}">
        <appender-ref ref="${logbackAppender}" />
    </root>
</configuration>