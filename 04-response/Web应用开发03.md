> 掌握http协议之响应部分
> 熟练掌握response的相关API（重定向 路径 输出流）
> 掌握servletContext的常用API
> 独立完成文件下载案例

​

## HTTP协议之响应消息
组成：协议/版本 响应状态码 状态码描述
响应状态码

- 状态码都是三位数
- 状态码1-5

常见的响应头

- Context-Type服务器告诉客户端响应体数据格式以及编码格式
- Content-disposition以什么格式打开响应体数据
   - 值：
      - in-line默认值 在当前页面内打开
      - attachment;filename=xxx 以附件形式打开响应体 文件下载
### renponse功能：设置响应消息

- 设置响应行
   - 格式 HTTP/1.1 200 ok
   - 设置状态码 setStatus(int sc)
- 设置响应头 setHeader(String name,String value)
- 设置响应体
   - 获取输出流
      - 字符输出流PrintWriter getWriter()
      - 字节输出流 ServletOutpoutStream getOutputStream()
   - 使用输出流 将数据输出到客户端浏览器
### 重定向和转发

- 重定向的特点：redirect
   - 地址栏发生变化
   - 重定向可以访问其他站点的资源
   - 重定向是两次请求 请求响应一来一回 不能再使用request对象来共享数据 所以在进行重定向时 通过request.setAttribute()传值是无效的 要通过下面的方式 中间不能隔一层response
      - request.setAttribute("msg","hello response");
request.getRequestDispatcher("/responseDemo2");
- 转发的特点 forword
   - 转发地址栏路径不变
   - 转发只能访问当前服务器下的资源
- sendRedirect方法可以跨域 请求头重定向不能
- page ->request->session->application 作用域从小打大

​

### 跳转路径之相对路径
相对路径 通过相对路径不可以确定唯一资源

- 不以/开头 以.开头
- ./当前目录
- ../后退一级目录
- 通过/开头的都是绝对路径

​

### 使用response对象输出字符数据

1. 获取字符输出流
1. 输出数据

乱码问题

- PrintWriter pw = response.getWriter()获取的流的默认编码是ISO-8859-1
- 设置该流的默认编码
- 告诉浏览器响应体使用的编码 response.setContextType("text/html;charset=utf-8")



​

## BufferedImage类
BufferedImage是其Image抽象类的实现类，是一个带缓冲区图像类，主要作用是将一幅图片加载到内存中

| 变量和类型 | 字段 | 描述 |
| --- | --- | --- |
| static int | [TYPE_3BYTE_BGR](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_3BYTE_BGR) | 表示具有8位RGB颜色分量的图像，对应于Windows样式的BGR颜色模型，其中颜色为蓝色，绿色和红色，以3个字节存储。 |
| static int | [TYPE_4BYTE_ABGR](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_4BYTE_ABGR) | 表示具有8位RGBA颜色分量的图像，其中颜色为蓝色，绿色和红色，存储在3个字节和1个字节的alpha中。 |
| static int | [TYPE_4BYTE_ABGR_PRE](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_4BYTE_ABGR_PRE) | 表示具有8位RGBA颜色分量的图像，其中颜色为蓝色，绿色和红色，存储在3个字节和1个字节的alpha中。 |
| static int | [TYPE_BYTE_BINARY](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_BYTE_BINARY) | 表示不透明的字节打包的1,2或4位图像。 |
| static int | [TYPE_BYTE_GRAY](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_BYTE_GRAY) | 表示无索引的无符号字节灰度图像。 |
| static int | [TYPE_BYTE_INDEXED](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_BYTE_INDEXED) | 表示索引的字节图像。 |
| static int | [TYPE_CUSTOM](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_CUSTOM) | 图像类型无法识别，因此必须是自定义图像。 |
| static int | [TYPE_INT_ARGB](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_INT_ARGB) | 表示将8位RGBA颜色分量打包为整数像素的图像。 |
| static int | [TYPE_INT_ARGB_PRE](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_INT_ARGB_PRE) | 表示将8位RGBA颜色分量打包为整数像素的图像。 |
| static int | [TYPE_INT_BGR](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_INT_BGR) | 表示具有8位RGB颜色分量的图像，对应于Windows或Solaris样式的BGR颜色模型，蓝色，绿色和红色填充为整数像素。 |
| static int | [TYPE_INT_RGB](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_INT_RGB) | 表示将8位RGB颜色分量打包为整数像素的图像。 |
| static int | [TYPE_USHORT_555_RGB](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_USHORT_555_RGB) | 表示具有5-5-5 RGB颜色分量（5位红色，5位绿色，5位蓝色）且没有alpha的图像。 |
| static int | [TYPE_USHORT_565_RGB](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_USHORT_565_RGB) | 表示具有5-6-5 RGB颜色分量（5位红色，6位绿色，5位蓝色）且没有alpha的图像。 |
| static int | [TYPE_USHORT_GRAY](https://www.apiref.com/java11-zh/java.desktop/java/awt/image/BufferedImage.html#TYPE_USHORT_GRAY) | 表示未签名的短灰度图像，非索引）。 |





## ServletContext对象
代表整个web应用 可以和程序的容器（服务器）来通信
ServletContext获取方式：

- 通过request.getServletContext()每次请求都有一个
- 通过HttpServlet获取 this.getServletContext() 一直有
### ServletContext的功能

- 1.获取MIME类型
- 2.共享数据
- 3.获取服务器的真实路径

**ServletContext获取MIME类型**

- _MIME_ 类型 （全称为 Multipurpose Internet Mail Extensions ，媒体类型）是一种标准
- 格式：大类型/小类型 text/html images/jpeg
- 获取 String getMimeType(Strng file)

**ServletContext共享数据**

1. setAttribute(String name,Object value)
1. getAttribute(String name)
1. removeAttribute(String name)

ServletContext对象范围：所有用户所有请求的数据
**ServletContext获取服务器真实路径getRealPath（String path）**
**​**

### MIME类型
| 类型 | 描述 | 典型示例 |
| --- | --- | --- |
| text | 表明文件是普通文本，理论上是人类可读 | text/plain, text/html, text/css, text/javascript |
| image | 表明是某种图像。不包括视频，但是动态图（比如动态gif）也使用image类型 | image/gif, image/png, image/jpeg, image/bmp, image/webp, image/x-icon, image/vnd.microsoft.icon |
| audio | 表明是某种音频文件 | audio/midi, audio/mpeg, audio/webm, audio/ogg, audio/wav |
| video | 表明是某种视频文件 | video/webm, video/ogg |
| application | 表明是某种二进制数据 | application/octet-stream, application/pkcs12, application/vnd.mspowerpoint, application/xhtml+xml, application/xml,  application/pdf |

​

