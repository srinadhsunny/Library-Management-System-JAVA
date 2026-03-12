<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Library Home</title>
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
        background-repeat: no-repeat;
    }

    
    .dashboard-frame {
        background: rgba(255, 255, 255, 0.1); /* Transparent white */
        backdrop-filter: blur(12px); /* Glass effect */
        padding: 60px 40px;
        border-radius: 20px;
        border: 1px solid rgba(255, 255, 255, 0.2);
        box-shadow: 0 15px 35px rgba(0, 0, 0, 0.5);
        text-align: center;
        width: 380px;
    }

    h1 {
        color: white;
        font-size: 26px;
        margin-bottom: 40px;
        letter-spacing: 2px;
        text-transform: uppercase;
        text-shadow: 2px 2px 4px rgba(0,0,0,0.5);
    }

   
    .btn-container {
        display: flex;
        flex-direction: column;
        gap: 20px;
        align-items: center;
    }

    
    .pill-button {
        background: transparent;
        color: white;
        border: 2px solid white;
        padding: 12px 40px;
        font-size: 16px;
        font-weight: bold;
        border-radius: 50px; /* Pill Shape */
        cursor: pointer;
        width: 220px;
        transition: all 0.3s ease;
        text-decoration: none;
        display: inline-block;
    }

    .pill-button:hover {
        background: white;
        color: #333;
        transform: scale(1.05);
    }

    /* The "Add" Button - Rectangular & Bright */
    .rect-button {
        background: #ff9800; /* Orange theme */
        color: white;
        border: none;
        padding: 14px 40px;
        font-size: 16px;
        font-weight: bold;
        border-radius: 8px; /* Modern Rectangular */
        cursor: pointer;
        width: 220px;
        transition: all 0.3s ease;
        box-shadow: 0 4px 15px rgba(255, 152, 0, 0.3);
        text-decoration: none;
        display: inline-block;
    }

    .rect-button:hover {
        background: #e68a00;
        transform: translateY(-3px);
        box-shadow: 0 6px 20px rgba(255, 152, 0, 0.5);
    }

    /* Remove default button styling if using <button> inside <a> */
    button {
        all: unset;
        width: 100%;
    }
</style>
</head>
<body>

    <div class="dashboard-frame">
        <h1>WELCOME TO THE LIBRARY</h1>
        
        <div class="btn-container">
            <a href="viewServlets" class="pill-button">VIEW BOOKS</a>
            
            <a href="index.jsp" class="rect-button">ADD NEW BOOK</a>
        </div>
    </div>

</body>

</html>
