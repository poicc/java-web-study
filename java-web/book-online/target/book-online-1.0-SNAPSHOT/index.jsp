<%@ page import="com.crq.bookonline.entity.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>首页</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
    <style type="text/css">
        h2, h3 {
            color: rgb(73, 73, 73);
        }

        #search {
            height: 80px;
            background-color: rgb(246, 246, 241);
            display: flex;
            align-items: center;
            padding-left: 8%;
            margin-bottom: 10px;
        }

        .search-input {
            flex: 0 0 40%;
            height: 35px;
            background-color: #fff;
            border: none;
            border-radius: 3px;
            margin-left: 50px;
        }

        .search-input1 {
            width: 35px;
            height: 35px;
            background-color: rgb(64, 152, 238);
            border: none;
        }

        .search-btn img {
            width: 50%;
            height: 50%;
        }

        .card {
            height: 160px;
            margin: 20px 5px 20px 5px;
        }

        .card img {
            width: 100%;
            height: 90%;
            border-radius: 20px;
        }

        .card p {
            font-size: 13px;
            color: #9b9b9b;
        }


    </style>
</head>
<body>
<%
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
%>
<%--使用jsp的include动作，将top.jsp页面包含进来，这个顶部导航可以给各个页面共享--%>
<div id="top">
    <jsp:include page="top.jsp"/>
</div>

<%--搜索区--%>
<div id="search">
    <h2>搜索番剧</h2>
    <form action="/index.do" method="post">
        <input name="searchName" type="text" placeholder="番剧名" class="search-input">
        <input type="submit" value="搜索" class="search-input1">
    </form>
</div>
<div style="display: flex;width: 90%;margin: 0 auto;">
<div style="width: 75%;text-align: center">
    <img style="width: 95%;height: 60px;"
         src="https://cdn.jsdelivr.net/gh/poicc/image@main/rk/Snipaste_2022-02-24_20-07-24.21cfdbcrxdcw.webp" alt=""/>
</div>
<div style="width: 24%">
    <img style="width: 95%;height: 60px;"
         src="https://cdn.jsdelivr.net/gh/poicc/image@main/rk/Snipaste_2022-02-24_20-07-34.60d7ht23uag0.webp"
         alt=""/>
</div>
</div>
<%--主体内容区--%>
<div class="container">
    <div class="row">
        <%--左侧2/3主体部分--%>
        <div class="col-9">
            <div class="row">
                <%--遍历图书数据集合，将每个图书对象放入页面对象--%>
                <%
                    for (Book book : bookList) {
                        pageContext.setAttribute("book", book);
                %>
                <%--引用col-2表示每行显示5本，再追加card细节样式--%>
                <div class="col-3 card">
                    <%--点击每本图书封面图，地址栏跳转为/detail/id,进入图书详情Servlet--%>
                    <a href="${pageContext.request.contextPath}/detail/${book.id}">
                        <img src="images/${book.cover}" alt="">
                    </a>
                    <p style="color:black;font-size:13px;font-weight:600">${book.name}</p>
                    <p>${book.author}</p>
                </div>
                <%
                    }
                %>
            </div>
        </div>

        <div class="col-3" style="margin-top: 20px;">
            <div class="ph-border">
                <div class="white-back"><span class="first">1</span> 天才王子的赤字国家振兴术</div>
                <div class="gray-back"><span class="second">2</span> 公主连结 与你重逢 第二季</div>
                <div class="white-back"><span class="third">3</span> 与变成了异世界美少女的...</div>
                <div class="gray-back"><span class="gray">4</span> 擅长捉弄的高木同学 第三季</div>
                <div class="white-back"><span class="gray">5</span> 国王排名</div>
                <div class="gray-back"><span class="gray">6</span> 里亚德录大地</div>
                <div class="white-back"><span class="gray">7</span> 失格纹的最强贤者~世界...</div>
                <div class="gray-back"><span class="gray">8</span> 自称贤者弟子的限制</div>

            </div>
        </div>
    </div>

    <footer>
        <ul>
            <li>@2015-2019</li>
            <li>niit.edu.cn,</li>
            <li>all rights reserved</li>
            <li>南工院计算机学院</li>
        </ul>
        <ul>
            <li>联系我们</li>
            <li>帮助中心</li>
            <li>法律声明</li>
            <li>移动合作</li>
        </ul>
    </footer>
</div>
</body>
</html>
