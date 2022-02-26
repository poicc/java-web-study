<%--
  Created by IntelliJ IDEA.
  User: crq
  Date: 2022/2/24
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>

<%@ page import="com.crq.bookonline.entity.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书详情页面</title>
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

        .search-btn {
            width: 35px;
            height: 35px;
            background-color: rgb(155, 154, 143);
            display: flex;
            align-items: center;
            justify-content: center;
        }

        .search-btn img {
            width: 50%;
            height: 50%;
        }


        .col-4 img {
            margin: 10px 5px 20px 5px;
            width: 80%;
        }

        hr {
            width: 90%;
            color: #eee;
            margin-top: 10px;
        }

        .col-6 {
            height: 400px;
            padding-right: 10px;
        }

        .col-6 img {
            width: 100%;
            height: 100%;
            border-radius: 20px;
        }
    </style>
</head>
<body>
<%
    Book book = (Book) request.getAttribute("book");
    pageContext.setAttribute("book", book);
%>

<div id="top">
    <jsp:include page="top.jsp"/>
</div>

<div id="search">
    <h2>搜索番剧</h2>
    <form action="/index.do" method="post">
        <input name="searchName" type="text" placeholder="番剧名" class="search-input">
        <input type="submit" value="搜索" class="search-input1">
    </form>
</div>

<div class="container">
    <div class="row">
        <div class="col-8">
            <div class="row">
                <div class="col-6">
                    <img style="height: 80%" src="/images/${book.cover}" alt="">
                </div>
                <div class="col-4">
                    <h3 style="font-size: 30px">${book.name}</h3>
                    <p style="margin-top: 10px">${book.author}</p>
                </div>
                <div class="col-12">
                    <img style="width: 100%;height: 300px" src="https://cdn.jsdelivr.net/gh/poicc/image@main/Snipaste_2022-02-24_21-02-22.1rp8qqz44i4g.webp"/>
                </div>
            </div>
        </div>
        <div class="col-3">
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

</div>
</body>
</html>
