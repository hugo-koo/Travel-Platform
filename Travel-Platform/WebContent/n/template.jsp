<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info="游记编辑"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>

<head>
<%--导入站点全局首部--%>
<%@ include file="/site-head.jsp"%>
</head>

<body>
    <header>
        <%@ include file="/site-header.jsp"%>
    </header>
        <div class="container-fluid">
        <div class="row align-items-start">
            <img src="<%="/Travel-Platform/_img/page_bg.jpg"%>" class="img-fluid"
                alt="头图">
        </div>
        <hr>
        <div class="row">
            <div class="col-sm-1"></div>
            <div class="col-6 col-lg-8"></div>
            <div class="col-3 col-lg-3" id="cards-flows"></div>
        </div>
        </div>
    <footer>
        <%@ include file="/site-footer.jsp"%>
    </footer>
</body>

</html>