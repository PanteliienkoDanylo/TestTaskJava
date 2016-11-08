<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update user</title>
</head>
<body>

    <form action="controllerServlet" method="get">
        <input type="hidden" name="command" value="update_user">
        <input type="hidden" name="id" value="${user.id}">
        <p id="validSurname"></p>
        <p>Surname</p>
        <input type="text" id="surname" name="surname" value="${user.surname}"><br>
        <p id="validName"></p>
        <p>Name</p>
        <input type="text" id="name" name="name" value="${user.name}"><br>
        <p id="validAge"></p>
        <p>Age</p>
        <input type="text" id="age" name="age" value="${user.age}"><br>
        <p id="validSex"></p>
        <p>Sex</p>
        <select id="sex" name="sex">
            <option>w</option>
            <option>m</option>
        </select>
        <p id="validMobileNumber"></p>
        <p>Mobile number</p>
        <input type="text" id="mobile_number" name="mobile_number" value="${user.mobileNumber}"><br>
        <input type="submit" id="update_button" value="Update" disabled>
    </form>

    <script>
        const notValidSurname = "Not valid surname (must be > 5 symbols)";
        const notValidName = "Not valid name (must be > 5 symbols)";
        const notValidAge = "Not valid age (must be <= 3 symbols)";
        const notValidSex = "Not valid age (must be 'w' or 'm')";
        const notValidMobileNumber = "Not valid age (must be like (xxx)xxx-xx-xx)";
        const valid = "valid";

        var isSurnameValid = true;
        var isNameValid = true;
        var isAgeValid = true;
        var isSexValid = true;
        var isMobileNumberValid = true;

        document.getElementById("surname").onclick = function() {validSurname()};
        document.getElementById("name").onchange = function() { validName()};
        document.getElementById("age").onchange = function() { validAge()};
        document.getElementById("sex").onchange = function() {validSex()};
        document.getElementById("mobile_number").onchange = function() {validMobileNumber()};



        function validSurname(){
            var surname = document.getElementById("surname").value;
            var regex = new RegExp("^[A-Za-z]{5,20}$");
            if(regex.test(surname)){
                document.getElementById("validSurname").innerHTML = valid;
                isSurnameValid = true;
            }else{
                document.getElementById("validSurname").innerHTML = notValidSurname;
                isSurnameValid = false;
            }
            makeButtonDisable();
        }

        function validName(){
            var name = document.getElementById("name").value;
            var regex = new RegExp("^[A-Za-z]{5,20}$");
            if(regex.test(name)){
                document.getElementById("validName").innerHTML = valid;
                isNameValid = true;
            }else{
                document.getElementById("validName").innerHTML = notValidName;
                isSurnameValid = false;
            }
            makeButtonDisable();
        }

        function validAge(){
            var age = document.getElementById("age").value;
            var regex = new RegExp("^[0-9]{1,3}$");
            if(regex.test(age)){
                document.getElementById("validAge").innerHTML = valid;
                isAgeValid = true;
            }else{
                document.getElementById("validAge").innerHTML = notValidAge;
                isSurnameValid = false;
            }
            makeButtonDisable();
        }

        function validSex(){
            var sex = document.getElementById("sex").value;
            var regex = new RegExp("^[m,w]$");
            if(regex.test(sex)){
                document.getElementById("validSex").innerHTML = valid;
                isSexValid = true;
            }else{
                document.getElementById("validSex").innerHTML = notValidSex;
                isSurnameValid = false;
            }
            makeButtonDisable();
        }

        function validMobileNumber(){
            var mobileNumber = document.getElementById("mobile_number").value;
            var regex = new RegExp("^[(]([0-9]{3})[)][0-9]{3}[-][0-9]{2}[-][0-9]{2}$");
            if(regex.test(mobileNumber)){
                document.getElementById("validMobileNumber").innerHTML = valid;
                isMobileNumberValid = true;
            }else{
                document.getElementById("validMobileNumber").innerHTML = notValidMobileNumber;
                isSurnameValid = false;
            }
            makeButtonDisable();
        }

        function makeButtonDisable(){
            if(isSurnameValid && isNameValid && isAgeValid && isSexValid && isMobileNumberValid){
                document.getElementById("update_button").disabled = false;
            }
        }
    </script>

</body>
</html>
