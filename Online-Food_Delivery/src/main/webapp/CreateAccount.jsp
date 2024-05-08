<!DOCTYPE html>
<html>
    <head>
    <style type="text/css">
    <%@ include file="/css/login.css" %>
    
    </style>
        

    </head>
    <body>
        <div class="container">
            <h2>get in touch</h2>
            <form action="Register" method="post">
            <input type="text" id="name" placeholder="name" name="name" required>
            <input type="text" id="phone" placeholder="phone" name="phone" maxlength="10" required>
            <input type="email" id="email" placeholder="email" name="email" required>
            <input type="text" id="email" placeholder="Address" name="address" required>
            <input type="text" id="email" placeholder="pass" name="pass"  required>
            
            <button type="submit" class="btn">submit</button>
        </form>
        </div>
       
    </body>
</html>