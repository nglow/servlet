<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.servlet.domain.member.Member" %>
<%@ page import="com.example.servlet.domain.member.MemberRepository" %>
<%
    // Request, response 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();

    System.out.println("MemberSaveServlet.service");

    String username = request.getParameter("username"); // var 지원안함
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
</body>
</html>
