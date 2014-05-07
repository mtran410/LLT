<?php

		$con = mysql_connect("localhost","jqbao_lltuser","ITQ;6H7RDmeZ");
		if (!$con)
		  {
		  die('Could not connect: ' . mysql_error());
		  }
		mysql_select_db("jqbao_llt", $con);
		mysql_query("UPDATE `player` SET `health`='".$_REQUEST['health']."' WHERE `pid` = '".$_REQUEST['id']."'");
		
		$result = mysql_query("SELECT  * FROM player WHERE pid = '".$_REQUEST['id']."' AND health = '".$_REQUEST['health']."'");

		
		while($data = mysql_fetch_array($result)) {
 				$output[] = $data;
			}
			if(is_null($output)){
					$post_data = json_encode(array('playerhit' => 'false'), JSON_FORCE_OBJECT);
			
			}else{
				$post_data = json_encode(array('playerhit' => 'true'), JSON_FORCE_OBJECT);
			
			}
					echo $post_data;
		
		  mysql_close($con);
		  
		  
?> 
