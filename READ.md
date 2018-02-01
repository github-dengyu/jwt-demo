一、 什么是JWT呢?就是Java Web Token，是一种基于JSON的、用于在网络上声明某种主张的令牌（token）。
JWT通常由三部分组成: 头信息（header）, 消息体（payload）和签名（signature）。

二、关于jwt的下载，可以从其官网进行下载，其地址是:https://jwt.io/ 目前支持的语言多种Java,Python,.NET,Go,Ruby,Nodejs,JavaScript等等,我这下载的是Java版本,github地址是https://github.com/auth0/java-jwt 

第一步如果项目采用的是SpringMVC + Maven架构的话，第一步当然是引包
<dependency>
    <groupId>com.auth0</groupId>
    <artifactId>java-jwt</artifactId>
    <version>3.3.0</version>
</dependency>
