<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Book</title>
<style>
    
    body {
        margin: 0;
        padding: 0;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        font-family: 'Segoe UI', Arial, sans-serif;
        background: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)), 
                    url('https://tse3.mm.bing.net/th/id/OIP.ObImjoIMbB_ydK2bilL2HwHaE7?pid=Api&h=220&P=0');
        background-size: cover;
        background-position: center;
        color: white;
    }

   
    .form-frame {
        background: rgba(255, 255, 255, 0.1);
        backdrop-filter: blur(15px);
        padding: 40px;
        border-radius: 20px;
        border: 1px solid rgba(255, 255, 255, 0.2);
        box-shadow: 0 15px 35px rgba(0, 0, 0, 0.5);
        width: 400px;
    }

    h1 {
        margin-top: 0;
        font-size: 22px;
        text-align: center;
        letter-spacing: 2px;
        text-transform: uppercase;
        color: #ff9800; /* Matching the orange theme */
    }

    
    table {
        width: 100%;
    }

    td {
        padding: 10px 0;
    }

    input[type="text"], input[type="number"] {
        width: 100%;
        padding: 10px;
        border-radius: 5px;
        border: 1px solid rgba(255, 255, 255, 0.3);
        background: rgba(255, 255, 255, 0.1);
        color: white;
        outline: none;
    }

    input:focus {
        border-color: #ff9800;
        background: rgba(255, 255, 255, 0.2);
    }

   
    .submit-btn {
        background: #ff9800;
        color: white;
        border: none;
        padding: 12px;
        width: 100%;
        border-radius: 8px; /* Rectangular shape like Home page */
        font-weight: bold;
        cursor: pointer;
        transition: 0.3s;
        margin-top: 10px;
    }

    .submit-btn:hover {
        background: #e68a00;
        transform: translateY(-2px);
    }

    .nav-links {
        margin-top: 20px;
        text-align: center;
        display: flex;
        justify-content: space-around;
    }

    .nav-links a {
        color: #ddd;
        text-decoration: none;
        font-size: 14px;
        transition: 0.3s;
    }

    .nav-links a:hover {
        color: white;
        text-decoration: underline;
    }
</style>
</head>
<body>

    <div class="form-frame">
        <h1>ADD NEW BOOK</h1>
        
        <form action="saveservlet" method="post">
            <table>
                <tr>
                    <td>Book Name:</td>
                    <td><input type="text" name="name" required/></td>
                </tr>
                <tr>
                    <td>Quantity:</td>
                    <td><input type="number" name="quantity" required/></td>
                </tr>
                <tr>
                    <td>Author:</td>
                    <td><input type="text" name="author" required/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="CREATE BOOK" class="submit-btn"/>
                    </td>
                </tr>
            </table>
        </form>

        <div class="nav-links">
            <a href="viewServlets">View Books</a>
            <a href="home.jsp">Back to Home</a>
        </div>
    </div>

</body>

</html>
