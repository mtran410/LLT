<?php

		$con = mysql_connect("localhost","jqbao_lltuser","ITQ;6H7RDmeZ");
		if (!$con)
		  {
		  die('Could not connect: ' . mysql_error());
		  }
		mysql_select_db("jqbao_llt", $con);
		$result = mysql_query("SELECT  * FROM player WHERE display_name = '".$_REQUEST['username']."' AND password = '".$_REQUEST['password']."'");

		
		while($data = mysql_fetch_array($result)) {
 				$output[] = $data;
			}
			if(is_null($output)){
					$post_data = json_encode(array('isvalid' => 'false'), JSON_FORCE_OBJECT);
			
			}else{
				$post_data = json_encode(array('isvalid' => 'true'), JSON_FORCE_OBJECT);
			
			}
					echo $post_data;
		
		  mysql_close($con);
		  
		  
?> 
