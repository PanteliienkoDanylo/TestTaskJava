<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
    <form action="controllerServlet" method="get">
      <input type="hidden" name="command" value="add_user">
        <p id="validSurname"></p>
        <p>Surname</p>
      <input type="text" id="surname" name="surname" value="enter surname">
        <p id="validName"></p>
        <p>Name</p>
      <input type="text" id="name" name="name" value="enter name">
        <p id="validAge"></p>
        <p>Age</p>
      <input type="text" id="age" name="age" value="enter age">
        <p id="validSex"></p>
        <p>Sex</p>
        <select id="sex" name="sex">
            <option>select a sex</option>
            <option>w</option>
            <option>m</option>
        </select>
        <p id="validMobileNumber"></p>
        <p>Mobile number</p>
      <input type="text" id="mobile_number" name="mobile_number" value="enter mobile_number"><br><br>
      <input type="submit" id="add_button" value="Add" disabled>
    </form>

    <script>
        const notValidSurname = "Not valid surname (must be > 5 symbols)";
        const notValidName = "Not valid name (must be > 5 symbols)";
        const notValidAge = "Not valid age (must be <= 3 symbols)";
        const notValidSex = "Not valid age (must be 'w' or 'm')";
        const notValidMobileNumber = "Not valid age (must be like (xxx)xxx-xx-xx)";
        const valid = "valid";

        var isSurnameValid = false;
        var isNameValid = false;
        var isAgeValid = false;
        var isSexValid = false;
        var isMobileNumberValid = false;

        document.getElementById("surname").onchange = function() {validSurname()};
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
            }
            makeButtonDisable();
        }

        function makeButtonDisable(){
            if(isSurnameValid && isNameValid && isAgeValid && isSexValid && isMobileNumberValid){
                document.getElementById("add_button").disabled = false;
            }
        }
    </script>
</body>
</html>
