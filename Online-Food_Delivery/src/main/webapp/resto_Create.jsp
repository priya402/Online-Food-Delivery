<!DOCTYPE html>
<html>
    <head>
    <style type="text/css">
    <%@ include file="/css/login.css" %>
    
    </style>
        

    </head>
    <body>
        <div class="container">
            <h2>Create Account</h2>
            <form action="RestoCreate" method="post">
            <input type="text" id="name" placeholder="Restorunt name" name="name" required>
            <input type="text" id="phone" placeholder="Restorunt phone" name="phone" maxlength="10" required>
            <input type="email" id="email" placeholder="Restorunt email" name="email" required>
            <input type="text" id="email" placeholder="Restorunt Address" name="address" required>
            <input type="text" id="email" placeholder="pass" name="pass"  required>
            
            <button type="submit" class="btn" >submit</button>
        </form>
        </div>
       
    </body>
</html>