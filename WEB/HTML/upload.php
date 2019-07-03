<?php
  $source = $_FILES['profile']['tmp_name'];
  $dest = "./" basename($_FILES['file']['name']);
  move_uploaded_file($source, $dest);
 ?>
