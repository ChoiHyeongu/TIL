<?php
$link=mysqli_connect("localhost","root","11asbdccd","bibleReading");
if (!$link){
  echo "MySQL 접속 에러 : ";
  echo mysqli_connect_error();
  exti();
}

mysqli_set_charset($link, "utf8");

$sql="select * from userTbl";

$result=mysqli_query($link,$sql);
$data=array();

if($result){

  while($row=mysqli_fetch_array($result)){
    array_push($data,
         array('ID' => $row[0],
         'PW' => $row[1]
       ));
  }

  header('Content-Type: application/json; charset=utf8');
$json = json_encode(array("webnautes => $data"), JSON_PRETTY_PRINT+JSON_UNESCAPED_UNICODE);
echo $json;

}
else{
  echo "SQL문 처리중 에러 발생 : "
  echo mysqli_error();
}

mysqli_close($link);
?>
