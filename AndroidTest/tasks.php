<?php

    if($_SERVER['REQUEST_METHOD'] == 'GET')
    {

        require_once "connect.php";

        $sql = "SELECT * FROM users_task";

        $response = [];

        $result = mysqli_query($conn, $sql);

        while($row = mysqli_fetch_assoc($result))
        {
            $response[] = $row;
        }

        header('Content-Type: application/json');
        echo json_encode($response);

    }

?>