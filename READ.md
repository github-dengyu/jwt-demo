一、 什么是JWT呢?就是Java Web Token，是一种基于JSON的、用于在网络上声明某种主张的令牌（token）。
JWT通常由三部分组成: 头信息（header）, 消息体（payload）和签名（signature）。
关于头部信息中的签名算法，JWT提供了很多种，
JWS	Algorithm	Description
HS256	HMAC256	HMAC with SHA-256
HS384	HMAC384	HMAC with SHA-384
HS512	HMAC512	HMAC with SHA-512
RS256	RSA256	RSASSA-PKCS1-v1_5 with SHA-256
RS384	RSA384	RSASSA-PKCS1-v1_5 with SHA-384
RS512	RSA512	RSASSA-PKCS1-v1_5 with SHA-512
ES256	ECDSA256	ECDSA with curve P-256 and SHA-256
ES384	ECDSA384	ECDSA with curve P-384 and SHA-384
ES512	ECDSA512	ECDSA with curve P-521 and SHA-512
默认我们采用的是HS256	HMAC256	HMAC with SHA-256

二、关于jwt的下载，可以从其官网进行下载，其地址是:https://jwt.io/ 目前支持的语言多种，有Java,Python,.NET,Go,Ruby,Nodejs,JavaScript等等,我这下载的是Java版本,github地址是https://github.com/auth0/java-jwt ，最新版本是3.3.1

第一步如果项目采用的是SpringMVC + Maven架构的话，第一步当然是引包
<dependency>
    <groupId>com.auth0</groupId>
    <artifactId>java-jwt</artifactId>
    <version>2.2.0</version>
</dependency>
第二步就是写签入并生成token的算法
第三步写验证token,并解析token。（前提是token的exp未过期）
最后就是开放自己的Controller验证。

其实JWT是一种基于token的鉴权机制类似于http协议也是无状态的，它不需要在服务端去保留用户的认证信息或者会话信息。
这就意味着基于token认证机制的应用不需要去考虑用户在哪一台服务器登录了，使得应用程序具有很好的伸缩性。确定是它的安全性，
因为token完全暴露在客户端，这时候如果配合https中的ssl安全加密一起使用，那是一种比较好的方式。

当然了，传统的cookie-session机制，使用集中式管理session机制，比如外部session存储方案已经非常成熟了（比如Redis），
在一些Framework的帮助下（比如spring-session），session复制也就很容易处理。

参考文章:
什么是 JWT -- JSON WEB TOKEN   https://www.jianshu.com/p/576dbf44b2ae
讲真，别再使用JWT了！           https://www.jianshu.com/p/af8360b83a9f
