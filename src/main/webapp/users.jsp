<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Users</title>
</head>
<body>
    <table border="1">
      <thead>
      <tr>
        <th>id</th>
        <th>surname</th>
        <th>name</th>
        <th>age</th>
        <th>sex</th>
        <th>mobile number</th>
        <th>change user</th>
      </tr>
      </thead>

        <c:forEach items="${users}" var="user">

            <tr>
                <td>${user.id}</td>
                <td>${user.surname}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.sex}</td>
                <td>${user.mobileNumber}</td>
                <td>
                    <form action="controllerServlet" method="get">
                        <input type="hidden" name="command" value="show_user">
                        <input type="hidden" name="user_id" value="${user.id}">
                        <input type="submit" value="Update">
                    </form>
                </td>
            </tr>

        </c:forEach>

    </table>

    <form action="add_user.jsp">
        <input type="submit" value="Add">
    </form>

    <form action="controllerServlet" method="get">
        <input type="hidden" name="command" value="find_user">
        <select id="find_type" name="find_type">
            <option>Select a type of search</option>
            <option value="show_all">Show all</option>
            <option value="find_user_by_surname">Find by surname</option>
            <option value="find_user_by_name">Find by name</option>
            <option value="find_user_by_age">Find by age</option>
            <option value="find_user_by_sex">Find by sex</option>
            <option value="find_user_by_mobile_number">Find by mobile number</option>
        </select>
        <input type="text" id="text_for_find" name="enter_field" value="" disabled>
        <select id="sex" name="sex" disabled>
            <option value="w">w</option>
            <option value="m">m</option>
        </select>
        <input type="submit" id="find_button" value="Find" disabled>
    </form>

    <script>

        const showAll = "show_all";
        const findBySurname = "find_user_by_surname";
        const findByName = "find_user_by_name";
        const findByAge = "find_user_by_age";
        const findBySex = "find_user_by_sex";
        const findByMobileNumber = "find_user_by_mobile_number";

        document.getElementById("find_type").onchange = function(){ findUser(document.getElementById("find_type").value)}

        function findUser(findType){

            switch(findType){
                case showAll :
                    document.getElementById("text_for_find").disabled = true;
                    document.getElementById("sex").disabled = true;
                    document.getElementById("find_button").disabled = false;
                    break;

                case findBySurname :
                    document.getElementById("text_for_find").disabled = false;
                    document.getElementById("sex").disabled = true;
                    document.getElementById("find_button").disabled = false;
                    break;

                case findByName :
                    document.getElementById("text_for_find").disabled = false;
                    document.getElementById("sex").disabled = true;
                    document.getElementById("find_button").disabled = false;
                    break;

                case findByAge :
                    document.getElementById("text_for_find").disabled = false;
                    document.getElementById("sex").disabled = true;
                    document.getElementById("find_button").disabled = false;
                    break;

                case findBySex :
                    document.getElementById("text_for_find").disabled = true;
                    document.getElementById("sex").disabled = false;
                    document.getElementById("find_button").disabled = false;
                    break;

                case findByMobileNumber:
                    document.getElementById("text_for_find").disabled = false;
                    document.getElementById("sex").disabled = true;
                    document.getElementById("find_button").disabled = false;
                    break;
            }
        }


    </script>
</body>
</html>
