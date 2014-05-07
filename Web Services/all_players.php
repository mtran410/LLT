<?php

		$con = mysql_connect("localhost","jqbao_lltuser","ITQ;6H7RDmeZ");
		if (!$con)
		  {
		  die('Could not connect: ' . mysql_error());
		  }
		mysql_select_db("jqbao_llt", $con);
		$result = mysql_query("SELECT  * FROM player ");

		
			while($data = mysql_fetch_array($result)) {
 				$output[] = $data;
			}
			
				echo json_encode(array('players' => $output));
		
		  mysql_close($con);
		  
		  
?>  
 
  
 
